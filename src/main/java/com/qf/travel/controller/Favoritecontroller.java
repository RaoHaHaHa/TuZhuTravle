package com.qf.travel.controller;

import com.qf.travel.pojo.FavoriteInfo;
import com.qf.travel.service.Impl.FavoriteInfoServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

@Controller
public class Favoritecontroller {
    @Resource
    FavoriteInfoServiceImpl favoriteInfoService;

    @RequestMapping(value = "favorite111")
    @ResponseBody
    public List<FavoriteInfo> test(@RequestBody FavoriteInfo favoriteInfo){
        int user_id = favoriteInfo.getUser_id();
        System.out.println(user_id);
        return favoriteInfoService.findByFavorite(user_id);
    }


    @RequestMapping(value = "addfavorite111")
    @ResponseBody
    public int test1(@RequestBody FavoriteInfo favoriteInfo){
/*        FavoriteInfo favoriteInfo1 = new FavoriteInfo();
        favoriteInfo1.setId(favoriteInfo.getId());
        favoriteInfo1.setUser_id(favoriteInfo.getUser_id());
        int rSet = favoriteInfoService.addByFavorite(favoriteInfo1);*/
        /*System.out.println(rSet);*/
        /*System.out.println(favoriteInfo.getId());
        System.out.println(favoriteInfo.getUser_id());*/
        FavoriteInfo favoriteInfo1 = new FavoriteInfo();
        favoriteInfo1.setId(favoriteInfo.getId());
        favoriteInfo1.setUser_id(favoriteInfo.getUser_id());

        List<FavoriteInfo> list = favoriteInfoService.selectFavorite(favoriteInfo1);
        if(list.size()==0){

            return favoriteInfoService.addByFavorite(favoriteInfo1);
        }
        return 1;
    }


    @RequestMapping(value = "deleteInfo")
    @ResponseBody
    public String test5(@RequestBody FavoriteInfo favoriteInfo){
        int id = favoriteInfo.getId();
        int user_id = favoriteInfo.getUser_id();
        System.out.println(id);
        FavoriteInfo favoriteInfo1 = new FavoriteInfo();
        favoriteInfo1.setId(id);
        favoriteInfo1.setUser_id(user_id);
        favoriteInfoService.deleteFavorite(favoriteInfo1);
        return "1";
    }
}

package com.qf.travel.controller;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.qf.travel.service.PhotoService;
import com.qf.travel.vo.PhotoVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/*  图片管理 */
@Controller
public class PhotoController {

    @Autowired
    PhotoService photoService;

    /* 显示所有旅游景点 */
    @RequestMapping(value = "listAllPhoto",method = RequestMethod.POST)
    @ResponseBody
    public Object listAllPhoto(@RequestBody(required = false) PhotoVo photoVo){
        System.out.println(photoVo);
        PageHelper.startPage(photoVo.getCurrentPage(), photoVo.getPageSize());
        List<PhotoVo> attractionVos = photoService.listAllPhoto();
        PageInfo<PhotoVo> attractionVoPageInfo = new PageInfo<PhotoVo>(attractionVos);
        System.out.println(attractionVos);
        return attractionVoPageInfo;
    }



    /* 增加图片 */
    @RequestMapping(value = "addPhoto",method = RequestMethod.POST)
    @ResponseBody
    public Object addPhoto(@RequestBody(required = false) PhotoVo photoVo){
        System.out.println(photoVo);

        boolean flag = photoService.addPhoto(photoVo);
        return flag;
    }

    /* 删除图片 */
    @RequestMapping(value = "delPhoto",method = RequestMethod.POST)
    @ResponseBody
    public Object delPhoto(@RequestBody(required = false)  PhotoVo photoVo){
        System.out.println(photoVo);
        boolean flag ;
        flag = photoService.delPhoto(photoVo);
        return flag;
    }

    /*  批量删除图片  */
    @RequestMapping(value = "delPhotos",method = RequestMethod.POST)
    @ResponseBody
    public Object delPhotos(@RequestBody(required = false)  PhotoVo photoVo){
        System.out.println(photoVo);
        boolean flag ;
        flag = photoService.delPhotos(photoVo);
        return flag;
    }

    /* 修改图片 */
    @RequestMapping(value = "updatePhoto",method = RequestMethod.POST)
    @ResponseBody
    public Object updatePhoto(@RequestBody(required = false)  PhotoVo photoVo){
        System.out.println(photoVo);
        boolean flag ;
        flag = photoService.updatePhoto(photoVo);
        return flag;
    }

    /* 图片上传 */


}

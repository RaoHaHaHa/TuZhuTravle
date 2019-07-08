package com.qf.travel.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.qf.travel.service.AttractionService;
import com.qf.travel.vo.AttractionVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/*  旅游景点管理 */
@RestController
public class AttractionController {

    @Autowired
    AttractionService attractionService;

    /* 显示所有旅游景点 */
    @RequestMapping(value = "listAllAttraction",method = RequestMethod.POST)
    public Object listAllAttraction(@RequestBody(required = false) AttractionVo attractionVo){
        System.out.println(attractionVo);
        PageHelper.startPage(attractionVo.getCurrentPage(), attractionVo.getPageSize());
        List<AttractionVo> attractionVos = attractionService.listAllAttraction();
        System.out.println(attractionVos.toString());
        PageInfo<AttractionVo> attractionVoPageInfo = new PageInfo<AttractionVo>(attractionVos);
        System.out.println(attractionVos);
        return attractionVoPageInfo;
    }



    /* 增加旅游景点 */
    @RequestMapping(value = "addAttraction",method = RequestMethod.POST)
    @ResponseBody
    public Object addAttraction(@RequestBody(required = false) AttractionVo attractionVo){
        System.out.println("增加的旅游景点详情为"+attractionVo);

        boolean flag = attractionService.addAttraction(attractionVo);
        System.out.println(flag);
        return flag;
    }

    /* 删除旅游景点  */
    @RequestMapping(value = "delAttraction",method = RequestMethod.POST)
    @ResponseBody
    public Object delAttraction(@RequestBody(required = false)  AttractionVo attractionVo){
        System.out.println(attractionVo);
        boolean flag ;
        flag = attractionService.delAttraction(attractionVo);
        return flag;
    }

    /*  批量删除旅游景点  */
    @RequestMapping(value = "delAttractions",method = RequestMethod.POST)
    @ResponseBody
    public Object delAttractions(@RequestBody(required = false) AttractionVo attractionVo){
        System.out.println(attractionVo);
        boolean flag ;
        flag = attractionService.delAttractions(attractionVo);
        return flag;
    }

    /* 更改*/
    @RequestMapping(value = "updateAttraction",method = RequestMethod.POST)
    @ResponseBody
    public Object updateAttraction(@RequestBody(required = false) AttractionVo attractionVo){
        System.out.println(attractionVo.toString());
        boolean flag;
        flag= attractionService.updateAttraction(attractionVo);
        return flag;
    }

    /* 查询单个*/
    @RequestMapping(value = "SelectById",method = RequestMethod.POST)
    @ResponseBody
    public Object SelectById(@RequestBody(required = false) AttractionVo attractionVo){
        System.out.println(attractionVo.toString());
        AttractionVo attractionVoReturn = attractionService.SelectById(attractionVo);
        System.out.println(attractionVoReturn);
        return attractionVoReturn;
    }

}

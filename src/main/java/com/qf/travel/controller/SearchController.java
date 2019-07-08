package com.qf.travel.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.qf.travel.controller.po.City;
import com.qf.travel.controller.po.PlayRoute;
import com.qf.travel.controller.po.Recommendation;
import com.qf.travel.entity.Route;
import com.qf.travel.service.SearchService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

@Controller
public class SearchController {

    @Resource
    SearchService searchService;

    //首次加载页面条件搜索框的城市数据
    @RequestMapping(value = "/city")
    @ResponseBody
    public List<City> getCity(){
        List<City> city = searchService.FindAllCity();
        return city;
    }
    //首次加载页面条件搜索框的推荐数据
    @RequestMapping(value = "/Rec")
    @ResponseBody
    public List<Recommendation> getRec(){
        List<Recommendation> recommendations = searchService.findAllRecommendation();
        return recommendations;
    }
    //首次加载页面条件搜索框的路线数据
    @RequestMapping(value = "/Route")
    @ResponseBody
    public List<PlayRoute> getRoute(){
        List<PlayRoute> routes = searchService.findAllPlayRoute();
        return routes;
    }
    //加载搜索页的详情
    @RequestMapping(value = "/Result")
    @ResponseBody
    public PageInfo getValue(@RequestBody Recommendation value, @RequestParam int pageNO){
        //如果是默认页则赋值默认-"海"
        if(value.getTest()=="null"){
            value.setTest("海");
        }
        /*System.out.println(pageNO);*/
        //如果传入的数据没有pageNO则自动第一页
        if(pageNO == 0){
            pageNO = 1;
        }
        /*System.out.println(pageNO+"pageNo");*/
        //设置分数属性
        PageHelper.startPage(pageNO,5);
        //查找数据
        List<Route> values = searchService.findValues(value.getTest());
        /*System.out.println(values);*/
        //在插件自动分页
        PageInfo<Route> pageInfo = new PageInfo<Route>(values);

        //包含List数据和分页自身属性
        return pageInfo;
    }
    //在Seesion中获得页面的值
   /* @RequestMapping(value = "/Detail")
    @ResponseBody
    public Route find(@RequestParam String value) throws IOException {

        Route value1 = seachService.findValue(value);
        System.out.println(value1);

        return value1;
    }*/

}

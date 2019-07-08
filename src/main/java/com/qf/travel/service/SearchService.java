package com.qf.travel.service;

import com.qf.travel.controller.po.City;
import com.qf.travel.controller.po.PlayRoute;
import com.qf.travel.controller.po.Recommendation;
import com.qf.travel.entity.Route;

import java.util.List;

public interface SearchService {
    /*Route SeachRoute(Vo vo);*/
    //搜索框的城市数据
    List<City> FindAllCity();
    //搜索框的热门推荐
    List<Recommendation> findAllRecommendation();
    //搜索框的游玩路线
    List<PlayRoute> findAllPlayRoute();
    //搜索框搜索
    /*Route findValue(String o);*/
    List<Route> findValues(Object o);
}

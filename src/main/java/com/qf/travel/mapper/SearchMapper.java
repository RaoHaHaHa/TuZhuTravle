package com.qf.travel.mapper;

import com.qf.travel.controller.po.City;
import com.qf.travel.controller.po.PlayRoute;
import com.qf.travel.controller.po.Recommendation;
import com.qf.travel.entity.Route;

import java.util.List;

public interface SearchMapper {
    //搜索框的城市数据
    List<City> findAllCity();
    //搜索框的热门推荐
    List<Recommendation> findAllRecommendation();
    //搜索框的游玩路线
    List<PlayRoute> findAllPlayRoute();

    /*Route findValue(Object o);*/
    //查询数据组
    List<Route> findValuetwo(Object o);
}

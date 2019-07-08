package com.qf.travel.service.Impl;

import com.qf.travel.controller.po.City;
import com.qf.travel.controller.po.PlayRoute;
import com.qf.travel.controller.po.Recommendation;
import com.qf.travel.entity.Route;
import com.qf.travel.mapper.SearchMapper;
import com.qf.travel.service.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SearchServiceImpl implements SearchService {
    @Autowired
    SearchMapper searchMapper;
    @Override
    public List<City> FindAllCity() {
        return searchMapper.findAllCity();
    }

    @Override
    public List<Recommendation> findAllRecommendation() {
        return searchMapper.findAllRecommendation();
    }

    @Override
    public List<PlayRoute> findAllPlayRoute() {
        return searchMapper.findAllPlayRoute();
    }

    @Override
    public List<Route> findValues(Object o) {
        return searchMapper.findValuetwo(o);
    }
}

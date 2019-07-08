package com.qf.travel.service.Impl;

import com.qf.travel.mapper.FavoriteInfoMapper;
import com.qf.travel.pojo.FavoriteInfo;
import com.qf.travel.service.FavoriteInfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class FavoriteInfoServiceImpl implements FavoriteInfoService {

    @Resource
    FavoriteInfoMapper favoriteInfoMapper;
    @Override
    public List<FavoriteInfo> findByFavorite(int id) {
        return favoriteInfoMapper.findByFavorite(id);
    }

    @Override
    public int addByFavorite(FavoriteInfo favoriteInfo) {
        return favoriteInfoMapper.addByFavorite(favoriteInfo);
    }

    @Override
    public List selectFavorite(FavoriteInfo favoriteInfo) {
        return favoriteInfoMapper.selectFavorite(favoriteInfo);
    }

    @Override
    public Integer deleteFavorite(FavoriteInfo favoriteInfo) {
        return favoriteInfoMapper.deleteFavorite(favoriteInfo);
    }
}

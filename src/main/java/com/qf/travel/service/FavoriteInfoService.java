package com.qf.travel.service;

import com.qf.travel.pojo.FavoriteInfo;

import java.util.List;

public interface FavoriteInfoService {
    public List<FavoriteInfo> findByFavorite(int id);
    public int addByFavorite(FavoriteInfo favoriteInfo);
    public List selectFavorite(FavoriteInfo favoriteInfo);
    public Integer deleteFavorite(FavoriteInfo favoriteInfo);
}

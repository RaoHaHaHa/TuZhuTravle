package com.qf.travel.mapper;

import com.qf.travel.pojo.IndexInfo;

import java.util.List;

public interface IndexInfoMapper {
    public List<IndexInfo> findByIndex(IndexInfo indexInfo);
}

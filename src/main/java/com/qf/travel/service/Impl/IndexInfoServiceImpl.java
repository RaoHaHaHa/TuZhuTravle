package com.qf.travel.service.Impl;

import com.qf.travel.mapper.IndexInfoMapper;
import com.qf.travel.pojo.IndexInfo;
import com.qf.travel.service.IndexInfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;


@Service
public class IndexInfoServiceImpl implements IndexInfoService {
    @Resource
    IndexInfoMapper indexInfoMapper;
    @Override
    public List<IndexInfo> getIndexInfo(IndexInfo indexInfo) {
        return indexInfoMapper.findByIndex(indexInfo);
    }
}

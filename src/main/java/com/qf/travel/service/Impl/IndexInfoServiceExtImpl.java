package com.qf.travel.service.Impl;

import com.qf.travel.mapper.IndexInfoMapperext;
import com.qf.travel.pojo.ext.Address;
import com.qf.travel.service.IndexInfoServiceExt;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;


@Service
public class IndexInfoServiceExtImpl implements IndexInfoServiceExt {
    @Resource
    IndexInfoMapperext indexInfoMapperext;

    @Override
    public List<Address> findByAddress(Integer id) {
        return indexInfoMapperext.findByAddress(id);
    }
}

package com.qf.travel.mapper;

import com.qf.travel.pojo.ext.Address;

import java.util.List;

public interface IndexInfoMapperext {
    public List<Address> findByAddress(Integer id);
}

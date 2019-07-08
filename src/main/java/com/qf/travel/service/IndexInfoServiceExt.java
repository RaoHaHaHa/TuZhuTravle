package com.qf.travel.service;

import com.qf.travel.pojo.ext.Address;

import java.util.List;

public interface IndexInfoServiceExt {
    public List<Address> findByAddress(Integer id);
}

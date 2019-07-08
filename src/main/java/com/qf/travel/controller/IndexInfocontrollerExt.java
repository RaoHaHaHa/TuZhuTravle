package com.qf.travel.controller;


import com.qf.travel.mapper.IndexInfoMapperext;
import com.qf.travel.pojo.ext.Address;
import com.qf.travel.service.Impl.IndexInfoServiceExtImpl;
import com.qf.travel.service.Impl.IndexInfoServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

@Controller
public class IndexInfocontrollerExt {
    @Resource
    IndexInfoServiceExtImpl indexInfoServiceExt;


    @RequestMapping(value = "route_detail111")
    @ResponseBody
    public List<Address> test(/*@RequestParam int id*/){
        return indexInfoServiceExt.findByAddress(1);
    }

}

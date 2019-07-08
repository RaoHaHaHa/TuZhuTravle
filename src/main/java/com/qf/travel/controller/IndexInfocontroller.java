package com.qf.travel.controller;

import com.qf.travel.pojo.IndexInfo;
import com.qf.travel.service.Impl.IndexInfoServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@Controller
public class IndexInfocontroller {

    @Resource
    IndexInfoServiceImpl indexInfoService;

    @RequestMapping(value = "test1")
    @ResponseBody
    public List<IndexInfo> test(){
        IndexInfo indexInfo = new IndexInfo();
        indexInfo.setOrder_type("人气旅游");
        System.out.println(indexInfoService.getIndexInfo(indexInfo));
        return indexInfoService.getIndexInfo(indexInfo);
    }

    @RequestMapping(value = "test2")
    @ResponseBody
    public List<IndexInfo> test2(){
        IndexInfo indexInfo = new IndexInfo();
        indexInfo.setOrder_type("最新旅游");
        System.out.println(indexInfoService.getIndexInfo(indexInfo));
        return indexInfoService.getIndexInfo(indexInfo);
    }

    @RequestMapping(value = "test3")
    @ResponseBody
    public List<IndexInfo> test3(){
        IndexInfo indexInfo = new IndexInfo();
        indexInfo.setOrder_type("主题旅游");
        System.out.println(indexInfoService.getIndexInfo(indexInfo));
        return indexInfoService.getIndexInfo(indexInfo);
    }

    @RequestMapping(value = "test4")
    @ResponseBody
    public List<IndexInfo> test4(){
        IndexInfo indexInfo = new IndexInfo();
        indexInfo.setOrder_type("国内旅游");
        System.out.println(indexInfoService.getIndexInfo(indexInfo));
        return indexInfoService.getIndexInfo(indexInfo);
    }

    @RequestMapping(value = "test5")
    @ResponseBody
    public List<IndexInfo> test5(){
        IndexInfo indexInfo = new IndexInfo();
        indexInfo.setOrder_type("境外旅游");
        System.out.println(indexInfoService.getIndexInfo(indexInfo));
        return indexInfoService.getIndexInfo(indexInfo);
    }

}

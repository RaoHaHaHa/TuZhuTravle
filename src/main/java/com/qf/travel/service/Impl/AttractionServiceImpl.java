package com.qf.travel.service.Impl;

import com.qf.travel.mapper.AttractionMapper;
import com.qf.travel.service.AttractionService;
import com.qf.travel.vo.AttractionVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AttractionServiceImpl implements AttractionService {

    @Autowired
    AttractionMapper attractionMapper;

    /* 显示所有旅游景点 */
    @Override
    public List<AttractionVo> listAllAttraction() {
        List<AttractionVo> attractionVos = attractionMapper.listAllAttraction();

        System.out.println(attractionVos);

        return attractionVos;
    }

    /* 增加旅游景点 */
    @Transactional
    @Override
    public boolean addAttraction(AttractionVo attractionVo) {
        int count = attractionMapper.addAttraction(attractionVo);
        boolean flag;
        if(count > 0) {
            flag = true;
        }else {
            flag = false;
        }
        return flag;
    }

    /* 删除旅游景点 */
    @Transactional
    @Override
    public boolean delAttraction(AttractionVo attractionVo) {
        int count = attractionMapper.delAttraction(attractionVo);
        boolean flag;
        if(count > 0) {
            flag = true;
        }else {
            flag = false;
        }
        return flag;
    }

    /* 批量删除旅游景点 */
    @Transactional
    @Override
    public boolean delAttractions(AttractionVo attractionVo) {
        int count = attractionMapper.delAttractions(attractionVo);
        boolean flag;
        if(count > 0) {
            flag = true;
        }else {
            flag = false;
        }
        return flag;
    }

    /* 修改旅游景点 */
    @Transactional
    @Override
    public boolean updateAttraction(AttractionVo attractionVo) {
        int count = attractionMapper.updateAttraction(attractionVo);
        boolean flag;
        if(count > 0) {
            flag = true;
        }else {
            flag = false;
        }
        return flag;
    }

    public AttractionVo SelectById(AttractionVo attractionVo){
        AttractionVo attractionVoReturn = attractionMapper.SelectById(attractionVo);
        return attractionVoReturn;
    }
}

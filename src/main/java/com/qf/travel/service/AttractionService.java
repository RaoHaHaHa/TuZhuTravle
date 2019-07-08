package com.qf.travel.service;

import com.qf.travel.vo.AttractionVo;

import java.util.List;

public interface AttractionService {

    List<AttractionVo> listAllAttraction();

    boolean addAttraction(AttractionVo attractionVo);

    boolean delAttraction(AttractionVo attractionVo);

    boolean delAttractions(AttractionVo attractionVo);

    boolean updateAttraction(AttractionVo attractionVo);

    AttractionVo SelectById(AttractionVo attractionVo);
}

package com.qf.travel.mapper;

import com.qf.travel.vo.AttractionVo;

import java.util.List;

public interface AttractionMapper {
    List<AttractionVo> listAllAttraction();

    int addAttraction(AttractionVo attractionVo);

    int delAttraction(AttractionVo attractionVo);

    int delAttractions(AttractionVo attractionVo);

    int updateAttraction(AttractionVo attractionVo);

    AttractionVo SelectById(AttractionVo attractionVo);

}

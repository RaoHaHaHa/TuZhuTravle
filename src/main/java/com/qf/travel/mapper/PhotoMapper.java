package com.qf.travel.mapper;


import com.qf.travel.vo.PhotoVo;

import java.util.List;

public interface PhotoMapper {
    /* 显示所有图片 */
    List<PhotoVo> listAllPhoto();

    /* 增加图片 */
    int addPhoto(PhotoVo photoVo);

    /* 删除图片 */
    int delPhoto(PhotoVo photoVo);

    /*  批量删除图片 */
    int delPhotos(PhotoVo photoVo);

    /*  修改图片 */
    int updatePhoto(PhotoVo photoVo);
}

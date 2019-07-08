package com.qf.travel.service;

import com.qf.travel.vo.PhotoVo;

import java.util.List;

public interface PhotoService {


    List<PhotoVo> listAllPhoto();

    boolean addPhoto(PhotoVo photoVo);

    /* 删除图片 */
    boolean delPhoto(PhotoVo photoVo);

    /*  批量删除图片 */
    boolean delPhotos(PhotoVo photoVo);

    /*  修改图片 */
    boolean updatePhoto(PhotoVo photoVo);

}

package com.qf.travel.service.Impl;

import com.qf.travel.mapper.PhotoMapper;
import com.qf.travel.service.PhotoService;
import com.qf.travel.vo.PhotoVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
public class PhotoServiceImpl implements PhotoService {

    @Autowired
    PhotoMapper photoMapper;

    /* 显示所有photo */
    @Override
    public List<PhotoVo> listAllPhoto() {
        List<PhotoVo> photoVos = photoMapper.listAllPhoto();
        return photoVos;
    }

    /* 增加图片 */
    @Transactional
    @Override
    public boolean addPhoto(PhotoVo photoVo) {
        int count = photoMapper.addPhoto(photoVo);
        boolean flag = false;
        if(count > 0) {
            flag = true;
        }
        return flag;
    }

    /* 删除图片 */
    @Transactional
    @Override
    public boolean delPhoto(PhotoVo photoVo) {
        int count = photoMapper.delPhoto(photoVo);
        boolean flag = false;
        if(count > 0) {
            flag = true;
        }
        return flag;
    }

    /* 批量删除图片 */
    @Transactional
    @Override
    public boolean delPhotos(PhotoVo photoVo) {
        int count = photoMapper.delPhotos(photoVo);
        boolean flag = false;
        if(count > 0) {
            flag = true;
        }
        return flag;
    }

    /* 更新图片 */
    @Transactional
    @Override
    public boolean updatePhoto(PhotoVo photoVo) {
        int count = photoMapper.updatePhoto(photoVo);
        boolean flag = false;
        if(count > 0) {
            flag = true;
        }
        return flag;
    }
}

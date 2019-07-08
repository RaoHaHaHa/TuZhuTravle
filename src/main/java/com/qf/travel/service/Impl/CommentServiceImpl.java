package com.qf.travel.service.Impl;

import com.qf.travel.mapper.CommentMapper;
import com.qf.travel.service.CommentService;
import com.qf.travel.vo.CommentVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    CommentMapper commentMapper;

    /* 显示所有评论 */
    @Override
    public List<CommentVo> listAllComment() {
        List<CommentVo> commentVos = commentMapper.listAllComment();
        return commentVos;
    }

    /* 删除评论 */
    @Transactional
    @Override
    public boolean delComment(CommentVo commentVo) {
        int count = commentMapper.delComment(commentVo);
        boolean flag = false;
        if(count > 0) {
            flag = true;
        }
        return flag;
    }

    /* 批量删除评论 */
    @Transactional
    @Override
    public boolean delComments(CommentVo commentVo) {
        int count = commentMapper.delComments(commentVo);
        boolean flag = false;
        if(count > 0) {
            flag = true;
        }
        return flag;
    }
}

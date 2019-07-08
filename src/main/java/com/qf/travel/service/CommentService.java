package com.qf.travel.service;

import com.qf.travel.vo.CommentVo;

import java.util.List;

public interface CommentService {
    List<CommentVo> listAllComment();
    boolean delComment(CommentVo commentVo);
    boolean delComments(CommentVo commentVo);
}

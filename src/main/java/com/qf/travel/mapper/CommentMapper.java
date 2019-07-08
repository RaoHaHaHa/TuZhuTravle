package com.qf.travel.mapper;

import com.qf.travel.vo.CommentVo;

import java.util.List;

public interface CommentMapper {
    /* 显示所有评论 */
    List<CommentVo> listAllComment();

    /* 删除评论 */
    int delComment(CommentVo commentVo);

    /* 批量刪除评论 */
    int delComments(CommentVo commentVo);
}

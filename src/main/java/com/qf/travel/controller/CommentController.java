package com.qf.travel.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.qf.travel.service.CommentService;
import com.qf.travel.vo.CommentVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;


/*  评论管理 */
@Controller
public class CommentController {

    @Autowired
    CommentService commentService;

    /* 显示所有评论 */
    @RequestMapping(value = "listAllComment",method = RequestMethod.POST)
    @ResponseBody
    public Object listAllComment(@RequestBody(required = false) CommentVo commentVo){
        System.out.println(commentVo);
        PageHelper.startPage(commentVo.getCurrentPage(), commentVo.getPageSize());
        List<CommentVo> userInfoVos = commentService.listAllComment();
        PageInfo<CommentVo> userInfoVoPageInfo = new PageInfo<CommentVo>(userInfoVos);
        System.out.println(userInfoVos);
        return userInfoVoPageInfo;

    }


    /* 删除评论  */
    @RequestMapping(value = "delComment",method = RequestMethod.POST)
    @ResponseBody
    public Object delComment(@RequestBody(required = false) CommentVo commentVo){
        System.out.println(commentVo);
        boolean flag ;
        flag = commentService.delComment(commentVo);
        return flag;
    }

    /* 删除评论  */
    @RequestMapping(value = "delComments",method = RequestMethod.POST)
    @ResponseBody
    public Object delComments(@RequestBody(required = false) CommentVo commentVo){
        System.out.println(commentVo);
        boolean flag ;
        flag = commentService.delComments(commentVo);
        return flag;
    }


}

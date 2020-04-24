package com.lsnu.controller;

import com.lsnu.dto.AjaxResult;
import com.lsnu.model.Comment;
import com.lsnu.service.CommentService;
import com.lsnu.service.PostService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/comment")
public class CommentController {

    private static Log LOG = LogFactory.getLog(CommentController.class);

    @Autowired
    private CommentService commentService;
    @Autowired
    private PostService postService;

    //添加评论
    @RequestMapping(value="/api/addComment", method= RequestMethod.POST)
    @ResponseBody
    public AjaxResult addComment(@RequestBody Comment comment) {
        AjaxResult ajaxResult = new AjaxResult();
        postService.updateReplyNumById(comment.getPostId());
        int commentId = commentService.addComment(comment);
        return new AjaxResult().setData(commentId);
    }

    //删除评论
    @DeleteMapping("/api/deleteComment/{id}")
    public AjaxResult deleteComment(@PathVariable int id) {
        AjaxResult ajaxResult = new AjaxResult();
        boolean result = commentService.deleteCommentById(id);
        return new AjaxResult().setData(result);
    }
}

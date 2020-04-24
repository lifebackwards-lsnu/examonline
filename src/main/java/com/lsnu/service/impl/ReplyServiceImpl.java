package com.lsnu.service.impl;

import com.lsnu.dao.ReplyMapper;
import com.lsnu.model.Reply;
import com.lsnu.service.ReplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("replyService")
public class ReplyServiceImpl implements ReplyService {

    @Autowired
    private ReplyMapper replyMapper;

    @Override
    public int addReply(Reply reply) {
        return replyMapper.insertReply(reply);
    }

    @Override
    public List<Reply> getReliesByPostId(int postId) {
        return replyMapper.getReliesByPostId(postId);
    }
}

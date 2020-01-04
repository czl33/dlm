package service.impl;

import dao.LostComment;
import org.springframework.stereotype.Service;
import service.LostCommentService;

import javax.annotation.Resource;

/**
 * @program: dlm
 * @description: service评论实现类
 * @author: cr
 * @create: 2020-01-04 01:17
 */
@Service
public class LostCommentImp implements LostCommentService {
    @Resource
    LostComment lostComment;
    /*
    插入一条数据
     */
    @Override
    public int instertComment(LostComment lostComment) {
        int i=lostComment.insterComment(lostComment);
        return i;
    }
}

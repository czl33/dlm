package service;

import dao.LostComment;

/**
 * @program: dlm
 * @description: 丢失物评论接口
 * @author: cr
 * @create: 2020-01-04 01:12
 */
public interface LostCommentService {
    //插入一条新的评论
    public int instertComment(LostComment lostComment);


}

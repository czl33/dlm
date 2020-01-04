package controller;

import dao.LostComment;
import entity.Comment;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import service.LostCommentService;
import utils.GsonInfo;

import javax.annotation.Resource;

/**
 * @program: dlm
 * @description: 丢失物评论
 * @author: cr
 * @create: 2020-01-04 01:24
 */
@Controller
public class LoatCommentController {
    @Resource
    LostCommentService lostCommentService;

    @RequestMapping(path = "insterComment", method = RequestMethod.POST,produces = "application/json;charset=utf-8")
    @ResponseBody
    public String insterComment(@RequestBody Comment commt){
        System.out.println(commt.getConMess());
        return GsonInfo.successToJson(commt);
    }
}

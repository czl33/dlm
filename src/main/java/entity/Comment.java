package entity;

import org.springframework.validation.beanvalidation.SpringValidatorAdapter;

/**
 * @program: dlm
 * @description: 评论bean对象
 * @author: cr
 * @create: 2020-01-04 00:54
 */
public class Comment {
    private int id;//评论id
    private int lostId;//丢失物id
    private int uId;//用户id
    private String conMess;//评论内容
    private String PublicTime;//评论发布时间

    public Comment() {
    }

    public Comment(int id, int lostId, int uId, String conMess, String publicTime) {
        this.id = id;
        this.lostId = lostId;
        this.uId = uId;
        this.conMess = conMess;
        PublicTime = publicTime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getLostId() {
        return lostId;
    }

    public void setLostId(int lostId) {
        this.lostId = lostId;
    }

    public int getuId() {
        return uId;
    }

    public void setuId(int uId) {
        this.uId = uId;
    }

    public String getConMess() {
        return conMess;
    }

    public void setConMess(String conMess) {
        this.conMess = conMess;
    }

    public String getPublicTime() {
        return PublicTime;
    }

    public void setPublicTime(String publicTime) {
        PublicTime = publicTime;
    }
}

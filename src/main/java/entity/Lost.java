package entity;

import java.util.ArrayList;
import java.util.Date;

/**
 * @ClassName Lost
 * @Description 寻找失物
 * @Author cxr
 * @Date 2020/01/01 18:27
 */
public class Lost {

    private int lostId;           //失物Id
    private int publishUserId;     //发布用户

    private String publishTitle;  //发布标题
    private String publishDate;     //发布时间
    private String lostMsg;       //失物信息描述（可以是物品描述，也可以是丢失原因描述）
    private String lostImage;     //丢失图片组(ArrayList<String>转成String)
    private String lostDate;        //丢失时间
    private String lostAddress;   //丢失地点
    private String lostUserTel;   //失主电话
    private String lostUserEmail; //失主邮箱
    private String lostUserName;  //失主称呼
    private int publishState = Find.NOT_READ;     //发布状态(已完成/公示中/未发布)


    public Lost() {}

    public Lost(int publishUserId, String publishTitle, String publishDate, String lostMsg, String lostImage, String lostDate,
                String lostAddress, String lostUserTel, String lostUserEmail, String lostUserName, int publishState) {
        this.publishUserId = publishUserId;
        this.publishTitle = publishTitle;
        this.publishDate = publishDate;
        this.lostMsg = lostMsg;
        this.lostImage = lostImage;
        this.lostDate = lostDate;
        this.lostAddress = lostAddress;
        this.lostUserTel = lostUserTel;
        this.lostUserEmail = lostUserEmail;
        this.lostUserName = lostUserName;
        this.publishState = publishState;
    }

    public int getLostId() {
        return lostId;
    }

    public void setLostId(int lostId) {
        this.lostId = lostId;
    }

    public int getPublishUserId() {
        return publishUserId;
    }

    public void setPublishUserId(int publishUserId) {
        this.publishUserId = publishUserId;
    }

    public String getLostDate() {
        return lostDate;
    }

    public void setLostDate(String lostDate) {
        this.lostDate = lostDate;
    }

    public String getLostAddress() {
        return lostAddress;
    }

    public void setLostAddress(String lostAddress) {
        this.lostAddress = lostAddress;
    }

    public String getLostImage() {
        return lostImage;
    }

    public void setLostImage(String lostImage) {
        this.lostImage = lostImage;
    }

    public String getLostMsg() {
        return lostMsg;
    }

    public void setLostMsg(String lostMsg) {
        this.lostMsg = lostMsg;
    }

    public int getPublishState() {
        return publishState;
    }

    public void setPublishState(int publishState) {
        this.publishState = publishState;
    }

    public String getLostUserTel() {
        return lostUserTel;
    }

    public void setLostUserTel(String lostUserTel) {
        this.lostUserTel = lostUserTel;
    }

    public String getLostUserEmail() {
        return lostUserEmail;
    }

    public void setLostUserEmail(String lostUserEmail) {
        this.lostUserEmail = lostUserEmail;
    }

    public String getLostUserName() {
        return lostUserName;
    }

    public void setLostUserName(String lostUserName) {
        this.lostUserName = lostUserName;
    }

    public String getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(String publishDate) {
        this.publishDate = publishDate;
    }

    public String getPublishTitle() {
        return publishTitle;
    }

    public void setPublishTitle(String publishTitle) {
        this.publishTitle = publishTitle;
    }

    @Override
    public String toString() {
        return "Lost{" +
                "lostId=" + lostId +
                ", publishUserId=" + publishUserId +
                ", publishTitle='" + publishTitle + '\'' +
                ", publishDate='" + publishDate + '\'' +
                ", lostMsg='" + lostMsg + '\'' +
                ", lostImage='" + lostImage + '\'' +
                ", lostDate='" + lostDate + '\'' +
                ", lostAddress='" + lostAddress + '\'' +
                ", lostUserTel='" + lostUserTel + '\'' +
                ", lostUserEmail='" + lostUserEmail + '\'' +
                ", lostUserName='" + lostUserName + '\'' +
                ", publishState=" + publishState +
                '}';
    }
}

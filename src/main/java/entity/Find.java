package entity;

import java.util.Date;
/**
 * @ClassName Find
 * @Description 招领失物
 * @Author cxr
 * @Date 2020/01/01 18:28
 */
public class Find {

    public static final int NOT_READ=0;      //未审核
    public static final int PUBLICITY=1;    //公示中
    public static final int FINISH=2;    //已完成
    public static final int READ_FAIL =3;   //审核未通过

    private int findId;           //捡到物品Id
    private int publishUserId;     //发布用户

    private String publishTitle;  //发布标题
    private String publishDate;     //发布时间
    private String findMsg;       //捡到物品信息描述
    private String findImage;     //捡到物品图片组(ArrayList<String>转成String)
    private String findDate;        //捡到物品时间
    private String findAddress;   //捡到物品地点
    private String findUserTel;   //捡到物品者电话
    private String findUserEmail; //捡到物品者邮箱
    private String findUserName;  //捡到物品者称呼
    private int publishState = NOT_READ;     //发布状态(已完成/公示中/未发布)

    public Find() {}

    public Find(int publishUserId, String publishTitle, String publishDate, String findMsg, String findImage,
                String findDate, String findAddress, String findUserTel, String findUserEmail, String findUserName, int publishState) {
        this.publishUserId = publishUserId;
        this.publishTitle = publishTitle;
        this.publishDate = publishDate;
        this.findMsg = findMsg;
        this.findImage = findImage;
        this.findDate = findDate;
        this.findAddress = findAddress;
        this.findUserTel = findUserTel;
        this.findUserEmail = findUserEmail;
        this.findUserName = findUserName;
        this.publishState = publishState;
    }

    public Find(int findId, int publishUserId, String publishTitle, String publishDate, String findMsg, String findImage,
                String findDate, String findAddress, String findUserTel, String findUserEmail, String findUserName, int publishState) {
        this.findId = findId;
        this.publishUserId = publishUserId;
        this.publishTitle = publishTitle;
        this.publishDate = publishDate;
        this.findMsg = findMsg;
        this.findImage = findImage;
        this.findDate = findDate;
        this.findAddress = findAddress;
        this.findUserTel = findUserTel;
        this.findUserEmail = findUserEmail;
        this.findUserName = findUserName;
        this.publishState = publishState;
    }

    public int getFindId() {
        return findId;
    }

    public void setFindId(int findId) {
        this.findId = findId;
    }

    public int getPublishUserId() {
        return publishUserId;
    }

    public void setPublishUserId(int publishUserId) {
        this.publishUserId = publishUserId;
    }

    public String getFindDate() {
        return findDate;
    }

    public void setFindDate(String findDate) {
        this.findDate = findDate;
    }

    public String getFindAddress() {
        return findAddress;
    }

    public void setFindAddress(String findAddress) {
        this.findAddress = findAddress;
    }

    public String getFindImage() {
        return findImage;
    }

    public void setFindImage(String findImage) {
        this.findImage = findImage;
    }

    public String getFindMsg() {
        return findMsg;
    }

    public void setFindMsg(String findMsg) {
        this.findMsg = findMsg;
    }

    public int getPublishState() {
        return publishState;
    }

    public void setPublishState(int publishState) {
        this.publishState = publishState;
    }

    public String getFindUserTel() {
        return findUserTel;
    }

    public void setFindUserTel(String findUserTel) {
        this.findUserTel = findUserTel;
    }

    public String getFindUserEmail() {
        return findUserEmail;
    }

    public void setFindUserEmail(String findUserEmail) {
        this.findUserEmail = findUserEmail;
    }

    public String getFindUserName() {
        return findUserName;
    }

    public void setFindUserName(String findUserName) {
        this.findUserName = findUserName;
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
        return "Find{" +
                "findId=" + findId +
                ", publishUserId=" + publishUserId +
                ", publishTitle='" + publishTitle + '\'' +
                ", publishDate='" + publishDate + '\'' +
                ", findMsg='" + findMsg + '\'' +
                ", findImage='" + findImage + '\'' +
                ", findDate='" + findDate + '\'' +
                ", findAddress='" + findAddress + '\'' +
                ", findUserTel='" + findUserTel + '\'' +
                ", findUserEmail='" + findUserEmail + '\'' +
                ", findUserName='" + findUserName + '\'' +
                ", publishState=" + publishState +
                '}';
    }
}

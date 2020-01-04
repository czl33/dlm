package entity;

/**
 * @auther ckx
 * @description 轮播图
 * @date 2020/1/4
 */
public class Banner {

    private int bId;
    private String bTitle; //标题
    private String bUrl; //路径
    private String bPic; //图片

    public Banner(String bTitle,String bUrl, String bPic) {
        this.bTitle=bTitle;
        this.bUrl = bUrl;
        this.bPic = bPic;
    }

    public String getbTitle() {
        return bTitle;
    }

    public void setbTitle(String bTitle) {
        this.bTitle = bTitle;
    }

    public int getbId() {
        return bId;
    }

    public void setbId(int bId) {
        this.bId = bId;
    }

    public String getbUrl() {
        return bUrl;
    }

    public void setbUrl(String bUrl) {
        this.bUrl = bUrl;
    }

    public String getbPic() {
        return bPic;
    }

    public void setbPic(String bPic) {
        this.bPic = bPic;
    }
}

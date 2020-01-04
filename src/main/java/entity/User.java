package entity;

import java.util.Date;

/**
 * @ClassName User
 * @Description 用户实体类
 * @Author czl
 * @Date 2019/12/31 17:41
 */
public class User {
	private int uId;

	private String uAccNum;//登录账号
	private String uPwd;

	private String uNickName; //昵称
	private int uSex;  //0为男，1为女
	private String uBirthday; //出生日期

	private String uEmail; //邮箱
	private String uTel; //手机号

	private String uAdress;//联系地址

	private String uPic;//头像

	public String getuPic() {
		return uPic;
	}

	public void setuPic(String uPic) {
		this.uPic = uPic;
	}

	public User(){

	}

	public User(String uAccNum, String uPwd, String uNickName, int uSex, String uBirthday, String uEmail, String uTel, String uAdress) {
		this.uAccNum = uAccNum;
		this.uPwd = uPwd;
		this.uNickName = uNickName;
		this.uSex = uSex;
		this.uBirthday = uBirthday;
		this.uEmail = uEmail;
		this.uTel = uTel;
		this.uAdress = uAdress;
		this.uPic="default.jpg";
	}

	public int getuId() {
		return uId;
	}

	public void setuId(int uId) {
		this.uId = uId;
	}

	public String getuAccNum() {
		return uAccNum;
	}

	public void setuAccNum(String uAccNum) {
		this.uAccNum = uAccNum;
	}

	public String getuPwd() {
		return uPwd;
	}

	public void setuPwd(String uPwd) {
		this.uPwd = uPwd;
	}

	public String getuNickName() {
		return uNickName;
	}

	public void setuNickName(String uNickName) {
		this.uNickName = uNickName;
	}

	public int getuSex() {
		return uSex;
	}

	public void setuSex(int uSex) {
		this.uSex = uSex;
	}

	public String getuBirthday() {
		return uBirthday;
	}

	public void setuBirthday(String uBirthday) {
		this.uBirthday = uBirthday;
	}

	public String getuEmail() {
		return uEmail;
	}

	public void setuEmail(String uEmail) {
		this.uEmail = uEmail;
	}

	public String getuTel() {
		return uTel;
	}

	public void setuTel(String uTel) {
		this.uTel = uTel;
	}

	public String getuAdress() {
		return uAdress;
	}

	public void setuAdress(String uAdress) {
		this.uAdress = uAdress;
	}

	@Override
	public String toString() {
		return "User{" +
				"uId=" + uId +
				", uAccNum='" + uAccNum + '\'' +
				", uPwd='" + uPwd + '\'' +
				", uNickName='" + uNickName + '\'' +
				", uSex=" + uSex +
				", uBirthday=" + uBirthday +
				", uEmail='" + uEmail + '\'' +
				", uTel='" + uTel + '\'' +
				", uAdress='" + uAdress + '\'' +
				'}';
	}
}

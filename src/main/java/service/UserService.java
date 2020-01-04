package service;

import entity.User;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @ClassName UserService
 * @Description 用户服务接口
 * @Author czl
 * @Date 2019/12/31 17:41
 */

public interface UserService {
	public List<User> getAll();//获取所有
	public String login(String  uAccNum,String uPwd); //判断是否能登陆
	public String register(String uAccNum,String uPwd,String uPwdAgain,String uNickName,String uSex,String uBirthday,String uEmail,String uTel,String uAdress );

	public String delete(String uId); //删除指定的用户

	//修改用户
	public String updUser(String uId,String uAccNum, String uPwd, String uPwdAgain, String uNickName, String uSex, String uBirthday, String uEmail, String uTel, String uAdress);

	//邮箱校验
	public String uEmailJY(String uEmail); //删除指定的用户

	//修改头像
    public String updUPic(int uId, MultipartFile file, HttpServletRequest request);

    String getUserPage(int page, int entry, String searchKey);
}

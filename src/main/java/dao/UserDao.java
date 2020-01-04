package dao;

import entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @ClassName UserDao
 * @Description 用户数据库访问类
 * @Author czl
 * @Date 2019/12/31 17:41
 */
public interface UserDao {
    public List<User> getAll(); //查询所有用户

    public User findByUId(int uId); //查询用户  id

    public User findByNumPswd(User user);//查询用户 账号密码

    public User  findByUAccNum(String  uAccNum); //查询用户  uAccNum

    public User findUserByUTel(String uTel); //查询用户 电话

    public User findUserByUEmail(String uEmail); //查询用户 邮箱

    public int addUser(User user); //添加用户

    public int updataUser(User user);//修改用户

    public int delUser(int uId); //删除用户

    public int updUPic(int uId,String uPic); //修改用户头像

    public int getUserCount();//返回用户的数量


    public List<User> getUserByKey(@Param("startIndex")int startIndex,@Param("endIndex")int endIndex,@Param("key")String key);//查询分页

}

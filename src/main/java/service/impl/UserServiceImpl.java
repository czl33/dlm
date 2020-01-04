package service.impl;

import com.google.gson.Gson;
import dao.UserDao;
import entity.User;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import service.UserService;
import utils.GsonInfo;
import utils.UploadUtils;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
/**
 * @ClassName UserServiceImpl
 * @Description 用户服务实现类
 * @Author czl
 * @Date 2019/12/31 17:41
 */
@Service
public class UserServiceImpl implements UserService {

    @Resource
    UserDao userDao;//数据访问对象

    @Override
    public List<User> getAll() {
        List<User> all = userDao.getAll();
        return all;
    }

    /**
     *
     * @param uAccNum
     * @param uPwd
     * @return 登陆
     */
    @Override
    public String login(String  uAccNum,String uPwd) {
        if(uAccNum!=null &&uAccNum.length()>0 && uPwd!=null&&uPwd.length()>0){
//            User user=new User();
//            user.setuAccNum(uAccNum);
//            user.setuPwd(uPwd);
            System.out.println("账号:  "+uAccNum+",密码： "+uPwd);
            User  datas = userDao.findByUAccNum(uAccNum);
            if(datas!=null){
                System.out.println("有数据：");
                String msg;
                try{
                        if(datas.getuPwd().trim().equals(uPwd.trim())){

                            msg=GsonInfo.successToJson((datas));
                        }else {
                            msg=GsonInfo.failToJson("登陆的密码错误");
                        }

                    }catch (Exception e){
                        msg=GsonInfo.failToJson(e.getMessage().toString());
                    }
                return msg;
            }
            return   GsonInfo.failToJson("登陆的账号或密码错误");
        }
        return GsonInfo.failToJson("登陆的账号或密码不为空");

    }

    /**
     *
     * @param uAccNum
     * @param uPwd
     * @param uPwdAgain
     * @param uNickName
     * @param uSex
     * @param uBirthday
     * @param uEmail
     * @param uTel
     * @param uAdress
     * @return 注册
     */
    @Override
    public String register(String uAccNum, String uPwd, String uPwdAgain, String uNickName, String uSex, String uBirthday, String uEmail, String uTel, String uAdress) {
        if(!uPwd.equals(uPwdAgain)){
            return GsonInfo.failToJson("两次输入的密码不一致");
        }
        User user=new User(uAccNum,uPwd,uNickName,Integer.parseInt(uSex),uBirthday,uEmail,uTel,uAdress);
        //这边要进行登陆账号，email,tel的校验

        if(userDao.findByUAccNum(uAccNum)!=null)return GsonInfo.failToJson("账号已存在");
        if(userDao.findUserByUTel(uTel)!=null)return GsonInfo.failToJson("电话已绑定");
        if(userDao.findUserByUEmail(uEmail)!=null)return GsonInfo.failToJson("邮箱已绑定");

        int i = userDao.addUser(user);
        if(i>0){
            return GsonInfo.successToJson("注册成功");
        }
        return GsonInfo.failToJson("注册失败");
    }

    /**
     * 这是一个删除的方法
     * @param uId
     * @return
     */
    @Override
    public String delete(String uId) {
        String msg="";
        System.out.println("删除的用户id为："+uId);
        try {
            int i = userDao.delUser(Integer.parseInt(uId.trim()));

            if(i>0)msg=GsonInfo.successToJson("删除成功");
        }catch (Exception e){
            msg= GsonInfo.failToJson(e.getMessage().toString());
        }
        return msg;
    }

    @Override
    public String updUser(String uId, String uAccNum, String uPwd, String uPwdAgain, String uNickName, String uSex, String uBirthday, String uEmail, String uTel, String uAdress) {

        if(!uPwd.equals(uPwdAgain)){
            return GsonInfo.failToJson("两次输入的密码不一致");
        }
        User user=new User(uAccNum,uPwd,uNickName,Integer.parseInt(uSex),uBirthday,uEmail,uTel,uAdress);
       user.setuId(Integer.parseInt(uId));
        int i = userDao.updataUser(user);
        if(i>0){
            return GsonInfo.successToJson("修改成功");
        }
        return GsonInfo.failToJson("修改失败失败");
    }

    @Override
    public String uEmailJY(String uEmail) {
        if(userDao.findUserByUEmail(uEmail)!=null)return GsonInfo.failToJson("邮箱已存在");
        return GsonInfo.successToJson("邮箱不存在，可以注册");

    }

    @Override
    public String updUPic(int uId, MultipartFile file, HttpServletRequest request) {
        String msg=GsonInfo.failToJson("未知错误");
        try{
            String upload = UploadUtils.Upload(file, request);
            int i = userDao.updUPic(uId, upload);
            if(i>0){
                User u = userDao.findByUId(uId);
                msg=GsonInfo.successToJson(u);
            }else {
                msg=GsonInfo.failToJson("修改失败");
            }

        }catch (Exception e){
            msg=GsonInfo.failToJson("错误类型: "+e.getMessage().toString());
        }finally {
            return msg;
        }
    }

    @Override  //获取用户条数
    public String getUserPage(int page, int entry, String searchKey) {
        int userCount = userDao.getUserCount();
        String msg="";
        int startIndex=0;
        int endIndex=0;

        if(userCount>0){
            startIndex=entry*page-5;
            if(entry*page<=userCount){
                endIndex=entry*entry;
            }else {
                endIndex=userCount;
            }
        }
        try {
            List<User> userByKey = userDao.getUserByKey(startIndex, endIndex, searchKey);
            msg=GsonInfo.successListToJson(userByKey,userCount);
        }catch (Exception e){
            msg=GsonInfo.failToJson(e.getMessage().toString());
        }finally {

            return  msg;
        }
    }

}

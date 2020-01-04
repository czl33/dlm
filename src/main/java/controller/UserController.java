package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import service.impl.UserServiceImpl;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@Controller
public class UserController {
    @Resource
    private UserServiceImpl userService;//用户服务实现类

    /**
     *登陆
     * @param uAccNum
     * @param uPwd
     * @return GsonInfo
     */
    @RequestMapping(value = "logUser",method = RequestMethod.POST,produces = "text/plain;charset=utf-8")
    @ResponseBody
        public String logUser(@RequestParam(name = "uAccNum") String  uAccNum,
                        @RequestParam(name = "uPwd") String uPwd){
//        System.out.println("uAccNum"+uAccNum);
        System.out.println("uAccNum"+uPwd);
        String str=userService.login(uAccNum,uPwd);
        System.out.println("json: "+str);
        return str;
    }

    /**
     *注册
     * @param uAccNum
     * @param uPwd
     * @param uPwdAgain
     * @param uNickName
     * @param uSex
     * @param uBirthday
     * @param uEmail
     * @param uTel
     * @param uAdress
     * @return GsonInfo
     */
    @RequestMapping(value = "regUser",method = RequestMethod.POST,produces = "text/plain;charset=utf-8")
    @ResponseBody
    public String regUser(@RequestParam(name = "uAccNum") String  uAccNum,
                            @RequestParam(name = "uPwd") String uPwd,
                               @RequestParam(name = "uPwdAgain") String uPwdAgain,
                           @RequestParam(name = "uNickName") String uNickName,
                           @RequestParam(name = "uSex") String uSex,
                           @RequestParam(name = "uBirthday") String uBirthday,
                           @RequestParam(name = "uEmail") String uEmail,
                           @RequestParam(name = "uTel") String uTel,
                           @RequestParam(name = "uAdress") String uAdress
                           ){

//        System.out.println("uAccNum"+uAccNum);
//        System.out.println("uAccNum"+uPwd);
        return userService.register(uAccNum,uPwd,uPwdAgain,uNickName,uSex,uBirthday,
                uEmail,uTel,uAdress);
    }

//    /**删除功能
//     ** @param uId
//     * @return GsonInfo
//     */
//    @RequestMapping(value = "delUser",method = RequestMethod.POST)
//    @ResponseBody
//    public String delUser(@RequestParam(name = "uId") String  uId){
////        System.out.println("uAccNum"+uAccNum);
////        System.out.println("uAccNum"+uPwd);
//        return userService.delete(uId);
//    }

    /**
     *修改
     * @param uAccNum
     * @param uPwd
     * @param uPwdAgain
     * @param uNickName
     * @param uSex
     * @param uBirthday
     * @param uEmail
     * @param uTel
     * @param uAdress
     * @return GsonInfo
     */
    @RequestMapping(value = "updUser",method = RequestMethod.POST,produces = "text/plain;charset=utf-8")
    @ResponseBody
    public String updUser(@RequestParam(name = "uAccNum") String  uAccNum,
                          @RequestParam(name = "uId") String uId,
                          @RequestParam(name = "uPwd") String uPwd,
                           @RequestParam(name = "uPwdAgain") String uPwdAgain,
                           @RequestParam(name = "uNickName") String uNickName,
                           @RequestParam(name = "uSex") String uSex,
                           @RequestParam(name = "uBirthday") String uBirthday,
                           @RequestParam(name = "uEmail") String uEmail,
                           @RequestParam(name = "uTel") String uTel,
                           @RequestParam(name = "uAdress") String uAdress
    ){

//        System.out.println("uAccNum"+uAccNum);
//        System.out.println("uAccNum"+uPwd);
        return userService.updUser(uId,uAccNum,uPwd,uPwdAgain,uNickName,uSex,uBirthday,
                uEmail,uTel,uAdress);
    }

    /**
     * 修改用户头像
     * @param request
     * @param uId uid
     * @param file 上传一张
     * @return
     */
    @RequestMapping(value = "updUPic",method = RequestMethod.POST,produces = "text/plain;charset=utf-8")
    @ResponseBody
    public String updUPic(HttpServletRequest request,
                          @RequestParam(name = "uId") int uId,
                          @RequestParam(value="uPic",required=false)MultipartFile[] file
                        ){
        System.out.println("--------正在上传图片-------");
        String s = userService.updUPic(uId, file[0], request);
        System.out.println(s);
        return s;
    }

    /**删除功能
     ** @param uEmail
     * @return GsonInfo
     */
    @RequestMapping(value = "emailJY",method = RequestMethod.POST,produces = "text/plain;charset=utf-8")
    @ResponseBody
    public String uEmailJY(@RequestParam(name = "uEmail") String  uEmail){
//        System.out.println("uAccNum"+uAccNum);
//        System.out.println("uAccNum"+uPwd);
        return userService.uEmailJY(uEmail);
    }

    /**获取第page页的数据
     * 分类
     * @param page  第几页
     * @param entry  每页的个数
     * @param searchKey 查找的关键字 {uAccNum,uNickName,uEmail,uTel }
     * @return list<User>
     */
    @RequestMapping(path = "getUserPage",method = RequestMethod.GET,produces = "text/plain;charset=utf-8")
    @ResponseBody
    public String getUserPage(@RequestParam(name ="page" )int page,
                           @RequestParam(name = "entry") int entry,
                           @RequestParam(name = "searchKey") String searchKey){
        String str;
        str = userService.getUserPage(page,entry,searchKey);
        System.out.println(str);
        return str;
    }
}

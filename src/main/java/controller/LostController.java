package controller;

import entity.Lost;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import service.impl.LostServiceImpl;
import utils.GsonInfo;
import utils.UploadUtils;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @program: dlm
 * @description: lost控制类
 * @author: cxr
 * @create: 2020-01-02 10:26
 */

@Controller
public class LostController {
    @Resource
    LostServiceImpl lostService;

    /**
     * 发布失物信息
     * 传递参数Lost类参数
     */
    @RequestMapping(value = "publishLost", method = RequestMethod.POST,produces = "text/plain;charset=utf-8")
    @ResponseBody
    public String publishLost(HttpServletRequest request, int publishUserId, String publishTitle, String publishDate,
                          String lostMsg, @RequestParam("file") MultipartFile[] file , String lostDate,
                          String lostAddress, String lostUserTel, String lostUserEmail, String lostUserName)throws Exception{

        String lostImage = "";
        Lost lost = new Lost( publishUserId, publishTitle, publishDate, lostMsg, lostImage, lostDate,
                lostAddress, lostUserTel, lostUserEmail, lostUserName, 0);

        if (file != null && file.length > 0){
            List files = new ArrayList<String>();
            for (int i = 0; i < file.length ; i++) {
                MultipartFile multipartFile = file[i];
                if (!multipartFile.isEmpty()){
                    String path= UploadUtils.Upload(multipartFile, request);
                    files.add(path);
                }
            }
            System.out.println("files:"+files);

            HashMap<String,List> map=new HashMap<>();
            map.put("src",files);
            lostImage = GsonInfo.ListToJson(map);
            lost.setLostImage(lostImage);
        }



        return lostService.publishLost(lost);
    }



    /**
     * 修改失物信息状态
     * 传递参数 lostId,state(失物id,失物状态)
     */
    @RequestMapping(value = "updateLostPublishState", method = RequestMethod.POST,produces = "text/plain;charset=utf-8")
    @ResponseBody
    public String updateLostPublishState(int lostId,int state){
        return lostService.updateLostPublishState(lostId,state);
    }



    /**
     * 修改失物信息
     * 传递参数
     */
    @RequestMapping(value = "updateLost", method = RequestMethod.POST,produces = "text/plain;charset=utf-8")
    @ResponseBody
    public String updateLost(HttpServletRequest request, int lostId, String publishTitle,  String lostMsg, @RequestParam("file") MultipartFile[] file,
                             String lostDate, String lostAddress, String lostUserTel, String lostUserEmail, String lostUserName){

        Lost lost = new Lost();
        String lostImage = "";
        if (file != null && file.length > 0){
            List files = new ArrayList<String>();
            for (int i = 0; i < file.length ; i++) {
                MultipartFile multipartFile = file[i];
                if (!multipartFile.isEmpty()){
                    String path= UploadUtils.Upload(multipartFile, request);
                    files.add(path);
                }
            }
            System.out.println("files:"+files);
            if (files != null && files.size() !=0){
                HashMap<String,List> map=new HashMap<>();
                map.put("src",files);
                lostImage = GsonInfo.ListToJson(map);
                lost.setLostImage(lostImage);
            }
        }
        lost.setLostId(lostId);
        lost.setPublishTitle(publishTitle);
        lost.setLostMsg(lostMsg);
        lost.setLostDate(lostDate);
        lost.setLostAddress(lostAddress);
        lost.setLostUserTel(lostUserTel);
        lost.setLostUserEmail(lostUserEmail);
        lost.setLostUserName(lostUserName);
        return lostService.updateLost(lost);
    }


    /**
     * 根据id查询失物信息
     * 传递参数 lostId(失物id)
     */
    @RequestMapping(value = "getLostById", method = RequestMethod.GET,produces = "text/plain;charset=utf-8")
    @ResponseBody
    public String getLostById(int lostId){
        return lostService.getLostById(lostId);
    }

    /**
     * 查询全部失物信息
     */
    @RequestMapping(value = "getAllLost", method = RequestMethod.GET,produces = "text/plain;charset=utf-8")
    @ResponseBody
    public String getAllLost(){
        return lostService.getAllLost();
    }

    /**
     * 根据用户id 查询用户发布的全部失物信息
     * 传递参数 userId
     */
    @RequestMapping(value = "getAllLostByUserId", method = RequestMethod.GET,produces = "text/plain;charset=utf-8")
    @ResponseBody
    public String getAllLostByUserId(int userId){
        return lostService.getAllLostByUserId(userId);
    }

    /**
     * 根据id 删除失物信息
     * 传递参数 findId
     */
    @RequestMapping(value = "delLostByLostId", method = RequestMethod.GET,produces = "text/plain;charset=utf-8")
    @ResponseBody
    public String delLostByLostId(int lostId){
        return lostService.delLostByLostId(lostId);
    }

    /**
     * 根据状态 查询各种状态的全部失物信息
     * 传递参数 state
     */
    @RequestMapping(path = "getAllLostByState", method = RequestMethod.GET,produces = "text/plain;charset=utf-8")
    @ResponseBody
    public String getAllLostByState(int state){
        return lostService.getAllLostByState(state);
    }

    /**
     * 分页
     * 根据传输的页码，行数，key   查询失物信息
     * 传递参数 page、count、key
     */
    @RequestMapping(value = "getLostDataByLimit", method = RequestMethod.GET,produces = "text/plain;charset=utf-8")
    @ResponseBody
    public String getLostDataByLimit(int page, int count, String key){

        return lostService.getLostDataByLimit(page,count,key);
    }

    /**
     * 公示状态分页
     * 根据传输的页码，行数，key   查询招领信息
     * 传递参数 page、count、key
     */
    @RequestMapping(value = "getDataByLostPublishState", method = RequestMethod.GET,produces = "text/plain;charset=utf-8")
    @ResponseBody
    public String getDataByLostPublishState(int page, int count, String key){

        return lostService.getDataByLostPublishState(page,count,key);
    }

    /**
     * 未审核以及已完成状态分页
     * 根据传输的页码，行数，key   查询招领信息
     * 传递参数 page、count、key
     */
    @RequestMapping(value = "getDataByLostNoReadState", method = RequestMethod.GET,produces = "text/plain;charset=utf-8")
    @ResponseBody
    public String getDataByLostNoReadState(int page, int count, String key){

        return lostService.getDataByLostNoReadState(page,count,key);
    }

    /**
     * 未通过审核状态分页
     * 根据传输的页码，行数，key   查询招领信息
     * 传递参数 page、count、key
     */
    @RequestMapping(value = "getDataByLostReadFailState", method = RequestMethod.GET,produces = "text/plain;charset=utf-8")
    @ResponseBody
    public String getDataByLostReadFailState(int page, int count, String key){

        return lostService.getDataByLostReadFailState(page,count,key);
    }


}

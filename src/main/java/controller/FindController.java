package controller;

import entity.Find;
import entity.Lost;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import service.impl.FindServiceImpl;
import utils.GsonInfo;
import utils.UploadUtils;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Controller
public class FindController {

    @Resource
    private FindServiceImpl findService;   //招领服务实现类

    /**
     * 发布招领信息
     * 传递参数Find类参数
     */

    @RequestMapping(value = "publishFind", method = RequestMethod.POST,produces = "text/plain;charset=utf-8")
    @ResponseBody
    public String addFind(HttpServletRequest request,int publishUserId, String publishTitle, String publishDate,
                          String findMsg, @RequestParam("file") MultipartFile[] file , String findDate,
                          String findAddress, String findUserTel, String findUserEmail, String findUserName)throws Exception{

        String findImage = "";
        Find find = new Find( publishUserId,  publishTitle,  publishDate,  findMsg,  findImage,  findDate,
                findAddress,  findUserTel,  findUserEmail,  findUserName,  0);

        if (file != null && file.length > 0){
            List files = new ArrayList<String>();
            for (int i = 0; i < file.length ; i++) {
                MultipartFile multipartFile = file[i];
                if (!multipartFile.isEmpty()){
                    String path= UploadUtils.Upload(multipartFile, request);
                    files.add(path);
                }
            }
            HashMap<String,List> map=new HashMap<>();
            map.put("src",files);
            findImage = GsonInfo.ListToJson(map);
            find.setFindImage(findImage);
        }


        System.out.println("结果："+find.toString());

        return findService.publishFind(find);
    }



    /**
     * 修改招领信息状态
     * 传递参数 findId,state(招领id,招领状态)
     */
    @RequestMapping(value = "updatePublishState", method = RequestMethod.POST,produces = "text/plain;charset=utf-8")
    @ResponseBody
    public String updatePublishState(int findId,int state){
        return findService.updatePublishState(findId,state);
    }



    /**
     * 修改招领信息
     * 传递参数
     */
    @RequestMapping(value = "updateFind", method = RequestMethod.POST,produces = "text/plain;charset=utf-8")
    @ResponseBody
    public String updateFind(HttpServletRequest request, int findId, String publishTitle,  String findMsg, @RequestParam("file") MultipartFile[] file,
                             String findDate, String findAddress, String findUserTel, String findUserEmail, String findUserName){
        String findImage = "";
        Find find = new Find();

        if (file != null && file.length > 0){
            List files = new ArrayList<String>();
            for (int i = 0; i < file.length ; i++) {
                MultipartFile multipartFile = file[i];
                if (!multipartFile.isEmpty()){
                    String path= UploadUtils.Upload(multipartFile, request);
                    files.add(path);
                }
            }
            if (files != null && files.size() !=0){
                HashMap<String,List> map=new HashMap<>();
                map.put("src",files);
                findImage = GsonInfo.ListToJson(map);
                find.setFindImage(findImage);
            }
        }
        find.setFindId(findId);
        find.setPublishTitle(publishTitle);
        find.setFindMsg(findMsg);
        find.setFindDate(findDate);
        find.setFindAddress(findAddress);
        find.setFindUserTel(findUserTel);
        find.setFindUserEmail(findUserEmail);
        find.setFindUserName(findUserName);

        return findService.updateFind(find);
    }


    /**
     * 根据id查询招领信息
     * 传递参数 findId(招领id)
     */
    @RequestMapping(value = "getFindById", method = RequestMethod.GET,produces = "text/plain;charset=utf-8")
    @ResponseBody
    public String getFindById(int findId){
        return findService.getFindById(findId);
    }

    /**
     * 查询全部招领信息
     */
    @RequestMapping(value = "getAllFind", method = RequestMethod.GET,produces = "text/plain;charset=utf-8")
    @ResponseBody
    public String getAllFind(){
        return findService.getAllFind();
    }

    /**
     * 根据用户id 查询用户发布的全部招领信息
     * 传递参数 UserId
     */
    @RequestMapping(value = "getAllFindByUserId", method = RequestMethod.GET,produces = "text/plain;charset=utf-8")
    @ResponseBody
    public String getAllFindByUserId(int UserId){
        return findService.getAllFindByUserId(UserId);
    }

    /**
     * 根据id 删除招领信息
     * 传递参数 findId
     */
    @RequestMapping(value = "delFindByFindId", method = RequestMethod.GET,produces = "text/plain;charset=utf-8")
    @ResponseBody
    public String delFindByFindId(int findId){
        return findService.delFindByFindId(findId);
    }

    /**
     * 根据状态 查询各种状态的全部招领信息
     * 传递参数 state
     */
    @RequestMapping(path = "getAllFindByState", method = RequestMethod.GET,produces = "text/plain;charset=utf-8")
    @ResponseBody
    public String getAllFindByState(int state){
        return findService.getAllFindByState(state);
    }

    /**
     * 分页
     * 根据传输的页码，行数，key   查询招领信息
     * 传递参数 page、count、key
     */
    @RequestMapping(value = "getDataByLimit", method = RequestMethod.GET,produces = "text/plain;charset=utf-8")
    @ResponseBody
    public String getDataByLimit(int page, int count, String key){

        return findService.getDataByLimit(page,count,key);
    }

    /**
     * 查询全部招领信息的总条数
     */
    @RequestMapping(value = "getAllFindCount", method = RequestMethod.GET,produces = "text/plain;charset=utf-8")
    @ResponseBody
    public String getAllFindCount(){
        return findService.getAllFindCount();
    }

    /**
     * 公示状态分页
     * 根据传输的页码，行数，key   查询招领信息
     * 传递参数 page、count、key
     */
    @RequestMapping(value = "getDataByPublishState", method = RequestMethod.GET,produces = "text/plain;charset=utf-8")
    @ResponseBody
    public String getDataByPublishState(int page, int count, String key){

        return findService.getDataByPublishState(page,count,key);
    }

    /**
     * 未审核以及已完成状态分页
     * 根据传输的页码，行数，key   查询招领信息
     * 传递参数 page、count、key
     */
    @RequestMapping(value = "getDataByNoReadState", method = RequestMethod.GET,produces = "text/plain;charset=utf-8")
    @ResponseBody
    public String getDataByNoReadState(int page, int count, String key){

        return findService.getDataByNoReadState(page,count,key);
    }

    /**
     * 未通过审核状态分页
     * 根据传输的页码，行数，key   查询招领信息
     * 传递参数 page、count、key
     */
    @RequestMapping(value = "getDataByReadFailState", method = RequestMethod.GET,produces = "text/plain;charset=utf-8")
    @ResponseBody
    public String getDataByReadFailState(int page, int count, String key){

        return findService.getDataByReadFailState(page,count,key);
    }

}

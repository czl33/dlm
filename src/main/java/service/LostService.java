package service;

import entity.Lost;

import java.util.List;

/**
 * @ClassName LostService
 * @Description 失物信息接口
 * @Author cxr
 * @Date 2020/01/02 20:15
 */


public interface LostService {

    public String publishLost(Lost lost);       //捡到者 发布失物失物

    public String updateLost(Lost lost);        //修改失物

    public String updateLostPublishState(int lostId, int state);     //修改失物

    public String getLostById(int lostId);      //根据id获取失物信息

    public String getAllLost();                //获取全部失物信息

    public String getAllLostByUserId(int userId);   //根据用户id获取用户所有失物信息

    public String delLostByLostId(int lostId);   //根据失物id删除失物信息

    public String getAllLostByState(int state);        //获取各种状态下的失物信息

    public String getLostDataByLimit(int page, int count, String key);        //分页

//    public String getAllLostCount();        //得到全部数量

    public String getDataByLostPublishState(int page, int count, String key);        //公示状态分页
    public String getDataByLostNoReadState(int page, int count, String key);         //未审核以及已完成状态分页
    public String getDataByLostReadFailState(int page, int count, String key);       //未通过审核状态分页
}

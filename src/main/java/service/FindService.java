package service;

import entity.Find;
import entity.User;

import java.util.List;

/**
 * @ClassName FindService
 * @Description 用户服务接口
 * @Author cxr
 * @Date 2020/01/01 20:15
 */

public interface FindService {

	public String publishFind(Find find);       //捡到者 发布招领失物
	public String updateFind(Find find);        //修改招领
	public String updatePublishState(int findId, int state);     //修改招领
	public String getFindById(int findId);      //根据id获取招领信息
	public String getAllFind();                //获取全部招领信息
	public String getAllFindByUserId(int UserId);   //根据用户id获取用户所有招领信息
	public String delFindByFindId(int findId);   //根据招领id删除招领信息

	public String getAllFindByState(int state);        //获取各种状态下的招领信息

	public String getDataByLimit(int page, int count, String key);        //分页
	public String getAllFindCount();        //得到全部数量

	public String getDataByPublishState(int page, int count, String key);        //公示状态分页
	public String getDataByNoReadState(int page, int count, String key);         //未审核以及已完成状态分页
	public String getDataByReadFailState(int page, int count, String key);       //未通过审核状态分页


}

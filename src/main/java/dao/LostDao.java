package dao;

import entity.Find;
import entity.Lost;
import entity.Lost;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @program: dlm
 * @description: 丢失
 * @author: cxr
 * @create: 2020-01-02 09:39
 */
public interface LostDao {

    public int publishLost(Lost lost);    //捡到者 发布失物信息

    public int updateLost(Lost lost);     //修改失物

    public int updateLostPublishState(Lost lost);     //修改失物

    public Lost getLostById(int lostId);   //根据id获取失物信息

    public List<Lost> getAllLost();        //获取全部失物信息

    public List<Lost> getAllLostByUserId(int userId);   //根据用户id获取用户所有失物信息

    public int delLostByLostId(int lostId);   //根据用户id获取用户所有失物信息

    public List<Lost> getAllLostByState(int state);        //获取各种状态下的失物信息

    //分页获取数据
    public List<Lost> getDataByLimit(@Param("page") int page, @Param("count") int count, @Param("key") String key);

    public int getAllLostCount();  //得到总共条数

    public int getLikeCount(@Param("key") String key);   //模糊查询得到总共条数

    //公示状态分页
    public List<Lost> getDataByLostPublishState(@Param("page") int page, @Param("count") int count, @Param("key") String key);

    //未审核以及已完成状态分页
    public List<Lost> getDataByLostNoReadState(@Param("page") int page, @Param("count") int count, @Param("key") String key);

    //未通过审核状态分页
    public List<Lost> getDataByLostReadFailState(@Param("page") int page, @Param("count") int count, @Param("key") String key);

    //模糊查询下，公示中状态的总共条数
    public int getCountByLostPublishState(@Param("key") String key);

    //模糊查询下，未审核以及已完成状态的总共条数
    public int getCountByLostNoReadState(@Param("key") String key);

    //模糊查询下，没有通过审核状态的总共条数
    public int getCountByLostReadFailState(@Param("key") String key);
}

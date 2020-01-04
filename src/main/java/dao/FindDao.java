package dao;

import entity.Find;
import entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @ClassName FindDao
 * @Description 招领数据库访问类
 * @Author cxr
 * @Date 2020/01/01 18:31
 */
public interface FindDao {

    public int publishFind(Find find);    //捡到者 发布招领失物

    public int updateFind(Find find);     //修改招领

    public int updatePublishState(Find find);     //修改招领

    public Find getFindById(int findId);   //根据id获取招领信息

    public List<Find> getAllFind();        //获取全部招领信息

    public List<Find> getAllFindByUserId(int UserId);   //根据用户id获取用户所有招领信息

    public int delFindByFindId(int findId);   //根据用户id获取用户所有招领信息

    public List<Find> getAllFindByState(int state);        //获取各种状态下的招领信息

    public List<Find> getDataByLimit(@Param("page") int page, @Param("count") int count, @Param("key") String key);        //分页获取数据

    public int getAllFindCount();  //得到总共条数

    public int getLikeCount(@Param("key") String key);   //模糊查询得到总共条数



    //公示状态分页
    public List<Find> getDataByPublishState(@Param("page") int page, @Param("count") int count, @Param("key") String key);
    //未审核以及已完成状态分页
    public List<Find> getDataByNoReadState(@Param("page") int page, @Param("count") int count, @Param("key") String key);
    //未通过审核状态分页
    public List<Find> getDataByReadFailState(@Param("page") int page, @Param("count") int count, @Param("key") String key);

    public int getCountByPublishState(@Param("key") String key);   //模糊查询下，公示中状态的总共条数

    public int getCountByNoReadState(@Param("key") String key);   //模糊查询下，未审核以及已完成状态的总共条数

    public int getCountByReadFailState(@Param("key") String key);   //模糊查询下，没有通过审核状态的总共条数
}

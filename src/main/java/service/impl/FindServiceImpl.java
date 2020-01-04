package service.impl;

import dao.FindDao;
import dao.UserDao;
import entity.Find;
import entity.Lost;
import entity.User;
import org.springframework.stereotype.Service;
import service.FindService;
import service.UserService;
import utils.GsonInfo;

import javax.annotation.Resource;
import java.sql.SQLException;
import java.util.List;

/**
 * @ClassName FindService
 * @Description 用户服务接口
 * @Author cxr
 * @Date 2020/01/01 20:16
 */
@Service
public class FindServiceImpl implements FindService {

    @Resource
    FindDao findDao;//数据访问对象

    //发布招领信息      传递参数Find类
    @Override
    public String publishFind(Find find) {
        try {
            int i = findDao.publishFind(find);
            if (i>0){
                return GsonInfo.successToJson(find.getFindId());
            }else {
                return GsonInfo.failToJson("发布失败！");
            }

        }catch (Exception e){
            System.out.println("--------------------------------------------");
            System.out.println("错误："+e.getMessage().toString());
            return GsonInfo.failToJson("发布失败！");
        }

    }

    //修改招领信息       传递参数Find类
    @Override
    public String updateFind(Find find) {
        try {
            int i = findDao.updateFind(find);
            if (i>0){
                return GsonInfo.successToJson("修改招领信息成功");
            }else {
                return GsonInfo.failToJson("修改招领信息失败！");
            }
        }catch (Exception e){
            System.out.println("--------------------------------------------");
            System.out.println("错误："+e.getMessage().toString());
            return GsonInfo.failToJson("修改招领信息失败！");
        }
    }

    //修改招领信息状态    传递参数 findId,state(招领id,招领状态)
    @Override
    public String updatePublishState(int findId,int state) {
        Find find = new Find();
        find.setFindId(findId);
        find.setPublishState(state);
        try {
            int i = findDao.updatePublishState(find);
            if (i>0){
                return GsonInfo.successToJson("修改状态成功");
            }else {
                return GsonInfo.failToJson("修改状态失败");
            }
        }catch (Exception e){
            System.out.println("--------------------------------------------");
            System.out.println("错误："+e.getMessage().toString());
            return GsonInfo.failToJson("修改状态失败");
        }
    }

    //根据Find类的id返回Find    传递参数 findId(招领id)
    @Override
    public String getFindById(int findId) {
        try {
            Find find = findDao.getFindById(findId);
            if (find!=null){
                return GsonInfo.successToJson(find);
            }else {
                return GsonInfo.failToJson("获取招领信息失败！");
            }
        }catch (Exception e){
            System.out.println("--------------------------------------------");
            System.out.println("错误："+e.getMessage().toString());
            return GsonInfo.failToJson("获取招领信息失败！");
        }
    }

    //获取全部招领信息
    @Override
    public String getAllFind() {
        try {
            List<Find> allFind = findDao.getAllFind();
            if (allFind!=null && allFind.size()>0){
                return GsonInfo.successListToJson(allFind,allFind.size());
            }else {
                return GsonInfo.failToJson("获取招领信息失败！");
            }
        }catch (Exception e){
            System.out.println("--------------------------------------------");
            System.out.println("错误："+e.getMessage().toString());
            return GsonInfo.failToJson("获取招领信息失败！");
        }
    }

    //根据用户id 查询用户发布的全部招领信息
    @Override
    public String getAllFindByUserId(int UserId) {

        try {
            List<Find> allFind = findDao.getAllFindByUserId(UserId);
            if (allFind!=null && allFind.size()>0){
                return GsonInfo.successListToJson(allFind,allFind.size());
            }else {
                if (allFind!=null && allFind.size() == 0){
                    return GsonInfo.failToJson("用户尚未发布招领信息！");
                }else {
                    return GsonInfo.failToJson("获取用户发布的招领信息失败！");
                }

            }
        }catch (Exception e){
            System.out.println("--------------------------------------------");
            System.out.println("错误："+e.getMessage().toString());
            return GsonInfo.failToJson("获取用户发布的招领信息失败！");
        }

    }

    //根据招领id删除招领信息
    @Override
    public String delFindByFindId(int findId) {
        try {
            int i = findDao.delFindByFindId(findId);
            if (i>0){
                return GsonInfo.successToJson("删除用户发布的招领信息成功！");
            }else {
                return GsonInfo.failToJson("删除用户发布的招领信息失败！");
            }
        }catch (Exception e){
            System.out.println("--------------------------------------------");
            System.out.println("错误："+e.getMessage().toString());
            return GsonInfo.failToJson("删除用户发布的招领信息失败！");
        }
    }

    @Override
    public String getAllFindByState(int state) {

        try {
            List<Find> stateAllFind = findDao.getAllFindByState(state);
            if (stateAllFind!=null && stateAllFind.size()>0){
                return GsonInfo.successListToJson(stateAllFind,stateAllFind.size());
            }else {
                if (state == Find.NOT_READ){
                    return GsonInfo.failToJson("没有未审核的招领信息！");
                }else if (state == Find.PUBLICITY){
                    return GsonInfo.failToJson("没有公示的招领信息！");
                }else if (state == Find.FINISH){
                    return GsonInfo.failToJson("没有已完成的招领信息！");
                }else if (state == Find.READ_FAIL){
                    return GsonInfo.failToJson("没有审核未通过的招领信息！");
                }else {
                    return GsonInfo.failToJson("状态出错！");
                }

            }
        }catch (Exception e){
            System.out.println("--------------------------------------------");
            System.out.println("错误："+e.getMessage().toString());
            return GsonInfo.failToJson("查询状态招领信息失败！");
        }
    }

    //分页
    @Override
    public String getDataByLimit(int page, int count, String key) {

        try {
            int pnum = (page-1) * count;
            List<Find> data = findDao.getDataByLimit(pnum, count, key);
            int allFindCount = findDao.getLikeCount(key);
            if (data != null && data.size() > 0){
                return GsonInfo.successListToJson(data,allFindCount);

            }else {
                return GsonInfo.failToJson("未查询到相关招领信息！");
            }
        }catch (Exception e){
            System.out.println("--------------------------------------------");
            System.out.println("错误："+e.getMessage().toString());
            return GsonInfo.failToJson("查询招领信息失败！");
        }
    }

    @Override
    public String getAllFindCount() {

        try {
            int allFindCount = findDao.getAllFindCount();
            return ""+allFindCount;
        }catch (Exception e){
            return e.getMessage().toString();
        }

    }

    //公示状态分页
    @Override
    public String getDataByPublishState(int page, int count, String key) {
        try {
            int pnum = (page-1) * count;
            List<Find> data = findDao.getDataByPublishState(pnum, count, key);
            int allFindCount = findDao.getCountByPublishState(key);
            if (data != null && data.size() > 0){
                return GsonInfo.successListToJson(data,allFindCount);

            }else {
                return GsonInfo.failToJson("未查询到公示状态的相关招领信息！");
            }
        }catch (Exception e){
            System.out.println("--------------------------------------------");
            System.out.println("错误："+e.getMessage().toString());
            return GsonInfo.failToJson("查询招领信息失败！");
        }
    }

    //未审核以及已完成状态分页
    @Override
    public String getDataByNoReadState(int page, int count, String key) {
        try {
            int pnum = (page-1) * count;
            List<Find> data = findDao.getDataByNoReadState(pnum, count, key);
            int allFindCount = findDao.getCountByNoReadState(key);
            if (data != null && data.size() > 0){
                return GsonInfo.successListToJson(data,allFindCount);

            }else {
                return GsonInfo.failToJson("未查询到未审核以及已完成状态的相关招领信息！");
            }
        }catch (Exception e){
            System.out.println("--------------------------------------------");
            System.out.println("错误："+e.getMessage().toString());
            return GsonInfo.failToJson("查询招领信息失败！");
        }
    }

    //未通过审核状态分页
    @Override
    public String getDataByReadFailState(int page, int count, String key) {
        try {
            int pnum = (page-1) * count;
            List<Find> data = findDao.getDataByReadFailState(pnum, count, key);
            int allFindCount = findDao.getCountByReadFailState(key);
            if (data != null && data.size() > 0){
                return GsonInfo.successListToJson(data,allFindCount);
            }else {
                return GsonInfo.failToJson("未查询到未通过审核状态的相关招领信息！");
            }
        }catch (Exception e){
            System.out.println("--------------------------------------------");
            System.out.println("错误："+e.getMessage().toString());
            return GsonInfo.failToJson("查询招领信息失败！");
        }
    }


}

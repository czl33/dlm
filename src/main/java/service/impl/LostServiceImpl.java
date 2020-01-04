package service.impl;

import dao.LostDao;
import entity.Find;
import entity.Lost;
import org.springframework.stereotype.Service;
import service.LostService;
import utils.GsonInfo;

import javax.annotation.Resource;
import java.util.List;


/**
 * @program: dlm
 * @description: Lost服务类
 * @author: cxr
 * @create: 2020-01-03 09:36
 */

@Service
public class LostServiceImpl implements LostService {
    @Resource
    public LostDao lostDao;

    //发布失物信息      传递参数Lost类
    @Override
    public String publishLost(Lost lost) {
        try {
            int i = lostDao.publishLost(lost);
            if (i>0){
                return GsonInfo.successToJson(lost.getLostId());
            }else {
                return GsonInfo.failToJson("失物信息发布失败！");
            }

        }catch (Exception e){
            System.out.println("--------------------------------------------");
            System.out.println("错误："+e.getMessage().toString());
            return GsonInfo.failToJson("发布失败！");
        }

    }

    //修改失物信息       传递参数Lost类
    @Override
    public String updateLost(Lost lost) {
        try {
            int i = lostDao.updateLost(lost);
            if (i>0){
                return GsonInfo.successToJson("修改失物信息成功");
            }else {
                return GsonInfo.failToJson("修改失物信息失败！");
            }
        }catch (Exception e){
            System.out.println("--------------------------------------------");
            System.out.println("错误："+e.getMessage().toString());
            return GsonInfo.failToJson("修改失物信息失败！");
        }
    }

    //修改失物信息状态    传递参数 LostId,state(失物id,失物状态)
    @Override
    public String updateLostPublishState(int lostId,int state) {
        Lost lost = new Lost();
        lost.setLostId(lostId);
        lost.setPublishState(state);
        try {
            int i = lostDao.updateLostPublishState(lost);
            if (i>0){
                return GsonInfo.successToJson("修改发布状态成功");
            }else {
                return GsonInfo.failToJson("修改发布状态失败");
            }
        }catch (Exception e){
            System.out.println("--------------------------------------------");
            System.out.println("错误："+e.getMessage().toString());
            return GsonInfo.failToJson("修改状态失败");
        }
    }

    //根据Lost类的id返回Lost    传递参数 LostId(失物id)
    @Override
    public String getLostById(int lostId) {
        try {
            Lost lost = lostDao.getLostById(lostId);
            if (lost!=null){
                return GsonInfo.successToJson(lost);
            }else {
                return GsonInfo.failToJson("获取失物信息失败！");
            }
        }catch (Exception e){
            System.out.println("--------------------------------------------");
            System.out.println("错误："+e.getMessage().toString());
            return GsonInfo.failToJson("获取失物信息失败！");
        }
    }

    //获取全部失物信息
    @Override
    public String getAllLost() {
        try {
            List<Lost> allLost = lostDao.getAllLost();
            if (allLost!=null && allLost.size()>0){
                return GsonInfo.successListToJson(allLost,allLost.size());
            }else {
                return GsonInfo.failToJson("获取失物信息失败！");
            }
        }catch (Exception e){
            System.out.println("--------------------------------------------");
            System.out.println("错误："+e.getMessage().toString());
            return GsonInfo.failToJson("获取失物信息失败！");
        }
    }

    //根据用户id 查询用户发布的全部失物信息
    @Override
    public String getAllLostByUserId(int userId) {

        try {
            List<Lost> allLost = lostDao.getAllLostByUserId(userId);
            if (allLost!=null && allLost.size()>0){
                return GsonInfo.successListToJson(allLost,allLost.size());
            }else {
                if (allLost!=null && allLost.size() == 0){
                    return GsonInfo.failToJson("用户尚未发布失物信息！");
                }else {
                    return GsonInfo.failToJson("获取用户发布的失物信息失败！");
                }

            }
        }catch (Exception e){
            System.out.println("--------------------------------------------");
            System.out.println("错误："+e.getMessage().toString());
            return GsonInfo.failToJson("获取用户发布的失物信息失败！");
        }

    }

    //根据失物id删除失物信息
    @Override
    public String delLostByLostId(int lostId) {
        try {
            int i = lostDao.delLostByLostId(lostId);
            if (i>0){
                return GsonInfo.successToJson("删除用户发布的失物信息成功！");
            }else {
                return GsonInfo.failToJson("删除用户发布的失物信息失败！");
            }
        }catch (Exception e){
            System.out.println("--------------------------------------------");
            System.out.println("错误："+e.getMessage().toString());
            return GsonInfo.failToJson("删除用户发布的失物信息失败！");
        }
    }

    //根据状态得到所有的失物信息
    @Override
    public String getAllLostByState(int state) {

        try {
            List<Lost> stateAllLost = lostDao.getAllLostByState(state);
            if (stateAllLost!=null && stateAllLost.size()>0){
                return GsonInfo.successListToJson(stateAllLost,stateAllLost.size());
            }else {
                if (state == Find.NOT_READ){
                    return GsonInfo.failToJson("没有未审核的失物信息！");
                }else if (state == Find.PUBLICITY){
                    return GsonInfo.failToJson("没有公示的失物信息！");
                }else if (state == Find.FINISH){
                    return GsonInfo.failToJson("没有已完成的失物信息！");
                }else if (state == Find.READ_FAIL){
                    return GsonInfo.failToJson("没有审核未通过的失物信息！");
                }else {
                    return GsonInfo.failToJson("状态出错！");
                }

            }
        }catch (Exception e){
            System.out.println("--------------------------------------------");
            System.out.println("错误："+e.getMessage().toString());
            return GsonInfo.failToJson("查询状态失物信息失败！");
        }
    }

    //分页
    @Override
    public String getLostDataByLimit(int page, int count, String key) {

        try {
            int pnum = (page-1) * count;
            List<Lost> data = lostDao.getDataByLimit(pnum, count, key);
            int allLostCount = lostDao.getLikeCount(key);
            if (data != null && data.size() > 0){
                return GsonInfo.successListToJson(data,allLostCount);

            }else {
                return GsonInfo.failToJson("未查询到相关失物信息！");
            }
        }catch (Exception e){
            System.out.println("--------------------------------------------");
            System.out.println("错误："+e.getMessage().toString());
            return GsonInfo.failToJson("查询失物信息失败！");
        }
    }




    //公示状态分页
    @Override
    public String getDataByLostPublishState(int page, int count, String key) {
        try {
            int pnum = (page-1) * count;
            List<Lost> data = lostDao.getDataByLostPublishState(pnum, count, key);
            int allFindCount = lostDao.getCountByLostPublishState(key);
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
    public String getDataByLostNoReadState(int page, int count, String key) {
        try {
            int pnum = (page-1) * count;
            List<Lost> data = lostDao.getDataByLostNoReadState(pnum, count, key);
            int allFindCount = lostDao.getCountByLostNoReadState(key);
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
    public String getDataByLostReadFailState(int page, int count, String key) {
        try {
            int pnum = (page-1) * count;
            List<Lost> data = lostDao.getDataByLostReadFailState(pnum, count, key);
            int allFindCount = lostDao.getCountByLostReadFailState(key);
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

package service.impl;

import dao.BannerDao;
import entity.Banner;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import service.BannerService;
import utils.GsonInfo;
import utils.UploadUtils;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @auther ckx
 * @description 轮播图实现类
 * @date 2020/1/4
 */
@Service
public class BannerServicelmpl implements BannerService {

   @Resource
    BannerDao bannerDao;

    @Override
    public String getAllBanner() {
        String msg="";
        try {
            List<Banner> allBanner = bannerDao.getAllBanner();
            msg=GsonInfo.successToJson(allBanner);
        }catch (Exception e){
            msg= GsonInfo.failToJson(e.getMessage().toString());
        }finally {
            return msg;

        }
    }

    @Override
    public String addBanner(HttpServletRequest httpServletRequest, MultipartFile file, String bTitle, String bUrl) {
        String msg="";
        try {
            String bPic = UploadUtils.Upload(file, httpServletRequest);
            Banner banner=new Banner(bTitle,bUrl,bPic);
            int i=bannerDao.addBanner(banner);
            if(i>0){
                msg=GsonInfo.successToJson("添加成功");
            }else {
                msg=GsonInfo.failToJson("回滚，添加失败");
            }
        }catch (Exception e){
            msg= GsonInfo.failToJson(e.getMessage().toString());
        }finally {
            return msg;

        }

    }

    @Override
    public String delBanner(int bId) {
        String msg="";
        try {
            int i = bannerDao.delBanner(bId);
            if(i>0){
                msg=GsonInfo.successToJson("删除成功");
            }else {
                msg=GsonInfo.failToJson("删除失败，回滚");
            }
        }catch (Exception e){
            msg= GsonInfo.failToJson(e.getMessage().toString());
        }finally {
            return msg;

        }

    }

    @Override
    public String updBanner(HttpServletRequest httpServletRequest, int bId, MultipartFile file, String bTitle, String bUrl) {
        String msg="";
        try {
            String bPic="";
            if(file!=null){
                bPic = UploadUtils.Upload(file, httpServletRequest);
            }else {
                bPic = bannerDao.getBannerByBId(bId).getbPic();
            }
            Banner banner =new Banner(bTitle,bUrl,bPic);
            banner.setbId(bId);

            int i=bannerDao.updBanner(banner);
            if(i>0){
                msg=GsonInfo.successToJson("修改成功");
            }else {
                msg=GsonInfo.failToJson("回滚，修改失败");
            }
        }catch (Exception e){
            msg= GsonInfo.failToJson(e.getMessage().toString());
        }finally {
            return msg;

        }
    }
}

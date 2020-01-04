package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import service.impl.BannerServicelmpl;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * @auther ckx
 * @description 轮播图控制层
 * @date 2020/1/4
 */
@Controller
public class BannerController {

    @Resource
    BannerServicelmpl bannerServicelmpl;


    /**
     * 查询所有轮播图
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "getAllBanner", method= RequestMethod.GET,produces = "text/plain;charset=utf-8")
    public String getAllBanner(){

        return bannerServicelmpl.getAllBanner();
    }

    /**
     * 添加一个轮播图
     * @param httpServletRequest
     * @param file
     * @param bTitle
     * @param bUrl
     * @return
     */
    @ResponseBody
    @RequestMapping(value ="addBanner",method = RequestMethod.POST,produces = "text/plain;charset=utf-8")
    public String addBanner(HttpServletRequest httpServletRequest,
                            @RequestParam(value="bPic",required=false) MultipartFile[] file,
                            @RequestParam(value = "bTitle") String bTitle,
                            @RequestParam(value = "bUrl")String bUrl){
        System.out.println("进入控制台");

        return bannerServicelmpl.addBanner(httpServletRequest,file[0],bTitle,bUrl);
    }

    /**
     * 删除轮播图
     * @param bId
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "delBanner",method = RequestMethod.GET,produces = "text/plain;charset=utf-8")
    public String delBanner(@RequestParam(value = "bId")int bId){
        System.out.println("进入删除控制台-----------------------------");
        return bannerServicelmpl.delBanner(bId);
    }

    @ResponseBody
    @RequestMapping(value = "updBanner",method = RequestMethod.POST,produces = "text/plain;charset=utf-8")
    public String updBanner(HttpServletRequest httpServletRequest,
                            @RequestParam(value = "bId")int bId,
                            @RequestParam(value="bPic",required=false) MultipartFile file,
                            @RequestParam(value = "bTitle") String bTitle,
                            @RequestParam(value = "bUrl")String bUrl){


        return bannerServicelmpl.updBanner(httpServletRequest, bId, file, bTitle, bUrl);
    }

}

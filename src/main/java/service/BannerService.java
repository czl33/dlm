package service;

import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;

/**
 * @auther ckx
 * @description 轮播图
 * @date 2020/1/4
 */

public interface BannerService {

    public String getAllBanner();

    public String addBanner(HttpServletRequest httpServletRequest,
                            MultipartFile file, String bTitle,String bUrl);

    public String delBanner(int bId);

    public String updBanner(HttpServletRequest httpServletRequest,int bId,
                            MultipartFile file, String bTitle,String bUrl);




}

package dao;

import entity.Banner;

import java.util.List;

/**
 * @auther ckx
 * @description 轮播图
 * @date 2020/1/4
 */
public interface BannerDao {

    public Banner getBannerByBId(int bId);

    public List<Banner> getAllBanner();

    public int addBanner(Banner banner);

    public int delBanner(int bId);

    public int updBanner(Banner banner);


}

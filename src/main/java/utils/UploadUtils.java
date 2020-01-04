package utils;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

/**
 * @program: dlm
 * @description: 图片上传工具类传入MultipartFile，HttpServletRequest
 * @author: cr
 * @create: 2020-01-03 09:16
 */
public class UploadUtils {
    //private static File file;

    public static String Upload(MultipartFile file, HttpServletRequest request){
        if(!file.isEmpty()) {
            try {
                //上传文件路径
                String path = request.getServletContext().getRealPath("/image");
                //获取文件后缀
                String suffix = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf(".") + 1);
                //生成文件名
                UUID uuid = UUID.randomUUID();
                String filename = uuid+"."+suffix;
                //上传文件名
                File filepath = new File(path,filename);
                //判断路径是否存在，如果不存在就创建一个
                if (!filepath.getParentFile().exists()) {
                    filepath.getParentFile().mkdirs();
                }
                //将上传文件保存到一个目标文件当中
                file.transferTo(new File(path + File.separator + filename));
                //输出文件上传最终的路径 测试查看
                String paths=path + File.separator + filename;
                System.out.println(paths);
                return filename;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
            return "0";

    }

}

package utils;

import com.google.gson.Gson;

import java.util.HashMap;

/**
 * @auther ckx
 * @description 这是类是返回的gson信息类
 * @date 2020/1/1
 */

public class GsonInfo {

    public static final int SUCCESS=0;//请求成功
    public static final int FAIL=1;//没有数据和信息

    private GsonInfo(){
    }

    private static GsonInfo gosnInfo=new GsonInfo(); //私有化
    private static Gson gson=new Gson().newBuilder().serializeNulls().create();;





   private static HashMap<String,Object> hashMap=new HashMap<>();

    //当err为1错误时，调用string，传入错误信息
    public static String failToJson(String msg){
        hashMap.put("err",GsonInfo.FAIL);
        hashMap.put("msg",msg);
        return gson.toJson(hashMap);
    }

    //当err为0成功时，调用string，传入类
    public static String successToJson(Object msg){
        hashMap.put("err",GsonInfo.SUCCESS);
        hashMap.put("msg",msg);
        return gson.toJson(hashMap);
    }

    public static String successListToJson(Object msg,int total){
        HashMap<String,Object> map=new HashMap<>();
        map.put("err",GsonInfo.SUCCESS);
        map.put("msg",msg);
        map.put("total",total);

        return gson.toJson(map);
    }
    public static String ListToJson(Object s){
        return gson.toJson(s);
    }



}

package com.springmvc.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Field;
import java.net.URL;
import java.net.URLConnection;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Utils {
    static Logger logger = LoggerFactory.getLogger(Utils.class);

    public static  <T> void mergeObject(T origin, T destination) {
        if (origin == null || destination == null)
            return;
        if (!origin.getClass().equals(destination.getClass()))
            return;
 
        Field[] fields = origin.getClass().getDeclaredFields();
        for (int i = 0; i < fields.length; i++) {
            try {
                fields[i].setAccessible(true);
                Object value = fields[i].get(origin);
                if (null != value) {
                    fields[i].set(destination, value);
                }
                fields[i].setAccessible(false);
            } catch (Exception e) {
            }
        }
    }
    public static Map httpGet(String url) throws JsonParseException, JsonMappingException, IOException{
//        Map map =new HashMap();
        logger.info("发送GET请求url:" + url);
     // 定义即将访问的链接
//        String url = "https://api.weixin.qq.com/sns/oauth2/access_token?appid="+appid+"&secret="+secret+"&code="+code+"&grant_type=authorization_code";
        // 定义一个字符串用来存储网页内容
        String result = "";
        // 定义一个缓冲字符输入流
        BufferedReader in = null;
        try
        {
            // 将string转成url对象
            URL realUrl = new URL(url);
            // 初始化一个链接到那个url的连接
            URLConnection connection = realUrl.openConnection();
            // 开始实际的连接
            connection.connect();
            // 初始化 BufferedReader输入流来读取URL的响应
            in = new BufferedReader(new InputStreamReader(connection.getInputStream(),"utf-8"));
            // 用来临时存储抓取到的每一行的数据
            String line;
            while ((line = in.readLine()) != null)
            {
                // 遍历抓取到的每一行并将其存储到result里面
                result += line + "\n";
            }
        } catch (Exception e)
        {
            logger.error("发送GET请求出现异常！" + e,e);
        } // 使用finally来关闭输入流
        finally
        {
            try
            {
                if (in != null)
                {
                    in.close();
                }
            } catch (Exception e2)
            {
                e2.printStackTrace();
            }
        }
        logger.info("发送GET请求result:" + result);
        ObjectMapper mapper = new ObjectMapper();
        Map map=mapper.readValue(result, Map.class);
        return map;
    }
    
//    public static Map<String ,List<Goods>> goodsListToMap(List<Goods> goodList){
//        Map<String,List<Goods>> map=new HashMap<String, List<Goods>>();
//        List<Goods> tempList=new ArrayList<Goods>();
//        for(Goods g:goodList){
//            if(map!=null){
//                tempList=map.get(g.getGoodsType().getTypeId().toString());
//                if(tempList==null){
//                    tempList=new ArrayList<Goods>();
//                }
//            }
//            tempList.add(g);
//            map.put(g.getGoodsType().getTypeId().toString(), tempList);
//        }
//        return map;
//    }
}

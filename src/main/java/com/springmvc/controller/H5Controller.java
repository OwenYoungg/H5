package com.springmvc.controller;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.mysql.jdbc.StringUtils;
import com.springmvc.entity.H5Count;
import com.springmvc.entity.H5Info;
import com.springmvc.entity.H5Users;
import com.springmvc.service.H5CountService;
import com.springmvc.service.H5InfoService;
import com.springmvc.service.H5UsersService;
import com.springmvc.util.ImageUtils;
import com.springmvc.util.Utils;

@RestController
@RequestMapping("/h5")
public class H5Controller {
    Logger logger = LoggerFactory.getLogger(H5Controller.class);
    @Autowired
    private H5InfoService h5InfoService;
    @Autowired
    private H5CountService h5CountService;
    @Resource(name="h5UsersService")
    private H5UsersService userService;
    @Value("${domain}")
    private String domain;
    @Value("${wechat_appid}")
    private String appid;
    @Value("${wechat_secret}")
    private String secret;
    @Value("${pic_uri}")
    private String picUri;
    @Autowired
    private H5UsersService h5UsersService;
    @RequestMapping(value="/views")
    public Map<String, Object> views(HttpServletRequest request, HttpServletResponse response,
            HttpSession session, Integer h5InfoId,Integer userId) {
        Map<String, Object> map = new HashMap<>();
        try {
            if(h5InfoId==null){
                map.put("SUCCESS", false);
                map.put("MESSAGE", "浏览失败!h5InfoId不能为空!");
                return map;                
            }
            H5Info h5Info=h5InfoService.getH5InfoById(h5InfoId);
            if(h5Info==null){
                map.put("SUCCESS", false);
                map.put("MESSAGE", "浏览失败!查不到对应信息!id:"+h5Info);
                return map;                
            }
            H5Users user=h5UsersService.getH5UsersById(userId);
            if(user==null){
                map.put("SUCCESS", false);
                map.put("MESSAGE", "浏览失败!查不到对应用户信息!userid:"+userId);
                return map;                  
            }
            h5CountService.increaseData(h5InfoId, 1);
            map.put("DATA", h5Info);
            map.put("SUCCESS", true);
            map.put("MESSAGE", "浏览成功");
            return map;
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            map.put("SUCCESS", false);
            map.put("EXCEPTION", e.getMessage());
            map.put("MESSAGE", "浏览失败!");
            return map;
        }
    }
    @RequestMapping(value="/share")
    public Map<String, Object> share(HttpServletRequest request, HttpServletResponse response,
            HttpSession session, Integer h5InfoId,Integer userId) {
        Map<String, Object> map = new HashMap<>();
        try {
            if(h5InfoId==null){
                map.put("SUCCESS", false);
                map.put("MESSAGE", "分享失败!h5InfoId不能为空!");
                return map;                
            }
            H5Info h5Info=h5InfoService.getH5InfoById(h5InfoId);
            if(h5Info==null){
                map.put("SUCCESS", false);
                map.put("MESSAGE", "分享失败!查不到对应信息!id:"+h5Info);
                return map;                
            }
            H5Users user=h5UsersService.getH5UsersById(userId);
            if(user==null){
                map.put("SUCCESS", false);
                map.put("MESSAGE", "分享失败!查不到对应用户信息!userid:"+userId);
                return map;                  
            }
            h5CountService.increaseData(h5InfoId, 2);
            map.put("DATA", h5Info);
            map.put("SUCCESS", true);
            map.put("MESSAGE", "分享成功");
            return map;
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            map.put("SUCCESS", false);
            map.put("EXCEPTION", e.getMessage());
            map.put("MESSAGE", "分享失败!");
            return map;
        }
    }
    @RequestMapping(value="/thumbUp")
    public Map<String, Object> thumbUp(HttpServletRequest request, HttpServletResponse response,
            HttpSession session, Integer h5InfoId,Integer userId) {
        Map<String, Object> map = new HashMap<>();
        try {
            if(h5InfoId==null){
                map.put("SUCCESS", false);
                map.put("MESSAGE", "点赞失败!h5InfoId不能为空!");
                return map;                
            }
            H5Info h5Info=h5InfoService.getH5InfoById(h5InfoId);
            if(h5Info==null){
                map.put("SUCCESS", false);
                map.put("MESSAGE", "点赞失败!查不到对应信息!id:"+h5Info);
                return map;                
            }
            H5Users user=h5UsersService.getH5UsersById(userId);
            if(user==null){
                map.put("SUCCESS", false);
                map.put("MESSAGE", "点赞失败!查不到对应用户信息!userid:"+userId);
                return map;                  
            }
            h5CountService.increaseData(h5InfoId, 3);
            map.put("DATA", h5Info);
            map.put("SUCCESS", true);
            map.put("MESSAGE", "点赞成功");
            return map;
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            map.put("SUCCESS", false);
            map.put("EXCEPTION", e.getMessage());
            map.put("MESSAGE", "点赞失败!");
            return map;
        }
    }
    /**
     * @description 根据code得到token
     * @author guoyang
     * @date 2017年10月18日
     * @param request
     * @param response
     * @param session
     * @param code 微信提供的code
     * @return
     */
    @RequestMapping("/getTokenByWechatCode")
  public Map<String, Object> getTokenByWechatCode(HttpServletRequest request, HttpServletResponse response,
          HttpSession session,String code) {
      Map<String, Object> map = new HashMap<>();
      try {
       // 定义即将访问的链接
          String url = "https://api.weixin.qq.com/sns/oauth2/access_token?appid="+appid+"&secret="+secret+"&code="+code+"&grant_type=authorization_code";
          Map mapData=Utils.httpGet(url);
          map.put("DATA", mapData);
          map.put("SUCCESS", true);
          map.put("MESSAGE", "查询成功");
          return map;
      } catch (Exception e) {
          logger.error(e.getMessage(), e);
          map.put("SUCCESS", false);
          map.put("EXCEPTION", e.getMessage());
          map.put("MESSAGE", "查询失败!");
          return map;
      }
  }

   
    @RequestMapping("/getUserInfoByWechatCode")
  public Map<String, Object> getUserInfoByWechatCode(HttpServletRequest request, HttpServletResponse response,
          HttpSession session,String code) {
      Map<String, Object> map = new HashMap<>();
      try {
       // 通过code 获取
          String url = "https://api.weixin.qq.com/sns/oauth2/access_token?appid="+appid+"&secret="+secret+"&code="+code+"&grant_type=authorization_code";
          Map mapData=Utils.httpGet(url);
          /*判断是否返回错误信息 code无效 返回{"errcode":40029,"errmsg":"invalid code"} 
                                  正常返回:
          { "access_token":"ACCESS_TOKEN",    
              "expires_in":7200,    
              "refresh_token":"REFRESH_TOKEN",    
              "openid":"OPENID",    
              "scope":"SCOPE" } */
          if(mapData.get("access_token")!=null){
              url="https://api.weixin.qq.com/sns/userinfo?access_token="+mapData.get("access_token")+"&openid="+mapData.get("openid")+"&lang=zh_CN";
              mapData=Utils.httpGet(url);
              /*正确时返回的JSON数据包如下：
              {    "openid":" OPENID",  
               " nickname": NICKNAME,   
               "sex":"1",   
               "province":"PROVINCE"   
               "city":"CITY",   
               "country":"COUNTRY",    
               "headimgurl":    "http://wx.qlogo.cn/mmopen/g3MonUZtNHkdmzicIlibx6iaFqAc56vxLSUfpb6n5WKSYVY0ChQKkiaJSgQ1dZuTOgvLLrhJbERQQ
              4eMsv84eavHiaiceqxibJxCfHe/46",  
              "privilege":[ "PRIVILEGE1" "PRIVILEGE2"     ],    
               "unionid": "o6_bmasdasdsad6_2sgVt7hMZOPfL" 
              } */
              logger.info((String) mapData.get("nickname"));
              if(mapData.get("nickname")!=null){
                  H5Users h5users=userService.getH5UserByOpenId((String) mapData.get("openid"));
                  if(h5users==null){//初次登录入库
                      h5users=new H5Users();
                      h5users.setCreateTime(new Date());
                      h5users.setLastLoginTime(new Date());
                      h5users.setNickname((String) mapData.get("nickname"));
                      h5users.setOpenId((String) mapData.get("openid"));
                      logger.info("即将新增用户openId:"+mapData.get("openid"));
                  }else{//非初次登录更新最后登录时间
                      h5users.setLastLoginTime(new Date());
                      h5users.setNickname((String) mapData.get("nickname"));
                      logger.info("即将更新用户openId:"+mapData.get("openid"));
                  }
                  userService.saveOrUpdateH5User(h5users);  
                  mapData.put("userId", h5users.getId());
                  logger.info("保存用户成功userId:"+h5users.getId());
              }
              
          }
          map.put("DATA", mapData);
          map.put("SUCCESS", true);
          map.put("MESSAGE", "查询成功");
          return map;
      } catch (Exception e) {
          logger.error(e.getMessage(), e);
          map.put("SUCCESS", false);
          map.put("EXCEPTION", e.getMessage());
          map.put("MESSAGE", "查询失败!");
          return map;
      }
  }

    /**
     * @description 得到H5Info的list
     * @author guoyang
     * @date 2017年10月11日
     * @param request
     * @param response
     * @param session
     * @param type 1.上传时间降序 2.点赞数降序
     * @return
     */
    @RequestMapping("/list")
//    @ResponseBody
    public Map<String, Object> getH5infoList(HttpServletRequest request, HttpServletResponse response,
            HttpSession session,Integer type,Integer pageNum,Integer pageCount) {
        Map<String, Object> map = new HashMap<>();
        try {
            List<H5Info> list =h5InfoService.getH5InfoList(type,pageNum,pageCount);
            map.put("DATA", list);
            map.put("SUCCESS", true);
            map.put("MESSAGE", "查询成功");
            return map;
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            map.put("SUCCESS", false);
            map.put("EXCEPTION", e.getMessage());
            map.put("MESSAGE", "查询失败!");
            return map;
        }
    }
    /**
     * @description 根据id查H5Info
     * @author guoyang
     * @date 2017年10月11日
     * @param request
     * @param response
     * @param session
     * @param id h5infoid
     * @return
     */
    @RequestMapping("/detail")
  public Map<String, Object> getH5infoById(HttpServletRequest request, HttpServletResponse response,
          HttpSession session,Integer id) {
      Map<String, Object> map = new HashMap<>();
      try {
          H5Info h5Info=h5InfoService.getH5InfoById(id);
          map.put("DATA", h5Info);
          map.put("SUCCESS", true);
          map.put("MESSAGE", "查询成功");
          return map;
      } catch (Exception e) {
          logger.error(e.getMessage(), e);
          map.put("SUCCESS", false);
          map.put("EXCEPTION", e.getMessage());
          map.put("MESSAGE", "查询失败!");
          return map;
      }
  }

    /**
     * @description 保存h5Info
     * @author guoyang
     * @date 2017年10月11日
     * @param request
     * @param response
     * @param session
     * @param h5info
     * @return
     */
    @RequestMapping(value="/save")
    public Map<String, Object> saveH5info(HttpServletRequest request, HttpServletResponse response,
            HttpSession session, H5Info h5info) {
        Map<String, Object> map = new HashMap<>();
        try {
            H5Count h5count=new H5Count();
            h5info.setUploadTime(new Date());
            h5InfoService.saveH5Info(h5info);
            h5count.setH5Info(h5info);
            h5CountService.saveH5Count(h5count);
            map.put("DATA", h5info);
            map.put("SUCCESS", true);
            map.put("MESSAGE", "保存成功");
            return map;
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            map.put("SUCCESS", false);
            map.put("EXCEPTION", e.getMessage());
            map.put("MESSAGE", "保存失败!");
            return map;
        }
    }

    /**
     * @description 更新h5info
     * @author guoyang
     * @date 2017年10月11日
     * @param request
     * @param response
     * @param session
     * @param h5info
     * @return
     */
    @RequestMapping("/update")
    public Map<String, Object> updateH5info(HttpServletRequest request, HttpServletResponse response,
            HttpSession session, H5Info h5info) {
        Map<String, Object> map = new HashMap<>();
        try {
            if (h5info.getId() == null) {
                map.put("SUCCESS", false);
                map.put("MESSAGE", "保存失败!id不能为空!");
                return map;
            }
            h5InfoService.saveH5Info(h5info);
            map.put("DATA", h5info);
            map.put("SUCCESS", true);
            map.put("MESSAGE", "保存成功");
            return map;
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            map.put("SUCCESS", false);
            map.put("EXCEPTION", e.getMessage());
            map.put("MESSAGE", "保存失败!");
            return map;
        }
    }


    /**
     * @description 删除h5info
     * @author guoyang
     * @date 2017年10月11日
     * @param request
     * @param response
     * @param session
     * @param h5info
     * @return
     */
    @RequestMapping("/delete")
    public Map<String, Object> deleteH5info(HttpServletRequest request, HttpServletResponse response,
            HttpSession session, H5Info h5info) {
        Map<String, Object> map = new HashMap<>();
        try {
            if (h5info.getId() == null) {
                map.put("SUCCESS", false);
                map.put("MESSAGE", "删除失败!id不能为空!");
                return map;
            }
            h5InfoService.deleteH5Info(h5info);;
//            map.put("DATA", h5info);
            map.put("SUCCESS", true);
            map.put("MESSAGE", "删除成功");
            return map;
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            map.put("SUCCESS", false);
            map.put("EXCEPTION", e.getMessage());
            map.put("MESSAGE", "删除失败!");
            return map;
        }
    }
    /*
     * 通过流的方式上传文件
     * @RequestParam("file") 将name=file控件得到的文件封装成CommonsMultipartFile 对象
     */
    @RequestMapping("fileUpload")
    public Map<String, Object>  fileUpload(@RequestParam("file") CommonsMultipartFile file,HttpServletRequest request) throws IOException {

        Map<String, Object> map = new HashMap<>();
         
        //用来检测程序运行时间
//        long  startTime=System.currentTimeMillis();
//        System.out.println("fileName："+file.getOriginalFilename());

        String url="";
        try {
//            String root=request.getSession().getServletContext().getRealPath("/");
            String fileName=new Date().getTime()+file.getOriginalFilename();
            String uri=picUri+fileName;
            //获取输出流
            OutputStream os=new FileOutputStream(uri);
            //获取输入流 CommonsMultipartFile 中可以直接得到文件的流
            InputStream is=file.getInputStream();
            int temp;
            //一个一个字节的读取并写入
            while((temp=is.read())!=(-1))
            {
                os.write(temp);
            }
           os.flush();
           os.close();
           is.close();
           new ImageUtils().thumbnailImage(uri, 150, 100);
           url+=domain+"/images/"+fileName;
        } catch (FileNotFoundException e) {
            logger.error(e.getMessage(), e);
            map.put("SUCCESS", false);
            map.put("EXCEPTION", e.getMessage());
            map.put("MESSAGE", "上传失败!");
            return map;
        }
//        long  endTime=System.currentTimeMillis();
//        System.out.println("方法一的运行时间："+String.valueOf(endTime-startTime)+"ms");
        map.put("URL", url);
        map.put("SUCCESS", true);
        map.put("MESSAGE", "上传成功");
        return map;
    }
    
    /**
     * 进入管理平台首页
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(value="/H5Index",method={RequestMethod.GET})
    public ModelAndView H5AdminIndex(HttpServletRequest request, HttpServletResponse response){
    	ModelAndView view = new ModelAndView();
		view.setViewName("management/H5Index");
		return view;
    }
    
    @RequestMapping(value="/WowH5List",method={RequestMethod.GET})
    public ModelAndView wowH5List(HttpServletRequest request, HttpServletResponse response){
    	logger.info("执行wowH5List...");
    	ModelAndView mv = new ModelAndView();
    	mv.setViewName("wowh5/WowH5List");
    	try {
    		String pageNumStr = request.getParameter("pageNum");
    		String pageCountStr = request.getParameter("pageCount");
    		Integer pageNum,pageCount;
    		if(StringUtils.isNullOrEmpty(pageNumStr))
    			pageNum = 1;
    		else
    			pageNum = Integer.parseInt(pageNumStr);
    		if(StringUtils.isNullOrEmpty(pageCountStr))
    			pageCount = 20;
    		else
    			pageCount = Integer.parseInt(pageCountStr);
			logger.info("pageNum:"+pageNum+",pageCount:"+pageCount);
			//获取新人秀列表
			List<H5Info> list1 =h5InfoService.getH5InfoList(1,pageNum,pageCount);
			//获取名人堂列表
			List<H5Info> list2 =h5InfoService.getH5InfoList(2,pageNum,pageCount);
			mv.addObject("list1", list1);
			mv.addObject("list2", list2);
			
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	return mv;
    }
}

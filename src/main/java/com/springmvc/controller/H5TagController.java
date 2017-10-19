package com.springmvc.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springmvc.entity.H5Info;
import com.springmvc.entity.H5Tag;
import com.springmvc.entity.H5TagCount;
import com.springmvc.entity.H5Users;
import com.springmvc.service.H5CountService;
import com.springmvc.service.H5InfoService;
import com.springmvc.service.H5TagCountService;
import com.springmvc.service.H5TagService;
import com.springmvc.service.H5UsersService;

@RestController
@RequestMapping("/h5tag")
public class H5TagController {
    Logger logger = LoggerFactory.getLogger(H5TagController.class);
    @Autowired
    private H5TagService h5TagService;
    @Autowired
    private H5InfoService h5InfoService;
    @Autowired
    private H5TagCountService h5TagCountService;
    @Autowired
    private H5CountService h5CountService;
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
    /**
     * @description 对标签点赞
     * @author guoyang
     * @date 2017年10月11日
     * @param request
     * @param response
     * @param session
     * @param h5Tag
     * @param h5InfoId
     * @return
     */
    @RequestMapping(value="/thumbUp")
    public Map<String, Object> thumbUp(HttpServletRequest request, HttpServletResponse response,
            HttpSession session, Integer h5TagId,Integer userId) {
        Map<String, Object> map = new HashMap<>();
        try {
            if(h5TagId==null){
                map.put("SUCCESS", false);
                map.put("MESSAGE", "点赞失败!h5TagId不能为空!");
                return map;                
            }
            H5Tag h5Tag=h5TagService.getH5TagById(h5TagId);
            if(h5Tag==null){
                map.put("SUCCESS", false);
                map.put("MESSAGE", "点赞失败!查不到对应标签信息!id:"+h5TagId);
                return map;                
            }
            H5Users user=h5UsersService.getH5UsersById(userId);
            if(user==null){
                map.put("SUCCESS", false);
                map.put("MESSAGE", "点赞失败!查不到对应用户信息!userid:"+userId);
                return map;                  
            }
            H5TagCount h5TagCount=new H5TagCount();
            h5TagCount.setUser(user);
            h5TagCount.setGoodTime(new Date());
            h5TagCount.setH5Tag(h5Tag);
            h5TagCount.setWechatOpenId(user.getOpenId());
            h5TagService.increaseData(h5TagId);
            h5TagCountService.saveOrUpdateH5TagCount(h5TagCount);
            h5CountService.increaseData(h5Tag.getH5Info().getId(), 3);
            map.put("DATA", h5TagCount);
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
     * @description 根据h5infoid得到标签列表
     * @author guoyang
     * @date 2017年10月11日
     * @param request
     * @param response
     * @param session
     * @param h5InfoId 
     * @return
     */
    @RequestMapping("/getH5TagListByH5InfoId")
  public Map<String, Object> getH5TagListByH5InfoId(HttpServletRequest request, HttpServletResponse response,
          HttpSession session,Integer h5InfoId) {
      Map<String, Object> map = new HashMap<>();
      try {
          List<H5Tag> list=h5TagService.getH5TagListByH5InfoId(h5InfoId);
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
     * @description 保存标签
     * @author guoyang
     * @date 2017年10月11日
     * @param request
     * @param response
     * @param session
     * @param h5Tag
     * @param h5InfoId
     * @return
     */
    @RequestMapping(value="/save")
    public Map<String, Object> saveH5Tag(HttpServletRequest request, HttpServletResponse response,
            HttpSession session, H5Tag h5Tag,Integer h5InfoId) {
        Map<String, Object> map = new HashMap<>();
        try {
            if(h5InfoId==null){
                map.put("SUCCESS", false);
                map.put("MESSAGE", "保存失败!h5InfoId不能为空!");
                return map;                
            }
            H5Info h5Info=h5InfoService.getH5InfoById(h5InfoId);
            if(h5Info==null){
                map.put("SUCCESS", false);
                map.put("MESSAGE", "保存失败!查不到对应信息!id:"+h5InfoId);
                return map;                
            }
            h5Tag.setH5Info(h5Info);
            h5TagService.saveOrUpdateH5Tag(h5Tag);
            map.put("DATA", h5Tag);
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
     * @description 更新标签
     * @author guoyang
     * @date 2017年10月11日
     * @param request
     * @param response
     * @param session
     * @param h5Tag
     * @param h5InfoId
     * @return
     */
    @RequestMapping("/update")
    public Map<String, Object> updateH5Tag(HttpServletRequest request, HttpServletResponse response,
            HttpSession session, H5Tag h5Tag,Integer h5InfoId) {
        Map<String, Object> map = new HashMap<>();
        try {
            if(h5InfoId==null){
                map.put("SUCCESS", false);
                map.put("MESSAGE", "保存失败!h5InfoId不能为空!");
                return map;                
            }
            H5Info h5Info=h5InfoService.getH5InfoById(h5InfoId);
            if(h5Info==null){
                map.put("SUCCESS", false);
                map.put("MESSAGE", "保存失败!查不到对应信息!id:"+h5InfoId);
                return map;                
            }
            h5Tag.setH5Info(h5Info);
            h5TagService.saveOrUpdateH5Tag(h5Tag);
            map.put("DATA", h5Tag);
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
     * @description 删除标签
     * @author guoyang
     * @date 2017年10月11日
     * @param request
     * @param response
     * @param session
     * @param h5Tag
     * @return
     */
    @RequestMapping("/delete")
    public Map<String, Object> deleteH5Tag(HttpServletRequest request, HttpServletResponse response,
            HttpSession session,H5Tag h5Tag) {
        Map<String, Object> map = new HashMap<>();
        try {
            if (h5Tag.getId() == null) {
                map.put("SUCCESS", false);
                map.put("MESSAGE", "删除失败!id不能为空!");
                return map;
            }
            h5TagService.deleteH5Tag(h5Tag);
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
}

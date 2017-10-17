package com.springmvc.repository;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.springmvc.entity.H5Count;

@Repository
public class H5CountRepository {
    @Autowired
    SessionFactory sessionFactory;
    private Session getSession(){
        return sessionFactory.getCurrentSession();
    }
    public void saveOrUpdateH5Count(H5Count h5Count){
        getSession().saveOrUpdate(h5Count);
    }
    public H5Count getH5Count(Integer id){
        return (H5Count) getSession().get(H5Count.class, id);
    }

    public void removeH5Info(H5Count h5Count){
        getSession().delete(h5Count);;
    }
    public List<H5Count> getH5CountList(Integer type){
        String hsql="from H5Count a ";
        if(type!=null){
            String order=" order by ";
            switch(type){
            case 1://上传时间降序
                order+="a.h5Info.uploadTime desc";
            case 2://点赞数降序
                order=" a.goodTimes desc";
            default:
                order=" a.id";
            }
            hsql+=order;
        }
        
        Query query = getSession().createQuery(hsql);        
        return query.list();
    }

    /**
     * @description 根据h5infoid查h5count
     * @author guoyang
     * @date 2017年10月11日
     * @param h5InfoId
     * @return
     */
    public H5Count getH5CountByH5InfoId(Integer h5InfoId) {
        if(h5InfoId==null){
            return null;
        }
        try{
        String hsql="from H5Count a where a.h5Info.id="+h5InfoId;        
        Query query = getSession().createQuery(hsql);        
        return (H5Count) query.list().get(0);
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }
//    public List<H5Count> getAllH5Count(H5Count h5Count,String goodsType,String orderBy){
//        String hsql="from Goods";
//        hsql+=" where 1=1 ";
////        if(goods!=null){
////            for (Field f : goods.getClass().getDeclaredFields()) {
////                f.setAccessible(true);
////                try {
////                    if (f.get(goods) != null) { //判断字段是否为空，并且对象属性中的基本都会转为对象类型来判断
////                        hsql+=" and "+f.getName()+"='"+f.get(goods)+"' ";
////                    }
////                } catch (IllegalArgumentException e) {
////                    e.printStackTrace();
////                } catch (IllegalAccessException e) {
////                    e.printStackTrace();
////                }
////            } 
////        }
////        if(goodsType!=null&&!"".equals(goodsType)&&!"null".equals(goodsType)){
////            hsql+=" and goodsType="+goodsType;
////        }
////        hsql+=" order by "+orderBy;
//        Query query = getSession().createQuery(hsql);        
//        return query.list();
//    }
}

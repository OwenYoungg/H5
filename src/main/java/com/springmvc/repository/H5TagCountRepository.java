package com.springmvc.repository;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.springmvc.entity.H5TagCount;

@Repository
public class H5TagCountRepository {
    @Autowired
    SessionFactory sessionFactory;
    private Session getSession(){
        return sessionFactory.getCurrentSession();
    }
    public void saveOrUpdateH5TagCount(H5TagCount h5TagCount){
        getSession().saveOrUpdate(h5TagCount);
    }
    public H5TagCount getH5Count(Integer id){
        return (H5TagCount) getSession().get(H5TagCount.class, id);
    }

    public void removeH5TagCount(H5TagCount h5TagCount){
        getSession().delete(h5TagCount);;
    }
    public H5TagCount getH5TagCount(Integer id){
        return (H5TagCount) getSession().get(H5TagCount.class, id);
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

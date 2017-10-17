package com.springmvc.repository;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.springmvc.entity.H5Tag;

@Repository
public class H5TagRepository {
    @Autowired
    SessionFactory sessionFactory;
    private Session getSession(){
        return sessionFactory.getCurrentSession();
    }
    public void saveH5Tag(H5Tag h5Tag){
        getSession().saveOrUpdate(h5Tag);
    }
    public H5Tag getH5Tag(Integer id){
        return (H5Tag) getSession().get(H5Tag.class, id);
    }

    public List<H5Tag> getH5TagListByH5InfoId(Integer h5InfoId){
        String hsql="from H5Tag a";
        if(h5InfoId!=null){
            hsql+=" where a.h5Info="+h5InfoId;
        }
        Query query = getSession().createQuery(hsql);        
        return query.list();
    }

    public void removeH5Tag(H5Tag h5Tag){
        getSession().delete(h5Tag);;
    }
//    public List<OrderList> getOrderList(OrderList selectOrder,Integer orderId){
//        String hsql="from OrderList  ";
//        hsql+=" where 1=1 ";
//        if(selectOrder!=null){
//            for (Field f : selectOrder.getClass().getDeclaredFields()) {
//                f.setAccessible(true);
//                try {
//                    if (f.get(selectOrder) != null) { //判断字段是否为空，并且对象属性中的基本都会转为对象类型来判断
//                        hsql+=" and "+f.getName()+"='"+f.get(selectOrder)+"' ";
//                    }
//                } catch (IllegalArgumentException e) {
//                    e.printStackTrace();
//                } catch (IllegalAccessException e) {
//                    e.printStackTrace();
//                }
//            }
//        }
//        
//        if(orderId!=null){
//            hsql+=" and id>"+orderId;
//        }
//        Query query = getSession().createQuery(hsql);        
//        return query.list();
//    }
    
    
    
}

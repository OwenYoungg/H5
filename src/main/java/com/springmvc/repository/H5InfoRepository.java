package com.springmvc.repository;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.springmvc.entity.H5Info;

@Repository
public class H5InfoRepository {
    @Autowired
    SessionFactory sessionFactory;
    private Session getSession(){
        return sessionFactory.getCurrentSession();
    }
    public void removeH5Info(H5Info h5Info){
        getSession().delete(h5Info);;
    }
    public void saveH5Info(H5Info h5Info){
        getSession().saveOrUpdate(h5Info);
    }
    public H5Info getH5Info(Integer id){
        return (H5Info) getSession().get(H5Info.class, id);
    }
    public List<H5Info> getAllH5Info(Integer type,Integer pageNum,Integer pageCount){
        String hsql="from H5Info a ";
        if(type!=null){
            String order=" order by ";
            if(type==1){//上传时间降序
                order+="a.uploadTime desc";
            }else if(type==2){//点赞数降序
                order+=" a.h5Count.goodTimes desc";
            }else{
                order+=" a.id";
            }
            hsql+=order;
        }
        Query query = getSession().createQuery(hsql); 
        if(pageNum!=null&&pageCount!=null&&pageNum>0&&pageCount>0){
            int startIndex=0;
            startIndex=(pageNum-1)*pageCount;
            query.setFirstResult(startIndex).setMaxResults(pageCount);
        }else{
            query.setMaxResults(20);          
        }
               
        return query.list();
    }
}

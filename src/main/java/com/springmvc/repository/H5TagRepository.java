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
    public void removeH5TagsByH5InfoId(Integer h5InfoId)throws Exception{
        if(h5InfoId==null){
            throw new Exception("删除H5Tag时,h5InfoId不能为空!");
        }
        String hsql="delete from H5Tag a where a.h5Info="+h5InfoId;
        Query query = getSession().createQuery(hsql);  
        query.executeUpdate();
    }
    
    
    
}

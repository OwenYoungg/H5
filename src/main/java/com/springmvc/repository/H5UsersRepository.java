package com.springmvc.repository;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.springmvc.entity.H5Users;

@Repository
public class H5UsersRepository  {
	@Resource(name="sessionFactory")
	private SessionFactory sessionFactory;
    private Session getSession(){
        return sessionFactory.getCurrentSession();
    }

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public List<H5Users> getAllUser(){
		String hsql="from H5Users";
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery(hsql);
		
		return query.list();
	}

    public H5Users getH5User(Integer id){
        return (H5Users) getSession().get(H5Users.class, id);
    }
    public void saveOrUpdateH5User(H5Users h5users){
        getSession().saveOrUpdate(h5users);        
    }
    public H5Users getH5UserByOpenId(String openId){
        if(openId==null){
            return null;
        }
        try {
            String hsql="from H5Users a where a.openId=:openId";        
            Session session = sessionFactory.getCurrentSession();
            Query query = session.createQuery(hsql);    
            query.setString("openId", openId);    
            return (H5Users) query.list().get(0); 
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
               
    }
    
}

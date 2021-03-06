package com.springmvc.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springmvc.entity.H5Users;
import com.springmvc.repository.H5UsersRepository;

@Service("h5UsersService")
@Transactional
public class H5UsersService {
	@Resource
	private H5UsersRepository h5UsersRepository;
	
	@Transactional
	public int userCount(){
		return h5UsersRepository.getAllUser().size();
	}

	public H5UsersRepository getUsersRepository() {
		return h5UsersRepository;
	}

	public void setUserDao(H5UsersRepository h5UsersRepository) {
		this.h5UsersRepository = h5UsersRepository;
	}
	public H5Users getH5UsersById(Integer id){
	    return h5UsersRepository.getH5User(id);
	}
	public void saveOrUpdateH5User(H5Users h5users){
	    h5UsersRepository.saveOrUpdateH5User(h5users);
	}
    public H5Users getH5UserByOpenId(String openId){
        return h5UsersRepository.getH5UserByOpenId(openId);
    }
}

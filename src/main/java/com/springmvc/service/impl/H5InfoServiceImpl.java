package com.springmvc.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.springmvc.entity.H5Info;
import com.springmvc.repository.H5InfoRepository;
import com.springmvc.service.H5InfoService;

@Service
public class H5InfoServiceImpl implements H5InfoService {
    @Resource
    private H5InfoRepository h5InfoRepository;

    @Override
    public void saveH5Info(H5Info h5Info) {
        h5InfoRepository.saveH5Info(h5Info);
        
    }

    @Override
    public H5Info getH5InfoById(Integer h5InfoId) {
        // TODO Auto-generated method stub
        return h5InfoRepository.getH5Info(h5InfoId);
    }

    @Override
    public List<H5Info> getH5InfoList(Integer type,Integer pageNum,Integer pageCount) {
        // TODO Auto-generated method stub
        return h5InfoRepository.getAllH5Info(type,pageNum,pageCount);
    }

    @Override
    public void deleteH5Info(H5Info h5Info) {
        // TODO Auto-generated method stub
        h5InfoRepository.removeH5Info(h5Info);
    }

}

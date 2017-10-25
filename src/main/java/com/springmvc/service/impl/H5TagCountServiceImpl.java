package com.springmvc.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springmvc.entity.H5TagCount;
import com.springmvc.repository.H5TagCountRepository;
import com.springmvc.service.H5TagCountService;

@Service
@Transactional
public class H5TagCountServiceImpl implements H5TagCountService {
    @Resource
    private H5TagCountRepository h5TagCountRepository;

    @Override
    public void saveOrUpdateH5TagCount(H5TagCount h5TagCount) {
        h5TagCountRepository.saveOrUpdateH5TagCount(h5TagCount);
        
    }

    @Override
    public H5TagCount getH5TagCount(Integer id) {
        // TODO Auto-generated method stub
        return h5TagCountRepository.getH5TagCount(id);
    }

    @Override
    public List<H5TagCount> getH5TagCount(H5TagCount h5TagCount, Integer h5TagCountId) {
        // TODO Auto-generated method stub
        return null;
    }


}

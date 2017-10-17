package com.springmvc.service;

import java.util.List;

import com.springmvc.entity.H5TagCount;

public interface H5TagCountService {

    public void saveOrUpdateH5TagCount(H5TagCount h5TagCount);
    H5TagCount getH5TagCount(Integer id);
    
    List<H5TagCount> getH5TagCount(H5TagCount h5TagCount,Integer h5TagCountId);
    
}

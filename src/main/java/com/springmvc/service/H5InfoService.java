package com.springmvc.service;

import java.util.List;

import com.springmvc.entity.H5Info;

public interface H5InfoService {
    public void saveH5Info(H5Info h5Info);
    
    public H5Info getH5InfoById(Integer h5InfoId);
    
    public List<H5Info> getH5InfoList(Integer type,Integer pageNum,Integer pageCount);

    public void deleteH5Info(H5Info h5Info);
    
}

package com.springmvc.service;

import java.util.List;

import com.springmvc.entity.H5Info;
import com.springmvc.entity.H5Tag;

public interface H5TagService {
    public void saveOrUpdateH5Tag(H5Tag h5Tag);
        
    public H5Tag getH5TagById(Integer h5TagId);
    
    public List<H5Tag> getH5TagList();
    
    public List<H5Tag> getH5TagListByH5InfoId(Integer h5InfoId);

    public void deleteH5Tag(H5Tag h5Tag);
    
    public void increaseData(Integer h5TagId );
    
    public void saveOrUpdateBatchH5Tags(String[] names,H5Info h5Info);
}

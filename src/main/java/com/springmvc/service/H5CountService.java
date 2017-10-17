package com.springmvc.service;

import java.util.List;

import com.springmvc.entity.H5Count;

public interface H5CountService {
    public void saveH5Count(H5Count h5Count);
    
    public H5Count getH5CountById(Integer h5CountId);
    
    public List<H5Count> getH5CountList(Integer type);
    
    /**
     * @description 增加数据 每次+1
     * @author guoyang
     * @date 2017年10月11日
     * @param h5InfoId 
     * @param type 1.累计浏览次数 2.累计被分享次数 3.被赞数
     */
    public void increaseData(Integer h5InfoId ,Integer type);
}

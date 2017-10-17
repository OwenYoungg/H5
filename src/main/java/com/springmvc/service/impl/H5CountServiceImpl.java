package com.springmvc.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.springmvc.entity.H5Count;
import com.springmvc.repository.H5CountRepository;
import com.springmvc.service.H5CountService;

@Service
public class H5CountServiceImpl implements H5CountService {
    @Resource
    private H5CountRepository h5CountRepository;
    @Override
    public void saveH5Count(H5Count h5Count) {
        h5CountRepository.saveOrUpdateH5Count(h5Count);

    }

    @Override
    public H5Count getH5CountById(Integer h5CountId) {
        // TODO Auto-generated method stub
        return h5CountRepository.getH5Count(h5CountId);
    }


    @Override
    public List<H5Count> getH5CountList(Integer type) {
        return h5CountRepository.getH5CountList(type);
    }

    @Override
    public void increaseData(Integer h5InfoId ,Integer type) {
        if(type!=null){
            H5Count h5Count=h5CountRepository.getH5CountByH5InfoId(h5InfoId);
            if(type==1){//累计浏览次数
                h5Count.setViewsTimes(h5Count.getViewsTimes()+1);
            }else if(type==2){//累计被分享次数
                h5Count.setShareTimes(h5Count.getShareTimes()+1);
            }else if(type==3){//累计被赞数
                h5Count.setGoodTimes(h5Count.getGoodTimes()+1);
            }
            h5CountRepository.saveOrUpdateH5Count(h5Count);
        }
        
    }

}

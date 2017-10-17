package com.springmvc.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.springmvc.entity.H5Tag;
import com.springmvc.repository.H5TagRepository;
import com.springmvc.service.H5TagService;

@Service
public class H5TagServiceImpl implements H5TagService {
    @Resource
    private H5TagRepository h5TagRepository;

    @Override
    public void saveOrUpdateH5Tag(H5Tag h5Tag) {
        h5TagRepository.saveH5Tag(h5Tag);
        
    }

    @Override
    public H5Tag getH5TagById(Integer h5TagId) {
        // TODO Auto-generated method stub
        return h5TagRepository.getH5Tag(h5TagId);
    }

    @Override
    public List<H5Tag> getH5TagList() {
        // TODO Auto-generated method stub
        return h5TagRepository.getH5TagListByH5InfoId(null);
    }

    @Override
    public List<H5Tag> getH5TagListByH5InfoId(Integer h5InfoId) {
        // TODO Auto-generated method stub
        return h5TagRepository.getH5TagListByH5InfoId(h5InfoId);
    }

    @Override
    public void deleteH5Tag(H5Tag h5Tag) {
        // TODO Auto-generated method stub
        h5TagRepository.removeH5Tag(h5Tag);
    }

    @Override
    public void increaseData(Integer h5TagId) {
        H5Tag h5Tag=h5TagRepository.getH5Tag(h5TagId);
        h5Tag.setGoodTimes(h5Tag.getGoodTimes()+1);
        h5TagRepository.saveH5Tag(h5Tag);
    }

}

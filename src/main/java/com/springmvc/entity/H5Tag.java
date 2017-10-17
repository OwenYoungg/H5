package com.springmvc.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;
/**
 * @description h5对应标签表
 * @author guoyang
 * @date 2017年10月9日
 */
@Entity
@Table(name="h5_tag")
public class H5Tag  {
    /**
     * 
     */
//    private static final long serialVersionUID = -6328351741956814749L;
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="id")
    private Integer id;
    /**H5基本信息表ID**/
//    @NotNull
    @JsonIgnore
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="h5_id")
    public H5Info h5Info;
    
    @OneToMany(cascade=CascadeType.ALL,fetch=FetchType.LAZY,mappedBy="h5Tag")
    @JsonIgnore
    private List<H5TagCount> tagCounts = new ArrayList<H5TagCount>();
    /**
     * 被赞数
     */
    @Column(name="good_times")
    private Integer goodTimes=0;
    /**
     * 标签名
     */
    @Column(name="name")
    private String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public H5Info getH5Info() {
        return h5Info;
    }

    public void setH5Info(H5Info h5Info) {
        this.h5Info = h5Info;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<H5TagCount> getTagCounts() {
        return tagCounts;
    }

    public void setTagCounts(List<H5TagCount> tagCounts) {
        this.tagCounts = tagCounts;
    }

    public Integer getGoodTimes() {
        return goodTimes;
    }

    public void setGoodTimes(Integer goodTimes) {
        this.goodTimes = goodTimes;
    }
    
    
    
}

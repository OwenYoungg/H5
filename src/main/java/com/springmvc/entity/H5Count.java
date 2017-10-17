package com.springmvc.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * @description h5计数表
 * @author guoyang
 * @date 2017年10月9日
 */
@Entity
@Table(name="h5_count")
@JsonIgnoreProperties(value={"hibernateLazyInitializer","handler","fieldHandler"}) 
public class H5Count{

    /**
     * 
     */
//    private static final long serialVersionUID = -5258392928082505094L;


    /**
     * 
     */

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="id")
    private Integer id;
    

    /**H5基本信息表ID**/
    @NotNull
    @OneToOne(fetch=FetchType.LAZY)  
    @JoinColumn(referencedColumnName="id",name="h5_id",unique=true)
    @JsonIgnore
    public H5Info h5Info;
    
    /**
     * 累计浏览次数
     */
    @Column(name="views_times")
    private Integer viewsTimes=0; 
    
    /**
     * 累计被分享次数
     */
    @Column(name="share_times")
    private Integer shareTimes=0; 
    
    /**
     * 被赞数
     */
    @Column(name="good_times")
    private Integer goodTimes=0;

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

    public Integer getViewsTimes() {
        return viewsTimes;
    }

    public void setViewsTimes(Integer viewsTimes) {
        this.viewsTimes = viewsTimes;
    }

    public Integer getShareTimes() {
        return shareTimes;
    }

    public void setShareTimes(Integer shareTimes) {
        this.shareTimes = shareTimes;
    }

    public Integer getGoodTimes() {
        return goodTimes;
    }

    public void setGoodTimes(Integer goodTimes) {
        this.goodTimes = goodTimes;
    } 
    


    

}

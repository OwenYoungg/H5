package com.springmvc.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * @description h5标签被赞记录
 * @author guoyang
 * @date 2017年10月9日
 */
@Entity
@Table(name="h5_tag_count")
public class H5TagCount  {



    /**
     * 
     */
//    private static final long serialVersionUID = 931171926811153953L;


    /**
     * 
     */

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="id")
    private Integer id;
    

    /**标签ID**/
    @NotNull
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="tag_id", nullable=false)
    @JsonIgnore
    public H5Tag h5Tag;

    /**用户**/
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="user_id", nullable=false)
    public H5Users user;
    
    /**
     * 用户微信号
     */
    @Column(name="wechat_open_id")
    private String wechatOpenId; 
    
    /**
     * 点赞时间
     */
    @NotNull
    @Column(name="good_time")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @Temporal(TemporalType.TIMESTAMP)
    private Date goodTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public H5Tag getH5Tag() {
        return h5Tag;
    }

    public void setH5Tag(H5Tag h5Tag) {
        this.h5Tag = h5Tag;
    }

    public H5Users getUser() {
        return user;
    }

    public void setUser(H5Users user) {
        this.user = user;
    }

    public String getWechatOpenId() {
        return wechatOpenId;
    }

    public void setWechatOpenId(String wechatOpenId) {
        this.wechatOpenId = wechatOpenId;
    }

    public Date getGoodTime() {
        return goodTime;
    }

    public void setGoodTime(Date goodTime) {
        this.goodTime = goodTime;
    }



    

}

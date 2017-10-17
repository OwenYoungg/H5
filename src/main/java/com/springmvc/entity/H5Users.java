package com.springmvc.entity;


import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity(name="h5_user")
@JsonIgnoreProperties(value={"hibernateLazyInitializer","handler","fieldHandler"}) 
public class H5Users implements Serializable{
	
	/**
     * 
     */
    private static final long serialVersionUID = 810957132564120921L;

    public H5Users(){
		super();
	}
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
	private Integer id;
	
	/**
	 * 微信openid
	 */
	@Column(name="wechat_open_id",length=255)
	private String openId;
	
	/**
	 * 微信昵称
	 */
	@Column(name="wechat_nickname")
	private String nickname;
	
    /**
     * 注册时间
     */
	@NotNull
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="create_time",updatable = false)
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date createTime;
    
    /**
     * 最后登录时间
     */
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="last_login_time",updatable = false)
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date lastLoginTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(Date lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

	
	

}

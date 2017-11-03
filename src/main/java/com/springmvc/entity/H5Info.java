package com.springmvc.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * @description h5基本信息表
 * @author guoyang
 * @date 2017年10月9日
 */
@Entity
@Table(name="h5_info")
@JsonIgnoreProperties(value={"hibernateLazyInitializer","handler","fieldHandler"}) 
public class H5Info {
    /**
     * 
     */
//    private static final long serialVersionUID = 4661171892918782318L;

    /**
     * 
     */

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="id")
    private Integer id;
    
    /**
     * h5链接地址
     */
    @NotNull
    @Column(name="url")
    private String url;
    
    /**
     * h5上传时间
     */
    @Column(name="upload_time")
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")//保存时格式化数据使用
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")//返回前台时格式化数据使用
    private Date uploadTime;
    
    /**
     * h5标题
     */
    @NotNull
    @Column(name="title")
    private String title;
    /**
     * h5缩略图地址
     */
    @NotNull
    @Column(name="thumb")
    private String thumb;
    
    /**
     * 出品公司
     */
    @Column(name="company")
    private String company;

    /**
     * 出品产品
     */
    @Column(name="product")
    private String product;
    /**
     * 出品时间
     */
    @Column(name="production_time")
    @DateTimeFormat(pattern="yyyy-MM-dd")
//    @Temporal(TemporalType.DATE)//返回前台时格式化数据使用
    @JsonFormat(pattern="yyyy-MM")//返回前台时格式化数据使用
    private Date productionTime;

    /**
     * 是否可用iframe嵌入
     */
    @Column(name="embedded_iframe")
    private Boolean embeddedIframe;

    
    @OneToMany(cascade=CascadeType.REMOVE,fetch=FetchType.LAZY,mappedBy="h5Info")
//    @JsonIgnore
    private List<H5Tag> tags = new ArrayList<H5Tag>();
    

    @OneToOne( cascade = CascadeType.ALL, mappedBy = "h5Info",fetch=FetchType.LAZY)
    private H5Count h5Count;
    

    public Integer getId() {
        return id;
    }


    public void setId(Integer id) {
        this.id = id;
    }


    public String getUrl() {
        return url;
    }


    public void setUrl(String url) {
        this.url = url;
    }


    public Date getUploadTime() {
        return uploadTime;
    }


    public void setUploadTime(Date uploadTime) {
        this.uploadTime = uploadTime;
    }


    public String getTitle() {
        return title;
    }


    public void setTitle(String title) {
        this.title = title;
    }


    public String getThumb() {
        return thumb;
    }


    public void setThumb(String thumb) {
        this.thumb = thumb;
    }


    public String getCompany() {
        return company;
    }


    public void setCompany(String company) {
        this.company = company;
    }


    public String getProduct() {
        return product;
    }


    public void setProduct(String product) {
        this.product = product;
    }


    public Date getProductionTime() {
        return productionTime;
    }


    public void setProductionTime(Date productionTime) {
        this.productionTime = productionTime;
    }


    public Boolean getEmbeddedIframe() {
        return embeddedIframe;
    }


    public void setEmbeddedIframe(Boolean embeddedIframe) {
        this.embeddedIframe = embeddedIframe;
    }


    public List<H5Tag> getTags() {
        return tags;
    }


    public void setTags(List<H5Tag> tags) {
        this.tags = tags;
    }


    public H5Count getH5Count() {
        return h5Count;
    }


    public void setH5Count(H5Count h5Count) {
        this.h5Count = h5Count;
    }



    

}

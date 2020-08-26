/**
 * 
 */
package com.ax.bug;

/**
 * @description:需要的数据对象，也就是实体类（但我们不需要数据库做连接，直接返回输出）
 * @author AoXiang
 * @date 2017年3月21日
 * @version 1.0
 */
public class LinkTypeData {
    
    /*
     * 序号id
     */
    private String id;
    
    /*
     * url链接
     */
    private String linkHref;
    
    /*
     * 链接标题
     */
    private String linkText;
    
    /*
     * 摘要
     */
    private String summary;
    
    /*
     * 内容
     */
    private String content;

    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return the linkHref
     */
    public String getLinkHref() {
        return linkHref;
    }

    /**
     * @param linkHref the linkHref to set
     */
    public void setLinkHref(String linkHref) {
        this.linkHref = linkHref;
    }

    /**
     * @return the linkText
     */
    public String getLinkText() {
        return linkText;
    }

    /**
     * @param linkText the linkText to set
     */
    public void setLinkText(String linkText) {
        this.linkText = linkText;
    }

    /**
     * @return the summary
     */
    public String getSummary() {
        return summary;
    }

    /**
     * @param summary the summary to set
     */
    public void setSummary(String summary) {
        this.summary = summary;
    }

    /**
     * @return the content
     */
    public String getContent() {
        return content;
    }

    /**
     * @param content the content to set
     */
    public void setContent(String content) {
        this.content = content;
    }
}
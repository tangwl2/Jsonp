/**
 * 
 */
package com.ax.bug;

/**
 * @description:规则类
 * 这个规则类定义了我们查询过程中需要的所有信息，方便我们的扩展
 * 以及代码的重用，因为我们不可能针对每个需求都要写一遍
 * @author AoXiang
 * @date 2017年3月21日
 * @version 1.0
 */
public class Rule {
    
    /*
     * 链接
     */
    private String url;
    
    /*
     * 参数集合
     */
    private String[] params;
    
    /*
     * 参数对应的值
     */
    private String[] values;
    
    /*
     * 对返回的html，第一次过滤所使用的标签，先设置type
     */
    private String resultTagName;
    
    /*
     * class/id/selection
     * 设置resultTagName的类型，默认为id
     */
    private int type = ID; 
    
    /*
     * GET/POST
     * 请求的类型，默认为Get
     */
    private int requestMethod = GET;
    
    public static final int GET =0;
    public static final int POST=1;
    public static final int CLASS=0;
    public static final int ID =1;
    public static final int SELECTION=2;
    
    /*
     * 当有参构造函数存在时，无参构造函数一定要表现出来
     * 如果有参构造函数没有，无参构造函数可以不写，默认就是无参的
     */
    public Rule(){
        
    }
    
    /**
     * @param url
     * @param params
     * @param values
     * @param resultTagName
     * @param type
     * @param requestMethod
     */
    public Rule(String url, String[] params, String[] values, String resultTagName, int type, int requestMethod) {
        super();
        this.url = url;
        this.params = params;
        this.values = values;
        this.resultTagName = resultTagName;
        this.type = type;
        this.requestMethod = requestMethod;
    }

    /**
     * @return the url
     */
    public String getUrl() {
        return url;
    }

    /**
     * @param url the url to set
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * @return the params
     */
    public String[] getParams() {
        return params;
    }

    /**
     * @param params the params to set
     */
    public void setParams(String[] params) {
        this.params = params;
    }

    /**
     * @return the values
     */
    public String[] getValues() {
        return values;
    }

    /**
     * @param values the values to set
     */
    public void setValues(String[] values) {
        this.values = values;
    }

    /**
     * @return the resultTagName
     */
    public String getResultTagName() {
        return resultTagName;
    }

    /**
     * @param resultTagName the resultTagName to set
     */
    public void setResultTagName(String resultTagName) {
        this.resultTagName = resultTagName;
    }

    /**
     * @return the type
     */
    public int getType() {
        return type;
    }

    /**
     * @param type the type to set
     */
    public void setType(int type) {
        this.type = type;
    }

    /**
     * @return the requestMethod
     */
    public int getRequestMethod() {
        return requestMethod;
    }

    /**
     * @param requestMethod the requestMethod to set
     */
    public void setRequestMethod(int requestMethod) {
        this.requestMethod = requestMethod;
    }
}
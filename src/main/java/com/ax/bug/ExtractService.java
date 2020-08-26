/**
 * 
 */
package com.ax.bug;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 * @description:核心的查询类
 * @author AoXiang
 * @date 2017年3月21日
 * @version 1.0
 */
public class ExtractService {
    
    public static List<LinkTypeData> extract(Rule rule) throws IOException{
        // 校验url
        validateRule(rule);
        
        // 定义和获取变量
        List<LinkTypeData> datas = new ArrayList<LinkTypeData>();
        LinkTypeData data = null;
        String url = rule.getUrl();
        String[] params = rule.getParams();
        String[] values = rule.getValues();
        String resultTagName = rule.getResultTagName();
        int type = rule.getType();
        int requestType = rule.getRequestMethod();
        
        // 建立和url的链接（参考jsoup的用法）
        Connection conn = Jsoup.connect(url);
        // 设置查询参数
        if(params != null){
            for(int i=0;i<params.length;i++){
                conn.data(params[i],values[i]);
            }
        }
        
        // 定义节点
        Document doc = null;
        
        // 设置请求类型
        switch(requestType){
        case Rule.GET:
            doc = conn.timeout(100000).get();
            break;
        case Rule.POST:
            doc = conn.timeout(100000).post();
            break;
        }
        
        /* 根据不同的请求类型处理返回的数据，当为Id时取到的只有一个指定元素，
         * 所以加入elements的集合中，但是为class时，取到的已经是一个集合
         * 不需要再额外添加，如果没有拿到请求参数，取全部，也就是body
         * 主体中的内容
         */
        Elements results = new Elements();
        switch(type){
        case Rule.CLASS:
            results = doc.getElementsByClass(resultTagName);
            break;
        case Rule.ID:
            Element result = doc.getElementById(resultTagName);
            results.add(result);
            break;
        case Rule.SELECTION:
            results = doc.select(resultTagName);
            break;
        default:
            if(resultTagName == null || resultTagName == ""){
                results = doc.getElementsByTag("body");
            }
        }
        
        /*
         * 提取结果中的链接地址和链接标题，返回数据
         */
        for(Element result : results){
            Elements links = result.getElementsByTag("a");//可以拿到链接
            for(Element link : links){
                    String linkText = link.text();
                    // 对取得的html中的 出现问号乱码进行处理
                    linkText = new String(linkText.getBytes(),"GBK").replace('?', ' ').replace('　', ' ');
                    String id = link.parent().firstElementSibling().text();
                    id = new String(id.getBytes(),"GBK").replace('?', ' ').replace('　', ' ');
                    String address = link.parent().nextElementSibling().text();
                    address = new String(address.getBytes(),"GBK").replace('?', ' ').replace('　', ' ');
                    String code = link.parent().lastElementSibling().text();
                    code = new String(code.getBytes(),"GBK").replace('?', ' ').replace('　', ' ');
                    data = new LinkTypeData();
                    data.setLinkText(linkText);
                    data.setSummary(address);
                    data.setContent(code);
                    data.setId(id);
                    datas.add(data);
            }
        }
        return datas;
    }
    
    /**
     * 对传入的参数（url链接）进行必要的校验
     * @author AoXiang
     * @date 2017年3月21日
     */
    public static void validateRule(Rule rule){
        String url = rule.getUrl();
        if(url==null || url == ""){
            throw new RuleException("url不能为空");
        }
        if(!url.startsWith("http://")){
            throw new RuleException("url的格式不正确");
        }
        if(rule.getParams()!=null && rule.getValues()!=null){
            if(rule.getParams().length!=rule.getValues().length){
                throw new RuleException("参数的键值对不匹配");
            }
        }
    }
}
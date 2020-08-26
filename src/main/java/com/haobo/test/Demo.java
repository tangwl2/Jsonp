package com.haobo.test;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

//导入jar包
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Demo {
	public static void main(String[] args) {
		Demo d = new Demo();
		try {
			ResponseResult rr = d.httpdata("https://www.baidu.com");
			System.err.println(rr.toString());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

//    @RequestMapping(value="/http",method=RequestMethod.GET)
    public ResponseResult httpdata(String http) throws IOException{
        //根据获取的网址 爬取内容
        Document doc = Jsoup.connect(http).get();  //"http://www.yiibai.com" @PathVariable
        String title = doc.title();  
        System.out.println("title is: " + title);  
        System.err.println(doc);
        Map<String,Object> map= new HashMap<String,Object>();
        ResponseResult result = new ResponseResult();
        if(title.isEmpty()){
            result.setStatus(0);
            result.setMsg("未找到记录");
        }else{
            map.put("title", title);
            result.setStatus(200);
            result.setMsg("查询成功");
            result.setData(map);
        }
        return result;
    }
}

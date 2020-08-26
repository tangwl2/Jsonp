package com.haobo.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
*
* @author 晓峰2007.1.18 抓取雅虎知识堂的文章标题及内容（测试） 手动输入网址抓取，可进一步自动抓取整个知识堂的全部内容
*
*/
public class Test{
	
	/**
	* 读取一个网页全部内容
	*/
	public String getOneHtml(final String htmlurl) throws IOException{
		URL url;
		String temp;
		final StringBuffer sb = new StringBuffer();
		try{
			url = new URL(htmlurl);
			final BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream(), "utf-8"));// 读取网页全部内容
			while ((temp = in.readLine()) != null){
				sb.append(temp);
			}
			in.close();
		}catch (final MalformedURLException me){
			System.out.println("你输入的URL格式有问题！请仔细输入");
			me.getMessage();
			throw me;
		}catch (final IOException e){
			e.printStackTrace();
			throw e;
		}
		return sb.toString();
	}

	/**
	*
	* @param s
	* @return 获得网页标题
	*/
	public String getTitle(final String s){
		String regex;
		String title = "";
		final List<String> list = new ArrayList<String>();
		regex = "<title>.*?</title>";
		final Pattern pa = Pattern.compile(regex, Pattern.CANON_EQ);
		final Matcher ma = pa.matcher(s);
		while (ma.find()){
			list.add(ma.group());
		}
		for (int i = 0; i < list.size(); i++){
			title = title + list.get(i);
		}
		return outTag(title);
	}

	/**
	*
	* @param s
	* @return 获得链接
	*/
	public List<String> getLink(final String s){
		String regex;
		final List<String> list = new ArrayList<String>();
		regex = "<a[^>]*href=(\"([^\"]*)\"|\'([^\']*)\'|([^\\s>]*))[^>]*>(.*?)</a>";
		final Pattern pa = Pattern.compile(regex, Pattern.DOTALL);
		final Matcher ma = pa.matcher(s);
		while (ma.find()){
			list.add(ma.group());
		}
		return list;
	}

	/**
	*
	* @param s
	* @return 获得脚本代码
	*/
	public List<String> getScript(final String s){
		String regex;
		final List<String> list = new ArrayList<String>();
		regex = "<SCRIPT.*?</SCRIPT>";
		final Pattern pa = Pattern.compile(regex, Pattern.DOTALL);
		final Matcher ma = pa.matcher(s);
		while (ma.find()){
			list.add(ma.group());
		}
		return list;
	}
	
	
	public List<String> getNews(String s){
		String regex = "<a.*?</a>";
		Pattern pa = Pattern.compile(regex, Pattern.DOTALL);
		Matcher ma = pa.matcher(s);
		List<String> list = new ArrayList<String>();
		while (ma.find()){
			list.add(ma.group());
		}
		return list;
	}
	/**
	*
	* @param s
	* @return 获得CSS
	*/
	public List<String> getCSS(final String s){
		String regex;
		final List<String> list = new ArrayList<String>();
		regex = "<style.*?</style>";
		final Pattern pa = Pattern.compile(regex, Pattern.DOTALL);
		final Matcher ma = pa.matcher(s);
		while (ma.find()){
			list.add(ma.group());
		}
		return list;
	}

	/**
	*
	* @param s
	* @return 去掉标记
	*/
	public String outTag(final String s){
		return s.replaceAll("<.*?>", "");
	}

	/**
	*
	* @param s
	* @return 获取雅虎知识堂文章标题及内容
	*/
	public HashMap<String, String> getFromYahoo(final String s){
		final HashMap<String, String> hm = new HashMap<String, String>();
		final StringBuffer sb = new StringBuffer();
		String html = "";
		System.out.println("\n------------------开始读取网页(" + s + ")--------------------");
		try{
			html = getOneHtml(s);
		}catch (final Exception e){
			e.getMessage();
		}
		
		System.out.println("------------------读取网页(" + s + ")结束--------------------\n");
		System.out.println("------------------分析(" + s + ")结果如下--------------------\n");
		String title = outTag(getTitle(html));
		title = title.replaceAll("_雅虎知识堂", "");
		// Pattern pa=Pattern.compile("<div
		// class=\"original\">(.*?)((\r\n)*)(.*?)((\r\n)*)(.*?)</div>",Pattern.DOTALL);
		final Pattern pa = Pattern.compile("<div class=\"original\">(.*?)</p></div>", Pattern.DOTALL);
		final Matcher ma = pa.matcher(html);
		while (ma.find()){
			sb.append(ma.group());
		}
		String temp = sb.toString();
		temp = temp.replaceAll("(<br>)+?", "\n");// 转化换行
		temp = temp.replaceAll("<p><em>.*?</em></p>", "");// 去图片注释
		hm.put("title", title);
		hm.put("original", outTag(temp));
		return hm;
		
	}

	public static void main(String[] args) throws IOException {
		Test t = new Test();
		String js = t.getOneHtml("http://gamelog.jinzun668.com:5001/servlet/gamelogssecond?today=1&type=daily&page=1");
		System.out.println(t.getOneHtml("http://gamelog.jinzun668.com:5001/servlet/gamelogssecond?today=1&type=daily&page=2"));
		List<String> a = t.getNews(js);
		List<String> news = new ArrayList<String>();
		for(String s: a){
			news.add(s.replaceAll("<.*?>", ""));
		}
		System.out.println(news);
	}
}

/**
 * 
 */
package com.ax.bug;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;


/**
 * @description:
 * @author AoXiang
 * @date 2017年3月21日
 * @version 1.0
 */
public class Test {
	public static void main(String[] args) {
		Test t = new Test();
		try {
			t.getDatasByCssQuery();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		  HashMap<String, Integer> hm = new HashMap<String, Integer>();
//        //放入元素
//        hm.put("Harry",23);
//        hm.put("Jenny",24);
//        hm.put("XiaoLi",20);
//
//        System.out.println(hm);//{XiaoLi=20, Harry=23, Jenny=24}
//        System.out.println(hm.keySet());//[XiaoLi, Harry, Jenny]
//        System.out.println(hm.values());//[20, 23, 24]
//
//        Set<Map.Entry<String, Integer>> entries = hm.entrySet();
//        Iterator<Map.Entry<String, Integer>> iterator = entries.iterator();
//        while (iterator.hasNext()) {
//			Entry<String, Integer> entry = iterator.next();
//			System.err.println(entry.getKey());
//			System.err.println(entry.getValue());
//        }
	}

    /**
     * 不带查询参数
     * @author AoXiang
     * 2017年3月21日
     */
//    public void getDataByClass() throws IOException{
//        Rule rule = new Rule( "http://www1.sxcredit.gov.cn/public/infocomquery.do?method=publicIndexQuery",
//                null,null,
//                "cont_right", Rule.CLASS, Rule.POST);
//        List<LinkTypeData> extracts = ExtractService.extract(rule);
//        printf(extracts);
//    }
    
    /**
     * 带查询参数
     * @author AoXiang
     * 2017年3月21日
     */
    public void getDatasByCssQuery() throws IOException  
    {  
        Rule rule = new Rule("http://www.11315.com/search",  
                new String[] { "name" }, new String[] { "兴网" },  
                "div.g-mn div.con-model", Rule.SELECTION, Rule.GET);  
        List<LinkTypeData> extracts = ExtractService.extract(rule);  
        printf(extracts);
    }
    
    @SuppressWarnings("resource")
	public void printf(List<LinkTypeData> datas){
         // 第一步，创建一个webbook，对应一个Excel文件  
        HSSFWorkbook wb = new HSSFWorkbook();  
        // 第二步，在webbook中添加一个sheet,对应Excel文件中的sheet  
        HSSFSheet sheet = wb.createSheet("信用企业");  
        // 第三步，在sheet中添加表头第0行,注意老版本poi对Excel的行数列数有限制short  
        HSSFRow row = sheet.createRow((int) 0);  
        // 第四步，创建单元格，并设置值表头 设置表头居中  
        HSSFCellStyle style = wb.createCellStyle();  
        style.setAlignment(HSSFCellStyle.ALIGN_CENTER); // 创建一个居中格式  
  
        HSSFCell cell = row.createCell(0);  
        cell.setCellValue("序号");  
        cell.setCellStyle(style);  
        cell = row.createCell(1);  
        cell.setCellValue("企业名称");  
        cell.setCellStyle(style);  
        cell = row.createCell(2);  
        cell.setCellValue("地址");  
        cell.setCellStyle(style);  
        cell = row.createCell(3);  
        cell.setCellValue("工商注册号");  
        cell.setCellStyle(style);  
        for (int i=0;i<datas.size();i++)  
        {  
            LinkTypeData ltd = (LinkTypeData) datas.get(i);  
            System.out.println(ltd.getId()+"======="+ltd.getLinkText()+"========="+ltd.getSummary()+"========"+ltd.getContent());
        
                // 第五步，写入实体数据
                row = sheet.createRow((int)i  + 1);  
                // 第四步，创建单元格，并设置值  
                row.createCell(0).setCellValue(ltd.getId());  
                row.createCell(1).setCellValue(ltd.getLinkText());  
                row.createCell(2).setCellValue(ltd.getSummary());  
                row.createCell(3).setCellValue(ltd.getContent());  
            }  
            // 第六步，将文件存到指定位置  
            try  
            {  
                FileOutputStream fout = new FileOutputStream("D:/信用企业.xls");  
                wb.write(fout);  
                fout.close();  
            }  
            catch (Exception e)  
            {  
                e.printStackTrace();  
            }  
        }
}
package com.haobo.test;

import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.codec.language.bm.Rule;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;


class Student{
	private int id;
	private String name;
	private String sex;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
}
@SuppressWarnings({ "unused", "resource" })
public class Demo_01 {
	
	
	public static void main(String[] args) throws Exception {
		Map<Integer, Student> map = new HashMap<Integer, Student>();
		Student stu1 = new Student();
		stu1.setId(1);
		stu1.setName("张三");
		stu1.setSex("男");
		Student stu2 = new Student();
		stu2.setId(2);
		stu2.setName("李四");
		stu2.setSex("男");
		Student stu3 = new Student();
		stu3.setId(3);
		stu3.setName("王五");
		stu3.setSex("男");
		
		map.put(stu1.getId(), stu1);
		map.put(stu2.getId(), stu2);
		map.put(stu3.getId(), stu3);
		System.err.println("\t"+map.containsKey(6));
		//假设是对象
		Student str = null;
		// 如果对象id是 1 的存在就获取对象
		if(map.containsKey(stu1.getId())) {
			str = map.get(stu1.getId());
		}
		System.err.println(str.getName()+"\t"+map.values().size());

//        // 第一步，创建一个webbook，对应一个Excel文件
//        HSSFWorkbook wb = new HSSFWorkbook();
//        // 第二步，在webbook中添加一个sheet,对应Excel文件中的sheet
//        HSSFSheet sheet = wb.createSheet("学生表一");
//        // 第三步，在sheet中添加表头第0行,注意老版本poi对Excel的行数列数有限制short
//        HSSFRow row = sheet.createRow((int) 0);
//        // 第四步，创建单元格，并设置值表头 设置表头居中
//        HSSFCellStyle style = wb.createCellStyle();
//        style.setAlignment(HSSFCellStyle.ALIGN_CENTER); // 创建一个居中格式
//        HSSFCell cell = row.createCell(0);
//        cell.setCellValue("姓名");
//        cell.setCellStyle(style);
//        cell = row.createCell(1);
//        cell.setCellValue("详情");
//        List<BatteryBean> list = new ArrayList<BatteryBean>();
//        for (int i = 0; i < 3; i++) {
//			BatteryBean bb = new BatteryBean();
//			bb.setName("张三_"+i);
//			bb.setBlork("详情_"+i);
//			list.add(bb);
//		}
//        // 第五步，写入实体数据 实际应用中这些数据从数据库得到，
//        for (int i = 0; i < list.size(); i++) {
//            row = sheet.createRow((int) i + 1);
//            BatteryBean stu = (BatteryBean) list.get(i);
//            // 第四步，创建单元格，并设置值
//            row.createCell(0).setCellValue(stu.getName());
//            row.createCell(1).setCellValue(stu.getBlork());
//        }
//        // 第六步，将文件存到指定位置1
//        try {
//            OutputStream outputStream = new ByteArrayOutputStream();
//            FileOutputStream fout = new FileOutputStream("D:/students.xls");
//            wb.write(fout);
//            fout.close();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
    }
	
	/**
     * 不带查询参数
     * @author AoXiang
     * 2017年3月21日
     */
    public void getDataByClass() throws IOException{
//        List<LinkTypeData> newList = new ArrayList<LinkTypeData>();
        for(int i=1;i<=8;i++){
            Rule rule = new Rule("http://www.aibang.com/?area=bizsearch2&cmd=bigmap&city=%E4%BD%9B%E5%B1%B1&a=%E5%8D%97%E6%B5%B7%E5%8C%BA&q=%E8%8D%AF%E5%BA%97&as=5000&ufcate=&rc=1&zone=&quan=&fm=&p="+i, null, null, null);
//            List<LinkTypeData> datas = ExtractService.extract(rule);
//            for(int j=0;j<datas.size();j++){
//                newList.add(datas.get(j));
//            }
        }
        
        // 第一步，创建一个webbook，对应一个Excel文件  
        HSSFWorkbook wb = new HSSFWorkbook();  
        
        // 第二步，在webbook中添加一个sheet,对应Excel文件中的sheet  
        HSSFSheet sheet = wb.createSheet("佛山药店");  
        
        // 第三步，在sheet中添加表头第0行,注意老版本poi对Excel的行数列数有限制short  
        HSSFRow row = sheet.createRow((int) 0);  
        
        // 第四步，创建单元格，并设置值表头 设置表头居中  
        HSSFCellStyle style = wb.createCellStyle();  
        style.setAlignment(HSSFCellStyle.ALIGN_CENTER); // 创建一个居中格式  
        HSSFCell cell = row.createCell(0);  
        cell.setCellValue("序号");  
        cell.setCellStyle(style);  
        cell = row.createCell(1);  
        cell.setCellValue("药店名称");  
        cell.setCellStyle(style);  
        cell = row.createCell(2);  
        cell.setCellValue("地址");  
        cell.setCellStyle(style);  
        cell = row.createCell(3);  
        cell.setCellValue("电话");  
        cell.setCellStyle(style);  
//        for(int m=0;m<newList.size();m++){
//            // 第五步，写入实体数据
//            row = sheet.createRow((int)m  + 1);  
//            // 第四步，创建单元格，并设置值  
//            row.createCell(0).setCellValue(newList.get(m).getId());  
//            row.createCell(1).setCellValue(newList.get(m).getLinkText());  
//            row.createCell(2).setCellValue(newList.get(m).getSummary());  
//            row.createCell(3).setCellValue(newList.get(m).getContent());  
//        }
          // 第六步，将文件存到指定位置  
        try  
        {  
            FileOutputStream fout = new FileOutputStream("F:/佛山药店.xls");  
            wb.write(fout);  
            fout.close();  
        }  
        catch (Exception e)  
        {  
            e.printStackTrace();  
        }  
    }
}

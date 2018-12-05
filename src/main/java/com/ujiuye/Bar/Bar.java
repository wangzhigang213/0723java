package com.ujiuye.Bar;

import java.awt.Font;
import java.io.IOException;

import javax.servlet.http.HttpSession;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.StandardChartTheme;
import org.jfree.chart.servlet.ServletUtilities;
import org.jfree.data.category.DefaultCategoryDataset;

public class Bar {
	
	public static String getBar(HttpSession session){
		//创建数据库集合
		DefaultCategoryDataset  dataset=new DefaultCategoryDataset();
		dataset.setValue(111, "北京", "香蕉");
		dataset.setValue(134, "北京", "苹果");
		dataset.setValue(156, "北京", "橘子");
		
		dataset.setValue(120, "上海", "香蕉");
		dataset.setValue(140, "上海", "苹果");
		dataset.setValue(150, "上海", "橘子");
		
		dataset.setValue(101, "深圳", "香蕉");
		dataset.setValue(111, "深圳", "苹果");
		dataset.setValue(170, "深圳", "橘子");
		//设置样式
		StandardChartTheme sct=new StandardChartTheme("CN");
		sct.setExtraLargeFont(new Font("宋体", Font.BOLD, 20));
		sct.setLargeFont(new  Font("宋体",Font.BOLD,20));
		sct.setRegularFont(new  Font("宋体",Font.ITALIC,20));
		
		ChartFactory.setChartTheme(sct);
		//创建柱状图
		JFreeChart chart = ChartFactory.createBarChart3D("水果销量图", "水果", "销量", dataset);
		
		//保存图片到服务器
		try {
			String filename=ServletUtilities.saveChartAsPNG(chart, 700, 700, session);
			return filename;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}

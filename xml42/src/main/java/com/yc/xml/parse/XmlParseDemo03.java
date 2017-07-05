package com.yc.xml.parse;

import java.io.InputStream;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class XmlParseDemo03 {
	public static void main(String[] args) throws Exception {
		//使用xml解析框架解析xml
			//1.引入解析框架包 dom4j		
			//2.要解析文件
			InputStream in = Thread.currentThread().getContextClassLoader().getResourceAsStream("person.xml");
			//3.解析工具
			SAXReader reader = new SAXReader(); 
			//4.开始解析
			Document doc = reader.read(in);   //解析成一个文档对象 （一个树结构的对象）
			Element root = doc.getRootElement();
			Element ele = root.element("name");
			System.out.println("id == " + root.attributeValue("id"));
			System.out.println(ele.getName() + " ==== " + ele.getText());
	}
}

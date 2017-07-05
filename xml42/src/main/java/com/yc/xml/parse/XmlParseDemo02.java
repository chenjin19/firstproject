package com.yc.xml.parse;

import java.io.InputStream;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

public class XmlParseDemo02 {
	public static void main(String[] args) throws Exception {
		//1.要解析文件
		InputStream in = Thread.currentThread().getContextClassLoader().getResourceAsStream("person01.xml");
		//2.解析工具
		SAXParserFactory factory = SAXParserFactory.newInstance();
		SAXParser parser = factory.newSAXParser();
		//3.开始解析, 要一个读取处理类，此类是DefaultHandler的子类
		parser.parse(in, new MyParserHandler());   //第一个参数是要解析的数据流， 第二个参数就是解析处理类
		
	}
}

package com.yc.xml.parse;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class MyParserHandler extends DefaultHandler {

	@Override  //开始读取xml文档
	public void startDocument() throws SAXException {
		System.out.println("<?xml version=\"1.0\" encoding=\"UTF-8\"");
	}

	@Override  //xml文档读取完成
	public void endDocument() throws SAXException {
		System.out.println("xml文件读取完成....");
	}

	@Override  //读取开始元素
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		System.out.print("\t<" + qName +">");
	}

	@Override //读取结束元素
	public void endElement(String uri, String localName, String qName) throws SAXException {
		System.out.println("</" + qName +">");
	}

	@Override //读取字符元素
	public void characters(char[] ch, int start, int length) throws SAXException {
		System.out.print("" + new String(ch, start, length));
	}
	
}

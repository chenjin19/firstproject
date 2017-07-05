package com.yc.xml.parse;

import java.io.InputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class XmlParseDemo {
	public static void main(String[] args) throws Exception {
		//要取到xml文件中的内容
		//1.加载半结构化数据文件到程序中
		InputStream in = Thread.currentThread().getContextClassLoader().getResourceAsStream("person01.xml");
		
		//XmlParseDemo.class.getClassLoader().getResourceAsStream(name);
		//2. 解析文件流成文档对象 Document
		//DocumentBuilderFactory, DocumentBuilder, Document
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();   //Documnent文档对象构建工厂对象 
		DocumentBuilder builder = factory.newDocumentBuilder();//Documnent文档对象构建 对象 
		Document doc = builder.parse(in);//通过数据流构建Document文档对象
		//3.使用Document对象取出半结构化数据文件中的数据内容
	/*	NodeList nodes = ((Element)(doc.getElementsByTagName("contact").item(0))).getElementsByTagName("telephone");  //取到所有元素名为“name”的元素节点 
		//Node node = nodes.item(0);  //在节点列表中取到第一个节点
		
		for (int i = 0; i <nodes.getLength(); i++) {
			Node node = nodes.item(i);
			if(node instanceof Element){
				Element ele = (Element) node; 
				System.out.print(ele.getNodeName());  //取到元素节点的名字
				//System.out.println(ele.getFirstChild().getNodeValue()); //取到元素节点的 文本字符
				System.out.println( " === " + ele.getTextContent());//取到元素节点的 文本字符
			}
		}*/
		
		NodeList nodes = doc.getChildNodes();
		
		for (int i = 0; i < nodes.getLength(); i++) {
			Node node = nodes.item(i);
			if(node.getNodeType() == Node.ELEMENT_NODE){
				nodes = node.getChildNodes();
				for (int j = 0; j <nodes.getLength(); j++) {
					if (nodes.item(j).getNodeType() == Node.ELEMENT_NODE) {
						System.out.print(nodes.item(j).getNodeName()); //取到元素节点的名字
						System.out.println(" === " + nodes.item(j).getTextContent());//取到元素节点的 文本字符
					}
				}
			}
		}
	}
}

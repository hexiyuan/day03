package cn.itcast.utils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

//
public class XmlUtils {
	private static String filepath;
	//居然可以这样写静态代码块！
	static{
		//得到xml文件位置；
		filepath = XmlUtils.class.getClassLoader().getResource("users.xml").getPath();
	}

	public static Document getDocument() throws Exception{
		SAXReader reader = new SAXReader();
		Document document = reader.read(new File(filepath));
		return document;
	}

	public static void write2Xml(Document document) throws IOException{
		OutputFormat format = OutputFormat.createPrettyPrint();
		format.setEncoding("utf-8");
		XMLWriter writer= new XMLWriter(new FileOutputStream(filepath),format);
		writer.write(document);
		writer.close();
	}
}
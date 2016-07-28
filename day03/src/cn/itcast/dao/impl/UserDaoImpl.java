package cn.itcast.dao.impl;

import java.text.SimpleDateFormat;

import org.dom4j.Document;
import org.dom4j.Element;

import cn.itcast.dao.UserDao;
import cn.itcast.domain.User;
import cn.itcast.utils.XmlUtils;
/*
 *Dao实现层需要根据业务需求来写（大部分是增删改查部分）
 */
public class UserDaoImpl implements UserDao {
	
	//1>增加节点。将新用户user的信息挂到根节点上去。
	public void add(User user){
		try {
			//引入工具类①：XmlUtils。该工具类实现对xml文档（相当与数据库）的读写操作。
			Document document = XmlUtils.getDocument();
			Element root = document.getRootElement();//获得根节点
			//在根节点中添加数据。
			Element user_tag = root.addElement("user");
			user_tag.setAttributeValue("id", user.getId());
			user_tag.setAttributeValue("username", user.getUsername());
			user_tag.setAttributeValue("password", user.getPassword());
			user_tag.setAttributeValue("email", user.getEmail());
			user_tag.setAttributeValue("birthday", user.getBirthday()==null?"":user.getBirthday().toLocaleString());
			user_tag.setAttributeValue("nickname", user.getNickname());
			//将文档从新写入xml文件。
			XmlUtils.write2Xml(document);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	//2>查找用户名为username密码为password的user用户。
	public User find(String username,String password){
		try{
			Document document = XmlUtils.getDocument();
			//xPath 元素查询语言
			Element e = (Element) document.selectSingleNode("//user[@username='"+username+"' and @password='"+password+"']");
			if(e == null){
				return null;
			}
			User user = new User();
			String date = e.attributeValue("birthday");
			if(date == null || date.equals("")){
				user.setBirthday(null);
			}else{
				SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
				user.setBirthday(df.parse(date));
			}
			user.setId(e.attributeValue("id"));
			user.setUsername(e.attributeValue("username"));
			user.setPassword(e.attributeValue("password"));
			user.setEmail(e.attributeValue("email"));
			user.setNickname(e.attributeValue("nickname"));
			return user;
		}
		catch(Exception e){
			 e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	//3>查找注册的用户是否在数据库中存在
	public boolean find(String username){
		try{
			Document document = XmlUtils.getDocument();
			Element e = (Element) document.selectSingleNode("//user[@username='"+username+"']");
			if(e == null){
				return false;
			}
			return true;
		}catch(Exception e){
			throw new RuntimeException(e);
		}
	}
}

package cn.itcast.web.formbean;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.beanutils.locale.converters.DateLocaleConverter;

public class RegisterForm {
	private String username;
	private String password;
	private String password2;
	private String email;
	private String birthday;
	private String nickname;
	private Map<String, String> errors = new HashMap<String, String>();

	public String getUsername() {return username;}
	public Map<String, String> getErrors() {return errors;}
	public void setErrors(Map<String, String> errors) {this.errors = errors;}
	public void setUsername(String username) {this.username = username;}
	public String getPassword() {return password;}
	public void setPassword(String password) {this.password = password;}
	public String getPassword2() {return password2;}
	public void setPassword2(String password2) {this.password2 = password2;}
	public String getEmail() {return email;}
	public void setEmail(String email) {this.email = email;}
	public String getBirthday() {return birthday;}
	public void setBirthday(String birthday) {this.birthday = birthday;}
	public String getNickname() {return nickname;}
	public void setNickname(String nickname) {this.nickname = nickname;}

	//用户名不能为空，并且要是3到8位字母。
	//密码不能为空，并且要是3到6位。
	//确认密码不能为空，并且要和第一次输入一致。
	//电子邮箱不能为空，并且要是一个格式合法的邮箱。
	//生日可以为空，但是一旦不为空，则必须要是一个日期。
	//昵称不可以为空，并且要是汉字。
	public boolean validate(){
		boolean isOK = true;
		//判定用户名
		if(this.username == null || this.username.trim().equals("")){
			isOK = false;
			errors.put("username", "用户名不能为空！");
		}else{
			//这个字母的正则表达式与下面密码判定的表达式有所不一样！请注意区分。
			if(!this.username.matches("[A-Za-z]{3,8}")){
				isOK = false;
				errors.put("username", "用户名必须要是3-8个字母！");
			}
		}
		//判定密码
		if(!this.password.matches("\\d{3,6}")){
			isOK = false;
			errors.put("password", "用户密码必须要是3-6个数字！");
		}
		//核对验证密码
		if(this.password2==null || this.password2.trim().equals("")){
			isOK = false;
			errors.put("password2", "确认密码不能为空！");
		}else{
			if(!this.password2.equals(password)){
				isOK = false;
				errors.put("password2", "确认密码必须与登陆密码一致！");
			}
		}
		//核对邮箱
		if(this.email==null || this.email.trim().equals("")){
			isOK = false;
			errors.put("email", "用户邮箱不能为空！");
		}else{
			//只存在一下三种邮箱格式：aaa@sina.com  或者 aaa@sina.com.cn  或者aa_bb.cc@sina.com.cn
			//正则表达式的格式为：\\w+@\\w+(\\.\\w+)+
			if(!this.email.matches("\\w+@\\w+(\\.\\w+)+")){
				isOK = false;
				errors.put("emial", "必须是一个正确的邮箱账号！");
			}
		}
		//核对生日
		if(this.birthday != null && !this.birthday.trim().equals("")){
			try{
				DateLocaleConverter dic = new DateLocaleConverter();
				dic.convert(this.birthday,"yyyy-MM-dd");
			}catch(Exception e){
				isOK = false;
				errors.put("birthday", "日期格式不对！");
			}
		}

		//核对昵称
		if(this.nickname == null || this.nickname.trim().equals("")){
			isOK = false;
			errors.put("nickname", "用户昵称不能为空！");
		}else {
			if(!this.nickname.matches("[\u4e00-\u9fa5]+")){
				isOK = false;
				errors.put("nickname", "昵称必须为汉字！");
			}
		}
		return isOK;
	}
}

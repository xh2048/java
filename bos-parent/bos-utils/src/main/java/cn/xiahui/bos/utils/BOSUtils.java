package cn.xiahui.bos.utils;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import cn.xiahui.bos.domain.User;

public class BOSUtils {
	//��ȡsession����
	public static HttpSession getSession(){
		return ServletActionContext.getRequest().getSession();
	}
	//��ȡ��¼�û�����
	public static User getLoginUser(){
		return (User) getSession().getAttribute("loginUser");
		
	}
}
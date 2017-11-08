package cn.xiahui.bos.web.action;


import java.io.IOException;

import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.apache.struts2.ServletActionContext;
import org.objectweb.asm.tree.TryCatchBlockNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import cn.xiahui.bos.domain.User;
import cn.xiahui.bos.service.IUserService;
import cn.xiahui.bos.utils.BOSUtils;
import cn.xiahui.bos.utils.MD5Utils;
import cn.xiahui.bos.web.action.base.BaseAction;

@Controller
@Scope("prototype")
public class UserAction extends BaseAction<User>{
	//��������������ҳ���������֤��
	private String checkcode;
	
	public void setCheckcode(String checkcode) {
		this.checkcode = checkcode;
	}
	
	@Autowired
	private IUserService userService;
	
	/**
	 * �û���¼,ʹ��shiro����ṩ�ķ���������֤����
	 */
	public String login(){
		//��session�л�ȡ���ɵ���֤��
		  String validatecode = (String) ServletActionContext.getRequest().getSession().getAttribute("key");
		  //У����֤���Ƿ�������ȷ
		  if(StringUtils.isNotBlank(checkcode) && checkcode.equals(validatecode)){
			//ʹ��shiro����ṩ�ķ�ʽ������֤����
			  Subject subject = SecurityUtils.getSubject();//��õ�ǰ�û�����״̬Ϊ��δ��֤��
			  AuthenticationToken token = new UsernamePasswordToken(model.getUsername(),MD5Utils.md5(model.getPassword()));//�����û����������ƶ���
			  try{
				  subject.login(token);
			  }catch(Exception e){
				  e.printStackTrace();
				  return LOGIN;
			  }
			  User user = (User) subject.getPrincipal();
			  ServletActionContext.getRequest().getSession().setAttribute("loginUser", user);
			  return HOME;
		  }else{
			  //�������֤�����������ʾ��Ϣ����ת����¼ҳ��
			  this.addActionError("�������֤�����");
			  return LOGIN;
		  }
		  
		  
	}
	
	
	/**
	 * �û���¼
	 */
	public String login_bak(){
		//��session�л�ȡ���ɵ���֤��
		  String validatecode = (String) ServletActionContext.getRequest().getSession().getAttribute("key");
		  //У����֤���Ƿ�������ȷ
		  if(StringUtils.isNotBlank(checkcode) && checkcode.equals(validatecode)){
			  //�������֤����ȷ
			  User user = userService.login(model);
			  if(user != null){
				  //��¼�ɹ�����user�������session����ת����ҳ
				  ServletActionContext.getRequest().getSession().setAttribute("loginUser", user);
				  return HOME;
			  }else{
					//��¼ʧ�ܣ�,������ʾ��Ϣ����ת����¼ҳ��
					//�������֤�����,������ʾ��Ϣ����ת����¼ҳ��
				  this.addActionError("�û������������������");
				  return LOGIN;
			  }
		  }else{
			  //�������֤�����������ʾ��Ϣ����ת����¼ҳ��
			  this.addActionError("�������֤�����");
			  return LOGIN;
		  }
	}
	
	/**
	 *�û�ע��
	 */
	public String logout(){
		ServletActionContext.getRequest().getSession().invalidate();
		return LOGIN;
	}
	
	/**
	 * �޸ĵ�ǰ�û�����
	 */
	public String editPassword() throws IOException{
		
		String f = "1";
		//��ȡ��ǰ��¼�û�
		User user = BOSUtils.getLoginUser();
		try {
			userService.editPassword(user.getId(),model.getPassword());
		} catch (Exception e) {
			f = "0";
			e.printStackTrace();
		}
		ServletActionContext.getResponse().setContentType("text/html;charset=utf-8");
		ServletActionContext.getResponse().getWriter().print(f);
		return NONE;
		
	}
	
	
	
	//�������������ܶ����ɫid
	private String[] roleIds;

	public void setRoleIds(String[] roleIds) {
		this.roleIds = roleIds;
	}
	
	/**
	 * ����û�
	 */
	public String add(){
		userService.save(model,roleIds);
		return LIST;
	}
	
	/**
	 * �û����ݷ�ҳ��ѯ
	 */
	public String pageQuery(){
		userService.pageQuery(pageBean);
		this.java2Json(pageBean, new String[]{"noticebills","roles"});
		return NONE;
	}
	
	
	
	
	
	
	
	
}

package cn.xiahui.bos.web.action;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import cn.xiahui.bos.domain.Role;
import cn.xiahui.bos.service.IRoleService;
import cn.xiahui.bos.web.action.base.BaseAction;

/**
 * ��ɫ����
 */
@Controller
@Scope("prototype")
public class RoleAction extends BaseAction<Role> {
	
	//��������������Ȩ�޵�id
	private String functionIds;
	
	@Autowired
	private IRoleService service;

	public void setFunctionIds(String functionIds) {
		this.functionIds = functionIds;
	}
	
	/**
	 * ��ӽ�ɫ
	 */
	public String add(){
		service.save(model,functionIds);
		return LIST;
	}
	
	/**
	 * ��ҳ��ѯ
	 */
	public String pageQuery(){
		service.pageQuery(pageBean);
		this.java2Json(pageBean, new String[]{"functions","users"});
		return NONE;
	}
	
	/**
	 * ��ѯ���еĽ�ɫ���ݣ�����json
	 */
	public String listajax(){
		List<Role> list = service.findAll();
		this.java2Json(list, new String[]{"functions","users"});
		return NONE;
	}
}

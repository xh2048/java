package cn.xiahui.bos.web.action;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import cn.xiahui.bos.domain.Function;
import cn.xiahui.bos.service.IFuctionService;
import cn.xiahui.bos.web.action.base.BaseAction;

/**
 * Ȩ�޹���
 * @author XH2016
 *
 */
@Controller
@Scope("prototype")
public class FunctionAction extends BaseAction<Function>{
	@Autowired
	private IFuctionService service;
	/**
	 * ��ѯ����Ȩ�ޣ�����json����
	 */
	public String listajax(){
		List<Function> list = service.findAll();
		this.java2Json(list, new String[]{"parentFunction","roles"});
		return NONE;
	}
	
	/**
	 * ���Ȩ��
	 */
	public String add(){
		service.save(model);
		return LIST;
	}
	
	public String pageQuery(){
		String page = model.getPage();
		pageBean.setCurrentPage(Integer.parseInt(page));
		service.pageQuery(pageBean);
		this.java2Json(pageBean, new String[]{"parentFunction","roles","children"});
		return NONE;
	}
}

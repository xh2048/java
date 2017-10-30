package cn.xiahui.bos.web.action;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import cn.xiahui.bos.domain.Decidedzone;
import cn.xiahui.bos.service.IDecidedzoneService;
import cn.xiahui.bos.web.action.base.BaseAction;

/**
 *��������
 */
@Controller
@Scope("prototype")
public class DecidedzoneAction extends BaseAction<Decidedzone>{
	//�������������ܶ������id
	private String[] subareaid;

	public void setSubareaid(String[] subareaid) {
		this.subareaid = subareaid;
	}
	
	@Autowired
	private IDecidedzoneService decidedzoneService;
	
	/**
	 * ��Ӷ���
	 */
	public String add(){
		decidedzoneService.save(model,subareaid);
		return LIST;
	}
	
	/**
	 * ��ҳ��ѯ����
	 */
	public String pageQuery() throws IOException{
		decidedzoneService.pageQuery(pageBean);
		this.java2Json(pageBean, new String[]{"currentPage","detachedCriteria","pageSize","subareas","decidedzones"});
		return NONE;
	}
}

package cn.xiahui.bos.web.action;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import cn.xiahui.bos.domain.Decidedzone;
import cn.xiahui.bos.service.IDecidedzoneService;
import cn.xiahui.bos.web.action.base.BaseAction;
import cn.xiahui.crm.Customer;
import cn.xiahui.crm.ICustomerService;

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
	
	//ע��crm�������
	@Autowired
	private ICustomerService proxy;
	
	/**
	 * Զ�̵���crm���񣬻�ȡδ�����������Ŀͻ�
	 */
	public String findListNotAssociation(){
		List<Customer> list =  proxy.findListNotAssociation();
		this.java2Json(list, new String[]{});
		return NONE;
	}
	/**
	 * Զ�̵���crm���񣬻�ȡ�Ѿ�������ָ���Ķ����Ŀͻ�
	 */
	public String findListHasAssociation(){
		String id = model.getId();
		List<Customer> list =  proxy.findListHasAssociation(id);
		this.java2Json(list, new String[]{});
		return NONE;
	}
	//��������������ҳ���ύ�Ķ�����ͻ�id
	private List<Integer> customerIds;
	
	/**
	 * Զ�̵���crm����,���ͻ�����������
	 */
	public String assigncustomerstodecidedzone(){
		proxy.assigncustomerstodecidedzone(model.getId(),customerIds);
		return LIST;
	}

	public List<Integer> getCustomerIds() {
		return customerIds;
	}

	public void setCustomerIds(List<Integer> customerIds) {
		this.customerIds = customerIds;
	}
	
	
}

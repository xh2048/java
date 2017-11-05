package cn.xiahui.bos.web.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import cn.xiahui.bos.domain.Noticebill;
import cn.xiahui.bos.service.INoticebillService;
import cn.xiahui.bos.web.action.base.BaseAction;
import cn.xiahui.crm.Customer;
import cn.xiahui.crm.ICustomerService;

@Controller
@Scope("prototype")
public class NoticebillAction extends BaseAction<Noticebill>{
	//ע��crm�ͻ��˴������
	@Autowired
	private ICustomerService customerService;
	
	/**
	 * Զ�̵���crm���񣬸����ֻ��Ų�ѯ�ͻ���Ϣ
	 */
	public String findCustomerByTelephone(){
		String telephone = model.getTelephone();
		Customer customer = customerService.findCustomerByTelephone(telephone);
		this.java2Json(customer, new String[]{});
		return NONE;
	}
	
	@Autowired
	private INoticebillService noticebillservice;
	
	/**
	 * ����һ��ҵ��֪ͨ�����������Զ��ֵ�
	 */
	public String add(){
		noticebillservice.save(model);
		return "noticebill_add";
	}
	
}

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
	//注入crm客户端代理对象
	@Autowired
	private ICustomerService customerService;
	
	/**
	 * 远程调用crm服务，根据手机号查询客户信息
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
	 * 保存一个业务通知单，并尝试自动分单
	 */
	public String add(){
		noticebillservice.save(model);
		return "noticebill_add";
	}
	
}

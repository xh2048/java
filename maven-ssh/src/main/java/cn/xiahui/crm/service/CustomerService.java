package cn.xiahui.crm.service;

import cn.xiahui.crm.entity.Customer;

public interface CustomerService {
	/**
	 * 根据ID获取客户信息
	 */
	Customer findById(Long id);

}

package cn.xiahui.crm.dao;

import cn.xiahui.crm.entity.Customer;

public interface CustomerDao {
	/**
	 * 根据ID获取客户信息
	 */
	public Customer findById(Long id);

}

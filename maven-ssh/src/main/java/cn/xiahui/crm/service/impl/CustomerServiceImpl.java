package cn.xiahui.crm.service.impl;
import cn.xiahui.crm.dao.CustomerDao;
import cn.xiahui.crm.entity.Customer;
import cn.xiahui.crm.service.CustomerService;

public class CustomerServiceImpl implements CustomerService {
	
	private CustomerDao customerDao;

	
	public void setCustomerDao(CustomerDao customerDao) {
		this.customerDao = customerDao;
	}


	@Override
	public Customer findById(Long id) {
		
		return customerDao.findById(id);
	}
	
	
}

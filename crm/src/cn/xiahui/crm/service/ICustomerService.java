package cn.xiahui.crm.service;

import java.util.List;

import javax.jws.WebService;

import cn.xiahui.crm.domain.Customer;

@WebService
public interface ICustomerService {
	public List<Customer> findAll();
	
}

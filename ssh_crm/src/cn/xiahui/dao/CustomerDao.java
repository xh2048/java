package cn.xiahui.dao;

import java.util.List;

import cn.xiahui.domain.Customer;

public interface CustomerDao extends BaseDao<Customer>{
	
	//按照行业统计客户数量
	List<Object[]> getIndustryCount();


}

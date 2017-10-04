package cn.xiahui.service.impl;

import cn.xiahui.dao.CustomerDao;
import cn.xiahui.dao.LinkManDao;
import cn.xiahui.domain.Customer;
import cn.xiahui.domain.LinkMan;
import cn.xiahui.service.LinkManService;
import cn.xiahui.utils.HibernateUtils;

public class LinkManServiceImpl implements LinkManService {

	private CustomerDao cd;
	private LinkManDao lmd;

	public void setCd(CustomerDao cd) {
		this.cd = cd;
	}

	public void setLmd(LinkManDao lmd) {
		this.lmd = lmd;
	}

	@Override
	public void save(LinkMan lm) {
		//打开事务
		HibernateUtils.getCurrentSession().beginTransaction();
		
		try {
			//1.根据客户id获得客户对象
			Long cust_id = lm.getCust_id();
			Customer c = cd.getById(cust_id);
			//2.将客户放入LinkMan中表达关系
			lm.setCustomer(c);
			//3.保存LinkMan
			lmd.save(lm);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			HibernateUtils.getCurrentSession().getTransaction().rollback();
		}
		
		//提交事务
		HibernateUtils.getCurrentSession().getTransaction().commit();
	}

}

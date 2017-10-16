package cn.xiahui.service;

import org.hibernate.criterion.DetachedCriteria;

import cn.xiahui.domain.SaleVisit;
import cn.xiahui.utils.PageBean;

public interface SaleVisitService {
	//保存客户拜访记录
	void save(SaleVisit saleVisit);
	//客户拜访记录的分页列表
	PageBean getPageBean(DetachedCriteria dc, Integer currentPage, Integer pageSize);
	//根据id获得客户对象
	SaleVisit getById(String visit_id);

}

package cn.xiahui.service.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import cn.xiahui.dao.SaleVisitDao;
import cn.xiahui.domain.SaleVisit;
import cn.xiahui.service.SaleVisitService;
import cn.xiahui.utils.PageBean;

public class SaleVisitServiceImpl implements SaleVisitService {

	private SaleVisitDao svd;

	@Override
	public void save(SaleVisit saleVisit) {
		svd.saveOrUpdate(saleVisit);
	}

	@Override
	public PageBean getPageBean(DetachedCriteria dc, Integer currentPage, Integer pageSize) {
		//调用Dao查询总记录数
		Integer totalCount = svd.getTotalCount(dc);
		//创建PageBean对象
		PageBean pb = new PageBean(currentPage,totalCount,pageSize);
		//调用Dao查询分页列表数据
		List<SaleVisit> list = svd.getPageList(dc, pb.getStart(), pb.getPageSize());
		//列表数据放入pageBean中，并返回
		pb.setList(list);
		return pb;
	}

	@Override
	public SaleVisit getById(Long visit_id) {

		return svd.getById(visit_id);
	}

	public void setSvd(SaleVisitDao svd) {
		this.svd = svd;
	}
	
	
}

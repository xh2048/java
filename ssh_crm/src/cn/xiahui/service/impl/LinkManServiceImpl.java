package cn.xiahui.service.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import cn.xiahui.dao.LinkManDao;
import cn.xiahui.domain.LinkMan;
import cn.xiahui.service.LinkManService;
import cn.xiahui.utils.PageBean;

public class LinkManServiceImpl implements LinkManService {

	private LinkManDao lmd;



	@Override
	public PageBean getPageBean(DetachedCriteria dc, Integer currentPage, Integer pageSize) {
		//调用Dao查询总记录数
		Integer totalCount = lmd.getTotalCount(dc);
		//创建PageBean对象
		PageBean pb = new PageBean(currentPage,totalCount,pageSize);
		//调用Dao查询分页列表数据
		List<LinkMan> list = lmd.getPageList(dc, pb.getStart(), pb.getPageSize());
		//列表数据放入pagebean中，并返回
		pb.setList(list);
		return pb;
	}
	
	@Override
	public void save(LinkMan linkMan) {
		lmd.saveOrUpdate(linkMan);
	}
	
	@Override
	public LinkMan getById(Long lkm_id) {
		
		return lmd.getById(lkm_id);
	}

	public void setLmd(LinkManDao lmd) {
		this.lmd = lmd;
	}

	
}

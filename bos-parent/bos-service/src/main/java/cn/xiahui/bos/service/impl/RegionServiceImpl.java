package cn.xiahui.bos.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.xiahui.bos.dao.IRegionDao;
import cn.xiahui.bos.domain.Region;
import cn.xiahui.bos.service.IRegionService;
import cn.xiahui.bos.utils.PageBean;

@Service
@Transactional
public class RegionServiceImpl implements IRegionService {

	@Autowired
	private IRegionDao regionDao;

	/**
	 * 区域数据批量保存
	 */
	public void saveBatch(List<Region> regionList) {
		for (Region region : regionList) {
			regionDao.saveOrUpdate(region);
		}
	}

	/**
	 * 区域分页查询
	 */
	public void pageQuery(PageBean pageBean) {
		regionDao.pageQuery(pageBean);
	}


	/***
	 * 根据页面输入进行模糊查询
	 */
	public List<Region> findListByQ(String q) {
		
		return regionDao.findListByQ(q);
	}

	/**
	 * 查询所有区域
	 */
	public List<Region> findAll() {
		
		return regionDao.findAll();
	}

}

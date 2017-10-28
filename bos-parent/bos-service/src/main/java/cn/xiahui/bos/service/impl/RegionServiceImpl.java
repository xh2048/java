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
	 * ����������������
	 */
	public void saveBatch(List<Region> regionList) {
		for (Region region : regionList) {
			regionDao.saveOrUpdate(region);
		}
	}

	/**
	 * �����ҳ��ѯ
	 */
	public void pageQuery(PageBean pageBean) {
		regionDao.pageQuery(pageBean);
	}


	/***
	 * ����ҳ���������ģ����ѯ
	 */
	public List<Region> findListByQ(String q) {
		
		return regionDao.findListByQ(q);
	}

	/**
	 * ��ѯ��������
	 */
	public List<Region> findAll() {
		
		return regionDao.findAll();
	}

}

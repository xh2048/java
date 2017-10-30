package cn.xiahui.bos.service.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.xiahui.bos.dao.ISubareaDao;
import cn.xiahui.bos.domain.Subarea;
import cn.xiahui.bos.service.ISubareaService;
import cn.xiahui.bos.utils.PageBean;

@Service
@Transactional
public class SubareaServiceImpl implements ISubareaService {

	@Autowired
	private ISubareaDao subareaDao;

	public void save(Subarea model) {
			subareaDao.save(model);
	}

	@Override
	public void pageQuery(PageBean pageBean) {
		subareaDao.pageQuery(pageBean);
	}

	@Override
	public List<Subarea> findAll() {
		
		return subareaDao.findAll();
	}

	@Override
	public List<Subarea> findListNotAssociation() {
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(Subarea.class);
		detachedCriteria.add(Restrictions.isNull("decidedzone"));
		return subareaDao.findByCriteria(detachedCriteria);
	}
}

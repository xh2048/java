package cn.xiahui.bos.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.xiahui.bos.dao.IDecidedzoneDao;
import cn.xiahui.bos.dao.ISubareaDao;
import cn.xiahui.bos.domain.Decidedzone;
import cn.xiahui.bos.domain.Subarea;
import cn.xiahui.bos.service.IDecidedzoneService;
import cn.xiahui.bos.utils.PageBean;
@Service
@Transactional
public class DecidedzoneServiceImpl implements IDecidedzoneService {

	@Autowired
	private ISubareaDao subareaDao;
	@Autowired
	private IDecidedzoneDao decidedzoneDao;

	/**
	 * 添加定区，同事关联分区
	 */
	public void save(Decidedzone model, String[] subareaid) {
		decidedzoneDao.save(model);
		for(String id : subareaid){
			Subarea subarea = subareaDao.findById(id);
			//model.getSubareas().add(subarea);一方（定区）已经放弃维护外键权利，只能由多方（分区）负责维护
			subarea.setDecidedzone(model);//分区关联定区
		}
	}

	@Override
	public void pageQuery(PageBean pageBean) {
		decidedzoneDao.pageQuery(pageBean);
	}

}

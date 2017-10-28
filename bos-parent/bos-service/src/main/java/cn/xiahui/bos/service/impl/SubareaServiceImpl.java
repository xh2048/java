package cn.xiahui.bos.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.xiahui.bos.dao.ISubareaDao;
import cn.xiahui.bos.domain.Subarea;
import cn.xiahui.bos.service.ISubareaService;

@Service
@Transactional
public class SubareaServiceImpl implements ISubareaService {

	@Autowired
	private ISubareaDao subareaDao;

	public void save(Subarea model) {
			subareaDao.save(model);
	}
}

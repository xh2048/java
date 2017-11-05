package cn.xiahui.bos.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.xiahui.bos.dao.IWorkordermanageDao;
import cn.xiahui.bos.domain.Workordermanage;
import cn.xiahui.bos.service.IWorkordermanageService;

@Service
@Transactional
public class WorkordermanageServiceImpl implements IWorkordermanageService {

	@Autowired
	private IWorkordermanageDao workordermanageDao;

	@Override
	public void add(Workordermanage model) {
		workordermanageDao.save(model);
	}

}

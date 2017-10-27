package cn.xiahui.bos.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.xiahui.bos.dao.IStaffDao;
import cn.xiahui.bos.domain.Staff;
import cn.xiahui.bos.service.IStaffService;

@Service
@Transactional
public class StaffServiceImpl implements IStaffService{

	@Autowired
	private IStaffDao staffDao;


	public void save(Staff model) {
		staffDao.save(model);
	}
	
}

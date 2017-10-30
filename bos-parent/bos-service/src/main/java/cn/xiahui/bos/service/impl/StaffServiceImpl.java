package cn.xiahui.bos.service.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.xiahui.bos.dao.IStaffDao;
import cn.xiahui.bos.domain.Staff;
import cn.xiahui.bos.service.IStaffService;
import cn.xiahui.bos.utils.PageBean;

@Service
@Transactional
public class StaffServiceImpl implements IStaffService{

	@Autowired
	private IStaffDao staffDao;


	public void save(Staff model) {
		staffDao.save(model);
	}


	public void pageQuery(PageBean pageBean) {
		staffDao.pageQuery(pageBean);
	}


	/**
	 * ȡ��Ա����ɾ��
	 * �߼�ɾ������deltag��Ϊ1
	 */
	public void deleteBatch(String ids) {//1,2,3,4
		if(StringUtils.isNoneBlank(ids)){
			String[] staffIds = ids.split(",");
			for(String id : staffIds){
				staffDao.executeUpdate("staff.delete", id);
			}
		}
		
	}


	/**
	 * ����id��ѯȡ��Ա
	 */
	public Staff findById(String id) {
		
		return staffDao.findById(id);
	}

	/**
	 * ����id�޸�ȡ��Ա
	 */
	public void update(Staff staff) {
		staffDao.update(staff);
	}


	@Override
	public List<Staff> findListNotDelete() {
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(Staff.class);
		//��ӹ����콾��deltag����0
		detachedCriteria.add(Restrictions.eq("deltag","0"));
		return staffDao.findByCriteria(detachedCriteria);
	}
	
}

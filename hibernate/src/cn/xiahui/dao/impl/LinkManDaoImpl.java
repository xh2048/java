package cn.xiahui.dao.impl;

import org.hibernate.Session;

import cn.xiahui.dao.LinkManDao;
import cn.xiahui.domain.LinkMan;
import cn.xiahui.utils.HibernateUtils;

public class LinkManDaoImpl implements LinkManDao {

	@Override
	public void save(LinkMan lm) {
		
		//获得session
		Session session = HibernateUtils.getCurrentSession();
		session.save(lm);
	}

}

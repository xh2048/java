package cn.xiahui.bos.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import cn.xiahui.bos.dao.IRegionDao;
import cn.xiahui.bos.dao.base.impl.BaseDaoImpl;
import cn.xiahui.bos.domain.Region;

@Repository
public class RegionDaoImpl extends BaseDaoImpl<Region> implements IRegionDao {
	/**
	 * ����q��������ģ����ѯ
	 */
	public List<Region> findListByQ(String q) {
		String hql = "FROM Region r WHERE r.shortcode LIKE ?"
					+ " OR r.citycode LIKE ? OR r.province LIKE ?"
					+ " OR r.city LIKE ? OR r.district LIKE ?";
		List<Region> list = (List<Region>) this.getHibernateTemplate().find(hql, "%"+q+"%","%"+q+"%","%"+q+"%","%"+q+"%","%"+q+"%");
		return list;
	}

}

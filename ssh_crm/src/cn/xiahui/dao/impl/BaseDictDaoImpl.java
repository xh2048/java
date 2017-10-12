package cn.xiahui.dao.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import cn.xiahui.dao.BaseDictDao;
import cn.xiahui.domain.BaseDict;

public class BaseDictDaoImpl extends BaseDaoImpl<BaseDict> implements BaseDictDao {


	@Override
	public List<BaseDict> getListTypeCode(String dict_type_code) {
		
		//创建离线查询对象
		DetachedCriteria dc = DetachedCriteria.forClass(BaseDict.class);
		//封装条件
		dc.add(Restrictions.eq("dict_type_code",dict_type_code));
		//执行查询
		List<BaseDict> list = (List<BaseDict>) getHibernateTemplate().findByCriteria(dc);
		return list;
	}

}

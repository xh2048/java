package cn.xiahui.bos.dao.impl;


import java.util.List;

import org.springframework.stereotype.Repository;

import cn.xiahui.bos.dao.IFunctionDao;
import cn.xiahui.bos.dao.base.impl.BaseDaoImpl;
import cn.xiahui.bos.domain.Function;

@Repository
public class FunctionDaoImpl extends BaseDaoImpl<Function> implements IFunctionDao {

	public List<Function> findAll() {
		String hql = "FROM Function f WHERE f.parentFunction IS NULL";
		List<Function> list = (List<Function>) this.getHibernateTemplate().find(hql);
		return list;
	}
}

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

	// �����û�id��ѯ��Ӧ��Ȩ��
	public List<Function> findFunctionListByUserId(String userId) {
		String hql = "SELECT DISTINCT f FROM Function f LEFT OUTER JOIN f.roles"
				+" r LEFT OUTER JOIN r.users u WHERE u.id = ?";
		List<Function> list = (List<Function>) this.getHibernateTemplate().find(hql, userId);
		return list;
	}

	// ��ѯ���в˵�
	public List<Function> findAllMenu() {
		String hql = "FROM Function f WHERE f.generatemenu = '1' ORDER BY f.zindex DESC";
		List<Function> list = (List<Function>) this.getHibernateTemplate().find(hql);
		return list;
	}

	//�����û�id��ѯ�˵�
	public List<Function> findMenuByUserId(String userId) {
		String hql = "SELECT DISTINCT f FROM Function f LEFT OUTER JOIN f.roles"
				+ " r LEFT OUTER JOIN r.users u WHERE u.id = ? AND f.generatemenu = '1' "
				+ "ORDER BY f.zindex DESC";
		List<Function> list = (List<Function>) this.getHibernateTemplate().find(hql,userId);
		return list;
	}
}
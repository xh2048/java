package cn.xiahui.bos.dao.base.impl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import cn.xiahui.bos.dao.base.IBaseDao;

public class BaseDaoImpl<T> extends HibernateDaoSupport implements IBaseDao<T>{

	//��������ĳ��ʵ�������
	private Class<T> entityClass;

	@Resource //��������ע��spring�����еĻỰ��������sessionFactory
	public void setMySessionFactory(SessionFactory sessionFactory){
		super.setSessionFactory(sessionFactory);
	}
	
	//�ڸ���(BaseDaoImpl)�Ĺ��췽���ж�̬���entityClass
	public BaseDaoImpl(){
		ParameterizedType superclass = (ParameterizedType) this.getClass().getGenericSuperclass();
		//��ø����������ķ�������
		Type[] actualTypeArguments = superclass.getActualTypeArguments();
		entityClass = (Class<T>) actualTypeArguments[0];
	}
	
	@Override
	public void save(T entity) {
		this.getHibernateTemplate().save(entity);
	}

	@Override
	public void delete(T entity) {
		this.getHibernateTemplate().delete(entity);
	}

	@Override
	public void update(T entity) {
		this.getHibernateTemplate().update(entity);
	}

	@Override
	public T findById(Serializable id) {
		
		return this.getHibernateTemplate().get(entityClass, id);
	}

	@Override
	public List<T> findAll() {
		String hql = "FROM" + entityClass.getSimpleName();
		return (List<T>) this.getHibernateTemplate().find(hql);
	}
	
}
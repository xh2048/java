package cn.xiahui.test;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.xiahui.dao.UserDao;
import cn.xiahui.domain.User;
import cn.xiahui.service.UserService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class HibernateTest {
	@Resource(name="sessionFactory")
	
	private SessionFactory sf;
	
	//单独测试hibernate
	@Test
	public void fun1(){
		Configuration conf = new Configuration().configure();
		
		SessionFactory sf = conf.buildSessionFactory();
		
		Session session = sf.openSession();
		
		Transaction tx = session.beginTransaction();
	//---------------------------------------------------------------
		
		User u = new User();
		
		u.setUser_code("rose");
		u.setUser_name("肉丝");
		u.setUser_password("1234");
		
		session.save(u);
	
	//---------------------------------------------------------------	
		tx.commit();
		
		session.close();
		
		sf.close();
	}
	
	//测试spring管理sessionFactory
	@Test
	public void fun2(){
		
		
		Session session = sf.openSession();
		
		Transaction tx = session.beginTransaction();
	//---------------------------------------------------------------
		
		User u = new User();
		
		u.setUser_code("xiahui");
		u.setUser_name("xiahui");
		u.setUser_password("1234");
		
		session.save(u);
	
	//---------------------------------------------------------------	
		tx.commit();
		
		session.close();
		
	}
	
	
	@Resource(name="userDao")
	private UserDao ud;
	@Test
	//测试Dao Hibernate模板
	public void fun3(){
		
		User userCode = ud.getByUserCode("rose");
		System.out.println(userCode);
		
	}
	
	
	@Resource(name="userService")
	private UserService us;
	@Test
	//测试aop事务
	public void fun4(){
		User u = new User();
		
		u.setUser_code("123");
		u.setUser_name("夏辉123");
		u.setUser_password("123");
		
		us.saveUser(u);
		
	}
	
}

package cn.xiahui.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import cn.xiahui.domain.Customer;
import cn.xiahui.service.CustomerService;
import cn.xiahui.service.impl.CustomerServiceImpl;

public class ListCustomerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private CustomerService cs =   new CustomerServiceImpl();
    public ListCustomerServlet() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//获得查询条件
		String cust_name = request.getParameter("cust_name");
		//判断查询条件是否不为空
		DetachedCriteria dc = DetachedCriteria.forClass(Customer.class);
		
		if(cust_name!=null && !"".equals(cust_name)){
			dc.add(Restrictions.like("cust_name","%"+cust_name+"%"));
		}
		
		
		//1.调用Service查询所有客户
		List<Customer> list = cs.getAll(dc);
		//2.将客户类别放入request域
		request.setAttribute("list", list);
		//3.转发到list.jsp显示
		request.getRequestDispatcher("/jsp/customer/list.jsp").forward(request, response);
	
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

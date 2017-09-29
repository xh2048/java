package com.xiahui.web.servlet;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.xiahui.domain.Category;
import com.xiahui.domain.Order;
import com.xiahui.service.AdminService;
import com.xiahui.utils.BeanFactory;

public class AdminServlet extends BaseServlet {

	//根据订单id查询订单项和商品信息
	public void findOrderInfoByOid(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		
		//获得oid
		String oid = request.getParameter("oid");

		//用解耦合的方式进行编码----解web层与service层的耦合
		//使用工厂+反射+配置文件
		AdminService service = (AdminService)BeanFactory.getBean("adminService");
		
		
		List<Map<String,Object>> mapList = service.findOrderInfoByOid(oid);
		
		Gson gson = new Gson();
		String json = gson.toJson(mapList);
		System.out.println(json);
		
		response.setContentType("text/html;charset=UTF-8");
		
		response.getWriter().write(json);
		
	}

	
	//获得所有的订单
	public void findAllOrders(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//获得所有的订单信息----List<Order>
		AdminService service = (AdminService)BeanFactory.getBean("adminService");
		List<Order> orderList = service.findAllOrders();
		
		request.setAttribute("orderList", orderList);
		request.getRequestDispatcher("/admin/order/list.jsp").forward(request, response);
	}

	
	
	//获得所有的分类
	public void findAllCategory(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//获得所有的订单信息
		AdminService service = (AdminService)BeanFactory.getBean("adminService");
		List<Category> categoryList =service.findAllCategory();
		
		Gson gson = new Gson();
		String json = gson.toJson(categoryList);
		
		response.setContentType("text/html;charset=UTF-8");
		response.getWriter().write(json);
		
	}

}
package com.xiahui.service.impl;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.xiahui.dao.AdminDao;
import com.xiahui.domain.Category;
import com.xiahui.domain.Order;
import com.xiahui.domain.Product;
import com.xiahui.service.AdminService;

public class AdminServiceImpl implements AdminService{
	
	public List<Category> findAllCategory() {
		
		AdminDao dao = new AdminDao();
		
		try {
			return dao.findAllCategory();
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	public void saveProduct(Product product) throws SQLException {
		
		AdminDao dao = new AdminDao();
		
		dao.saveProduct(product);
	}

	public List<Order> findAllOrders() {
		AdminDao dao = new AdminDao();
		List<Order> ordersList = null;
		try {
			ordersList = dao.findAllOrders();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ordersList;
	}

	public List<Map<String, Object>> findOrderInfoByOid(String oid) {
		AdminDao dao = new AdminDao();
		List<Map<String, Object>> mapList = null;
		try {
			mapList = dao.findOrderInfoByOid(oid);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return mapList;
	}
}

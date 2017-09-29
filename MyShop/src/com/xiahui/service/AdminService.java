package com.xiahui.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.xiahui.domain.Category;
import com.xiahui.domain.Order;
import com.xiahui.domain.Product;



public interface AdminService {


	public List<Category> findAllCategory();
	public void saveProduct(Product product) throws SQLException;

	public List<Order> findAllOrders();

	public List<Map<String, Object>> findOrderInfoByOid(String oid);

}

package cn.xiahui.web;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import cn.xiahui.domain.LinkMan;
import cn.xiahui.service.LinkManService;
import cn.xiahui.service.impl.LinkManServiceImpl;


public class AddLinkManServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private LinkManService lms = new LinkManServiceImpl();
       


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1.获得参数并封装LinkMan对象中
		LinkMan lm = new LinkMan();
		try {
			BeanUtils.populate(lm, request.getParameterMap());
		} catch (IllegalAccessException | InvocationTargetException e) {
			e.printStackTrace();
		}
		//2.调用service保存LinkMan对象
		lms.save(lm);
		//3.重定向到LinkMan的列表(404)
		response.sendRedirect(request.getContextPath()+"/ListLinkManServlet");
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

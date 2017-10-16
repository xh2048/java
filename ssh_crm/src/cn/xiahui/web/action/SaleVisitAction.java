package cn.xiahui.web.action;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import cn.xiahui.domain.SaleVisit;
import cn.xiahui.domain.User;
import cn.xiahui.service.SaleVisitService;
import cn.xiahui.utils.PageBean;

public class SaleVisitAction extends ActionSupport implements ModelDriven<SaleVisit> {



	private SaleVisit saleVisit = new SaleVisit();
	private SaleVisitService svs;
	private Integer pageSize;
	private Integer currentPage;
	
	
	//添加客户拜访记录
	public String add() throws Exception {
		//取出登录用户，放入SaleVisit实体，表达关系
		User u = (User) ActionContext.getContext().getSession().get("user");
		saleVisit.setUser(u);
		
		//调用Service保存客户拜访记录
		svs.save(saleVisit);
		//重定向到拜访记录列表Action
		return "toList";
	}

	public String list() throws Exception {
		//封装离线查询对象
		DetachedCriteria dc = DetachedCriteria.forClass(SaleVisit.class);
		//判断并封装参数
		if(saleVisit.getCustomer()!=null && saleVisit.getCustomer().getCust_id()!=null){
			dc.add(Restrictions.eq("customer.cust_id",saleVisit.getCustomer().getCust_id()));
		}
		
		//调用service查询分页数据(PageBean)
		PageBean pb = svs.getPageBean(dc,currentPage,pageSize);
		//将PageBean放入request域，转发到列表页面中显示
		ActionContext.getContext().put("pageBean",pb);
		return "list";
		
	}

	//去往编辑页面回显
	public String toEdit() throws Exception {
		//调用Service根据ID查询客户边防对象
		SaleVisit sv =  svs.getById(saleVisit.getVisit_id());
		//将对象放入request域
		ActionContext.getContext().put("saleVisit", sv);
		//转发到add.jsp
		return "add";
	}
	
	@Override
	public SaleVisit getModel() {
		
		return saleVisit;
	}



	public void setSvs(SaleVisitService svs) {
		this.svs = svs;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public Integer getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}

	
	
}

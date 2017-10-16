package cn.xiahui.web.action;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import cn.xiahui.domain.LinkMan;
import cn.xiahui.service.LinkManService;
import cn.xiahui.utils.PageBean;

public class LinkManAction extends ActionSupport implements ModelDriven<LinkMan>{

	private LinkMan linkMan = new LinkMan();
	private LinkManService lms;
	private Integer pageSize;
	private Integer currentPage;

	
	
	public String list() throws Exception {
		//封装离线查询对象
		DetachedCriteria dc = DetachedCriteria.forClass(LinkMan.class);
		//判断并封装参数
		if(StringUtils.isNotBlank(linkMan.getLkm_name())){
			dc.add(Restrictions.like("lkm_name", "%"+linkMan.getLkm_name()+"%"));
		}
		if(linkMan.getCustomer()!=null&&linkMan.getCustomer().getCust_id()!=null){
			dc.add(Restrictions.eq("customer.cust_id",linkMan.getCustomer().getCust_id()));
		}
		
		//调用service查询分页数据（PageBean)
		PageBean pb = lms.getPageBean(dc,currentPage,pageSize);
		//将pageBean放入request域，转发到列表页面显示
		ActionContext.getContext().put("pageBean", pb);
		return "list";
	}



	public String add() throws Exception {
		
		//调用service
		lms.save(linkMan);
		//重定向到联系人列表
		return "toList";
	}

	public String toEdit() throws Exception {
		
		//调用service,查询linkman
		LinkMan lm = lms.getById(linkMan.getLkm_id());
		//将查询到的LinkMan对象放入request域，转发到添加页面
		ActionContext.getContext().put("linkMan", lm);
		return "add";
	}


	@Override
	public LinkMan getModel() {
		
		return linkMan;
	}



	public void setLms(LinkManService lms) {
		this.lms = lms;
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

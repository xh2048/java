package cn.xiahui.web.action;

import java.io.File;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import cn.xiahui.domain.Customer;
import cn.xiahui.service.CustomerService;
import cn.xiahui.utils.PageBean;

public class CustomerAction extends ActionSupport  implements ModelDriven<Customer>{

	
	
	private Customer customer = new Customer();
	
	private Integer pageSize;
	private Integer currentPage;
	
	private CustomerService cs;
	
	//上传的文件会自动封装到File对象
	//在后台提供一个与前台input type=file组件 name相同的属性
	private File photo;
	//在提交键名后加上固定后缀FileName,文件名称会自动封装到属性中
	private String photoFileName;
	//在提交键名后加上固定后缀ContentType,文件MIME类型会自动封装到属性中 
	private String photoContentType;

	public String list() throws Exception {
		
		//封装离线查询对象
		DetachedCriteria dc = DetachedCriteria.forClass(Customer.class);
		
		//判断并封装参数
		if(StringUtils.isNotBlank(customer.getCust_name())){
			dc.add(Restrictions.like("cust_name", "%"+customer.getCust_name()+"%"));
		}
		
		//调用service查询分页数据(PageBean)
		PageBean pb = cs.getPageBean(dc,currentPage,pageSize);
		
		//将PageBean放入request域，转发到列表页面显示
		ActionContext.getContext().put("pageBean", pb);
		
		return "list";
		
	}

	
	public String add() throws Exception {
		if(photo!=null){
			System.out.println("文件名称:"+photoFileName);
			System.out.println("文件名称:"+photoContentType);
			//将上传文件保存到指定位置
			photo.renameTo(new File("D:/upload/haha.jpg"));
		}
		
		//调用service,保存Customer对象
		System.out.println(customer);
		cs.save(customer);
		//重定向到客户列表Action
		return "toList";
	}
	
	
	public String toEdit() throws Exception {
		//调用Service根据id获得客户对象
		Customer c = cs.getById(customer.getCust_id());
		//将客户对象放置到request域，并转发到编辑页面
		ActionContext.getContext().put("customer", c);
		return "edit";
	}

	public String industryCount() throws Exception {
		List<Object[]> list = cs.getIndustryCount();
		
		ActionContext.getContext().put("list", list);
		
		return "industryCount";
	}

	@Override
	public Customer getModel() {
		
		return customer;
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

	public void setCs(CustomerService cs) {
		this.cs = cs;
	}


	public File getPhoto() {
		return photo;
	}


	public void setPhoto(File photo) {
		this.photo = photo;
	}


	public String getPhotoFileName() {
		return photoFileName;
	}


	public void setPhotoFileName(String photoFileName) {
		this.photoFileName = photoFileName;
	}


	public String getPhotoContentType() {
		return photoContentType;
	}


	public void setPhotoContentType(String photoContentType) {
		this.photoContentType = photoContentType;
	}
	
	
}

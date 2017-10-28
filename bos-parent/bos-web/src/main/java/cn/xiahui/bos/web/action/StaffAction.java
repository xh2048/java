package cn.xiahui.bos.web.action;

import java.io.IOException;

import org.apache.struts2.ServletActionContext;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import cn.xiahui.bos.domain.Staff;
import cn.xiahui.bos.service.IStaffService;
import cn.xiahui.bos.utils.PageBean;
import cn.xiahui.bos.web.action.base.BaseAction;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;

@Controller
@Scope("prototype")
public class StaffAction extends BaseAction<Staff> {
	@Autowired
	private IStaffService staffService;
	
	/**
	 * ���ȡ��Ա
	 */
	public String add(){
		staffService.save(model);
		return LIST;
	}
	

	/**
	 * ��ҳ��ѯ����
	 */
	public String pageQuery() throws IOException{
		staffService.pageQuery(pageBean);
		this.java2Json(pageBean, new String[]{"currentPage","detachedCriteria","pageSize"});
		return NONE;
	}
/*
	//��������������ҳ���ύ�ķ�ҳ����
	private int page;
	private int rows;

	
	public String pageQuery() throws IOException{
		PageBean pageBean = new PageBean();
		pageBean.setCurrentPage(page);
		pageBean.setPageSize(rows);
		//���������ύ��ѯ����
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(Staff.class);
		pageBean.setDetachedCriteria(detachedCriteria);
		staffService.pageQuery(pageBean);
		
		//ʹ��json-lib��PageBean����תΪjson��ͨ�������д��ҳ����
		//JSONObject---����һ����תΪjson
		//JSONArray----��������߼��϶���תΪjson
		JsonConfig jsonConfig = new JsonConfig();
		//ָ����Щ���Բ���Ҫתjson
		jsonConfig.setExcludes(new String[]{"currentPage","detachedCriteria","pageSize"});
		String json = JSONObject.fromObject(pageBean,jsonConfig).toString();
		ServletActionContext.getResponse().setContentType("text/json;charset=utf-8");
		ServletActionContext.getResponse().getWriter().print(json);
		return NONE;
	}
*/
	
	//��������������ҳ���ύ��ids����
	private String ids;
	
	
	
	/**
	 * ȡ��Ա����ɾ��
	 */
	public String deleteBatch(){
		staffService.deleteBatch(ids);
		return LIST;
	}
	
	/**
	 * �޸�ȡ��Ա��Ϣ
	 */
	public String edit(){
		//�Բ�ѯ���ݿ⣬����id��ѯԭʼ����
		Staff staff = staffService.findById(model.getId());
		//ʹ��ҳ���ύ�����ݽ��и���
		staff.setName(model.getName());
		staff.setTelephone(model.getTelephone());
		staff.setHaspda(model.getHaspda());
		staff.setStandard(model.getStandard());
		staff.setStation(model.getStation());
		staffService.update(staff);
		return LIST;
	}
	


	public String getIds() {
		return ids;
	}

	public void setIds(String ids) {
		this.ids = ids;
	}
}

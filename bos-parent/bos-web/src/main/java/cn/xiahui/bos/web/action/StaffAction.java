package cn.xiahui.bos.web.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import cn.xiahui.bos.domain.Staff;
import cn.xiahui.bos.service.IStaffService;
import cn.xiahui.bos.web.action.base.BaseAction;

@Controller
@Scope("prototype")
public class StaffAction extends BaseAction<Staff> {
	@Autowired
	private IStaffService staffService;
	
	/**
	 * ����ȡ��Ա
	 */
	public String add(){
		staffService.save(model);
		return LIST;
	}
}
package cn.xiahui.bos.web.action;

import java.io.IOException;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import cn.xiahui.bos.domain.Workordermanage;
import cn.xiahui.bos.service.IWorkordermanageService;
import cn.xiahui.bos.web.action.base.BaseAction;

@Controller
@Scope("prototype")
public class WorkordermanageAction extends BaseAction<Workordermanage> {
	@Autowired
	private IWorkordermanageService workordermanageService;
	public String add() throws IOException {
		String f = "1";
		try {
			workordermanageService.add(model);
		} catch (Exception e) {
			e.printStackTrace();
			f = "0";
		}
		ServletActionContext.getResponse().setContentType("text/html;charset=utf-8");
		ServletActionContext.getResponse().getWriter().print(f);
		return NONE;
	}
	
}

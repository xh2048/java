package cn.xiahui.bos.web.action;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import cn.xiahui.bos.domain.Subarea;
import cn.xiahui.bos.service.ISubareaService;
import cn.xiahui.bos.web.action.base.BaseAction;

@Controller
@Scope("prototype")
public class SubareaAction extends BaseAction<Subarea> {
	@Resource
	private ISubareaService subareaService;
	/**
	 * Ìí¼Ó·ÖÇø
	 */
	public String add(){
		subareaService.save(model);
		return LIST;
	}
}

package cn.xiahui.bos.service;

import cn.xiahui.bos.domain.Decidedzone;
import cn.xiahui.bos.utils.PageBean;

public interface IDecidedzoneService {

	public void save(Decidedzone model, String[] subareaid);

	public void pageQuery(PageBean pageBean);

}

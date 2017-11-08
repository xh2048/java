package cn.xiahui.bos.service;

import java.util.List;

import cn.xiahui.bos.domain.Function;
import cn.xiahui.bos.utils.PageBean;

public interface IFuctionService {

	public List<Function> findAll();

	public void save(Function model);

	public void pageQuery(PageBean pageBean);

	public List<Function> findMenu();

}

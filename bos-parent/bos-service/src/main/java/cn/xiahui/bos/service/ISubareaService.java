package cn.xiahui.bos.service;

import java.util.List;

import cn.xiahui.bos.domain.Subarea;
import cn.xiahui.bos.utils.PageBean;

public interface ISubareaService {

	public void save(Subarea model);

	public void pageQuery(PageBean pageBean);

	public List<Subarea> findAll();

	public List<Subarea> findListNotAssociation();

	public List<Subarea> findListByDecidedzoneId(String decidedzoneId);

	public List<Object> findSubareasGroupByProvince();

}

package cn.xiahui.bos.service;

import java.util.List;

import cn.xiahui.bos.domain.Region;
import cn.xiahui.bos.utils.PageBean;

public interface IRegionService {

	public void saveBatch(List<Region> regionList);

	public void pageQuery(PageBean pageBean);

	public List<Region> findListByQ(String q);

	public List<Region> findAll();

}

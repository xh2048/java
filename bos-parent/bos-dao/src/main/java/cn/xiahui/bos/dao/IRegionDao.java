package cn.xiahui.bos.dao;

import java.util.List;

import cn.xiahui.bos.dao.base.IBaseDao;
import cn.xiahui.bos.domain.Region;

public interface IRegionDao extends IBaseDao<Region> {

	public List<Region> findListByQ(String q);



}

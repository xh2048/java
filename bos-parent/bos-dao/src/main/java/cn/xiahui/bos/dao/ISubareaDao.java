package cn.xiahui.bos.dao;

import java.util.List;

import cn.xiahui.bos.dao.base.IBaseDao;
import cn.xiahui.bos.domain.Subarea;

public interface ISubareaDao extends IBaseDao<Subarea>{

	
	

	public List<Object> findSubareasGroupByProvince();

}

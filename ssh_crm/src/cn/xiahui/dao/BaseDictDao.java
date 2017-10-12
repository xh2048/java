package cn.xiahui.dao;

import java.util.List;

import cn.xiahui.domain.BaseDict;

public interface BaseDictDao extends BaseDao<BaseDict>{
	//根据类型获得数据字典列表
	List<BaseDict> getListTypeCode(String dict_type_code);

}

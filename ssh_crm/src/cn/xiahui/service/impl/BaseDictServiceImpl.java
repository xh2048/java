package cn.xiahui.service.impl;

import java.util.List;

import cn.xiahui.dao.BaseDictDao;
import cn.xiahui.domain.BaseDict;
import cn.xiahui.service.BaseDictService;

public class BaseDictServiceImpl implements BaseDictService {

	private BaseDictDao bdd;

	@Override
	public List<BaseDict> getListByTypeCode(String dict_type_code) {
		
		return bdd.getListTypeCode(dict_type_code);
	}

	public void setBdd(BaseDictDao bdd) {
		this.bdd = bdd;
	}
	
}

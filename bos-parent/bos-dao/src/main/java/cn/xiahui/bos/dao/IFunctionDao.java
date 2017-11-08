package cn.xiahui.bos.dao;

import java.util.List;

import cn.xiahui.bos.dao.base.IBaseDao;
import cn.xiahui.bos.domain.Function;

public interface IFunctionDao extends IBaseDao<Function> {

	public List<Function> findFunctionListByUserId(String id);

	public List<Function> findAllMenu();

	public List<Function> findMenuByUserId(String id);

}

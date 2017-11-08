package cn.xiahui.bos.service;

import java.util.List;

import cn.xiahui.bos.domain.Role;
import cn.xiahui.bos.utils.PageBean;

public interface IRoleService {

	public void save(Role role, String functionIds);

	public void pageQuery(PageBean pageBean);

	public List<Role> findAll();

}

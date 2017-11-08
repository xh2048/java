package cn.xiahui.bos.service.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.xiahui.bos.dao.IRoleDao;
import cn.xiahui.bos.domain.Function;
import cn.xiahui.bos.domain.Role;
import cn.xiahui.bos.service.IRoleService;
import cn.xiahui.bos.utils.PageBean;

@Service
@Transactional
public class RoleServiceImpl implements IRoleService {

	@Autowired
	private IRoleDao dao;

	/**
	 * 保存一个角色，同时还需要关联权限
	 */
	public void save(Role role, String functionIds) {
		dao.save(role);
		if(StringUtils.isNotBlank(functionIds)){
			String[] fIds = functionIds.split(",");
			for(String functionId : fIds){
				//手动构造一个权限对象，设置id，对象状态为托管状态
				Function function = new Function(functionId);
				//角色关联权限
				role.getFunctions().add(function);
			}
		}
	}

	@Override
	public void pageQuery(PageBean pageBean) {
		dao.pageQuery(pageBean);
	}

	@Override
	public List<Role> findAll() {
		
		return dao.findAll();
	}

}

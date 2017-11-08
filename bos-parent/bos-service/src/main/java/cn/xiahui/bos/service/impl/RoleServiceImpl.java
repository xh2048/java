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
	 * ����һ����ɫ��ͬʱ����Ҫ����Ȩ��
	 */
	public void save(Role role, String functionIds) {
		dao.save(role);
		if(StringUtils.isNotBlank(functionIds)){
			String[] fIds = functionIds.split(",");
			for(String functionId : fIds){
				//�ֶ�����һ��Ȩ�޶�������id������״̬Ϊ�й�״̬
				Function function = new Function(functionId);
				//��ɫ����Ȩ��
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

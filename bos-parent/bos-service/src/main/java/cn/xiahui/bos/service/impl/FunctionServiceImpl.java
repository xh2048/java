package cn.xiahui.bos.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.xiahui.bos.dao.IFunctionDao;
import cn.xiahui.bos.domain.Function;
import cn.xiahui.bos.domain.User;
import cn.xiahui.bos.service.IFuctionService;
import cn.xiahui.bos.utils.BOSUtils;
import cn.xiahui.bos.utils.PageBean;

@Service
@Transactional
public class FunctionServiceImpl implements IFuctionService{

	@Autowired
	private IFunctionDao dao;


	public List<Function> findAll() {
		
		return dao.findAll();
	}

	
	public void save(Function model) {
		
		Function parentFunction = model.getParentFunction();
		if(parentFunction != null && parentFunction.getId().equals("")){
			model.setParentFunction(null);
		}
		dao.save(model);
	}


	public void pageQuery(PageBean pageBean) {
		dao.pageQuery(pageBean);
	}


	/**
	 * ���ݵ�ǰ��¼�˲�ѯ��Ӧ�Ĳ˵����ݣ�����json
	 */
	public List<Function> findMenu() {
		List<Function> list = null;
		User user = BOSUtils.getLoginUser();
		if(user.getUsername().equals("admin")){
			//����ǳ�������Ա�����û�����ѯ���в˵�
			list = dao.findAllMenu();
		}else{
			//�����û��������û�id��ѯ�˵�
			list = dao.findMenuByUserId(user.getId());
		}
		return list;
	}

}

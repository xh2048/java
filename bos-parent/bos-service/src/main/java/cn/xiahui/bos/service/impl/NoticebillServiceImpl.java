package cn.xiahui.bos.service.impl;

import java.sql.Timestamp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.xiahui.bos.dao.IDecidedzoneDao;
import cn.xiahui.bos.dao.INoticebillDao;
import cn.xiahui.bos.dao.IWorkbillDao;
import cn.xiahui.bos.dao.base.IBaseDao;
import cn.xiahui.bos.domain.Decidedzone;
import cn.xiahui.bos.domain.Noticebill;
import cn.xiahui.bos.domain.Staff;
import cn.xiahui.bos.domain.User;
import cn.xiahui.bos.domain.Workbill;
import cn.xiahui.bos.service.INoticebillService;
import cn.xiahui.bos.utils.BOSUtils;
import cn.xiahui.crm.ICustomerService;

@Service
@Transactional
public class NoticebillServiceImpl implements INoticebillService {

	@Autowired
	private INoticebillDao noticebillDao;
	
	@Autowired
	private ICustomerService customerService;
	
	@Autowired
	private IDecidedzoneDao decidedzoneDao;
	
	@Autowired
	private IWorkbillDao workbillDao;

	/**
	 * ����ҵ��֪ͨ������Ҫ�����Զ��ֵ�
	 */
	public void save(Noticebill model) {
		User user = BOSUtils.getLoginUser();
		model.setUser(user);//���õ�ǰ��¼�û�
		noticebillDao.save(model);
		
		//��ȡ�ͻ���ȡ����ַ
		String pickaddress = model.getPickaddress();
		//Զ�̵���crm���񣬸���ȡ����ַ��ѯ����id
		String decidedzoneId = customerService.findDecidedzoneIdByAddress(pickaddress);
		if(decidedzoneId != null){
			//��ѯ���˶���id,��������Զ��ֵ�
			Decidedzone decidedzone = decidedzoneDao.findById(decidedzoneId);
			Staff staff = decidedzone.getStaff();
			model.setStaff(staff);//ҵ��֪ͨ������ȡ��Ա����
			//���÷ֵ�����Ϊ���Զ��ֵ�
			model.setOrdertype(Noticebill.ORDERTYPE_AUTO);
			//Ϊȡ��Ա����һ������
			Workbill workbill = new Workbill();
			workbill.setAttachbilltimes(0);//׷������
			workbill.setBuildtime(new Timestamp(System.currentTimeMillis()));//����ʱ�䣬��ǰϵͳʱ��
			workbill.setNoticebill(model);//��������ҳ��֪ͨ��
			workbill.setPickstate(workbill.PICKSTATE_NO);//ȡ��״̬
			workbill.setRemark(model.getRemark());//��ע��Ϣ
			workbill.setStaff(staff);//��������ȡ��Ա
			workbill.setType(workbill.Type_1);//��������
			workbillDao.save(workbill);
			//���ö���ƽ̨�����Ͷ���
		}else{
			//û�в�ѯ������id,��������Զ��ֵ�
			model.setOrdertype(Noticebill.ORDERTYPE_MAN);
		}
		
	}

}

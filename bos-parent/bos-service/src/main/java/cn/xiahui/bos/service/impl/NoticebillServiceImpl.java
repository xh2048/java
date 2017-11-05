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
	 * 保存业务通知单，还要尝试自动分单
	 */
	public void save(Noticebill model) {
		User user = BOSUtils.getLoginUser();
		model.setUser(user);//设置当前登录用户
		noticebillDao.save(model);
		
		//获取客户的取件地址
		String pickaddress = model.getPickaddress();
		//远程调用crm服务，根据取件地址查询定区id
		String decidedzoneId = customerService.findDecidedzoneIdByAddress(pickaddress);
		if(decidedzoneId != null){
			//查询到了定区id,可以完成自动分单
			Decidedzone decidedzone = decidedzoneDao.findById(decidedzoneId);
			Staff staff = decidedzone.getStaff();
			model.setStaff(staff);//业务通知单关联取派员对象
			//设置分单类型为：自动分单
			model.setOrdertype(Noticebill.ORDERTYPE_AUTO);
			//为取派员产生一个工单
			Workbill workbill = new Workbill();
			workbill.setAttachbilltimes(0);//追单次数
			workbill.setBuildtime(new Timestamp(System.currentTimeMillis()));//创建时间，当前系统时间
			workbill.setNoticebill(model);//工单关联页面通知单
			workbill.setPickstate(workbill.PICKSTATE_NO);//取件状态
			workbill.setRemark(model.getRemark());//备注信息
			workbill.setStaff(staff);//工单关联取派员
			workbill.setType(workbill.Type_1);//工单类型
			workbillDao.save(workbill);
			//调用短信平台，发送短信
		}else{
			//没有查询到定区id,不能完成自动分单
			model.setOrdertype(Noticebill.ORDERTYPE_MAN);
		}
		
	}

}

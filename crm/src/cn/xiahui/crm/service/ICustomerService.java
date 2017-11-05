package cn.xiahui.crm.service;

import java.util.List;

import javax.jws.WebService;

import cn.xiahui.crm.domain.Customer;

@WebService
public interface ICustomerService {
	public List<Customer> findAll();
	//��ѯδ�����������Ŀͻ�
	public List<Customer> findListNotAssociation();
	//��ѯ�Ѿ�������ָ�������Ŀͻ�
	public List<Customer> findListHasAssociation(String decidedzoneId);
	//���������ͻ�
	public void assigncustomerstodecidedzone(String decidedzoneId,Integer[] customerIds);
	//���ݿͻ��ֻ��Ų�ѯ�ͻ���Ϣ
	public Customer findCustomerByTelephone(String telephone);
	//���ݿͻ��ĵ�ַ��ѯ����id
	public String findDecidedzoneIdByAddress(String address);
}

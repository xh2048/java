package cn.xiahui.bos.web.action.base;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
/**
 * ���ֲ�ͨ��ʵ��
 */
public class BaseAction<T> extends ActionSupport implements ModelDriven<T> {
	public static final String HOME = "home";
	
	//ģ�Ͷ���
	protected T model;
	public T getModel() {
		return model;
	}
	
	//�ڹ��췽���ж�̬��ȡʵ�����ͣ�ͨ�����䴴��model����
	public BaseAction() {
		ParameterizedType genericSuperclass = (ParameterizedType) this.getClass().getGenericSuperclass();
		//���BaseAction�������ķ�������
		Type[] actualTypeArguments = genericSuperclass.getActualTypeArguments();
		Class<T> entityClass = (Class<T>) actualTypeArguments[0];
		//ͨ�����䴴������
		try {
			model = entityClass.newInstance();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
	}
}
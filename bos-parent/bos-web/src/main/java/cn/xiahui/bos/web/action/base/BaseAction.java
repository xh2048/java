package cn.xiahui.bos.web.action.base;

import java.io.IOException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import org.apache.struts2.ServletActionContext;
import org.hibernate.criterion.DetachedCriteria;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import cn.xiahui.bos.utils.PageBean;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
/**
 * ���ֲ�ͨ��ʵ��
 */
public class BaseAction<T> extends ActionSupport implements ModelDriven<T> {
	protected PageBean pageBean = new PageBean();
	//���������ύ��ѯ����
	DetachedCriteria detachedCriteria = null;
	
	public void setPage(int page){
		pageBean.setCurrentPage(page);
	}
	
	public void setRows(int rows){
		pageBean.setPageSize(rows);
	}
	
	/**
	 * ��ָ��Java����תΪjson������Ӧ���ͻ���ҳ��
	 */
	public void java2Json(Object o , String[] exclueds){
		JsonConfig jsonConfig = new JsonConfig();
		//ָ����Щ���Բ���Ҫתjson
		jsonConfig.setExcludes(exclueds);
		String json = JSONObject.fromObject(o,jsonConfig).toString();
		ServletActionContext.getResponse().setContentType("text/json;charset=utf-8");
		
		try {
			ServletActionContext.getResponse().getWriter().print(json);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * ��ָ��Java����תΪjson������Ӧ���ͻ���ҳ��
	 */
	public void java2Json(List o , String[] exclueds){
		JsonConfig jsonConfig = new JsonConfig();
		//ָ����Щ���Բ���Ҫתjson
		jsonConfig.setExcludes(exclueds);
		String json = JSONArray.fromObject(o,jsonConfig).toString();
		ServletActionContext.getResponse().setContentType("text/json;charset=utf-8");
		
		try {
			ServletActionContext.getResponse().getWriter().print(json);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static final String HOME = "home";
	public static final String LIST = "list";
	
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
		
		detachedCriteria = DetachedCriteria.forClass(entityClass);
		pageBean.setDetachedCriteria(detachedCriteria);
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

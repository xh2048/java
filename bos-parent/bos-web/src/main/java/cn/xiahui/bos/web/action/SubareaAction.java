package cn.xiahui.bos.web.action;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;

import org.apache.commons.lang3.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.struts2.ServletActionContext;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import cn.xiahui.bos.domain.Region;
import cn.xiahui.bos.domain.Subarea;
import cn.xiahui.bos.service.ISubareaService;
import cn.xiahui.bos.utils.FileUtils;
import cn.xiahui.bos.web.action.base.BaseAction;

@Controller
@Scope("prototype")
public class SubareaAction extends BaseAction<Subarea> {
	@Resource
	private ISubareaService subareaService;
	/**
	 * ��ӷ���
	 */
	public String add(){
		subareaService.save(model);
		return LIST;
	}
	
	/**
	 * ������ѯ
	 * 
	 */
	public String pageQuery(){
		DetachedCriteria dc = pageBean.getDetachedCriteria();
		//��̬��ӹ�������
		String addresskey = model.getAddresskey();
		if(StringUtils.isNotBlank(addresskey)){
			//��ӹ������������ݵ�ַ�ؼ���ģ����ѯ
			dc.add(Restrictions.like("addresskey","%"+addresskey+"%"));
		}
		
		Region region = model.getRegion();
		if(region != null){
			String province = region.getProvince();
			String city = region.getCity();
			String district = region.getDistrict();
			dc.createAlias("region", "r");
			if(StringUtils.isNotBlank(province)){
                //��ӹ�������������ʡ��ģ����ѯ-----��������ѯ��ʹ�ñ�����ʽʵ��
                //����һ�����������й��������������������
                //����������������������
				dc.add(Restrictions.like("r.province", "%"+province+"%"));
			}
			if(StringUtils.isNotBlank(city)){
                //��ӹ���������������ģ����ѯ-----��������ѯ��ʹ�ñ�����ʽʵ��
                //����һ�����������й��������������������
                //����������������������
				dc.add(Restrictions.like("r.city", "%"+city+"%"));
			}
			if(StringUtils.isNotBlank(district)){
                //��ӹ���������������ģ����ѯ-----��������ѯ��ʹ�ñ�����ʽʵ��
                //����һ�����������й��������������������
                //����������������������
				dc.add(Restrictions.like("r.district", "%"+district+"%"));
			}
			
		}
		subareaService.pageQuery(pageBean);
		this.java2Json(pageBean, new String[]{"currentPage","detachedCriteria","pageSize","decidedzone","subareas"});
		return NONE;
		
	}
	
	/**
	 * �������ݵ�������
	 * 
	 */
	public String exportXls() throws IOException{
		
		//��һ��:��ѯ���еķ�������
		List<Subarea> list = subareaService.findAll();
		
		//�ڶ���:ʹ��POI������д��Excel�ļ���
		//���ڴ��д���һ��Excel�ļ�
		HSSFWorkbook workbook = new HSSFWorkbook();
		//����һ����ǩҳ
		HSSFSheet sheet = workbook.createSheet();
		//����������
		HSSFRow headRow = sheet.createRow(0);
		headRow.createCell(0).setCellValue("�������");
		headRow.createCell(1).setCellValue("��ʼ���");
		headRow.createCell(2).setCellValue("�������");
		headRow.createCell(3).setCellValue("λ����Ϣ");
		headRow.createCell(4).setCellValue("ʡ����");
		
		for (Subarea subarea : list) {
			HSSFRow dataRow = sheet.createRow(sheet.getLastRowNum()+1);
			dataRow.createCell(0).setCellValue(subarea.getId());
			dataRow.createCell(1).setCellValue(subarea.getStartnum());
			dataRow.createCell(2).setCellValue(subarea.getEndnum());
			dataRow.createCell(3).setCellValue(subarea.getPosition());
			dataRow.createCell(4).setCellValue(subarea.getRegion().getName());
		}
		
		//��������ʹ������������ļ����أ�һ����������ͷ��
		
		String filename = "��������.xls";
		String contentType = ServletActionContext.getServletContext().getMimeType(filename);
		ServletOutputStream out = ServletActionContext.getResponse().getOutputStream();
		ServletActionContext.getResponse().setContentType(contentType);
		
		//��ȡ�ͻ������������
		String agent = ServletActionContext.getRequest().getHeader("User-Agent");
		filename = FileUtils.encodeDownloadFilename(filename, agent);
		ServletActionContext.getResponse().setHeader("content-disposition","attachment;filename="+filename);
		workbook.write(out);
		return NONE;
		
	}
	
	/**
	 * ��ѯ����δ�����������ķ���������json
	 */
	public String listajax(){
		List<Subarea> list = subareaService.findListNotAssociation();
		this.java2Json(list, new String[]{"decidedzone","region"});
		return NONE;
	}
	
	
	//�������������ն���id
	private String decidedzoneId;
	
	/**
	 * ���ݶ�ȥid��ѯ�����ķ���
	 */
	public String findListByDecidedzoneId(){
		List<Subarea> list = subareaService.findListByDecidedzoneId(decidedzoneId);
		this.java2Json(list, new String[]{"decidedzone","subareas"});
		return NONE;
		
	}


	public String getDecidedzoneId() {
		return decidedzoneId;
	}

	public void setDecidedzoneId(String decidedzoneId) {
		this.decidedzoneId = decidedzoneId;
	}
	
	
}

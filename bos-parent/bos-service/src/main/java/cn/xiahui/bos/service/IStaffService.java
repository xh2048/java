package cn.xiahui.bos.service;

import java.util.List;

import cn.xiahui.bos.domain.Staff;
import cn.xiahui.bos.utils.PageBean;

public interface IStaffService {

	public void save(Staff model);

	public void pageQuery(PageBean pageBean);

	public void deleteBatch(String ids);

	public Staff findById(String id);

	public void update(Staff staff);

	public List<Staff> findListNotDelete();

}

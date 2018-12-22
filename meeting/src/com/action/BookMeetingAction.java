package com.action;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSON;
import com.service.BookMeetingService;
import com.vo.Department;
import com.vo.domeeting;
import com.vo.employee;
import com.vo.meeting;

@Component("bookmeet")
public class BookMeetingAction {

	@Autowired
	private BookMeetingService bookservice;

	// 查询会议室名称
	private List<meeting> list;

	public String lookmeetname() {
		list = bookservice.lookmeetname();
		return "success";
	}

	List<Department> listdept;

	public void lookmeetname01() {

		try {
			listdept = bookservice.listdept();
			String msg = JSON.toJSONString(listdept);
			HttpServletResponse response = ServletActionContext.getResponse();
			response.setContentType("text/html;charset=utf-8");
			response.getWriter().print(msg);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private int departmentid;
	List<employee> listemp;

	public void lookmeetname02() {
		// 选择参会人员当中的部门
		try {
			listemp = bookservice.listemp_1(departmentid);
			String msg = JSON.toJSONString(listemp);
			HttpServletResponse response = ServletActionContext.getResponse();
			response.setContentType("text/html;charset=utf-8");
			response.getWriter().print(msg);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// 预定会议,完成对数据库的插入
	private domeeting dmt;

	public String domeet() {

		dmt.setReservationtime(new Timestamp(System.currentTimeMillis()));
		// 插入除过员工以外的其他信息
		bookservice.domeet(dmt);
		// 获取到对应的meeting值
		dmt.setMeetingid(bookservice.getmeetingid());
		// 插入员工
		String[] emp = dmt.getSelSelectedEmployees();
		for (int i = 0; i < emp.length; i++) {
			String ee = emp[i];
			dmt.setEe(ee);
			System.out.println(ee);
			bookservice.domeet_1(dmt);
		}
		return "success";
	}

	public domeeting getDmt() {
		return dmt;
	}

	public void setDmt(domeeting dmt) {
		this.dmt = dmt;
	}

	public List<employee> getListemp() {
		return listemp;
	}

	public void setListemp(List<employee> listemp) {
		this.listemp = listemp;
	}

	public int getDepartmentid() {
		return departmentid;
	}

	public void setDepartmentid(int departmentid) {
		this.departmentid = departmentid;
	}

	public List<Department> getListdept() {
		return listdept;
	}

	public void setListdept(List<Department> listdept) {
		this.listdept = listdept;
	}

	public List<meeting> getList() {
		return list;
	}

	public void setList(List<meeting> list) {
		this.list = list;
	}

}

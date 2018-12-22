package com.action;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.service.TestService;
import com.vo.Area;

@Component("test")
public class TestAction {

	
	@Autowired
    private TestService service;
	
	
	public void modelmap() throws IOException{
		List<Area> list = service.getlist();
		String msg = JSON.toJSONString(list);
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=utf-8");
		response.getWriter().print(msg);
	}
	/**
	 *删除信息
	 */
	//传递过来的参数
	private int areaId;
	private String areaName;
	private String priority;
	public void testdelete(){
		System.out.println("传递的ID为:"+areaId);
		service.testdelte(areaId);
	}
	
	//根据id来查找
	public void findbyId() throws IOException{
		Area area = service.findbyId(areaId);
		//System.out.println(area);
		String msg = JSON.toJSONString(area);
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=utf-8");
		response.getWriter().print(msg);
	}
	public void modifyarea(){
		Area area = new Area();
		area.setAreaId(areaId);
		area.setAreaName(areaName);
		area.setPriority(priority);
		//System.out.println(area);
		service.modifyarea(area);
	}
	/**
	 * 添加信息
	 */
    public void addarea(){
    	System.out.println("添加");
    	Area area = new Area();
		area.setAreaId(areaId);
		area.setAreaName(areaName);
		area.setPriority(priority);
		//System.out.println(area);
    	service.addarea(area);
	}
	
	
	
	
	

	public String getAreaName() {
		return areaName;
	}

	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}

	public String getPriority() {
		return priority;
	}

	public void setPriority(String priority) {
		this.priority = priority;
	}

	public int getAreaId() {
		return areaId;
	}
	public void setAreaId(int areaId) {
		this.areaId = areaId;
	}
}

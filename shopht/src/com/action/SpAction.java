package com.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSON;
import com.service.SpService;
import com.vo.PlVO;
import com.vo.Shopinf;

@Component("sp")
public class SpAction {

	@Autowired
	private SpService service;
	//添加商品详细信息 首先展示品类，子品类供用户选择
	private List<PlVO> list;
	public String add_sp(){
		
		list = service.add_sp();
		return "success";
	}
	//子品类
	private int id;
	public void add_zpl() throws IOException{
		List<PlVO> list = service.add_zpl(id);
		String msg = JSON.toJSONString(list);
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=utf-8");
		response.getWriter().print(msg);
	}
	//商品管理
	private List<Shopinf> listsp;
	public String commodity_list(){
		listsp = service.commodity_list();
		return "success";
	}
	
	
	//添加商品
	private Shopinf sp;
	public String add_sp_detail(){
		service.add_sp_detail(sp);
		return "success";
	}
	
	//商品详情                                                                                                                                             此处有bug
	public String commodity_info(){
		listsp = service.commodity_info(id);
		return "success";
	}
	//修改商品                                                                                                                                              此处有bug
	public String update_commodity_info(){
		listsp = service.commodity_info(id);
		return "success";
	}
	//删除商品
	public String delete_commodity_info(){
		service.delete_commodity_info(id);
		return "success";
	}
	//更改商品   临时追加的异步请求
	public void sa_findPlList() throws IOException{
		List<PlVO>  list = service.sa_findPlList();
		String msg = JSON.toJSONString(list);
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=utf-8");
		response.getWriter().print(msg);
		
	}
	//更改商品状态信息
	public void sa_updateShopState() throws IOException{
		service.sa_updateShopState(sp);
		String msg = "SUCCESS";
		HttpServletResponse response = ServletActionContext.getResponse();		
		response.setContentType("text/html;charset=utf-8");
		response.getWriter().print(msg);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	


	public List<Shopinf> getListsp() {
		return listsp;
	}

	public void setListsp(List<Shopinf> listsp) {
		this.listsp = listsp;
	}

	public Shopinf getSp() {
		return sp;
	}
	public void setSp(Shopinf sp) {
		this.sp = sp;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<PlVO> getList() {
		return list;
	}

	public void setList(List<PlVO> list) {
		this.list = list;
	}

	public SpService getService() {
		return service;
	}

	public void setService(SpService service) {
		this.service = service;
	}
	
}

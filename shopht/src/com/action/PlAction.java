package com.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.List;

import javax.servlet.ServletContext;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.service.PlService;
import com.vo.PlVO;
import com.vo.ZPlVO;

@Component("pl")
public class PlAction {
	@Autowired
	private PlService service;

	//查询品类以及分页
	private int totalpage;
	private int page;
	private int pagesize;
	List<PlVO> list;
	public String selectplist(){
		int count = service.getplistcount();
		if(count%pagesize==0){
			totalpage = count/pagesize;
		}else{
			totalpage = count/pagesize+1;
		}
		list = service.selectplist(page,pagesize);
		return "success";
	}
	//增加商品
	private String pname;
	public String add_pl(){
		service.add_pl(pname);
		return "success";
	}
	private int id;
	private PlVO plvo;
	//更改品类名称 先是查询
	public String update_pl(){
		plvo = service.update_pl(id);
		return "success";
	}
	//更改品类名称
	public String updatepl(){
		service.updatepl(plvo);
		return "success";
	}
	//删除品类
	public String delete_pl(){
		service.delete_pl(id);
		return "success";
	}
	
	//查询子品类
	List<ZPlVO> zlist;
	public String look_zpl(){
		//父品类名称
		pname = service.lookplname(id);
		int count = service.zplistcount(id);
		if(count%3==0){
			totalpage = count/pagesize;
		}else{
			totalpage = count/pagesize+1;
		}
		zlist = service.look_zpl(id,page,pagesize);
		return "success";
	}
	
	//更改子品类名称  先是查询
	private ZPlVO zplvo;
	public String update_zpl(){
		zplvo = service.update_zpl(id);
		return "success";
	}	
	//执行更改子品类名称
	public String updatezpl(){
		service.updatezpl(zplvo);
		return "success";
	}
	//删除子品类          
	public String delete_zpl(){
		service.delete_zpl(id);
		return "success";
	}
	
	
	//添加子品类
	public String add_zpl(){
		return "success";
	}
	//添加子品类
	public String add_zpl_sure(){
		List list = zplvo.getList();
		for(int i =0;i<list.size();i++){
			service.add_zpl_sure(id,list.get(i));
		}
		return "success";
	}
	
	//上传图片
	private File upfile;
	private String upfileFileName;
	public void upfile(){
		try {
			FileInputStream fis = new FileInputStream(upfile);
			ServletContext context = ServletActionContext.getServletContext();
			String path = context.getRealPath("/");
			String oname = upfileFileName.substring(upfileFileName.lastIndexOf("."));
			String nname = System.currentTimeMillis()+oname;
			FileOutputStream fos = new FileOutputStream(path+"/upload/"+nname);
			int t = 0;
			while((t=fis.read())!=-1){
				fos.write(t);
			}
//			  
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	
	
	
	public PlVO getPlvo() {
		return plvo;
	}

	public void setPlvo(PlVO plvo) {
		this.plvo = plvo;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getTotalpage() {
		return totalpage;
	}
	public void setTotalpage(int totalpage) {
		this.totalpage = totalpage;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public PlService getService() {
		return service;
	}
	public void setService(PlService service) {
		this.service = service;
	}
	public List<PlVO> getList() {
		return list;
	}
	public void setList(List<PlVO> list) {
		this.list = list;
	}
	public int getPagesize() {
		return pagesize;
	}
	public void setPagesize(int pagesize) {
		this.pagesize = pagesize;
	}
	public List<ZPlVO> getZlist() {
		return zlist;
	}
	public void setZlist(List<ZPlVO> zlist) {
		this.zlist = zlist;
	}
	public ZPlVO getZplvo() {
		return zplvo;
	}
	public void setZplvo(ZPlVO zplvo) {
		this.zplvo = zplvo;
	}
	
}

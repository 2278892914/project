package com.action;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.service.SerchEmpService;
import com.vo.SerchEmployee;
import com.vo.employee;



@Component("SerchEmp")
public class SerchEmpAction {

	@Autowired
	private SerchEmpService serchempservice;
	//角色管理
	
	//三种状态的查询      已经通过审批员工
	List<employee> list01 = null;
	private int count;
	private int totalpage;
	private int page;
	private int pagesize;
	
	private SerchEmployee emp;
	
	public String serchemp(){
		
		if(emp==null){
			
			count = serchempservice.getcount();
			if(count%3==0){
				totalpage=count/3;
			}else{
				totalpage=count/3+1;
			}
			if(page<1){
				page=1;
			}
			if(page>totalpage){
				page=totalpage;
			}
			pagesize = (page-1)*3;
			
			list01 = serchempservice.serchempagree(pagesize);
			
		}else{
			
			String username=emp.getEmployeename();
			String accountname=emp.getAccountname();
			//按照姓名和状态查询
			if(!("".equals(username))){
				//按照按照姓名和状态查询总条数
				count = serchempservice.getcount01(emp);
				if(count%3==0){
					totalpage=count/3;
				}else{
					totalpage=count/3+1;
				}
				if(page<1){
					page=1;
				}
				if(page>totalpage){
					page=totalpage;
				}
				pagesize = (page-1)*3;
				emp.setPagesize((page-1)*3);
				list01 = serchempservice.serchemp01(emp);
			}
			//按照账户名和状态查询
			if(!("".equals(accountname))){
				//按照账户名和状态查询总条数
				count = serchempservice.getcount02(emp);
				if(count%3==0){
					totalpage=count/3;
				}else{
					totalpage=count/3+1;
				}
				if(page<1){
					page=1;
				}
				if(page>totalpage){
					page=totalpage;
				}
				pagesize = (page-1)*3;
				emp.setPagesize((page-1)*3);
				list01 = serchempservice.serchemp02(emp);
			}
			//按照审批状态进行查询
			if("".equals(username)&&"".equals(accountname)){
				//按照审批状态进行查询总条数
				count = serchempservice.getcount03(emp);
				if(count%3==0){
					totalpage=count/3;
				}else{
					totalpage=count/3+1;
				}
				if(page<1){
					page=1;
				}
				if(page>totalpage){
					page=totalpage;
				}
				pagesize = (page-1)*3;
				emp.setPagesize((page-1)*3);
				list01 = serchempservice.serchemp03(emp);
			}
		}
		
		return "success";
	}
	//关闭账号
	private String account;
	
	public String close(){
		serchempservice.close(account);
		return "success";
	}
	
	
	
	
	
	
	
	

	public String getAccount() {
		return account;
	}


	public void setAccount(String account) {
		this.account = account;
	}

	public int getPagesize() {
		return pagesize;
	}

	public void setPagesize(int pagesize) {
		this.pagesize = pagesize;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public SerchEmployee getEmp() {
		return emp;
	}

	public void setEmp(SerchEmployee emp) {
		this.emp = emp;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public List<employee> getList01() {
		return list01;
	}

	public void setList01(List<employee> list01) {
		this.list01 = list01;
	}

	
	public int getTotalpage() {
		return totalpage;
	}

	public void setTotalpage(int totalpage) {
		this.totalpage = totalpage;
	}

	
	
	
}

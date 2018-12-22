package com.action;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.service.SerchMeetingService;
import com.vo.SerchMeet;
import com.vo.domeeting;

@Component("serchmeet")
public class SerchMeetingAction {

	@Autowired
	private SerchMeetingService serchmeetservice;
	//搜索会议
	List<domeeting> listmeet;
	//获取当前页数
	private int page;     //当前页数
	private int totalpage;   //总页数
	private int count;   // 总条数
	private int pagesize;  //条数所到的条数
	//按照条件查照
	private SerchMeet serchmeet;
		
	public String serchmeeting(){
		if(serchmeet==null){
		
		
		count = serchmeetservice.getmeetingcount();
		if(count%3==0){
			totalpage = count/3;
		}else{
			totalpage = count/3+1;
		}
		if(page<1){
			page=1;
		}
		if(page>totalpage){
			page=totalpage;
		}
		pagesize = (page-1)*3;
		listmeet = serchmeetservice.serchmeeting(pagesize);
		}else{
			String meetingname=serchmeet.getMeetingname();
			String roomname=serchmeet.getRoomname();
			String employeename = serchmeet.getEmployeename();
			//按照会议室名字查照
			if(!("".equals(meetingname))){
				//按照按照姓名和状态查询总条数
				count = serchmeetservice.getcount01(serchmeet);
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
				serchmeet.setPagesize((page-1)*3);
				listmeet = serchmeetservice.serchmeeting01(serchmeet);
			}
			//按照房间名称查询
			if(!("".equals(roomname))){
				//按照账户名和状态查询总条数
				count = serchmeetservice.getcount02(serchmeet);
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
				serchmeet.setPagesize((page-1)*3);
				listmeet = serchmeetservice.serchmeeting02(serchmeet);
			}
			//按照员工姓名查照
//			if(!("".equals(employeename))){
//				//按照审批状态进行查询总条数
//				count = serchmeetservice.getcount03(serchmeet);
//				if(count%3==0){
//					totalpage=count/3;
//				}else{
//					totalpage=count/3+1;
//				}
//				listmeet = serchmeetservice.serchmeeting03(serchmeet);
//			}
		
		}
		return "success";
	}
	
	//查看会议室详情
	private int meetingid;   //会议对应的id
	List<domeeting> meetingdetail ;
	List<domeeting> employeedetail ;
	public String meetingdetails(){
		
		meetingdetail = serchmeetservice.meetingdetail(meetingid);
		employeedetail = serchmeetservice.employeedetail(meetingid);
		return "success";
	}
	
	
	public List<domeeting> getEmployeedetail() {
		return employeedetail;
	}


	public void setEmployeedetail(List<domeeting> employeedetail) {
		this.employeedetail = employeedetail;
	}


	public SerchMeet getSerchmeet() {
		return serchmeet;
	}

	public void setSerchmeet(SerchMeet serchmeet) {
		this.serchmeet = serchmeet;
	}

	public List<domeeting> getMeetingdetail() {
		return meetingdetail;
	}

	public void setMeetingdetail(List<domeeting> meetingdetail) {
		this.meetingdetail = meetingdetail;
	}

	public int getMeetingid() {
		return meetingid;
	}

	public void setMeetingid(int meetingid) {
		this.meetingid = meetingid;
	}

	public int getTotalpage() {
		return totalpage;
	}

	public void setTotalpage(int totalpage) {
		this.totalpage = totalpage;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public int getPage() {
		return page;
	}



	public void setPage(int page) {
		this.page = page;
	}

	public List<domeeting> getListmeet() {
		return listmeet;
	}
	public void setListmeet(List<domeeting> listmeet) {
		this.listmeet = listmeet;
	}
	
}

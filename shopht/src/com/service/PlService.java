package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.PlDao;
import com.vo.PlVO;
import com.vo.ZPlVO;

@Service
public class PlService {

	@Autowired
	private PlDao dao;

    public List<PlVO> selectplist(int page, int pagesize) {
		
		return dao.selectplist(page,pagesize);
	}
    public void add_pl(String pname) {
		dao.add_pl(pname);
	}
    public PlVO update_pl(int id) {
		
		return dao.update_pl(id);
	}
	
	public int getplistcount() {
		return dao.getplistcount();
	}
	public void updatepl(PlVO plvo) {
		dao.updatepl(plvo);
	}
	public void delete_pl(int id) {
		dao.delete_pl(id);
	}
	public String lookplname(int id) {
		return dao.lookplname(id);
	}
	public int zplistcount(int id) {
		
		return dao.zplistcount(id);
	}
	public List<ZPlVO> look_zpl(int id,int page, int pagesize) {
		
		return dao.look_zpl(id,page,pagesize);
	}
	public ZPlVO update_zpl(int id) {
		
		return dao.update_zpl(id);
	}
	public void updatezpl(ZPlVO zplvo) {
		dao.updatezpl(zplvo);
	}
	public void delete_zpl(int id) {
		dao.delete_zpl(id);
	}
	public void add_zpl_sure(int id, Object object) {
		dao.add_zpl_sure(id,object);
	}
	
	
}

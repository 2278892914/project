package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.SpDao;
import com.vo.PlVO;
import com.vo.Shopinf;

@Service
public class SpService {

	@Autowired
	private SpDao dao;

	public SpDao getDao() {
		return dao;
	}
	public void setDao(SpDao dao) {
		this.dao = dao;
	}
	public List<PlVO> add_sp() {
		
		return dao.add_sp();
	}
	public List<PlVO> add_zpl(int id) {
		return dao.add_zpl(id);
	}
	public void add_sp_detail(Shopinf sp) {
		dao.add_sp_detail(sp);
	}
	public List<Shopinf> commodity_list() {
		
		return dao.commodity_list();
	}
	public List<Shopinf> commodity_info(int id) {
		
		return dao.commodity_info(id);
	}
	public void delete_commodity_info(int id) {
		dao.delete_commodity_info(id);
	}
	public List<PlVO> sa_findPlList() {
		
		return dao.sa_findPlList();
	}
	public void sa_updateShopState(Shopinf sp) {
		dao.sa_updateShopState(sp);
	}

}

package com.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import com.dao.ShowCarDao;

import VO.BrandVO;
import VO.StoreVO;


public class ShowCarService {


	//查询品牌信息
	public List<BrandVO> findBrand(){

		ShowCarDao cd = new ShowCarDao();
		List<BrandVO> listBrand  = cd.findBrand();
			
		return listBrand;
	}
	//查询门店信息
	public List<StoreVO> findStore(){

		ShowCarDao cd = new ShowCarDao();
		List<StoreVO> listStore = cd.findStore();
			
		return listStore;


	}

}

package com.service;

import java.util.List;

import com.dao.CarListDao;

import VO.CarVO;

public class CarListService{

	public List<CarVO> findCarList(int page,int pageSize){
		CarListDao cd = new CarListDao();
		List<CarVO> list = cd.findCarList(page, pageSize);
		return list;
		
	}

	public int findTotalPage(int pageSize) {
		CarListDao cd = new CarListDao();
		int totalSize = cd.findCarCount();
		
		int totalPage = 0;
		
		
		if(totalSize%pageSize == 0){
			totalPage = totalSize/pageSize;
		}else{
			totalPage = totalSize/pageSize +1;
		}
		
		return totalPage;
	}
	
	
	
	
}

package com.service;


import java.util.List;

import com.dao.TypeDao;

import VO.TypeVO;



public class Typeservice {

	public List<TypeVO> type(String id){
		
		TypeDao t = new TypeDao();
		List<TypeVO> listType = t.type(id);
		
		return listType;
	}
}

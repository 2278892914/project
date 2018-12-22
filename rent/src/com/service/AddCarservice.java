package com.service;

import com.dao.AddCardao;

import PO.CarPO;

public class AddCarservice {
	//插入数据，更改数据，无需返回值
	public void addCar(CarPO car){
		new AddCardao().addCar(car);
	}
}

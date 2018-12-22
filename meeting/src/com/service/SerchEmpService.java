package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.SerchEmpDao;
import com.vo.SerchEmployee;
import com.vo.employee;

@Service
public class SerchEmpService {

	@Autowired
	private SerchEmpDao serchempdao;

	public List<employee> serchempagree(int page) {
		
		return serchempdao.serchempagree(page);
	}

	public int getcount() {
		
		return serchempdao.getcount();
	}
    public List<employee> serchemp01(SerchEmployee emp){
		
    	return serchempdao.serchemp01(emp);
	}
    public List<employee> serchemp02(SerchEmployee emp){
		
    	return serchempdao.serchemp02(emp);
	}

	public List<employee> serchemp03(SerchEmployee emp) {
		
		return serchempdao.serchemp03(emp);
	}

	public int getcount01(SerchEmployee emp) {
		
		return serchempdao.getcount01(emp);
	}
    public int getcount02(SerchEmployee emp) {
		
		return serchempdao.getcount02(emp);
	}
    public int getcount03(SerchEmployee emp) {
	
	return serchempdao.getcount03(emp);
}

	public void close(String account) {
		serchempdao.close(account);
	}
   
}

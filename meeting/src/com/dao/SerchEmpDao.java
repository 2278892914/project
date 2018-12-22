package com.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vo.SerchEmployee;
import com.vo.employee;


@Service
public class SerchEmpDao {

	@Autowired
	private SqlSessionTemplate sqlSession;

	public List<employee> serchempagree(int pagesize) {
		return sqlSession.selectList("p1.serchempagree",pagesize);
		
	}

	public int getcount() {
		return sqlSession.selectOne("p1.serchempcount");
	}
	public List<employee> serchemp01(SerchEmployee emp){
		
		return sqlSession.selectList("p1.employeename",emp);
	}
    public List<employee> serchemp02(SerchEmployee emp){
		
		return sqlSession.selectList("p1.accountname", emp);
		
	}

	public List<employee> serchemp03(SerchEmployee emp) {
		
		return sqlSession.selectList("p1.status", emp);
	}

	public int getcount01(SerchEmployee emp) {
		
		return sqlSession.selectOne("p1.getcount01", emp);
	}
    public int getcount02(SerchEmployee emp) {
		
		return sqlSession.selectOne("p1.getcount02", emp);
	}
    public int getcount03(SerchEmployee emp) {
	
	return sqlSession.selectOne("p1.getcount03", emp);
    }

	public void close(String account) {
		sqlSession.update("p1.closeaccount", account);
	}
}

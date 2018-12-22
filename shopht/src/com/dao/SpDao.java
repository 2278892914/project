package com.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vo.PlVO;
import com.vo.Shopinf;

@Service
public class SpDao {

	@Autowired
	private SqlSessionTemplate sqlSession;

	public SqlSessionTemplate getSqlSession() {
		return sqlSession;
	}

	public void setSqlSession(SqlSessionTemplate sqlSession) {
		this.sqlSession = sqlSession;
	}

	public List<PlVO> add_sp() {
		
		return sqlSession.selectList("p1.showpl");
	}

	public List<PlVO> add_zpl(int id) {
		
		return sqlSession.selectList("p1.showpl_2",id);
	}

	public void add_sp_detail(Shopinf sp) {
		sqlSession.insert("p2.add_sp_detail", sp);
	}

	public List<Shopinf> commodity_list() {
		
		return sqlSession.selectList("p2.commodity_list");
	}

	public List<Shopinf> commodity_info(int id) {
		
		return sqlSession.selectList("p2.commodity_info",id);
	}

	public void delete_commodity_info(int id) {
		sqlSession.delete("p2.delete_commodity_info", id);
	}

	public List<PlVO> sa_findPlList() {
		
		return sqlSession.selectList("p2.sa_findPlList");
	}

	public void sa_updateShopState(Shopinf sp) {
		sqlSession.update("p2.sa_updateShopState", sp);
	}
	
}

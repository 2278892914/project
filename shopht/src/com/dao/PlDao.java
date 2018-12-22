package com.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vo.PlVO;
import com.vo.ZPlVO;

@Service
public class PlDao {
	@Autowired
	private SqlSessionTemplate sqlSession;

	
	public List<PlVO> selectplist(int page,int pagesize) {
		Map<String,Integer> map = new HashMap<String,Integer>();
		map.put("page", (page-1)*pagesize);
		map.put("pagesize", pagesize);
		return sqlSession.selectList("p1.selectplist",map);
	}
	public void add_pl(String pname) {
		sqlSession.insert("p1.add_pl", pname);
	}

	public int getplistcount() {
		return sqlSession.selectOne("p1.getplistcount");
	}
	
	public SqlSessionTemplate getSqlSession() {
		return sqlSession;
	}
	public void setSqlSession(SqlSessionTemplate sqlSession) {
		this.sqlSession = sqlSession;
	}
	public PlVO update_pl(int id) {
		
		return sqlSession.selectOne("p1.update_pl", id);
	}
	public void updatepl(PlVO plvo) {
		sqlSession.update("p1.updatepl", plvo);
	}
	public void delete_pl(int id) {
		sqlSession.delete("p1.delete_pl",id);
	}
	public String lookplname(int id) {
		return sqlSession.selectOne("p1.lookplname", id);
	}
	public int zplistcount(int id) {
		return sqlSession.selectOne("p1.zplistcount", id);
	}
	public List<ZPlVO> look_zpl(int id,int page, int pagesize) {
		Map<String,Integer> map = new HashMap<String,Integer>();
		map.put("id", id);
		map.put("page", (page-1)*pagesize);
		map.put("pagesize", pagesize);
		return sqlSession.selectList("p1.look_zpl", map);
	}
	public ZPlVO update_zpl(int id) {
		
		return sqlSession.selectOne("p1.update_zpl", id);
	}
	public void updatezpl(ZPlVO zplvo) {
		sqlSession.update("p1.updatezpl", zplvo);
	}
	public void delete_zpl(int id) {
		sqlSession.delete("p1.delete_zpl", id);
	}
	public void add_zpl_sure(int id, Object object) {
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("id", id);
		map.put("pcname", object);
		sqlSession.insert("p1.add_zpl_sure", map);
	}

}

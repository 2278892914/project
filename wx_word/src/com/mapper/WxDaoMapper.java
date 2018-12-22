package com.mapper;

import java.util.List;
import java.util.Map;

import com.entity.Area;
import com.entity.User;
import com.entity.Word;

public interface WxDaoMapper {

	public List<Area> selectlist();

	public List<Word> selectword(Map<String, Object> map);

	public Word reciteword(Map<String, Object> map);

	public void updatawordstate(Map<String, Object> map);

	public Word getword(Map<Object, Object> map);

	public User getinfo();

	public void updateinfo(User users);

	public User getrecord(Map<String, String> map);

	public int getflag(Map<String, String> map);

	public void updateflag(Map<String, Object> map);

	public void tartwitdid(Map<String, Object> map);

	public void mupdateflag(Map<String, Object> map);

	public int getrecite();

	public void insertrecitetime(Map<String, Object> map);

	public int yiwords();

	public int weiwords();

	public List<Word> selectyiwords();

	public List<Word> selectweiwords();
	
}

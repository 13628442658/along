package com.baidu.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.baidu.mapper.DianMapper;
import com.baidu.pojo.DianYing;

@Service
public class DianServiceImpl implements DianService {

	@Resource
	DianMapper dianMapper;

	@Override
	public List<Map<String, Object>> findList(Map<String, Object> map) {
		return dianMapper.findList(map);
	}

	public List<Map<String, Object>> selectList() {
		return dianMapper.selectList();
	}

	@Override
	public int add(DianYing dianYing, int[] tids) {
		
		//首页添加电影表
		int i = dianMapper.addDianYing(dianYing);
		
		//添加电影分类表
		if(dianYing.getDid()>0) {
			
			Map<String,Object> map = new HashMap<>();
			map.put("tids",tids);
			map.put("did",dianYing.getDid());
			int j = dianMapper.addDT(map);
		}
		return 0;
	}
	
	
	@Override
	public DianYing selectId(DianYing dianYing) {
		return dianMapper.selectId(dianYing);
	}
	
	@Override
	public List<Integer> selectdt(DianYing dianYing) {
		return dianMapper.selectdt(dianYing);
	}
	
	@Override
	public int addDianType(int[] tids, int did) {
		
		int i = dianMapper.delete(did);
		if(did>0) {
			Map<String,Object> map = new HashMap<>();
			map.put("tids", tids);
			map.put("did", did);
			int j = dianMapper.addDianType(map);
		}
		
		
		
		return 0;
	}

	@Override
	public int deleteAll(String did) {
		String substring = did.substring(1);
		return dianMapper.deleteAll(substring);
	}

	
	
}

package com.baidu.service;

import java.util.List;
import java.util.Map;

import com.baidu.pojo.DianYing;

public interface DianService {

	List<Map<String, Object>> findList(Map<String, Object> map);

	List<Map<String, Object>> selectList();

	int add(DianYing dianYing, int[] tids);

	DianYing selectId(DianYing dianYing);

	List<Integer> selectdt(DianYing dianYing);

	int addDianType(int[] tids, int did);

	int deleteAll(String did);

}

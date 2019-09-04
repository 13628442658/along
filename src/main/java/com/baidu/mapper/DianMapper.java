package com.baidu.mapper;

import java.util.List;
import java.util.Map;

import com.baidu.pojo.DianYing;

public interface DianMapper {

	List<Map<String, Object>> findList(Map<String, Object> map);

	List<Map<String, Object>> selectList();

	int addDianYing(DianYing dianYing);

	int addDT(int did, int[] tids);

	int addDT(Map<String, Object> map);

	DianYing selectId(DianYing dianYing);

	List<Integer> selectdt(DianYing dianYing);

	int update(Map<String, Object> map);

	int addDianType(Map<String, Object> map);

	int delete(int did);

	int deleteAll(String substring);

}

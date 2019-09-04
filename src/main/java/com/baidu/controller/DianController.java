package com.baidu.controller;

import java.lang.ProcessBuilder.Redirect;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.baidu.pojo.DianYing;
import com.baidu.service.DianService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Controller
public class DianController {

	@Resource
	DianService dianService;
	
	/**
	 * 列表  分页以及模糊查询
	 * @param cpage
	 * @param pageSize
	 * @param mh
	 * @return
	 */
	@RequestMapping("list.do")
	public String list(
			@RequestParam(defaultValue = "1")int cpage,
			@RequestParam(defaultValue = "3")int pageSize,
			@RequestParam(defaultValue = "")String mh,
			Model model
			) {
		Map<String,Object> map = new HashMap<>();
		map.put("mh", mh);
		
		PageHelper.startPage(cpage, pageSize);
		List<Map<String,Object>> findList = dianService.findList(map);
		PageInfo<Map<String, Object>> pageInfo = new PageInfo<Map<String,Object>>(findList);
		
		model.addAttribute("map", map);
		model.addAttribute("findList", findList);
		model.addAttribute("page", pageInfo);
		return "list";
		
	}
	
	
	/**
	 * 
	 * 查询分类表，然后跳转到添加页面
	 */
	@RequestMapping("toadd.do")
	public String toadd(Model model) {
		
		List<Map<String,Object>> typeList = dianService.selectList();
		
		model.addAttribute("type", typeList);
		return "add";
		
	}
	
	/**
	 * 实现添加功能
	 */
	@RequestMapping("add.do")
	public String add(DianYing dianYing,int[] tids) {
		int i = dianService.add(dianYing,tids);
		
		return "redirect:list.do";
		
	}
	
	
	/**
	 * 查询分类表 然后跳转到修改页面
	 */
	@RequestMapping("toupdate.do")
	public String toupdate(Model model,DianYing dianYing) {
		Map<String,Object> map = new HashMap<>();
		DianYing dy = dianService.selectId(dianYing);
		List<Map<String,Object>> typeList = dianService.selectList();
		List<Integer> dt = dianService.selectdt(dianYing);
		model.addAttribute("type", typeList);
		model.addAttribute("dt", dt);
		model.addAttribute("dy", dy);
		return "update";
	}
	
	@RequestMapping("update.do")
	public String update(int did,int[] tids) {
		int i = dianService.addDianType(tids,did);
		return "redirect:list.do";
	}
	
	@RequestMapping("deleteAll.do")
	@ResponseBody
	public int deleteAll(String did) {
		 
		return dianService.deleteAll(did);
	}
	
	/**
	 * 我要版本冲突sadas
	 */
	
	
	
	
	
	
	
	
	
}

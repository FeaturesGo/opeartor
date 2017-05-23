package com.www.opeartor.action;

import com.www.opeartor.entity.Artic;
import com.www.opeartor.serviceImpl.ArticServiceImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@Controller
public class ArticAction {
	
	private static Logger logger = LogManager.getLogger(MaterialAction.class);
	
	@Autowired
	private ArticServiceImpl articServiceImpl;
	
	
	@RequestMapping(path="/artic/saveView")
	public Object saveview (Artic artic) {
		return "artic/addartic";
	}
	
	
	@RequestMapping(path="/artic/articListView")
	public Object articListView () {
		return "artic/articList";
	}
	
	
	@ResponseBody
	@RequestMapping(path="/artic/articListData",produces="application/json;charset=UTF-8")
	public Object articListData (String currentPage,String pageSize,Model model) {
		currentPage = currentPage==null?"1":currentPage;
		pageSize = pageSize ==null?"10":pageSize;
		List<Artic> result = articServiceImpl.getArticListData(Integer.valueOf(currentPage),Integer.valueOf(pageSize));
		logger.info(result);
		return result;
	}
	
	
	
	
	@RequestMapping(path="/artic/saveArtic")
	public Object saveArtic (Artic artic) {
		
		logger.debug("文章保存");
		Map<String,Object> result = articServiceImpl.saveArtic(artic);
		return "redirect:/artic/articListView";
	}
	
	
	@RequestMapping(path="/artic/updateArtic")
	public Object updateArtic (Artic artic) {
		
		logger.debug("文章修改");
		Map<String,Object> result = articServiceImpl.updateArtic(artic);
		return result;
	}
	
	
	@RequestMapping(path="/artic/getArticObject")
	public Object getArticObject (String id) {
		id = id==null?"0":id;
		logger.debug("获取单个文件");
		Map<String,Object> result = articServiceImpl.getArticObject(Integer.valueOf(id));
		return result;
	}
	
	
	@RequestMapping(path="/artic/getArticList")
	public Object getArticList (String currentPage,String pageSize) {
		
		logger.debug("获取文章列表");
		logger.debug("参数currentPage :{},pageSize:{}",currentPage,pageSize);
		currentPage = currentPage==null?"1":currentPage;
		pageSize = pageSize ==null?"10":pageSize;
		Map<String,Object> result = articServiceImpl.getArticList(Integer.valueOf(currentPage),Integer.valueOf(pageSize));
		return result;
	}
	
	
	
	
	

}

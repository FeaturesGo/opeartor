package com.www.opeartor.action;

import com.www.opeartor.entity.Artic;
import com.www.opeartor.serviceImpl.ArticServiceImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

/**
 * 文章控制层
 * @author hwg
 *
 *
 */
@Controller
public class ArticAction {
	
	private static Logger logger = LogManager.getLogger(MaterialAction.class);
	
	@Autowired
	private ArticServiceImpl articServiceImpl;
	
	@RequestMapping(path="/artic/saveArtic")
	public Object saveArtic (Artic artic) {
		
		logger.debug("文章保存");
		Map<String,Object> result = articServiceImpl.saveArtic(artic);
		return result;
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
	public Object getArticList (Artic artic) {
		
		logger.debug("文章修改");
		Map<String,Object> result = articServiceImpl.updateArtic(artic);
		return result;
	}
	
	

}

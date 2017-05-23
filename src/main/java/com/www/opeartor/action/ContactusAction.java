package com.www.opeartor.action;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.www.opeartor.entity.Tourist; 
import com.www.opeartor.serviceImpl.TouristServiceImpl;

@Controller
public class ContactusAction {
	
	private static Logger logger = LogManager.getLogger(ContactusAction.class);

	@Autowired
	private TouristServiceImpl touristServiceImpl;
	
	@RequestMapping(path="tourist/contactusView")
	public Object contactusView() {
		return "tourist/contactusView"; 
	}
	
	@ResponseBody
	@RequestMapping(path="tourist/saveTourist")
	public Object saveTourist(Tourist tourist) {
		
		logger.info("提交的表单数据：{}",tourist);
		touristServiceImpl.saveTourist(tourist);
		return ""; 
	}
}

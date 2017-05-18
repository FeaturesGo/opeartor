package com.www.opeartor.action;

import com.www.opeartor.entity.Operator;
import com.www.opeartor.serviceImpl.LoginServiceImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;


/***
 * 登录管理
 * @author hwg
 *
 */
@Controller
public class LoginAction {
	
	private static Logger logger = LogManager.getLogger(LoginAction.class);
	
	@Autowired
	private LoginServiceImpl loginServiceImpl;
	
	
	@RequestMapping(path={"/","login"})
	public Object login(Model model) {
		model.addAttribute("operator", new Operator());
		return "login";
	}
	
	@ResponseBody
	@RequestMapping(path="loginValidata")
	public Object loginValidata(String userName,String userPwd) {
		logger.info("参数用户名：{},密码：{}",userName,userPwd);
		Map<String,Object> result = loginServiceImpl.loginValidata(userName,userPwd);
		
		
		return result;
	}

}

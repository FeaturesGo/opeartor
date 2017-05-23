package com.www.opeartor.action;

import com.www.opeartor.serviceImpl.LoginServiceImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;


/***
 * 登录管理
 * @author wangweiwei
 *
 */
@Controller
public class LoginAction {
	
	private static Logger logger = LogManager.getLogger(LoginAction.class);
	
	@Autowired
	private LoginServiceImpl loginServiceImpl;
	
	
	@RequestMapping(path={"/","login"})
	public Object login(Model model) {
		return "login";
	}
	
	
	@RequestMapping(path={"home"})
	public Object home(Model model) {
		return "home";
	}
	
	@RequestMapping(path="loginValidata")
	public Object loginValidata(String userName,String userPwd,Model model) {
		logger.info("参数用户名：{},密码：{}",userName,userPwd);
		Map<String,Object> result = loginServiceImpl.loginValidata(userName,userPwd);
		if("0000".equals(result.get("code"))) {
			return "home";
		}
		model.addAttribute("error", result.get("codeDesc"));
		return "login";
	}

}

package com.www.opeartor.serviceImpl;

import com.www.opeartor.dao.LoginDaoMapper;
import com.www.opeartor.entity.Operator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class LoginServiceImpl {
	
	@Autowired
	private LoginDaoMapper LoginDao;

	public Map<String, Object> loginValidata(String userName, String userPwd) {
		Map<String, Object> result = new HashMap<>();
		Operator user = LoginDao.getUser(userName);
		result.put("code", "0001");
		result.put("codeDesc", "用户不存在");
		result.put("data", false);
		if(user!=null) {
			String userPwdDB = (String) user.getUserPwd();
			if(userPwd.equals(userPwdDB)) {
				result.put("data", true);
				result.put("code", "0000");
				result.put("codeDesc", "成功");
			} else {
				result.put("code", "0002");
				result.put("codeDesc", "密码错误");
			}
		}
		
		return result;
	}

}

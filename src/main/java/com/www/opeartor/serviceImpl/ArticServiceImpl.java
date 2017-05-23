package com.www.opeartor.serviceImpl;

import com.www.opeartor.dao.ArticDaoMapper;
import com.www.opeartor.entity.Artic;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ArticServiceImpl {
	
	private static Logger logger = LogManager.getLogger(ArticServiceImpl.class);
	
	@Autowired
	private ArticDaoMapper articDaoMapper;

	public Map<String, Object> saveArtic(Artic artic) {
		Map<String, Object> result = new HashMap<>();
		try {
			artic.setClickNum(0);
			articDaoMapper.save(artic);
			result.put("code", "0000");
			result.put("codeDesc", "保存成功");
		} catch (Exception e) {
			logger.error("保存文章出错了");
			logger.error(e.getMessage());
			result.put("code", "0001");
			result.put("codeDesc", "保存失败");
		}
		return result;
	}

	public Map<String, Object> updateArtic(Artic artic) {
		Map<String, Object> result = new HashMap<>();
		try {
			articDaoMapper.update(artic);
			result.put("code", "0000");
			result.put("codeDesc", "修改成功");
		} catch (Exception e) {
			logger.error("修改文章出错了");
			logger.error(e.getMessage());
			result.put("code", "0001");
			result.put("codeDesc", "修改失败");
		}
		return result;
	}

	public Map<String, Object> getArticObject(Integer id) {
		Map<String, Object> result = new HashMap<>();
		try {
			result.put("data",articDaoMapper.findObject(id));
			result.put("code", "0000");
			result.put("codeDesc", "查询成功");
		} catch (Exception e) {
			logger.error("查询出错了");
			logger.error(e.getMessage());
			result.put("code", "0001");
			result.put("codeDesc", "查询失败");
		}
		return null;
	}

	public Map<String, Object> getArticList(Integer currentPage, Integer pageSize) {
		Map<String, Object> result = new HashMap<>();
		try {
			
			//查询总个数
			int total = articDaoMapper.getArticListCount();
			result.put("code", "0000");
			result.put("codeDesc", "查询成功");
			result.put("page", total);
			if(total>0) {
				int startIn = (currentPage-1)*pageSize;
				
				List<Artic> data = articDaoMapper.getArticList(startIn,pageSize);
				if(data!=null && !data.isEmpty())
					result.put("data", data);
			}
			
			
		}catch (Exception e) {
			logger.error("查询列表出错了");
			logger.error(e.getMessage());
			result.put("code", "0001");
			result.put("codeDesc", "查询失败");
		}
		return null;
	}
	
	
	public List<Artic> getArticListData(Integer currentPage, Integer pageSize) {
		List<Artic> data = new ArrayList<>();
		try {
			int startIn = (currentPage-1)*pageSize;
			 data = articDaoMapper.getArticList(startIn,pageSize);
			 if(data.size()>0) {
				 for(Artic artic:data) {
					 artic.setNumber(++startIn);
				 }
			 }
			
			
		}catch (Exception e) {
			logger.error("查询列表出错了");
			logger.error(e.getMessage());
		}
		return data;
	}

}

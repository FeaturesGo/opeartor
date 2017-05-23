package com.www.opeartor.action;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.www.opeartor.entity.Material;
import com.www.opeartor.etc.Env;
import com.www.opeartor.serviceImpl.MaterialServiceImpl;
import com.www.opeartor.utils.DateUtil;

/***
 * 素材管理
 * @author wangweiwei
 *
 */
@Controller
public class MaterialAction {
	
	private static Logger logger = LogManager.getLogger(MaterialAction.class);
	
	@Autowired
	private Env en;
	@Autowired
	private MaterialServiceImpl materialServiceImpl;
	
	@RequestMapping("material/imgList")
	public Object imgList(Model model) {
		List<Material> data = materialServiceImpl.getMaterialList();
		if(data!=null && !data.isEmpty()) {
			for(Material temp:data) {
				String imgUrl = (String) temp.getImgUrl();
				imgUrl = en.getKey("imgHttpUrl")+File.separator +imgUrl;
				temp.setImgUrl(imgUrl);
			}
		}
		model.addAttribute("data", data);
		return "material/imgList";
	}

	@RequestMapping("material/imgadd")
	public Object imgadd() {
		return "material/imgadd";
	}
	
	
	@ResponseBody
	@RequestMapping("material/upload")
	public Object upload(@RequestParam(value = "uploadfile", required = false) MultipartFile file) {
		String fileName = file.getOriginalFilename();
		logger.info("文件名字：{}",fileName);
		Map<String,Object> result = new HashMap<>();
		try {
			String chushipath = en.getKey("materialDir");
			String dir = DateUtil.getNowFormat();
			String filena = UUID.randomUUID().toString().replaceAll("-", "")+".jpg";
			File targetFile = new File(chushipath+File.separator+dir, filena);  
	        if(!targetFile.exists()){  
	            targetFile.mkdirs();  
	        }  
	        file.transferTo(targetFile);
	        materialServiceImpl.saveMaterial(dir+File.separator+filena);
	        result.put("code", "0000");
			result.put("codeDesc", "文件上传成功");
			result.put("data", en.getKey("imgHttpUrl")+File.separator+dir+File.separator+filena);
		} catch (IOException e) {
			logger.error("文件上传报错了");
			logger.error(e.getMessage());
			result.put("code", "0001");
			result.put("codeDesc", "文件上传失败");
		}
		
		return result;
	}
}

package com.www.opeartor.entity;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.www.opeartor.core.annotate.CustomTable;
import com.www.opeartor.core.annotate.CustomTranslate;
import com.www.opeartor.core.entity.CommonEntity;

/**
 * 图片
 * @author hwg
 */
@CustomTable(tableName="op_bd_image")
public class Material extends CommonEntity{
	
	@CustomTranslate
	private Integer id;
	
	private String imgUrl;
	
	private String createTime;
	
	private String updateTime;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public String getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}
	
	public Material() {
	}

	public Material(String imgUrl) {
		this.imgUrl = imgUrl;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
	}
	
	
	
	

}

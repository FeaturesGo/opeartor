package com.www.opeartor.entity;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.www.opeartor.core.annotate.CustomTable;
import com.www.opeartor.core.entity.CommonEntity;

/***
 * 联系我们的提交表单
 * @author wangweiwei
 *
 */
@CustomTable(tableName="op_tourist")
public class Tourist extends CommonEntity{

	private Integer id;
	
	private String touristName;
	
	private String touristEmail;
	
	private String touristPhone;
	
	private String touristNeed;
	
	private Integer touristNeedFlag;
	
	private String createTime;
	
	private String updateTime;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTouristName() {
		return touristName;
	}

	public void setTouristName(String touristName) {
		this.touristName = touristName;
	}

	public String getTouristEmail() {
		return touristEmail;
	}

	public void setTouristEmail(String touristEmail) {
		this.touristEmail = touristEmail;
	}

	public String getTouristPhone() {
		return touristPhone;
	}

	public void setTouristPhone(String touristPhone) {
		this.touristPhone = touristPhone;
	}

	
	public Integer getTouristNeedFlag() {
		return touristNeedFlag;
	}

	public void setTouristNeedFlag(Integer touristNeedFlag) {
		this.touristNeedFlag = touristNeedFlag;
	}

	public String getTouristNeed() {
		return touristNeed;
	}

	public void setTouristNeed(String touristNeed) {
		this.touristNeed = touristNeed;
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
	
	
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
	}
}

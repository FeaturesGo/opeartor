package com.www.opeartor.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.www.opeartor.entity.Operator;

@Repository
public interface LoginDaoMapper {

	Operator getUser(@Param(value="userName") String userName);

}

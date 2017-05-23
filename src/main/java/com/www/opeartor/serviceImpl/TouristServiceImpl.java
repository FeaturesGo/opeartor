package com.www.opeartor.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.www.opeartor.dao.TouristDaoMapper;
import com.www.opeartor.entity.Tourist;

@Service
public class TouristServiceImpl {
	
	@Autowired
	private TouristDaoMapper touristDao;

	public void saveTourist(Tourist tourist) {
		tourist.setTouristNeedFlag(1);
		touristDao.save(tourist);
	}

}

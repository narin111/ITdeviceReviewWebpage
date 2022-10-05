package com.review.myapp;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReviewServiceImpl implements ReviewService {
	@Autowired
	 ReviewDao reviewDao;

	@Override
	public String create(Map<String, Object> map) {
	    int affectRowCount = this.reviewDao.insert(map);
	    if (affectRowCount ==  1) {
	        return map.get("review_id").toString();
	    }
	    return null;

	}
}

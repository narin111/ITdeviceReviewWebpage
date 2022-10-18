package com.review.myapp;

import java.util.Map;

public interface ReviewService {

	String create(Map<String, Object> map);

	Map<String, Object> detail(Map<String, Object> map);
	

}

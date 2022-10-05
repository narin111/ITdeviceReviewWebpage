package com.review.myapp;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class InfoController {
	
	@Autowired
	ReviewService reviewService;
	
	@RequestMapping(value="/create", method = RequestMethod.GET)
	public ModelAndView create() {
	    return new ModelAndView("review/create");
	}
	
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public ModelAndView createPost(@RequestParam Map<String, Object> map) {
	    ModelAndView mav = new ModelAndView();

	    String reviewID = this.reviewService.create(map);
	    if (reviewID == null) {
	        mav.setViewName("redirect:/create");
	    }else {
	        mav.setViewName("redirect:/detail?reviewID=" + reviewID); 
	    }  

	    return mav;
	}
}

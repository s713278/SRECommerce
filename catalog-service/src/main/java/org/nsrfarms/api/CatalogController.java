package org.nsrfarms.api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/catalog")
public class CatalogController {
	private Logger LOGGER= LoggerFactory.getLogger(this.getClass());

	@GetMapping("getById/{id}")
	@ResponseBody 
	public String getCatalogInfo(@PathVariable String id) {
		return "Hey !! I am Catalog Service and Provide you Catalog Information from " + id;
	}
	
	@GetMapping("/wish")
	@ResponseBody
	public String wish(@RequestParam String name) {
		return "Hi "+name;
	}
	
	@GetMapping("/add/{a}/{b}")
	@ResponseBody
	public Integer sum(@PathVariable Integer a,@PathVariable Integer b) {
		LOGGER.info(" Number#1: {a}, Number#2: {b}",a,b);
		return  a+b;
	}
}

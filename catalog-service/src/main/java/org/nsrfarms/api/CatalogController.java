package org.nsrfarms.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/catalog")
public class CatalogController {

	@GetMapping("getById/{id}")
	@ResponseBody 
	public String getCatalogInfo(@PathVariable String id) {
		return "Hey !! I am Catalog Service and Provide you Catalog Information from " + id;
	}
	
}

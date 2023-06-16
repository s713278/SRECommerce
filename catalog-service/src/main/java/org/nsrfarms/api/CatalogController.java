package org.nsrfarms.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController("/catalog")
public class CatalogController {

	@GetMapping(value= {"/"})
	@ResponseBody String getCatalogInfo(@PathVariable(required = false) String name) {
		return "Hey !! I am Catalog Service and Provide you Catalog Information from " + name;
	}
}

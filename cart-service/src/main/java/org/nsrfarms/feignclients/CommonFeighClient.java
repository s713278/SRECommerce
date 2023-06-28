package org.nsrfarms.feignclients;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

//@FeignClient(value="api-gateway")
public interface CommonFeighClient {

	
	@GetMapping("catalog-service/catalog/wish")
	public String wish(@RequestParam String name);
}


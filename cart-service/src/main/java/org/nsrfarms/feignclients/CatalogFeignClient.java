package org.nsrfarms.feignclients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Service
@FeignClient(url="${catalog.service.url}" ,name="catalog-feign-client")
public interface CatalogFeignClient {

	@GetMapping(value= {"/"})
	@ResponseBody 
	public String getCatalogInfo(@PathVariable(required = false) String name);
}

package org.nsrfarms.feignclients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Service
@FeignClient(url="${catalog.service.url}" ,name="catalog-feign-client" ,path="/catalog")
public interface CatalogFeignClient {

	
	
	@GetMapping("/getById/{id}")
	public String getCatalogInfo(@PathVariable String id);
}

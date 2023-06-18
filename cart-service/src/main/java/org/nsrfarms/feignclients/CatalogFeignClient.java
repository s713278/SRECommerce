package org.nsrfarms.feignclients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Service
@FeignClient(url="${catalog.service.url}" ,name="catalog-feign-client" ,path="/catalog")
public interface CatalogFeignClient {

	
	@GetMapping("/wish")
	public String wish(@RequestParam String name);
}

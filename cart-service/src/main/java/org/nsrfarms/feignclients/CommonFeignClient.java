package org.nsrfarms.feignclients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * <p>This is demonstration of calling catalog microservice from cart-service with api-gateway
 * @author Kuntaswa
 *
 */
@FeignClient(value="api-gateway")
public interface CommonFeignClient {
	
	@GetMapping("/catalog-service/catalog/add/{a}/{b}")
	public Integer sum(@PathVariable Integer a,@PathVariable Integer b);
}

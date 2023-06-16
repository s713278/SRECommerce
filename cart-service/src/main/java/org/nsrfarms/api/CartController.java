package org.nsrfarms.api;

import org.nsrfarms.feignclients.CatalogFeignClient;
import org.nsrfarms.vo.CartItemVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController("/cart")
public class CartController {

	@Autowired
	private CatalogFeignClient catalogFeignClient;

	@GetMapping("/feign/{name}")
	@ResponseBody
	String sayHi(@PathVariable(required = false) String name) {
		return catalogFeignClient.getCatalogInfo(name);
	}

	@PostMapping("/create")
	public void addItemToOrder(@RequestBody CartItemVO cartItem) {

	}

	@PostMapping("/update")
	public void updateItemToOrder(@RequestBody CartItemVO cartItem) {

	}
}

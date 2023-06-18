package org.nsrfarms.api;

import org.nsrfarms.feignclients.CatalogFeignClient;
import org.nsrfarms.vo.CartItemVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cart")
public class CartController {

	@Autowired
	private CatalogFeignClient catalogFeignClient;

	
	
	@GetMapping("/wish")
	@ResponseBody
	public String wish(@RequestParam String name) {
		return catalogFeignClient.wish(name);
	}

	@PostMapping("/create")
	public void addItemToOrder(@RequestBody CartItemVO cartItem) {

	}

	@PostMapping("/update")
	public void updateItemToOrder(@RequestBody CartItemVO cartItem) {

	}
}

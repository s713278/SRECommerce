package org.nsrfarms.api;

import org.nsrfarms.feignclients.CatalogFeignClient;
import org.nsrfarms.service.CartItemService;
import org.nsrfarms.vo.CartItemVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cart")
public class CartController {

	private Logger LOGGER= LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private CatalogFeignClient catalogFeignClient;

	@Autowired
	private CartItemService cartItemService;
	
	@GetMapping("/wish")
	@ResponseBody
	public String wish(@RequestParam String name) {
		return catalogFeignClient.wish(name);
	}
	
	@GetMapping("/add/{a}/{b}")
	@ResponseBody
	public Integer add(@PathVariable Integer a,@PathVariable Integer b) {
		LOGGER.info(" Number#1: {a}, Number#2: {b}",a,b);
		return cartItemService.sum(a,b);
	}

	@PostMapping("/create")
	public void addItemToOrder(@RequestBody CartItemVO cartItem) {

	}

	@PostMapping("/update")
	public void updateItemToOrder(@RequestBody CartItemVO cartItem) {

	}
}

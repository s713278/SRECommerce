package org.nsrfarms.api;

import java.util.ArrayList;

import org.nsrfarms.feignclients.CatalogFeignClient;
import org.nsrfarms.service.CartItemService;
import org.nsrfarms.vo.CartItemVO;
import org.nsrfarms.vo.OrderVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

	private Logger LOGGER = LoggerFactory.getLogger(this.getClass());

	@Autowired
	OrderVO shoppingCart;

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
	public Integer add(@PathVariable Integer a, @PathVariable Integer b) {
		LOGGER.info(" Number#1: {a}, Number#2: {b}", a, b);
		return cartItemService.sum(a, b);
	}

	@PostMapping("/create")
	public void addItemToOrder(@RequestBody CartItemVO cartItem) {
		shoppingCart.setId(123456L);
		if (shoppingCart.getCartItems() == null) {
			shoppingCart.setCartItems(new ArrayList<CartItemVO>());
		}
		cartItem.setItemListAmount(cartItem.getQuanity() * 25D);
		cartItem.setItemSaleAmount(cartItem.getQuanity() * 22D);
		cartItem.setDiscountAmount(cartItem.getItemListAmount() - cartItem.getItemSaleAmount());
		shoppingCart.getCartItems().add(cartItem);
	}

	@GetMapping("/getOrder/{orderId}")
	@ResponseBody
	public ResponseEntity<OrderVO> getOrder(@PathVariable Long orderId) {
		return new ResponseEntity<OrderVO>(shoppingCart, HttpStatus.OK);
	}

	@PostMapping("/update")
	public void updateItemToOrder(@RequestBody CartItemVO cartItem) {

	}
}

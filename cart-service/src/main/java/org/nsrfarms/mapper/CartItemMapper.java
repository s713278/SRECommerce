package org.nsrfarms.mapper;

import org.nsrfarms.entity.CartItem;
import org.nsrfarms.vo.CartItemVO;
import org.springframework.stereotype.Service;

@Service
public class CartItemMapper {

	public CartItem toEntity(CartItemVO cartItemVO) {

		return new CartItem(cartItemVO);
	}

	public CartItemVO toEntity(CartItem cartItem) {

		return new CartItemVO(cartItem);
	}
}

package org.nsrfarms.service;

import org.nsrfarms.vo.CartItemVO;

public interface CartItemService {

	public void addItem(CartItemVO cartItemVO);
	public void updateItem(CartItemVO cartItemVO);
	public void removeItem(CartItemVO cartItemVO);
}

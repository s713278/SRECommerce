package org.nsrfarms.service;

import org.nsrfarms.mapper.CartItemMapper;
import org.nsrfarms.vo.CartItemVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartItemServiceImpl implements CartItemService {

	@Autowired
	private CartItemMapper cartItemMapper;

	@Override
	public void addItem(CartItemVO cartItemVO) {

	}

	@Override
	public void updateItem(CartItemVO cartItemVO) {

	}

	@Override
	public void removeItem(CartItemVO cartItemVO) {

	}

}

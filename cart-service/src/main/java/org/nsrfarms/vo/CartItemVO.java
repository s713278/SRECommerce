package org.nsrfarms.vo;

import java.time.Instant;

import org.nsrfarms.entity.CartItem;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Data
@ToString
@Getter
@Setter
public class CartItemVO {
	public CartItemVO(CartItem cartItem) {
		this.id=cartItem.getId();
		this.productId = cartItem.getProductId();
		this.skuId = cartItem.getSkuId();
		this.quanity = cartItem.getQuanity();
	}
	private Long orderId;
	
	@JsonIgnore
	private Long id;
	private Long productId;
	private Long skuId;
	private Integer quanity;
	private Instant cartCreatedTimeStamp;
	private Instant orderTimeStamp;
}

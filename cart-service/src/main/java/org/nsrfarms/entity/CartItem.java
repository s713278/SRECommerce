package org.nsrfarms.entity;

import java.time.Instant;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.nsrfarms.vo.CartItemVO;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
@Entity
public class CartItem {
	public CartItem(CartItemVO cartItemVO) {
		this.id=cartItemVO.getId();
		this.productId = cartItemVO.getProductId();
		this.skuId = cartItemVO.getSkuId();
		this.quanity = cartItemVO.getQuanity();
	}
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private Long productId;
	private Long skuId;
	private Integer quanity;
	private Instant cartCreatedTimeStamp;
	private Instant orderTimeStamp;
}

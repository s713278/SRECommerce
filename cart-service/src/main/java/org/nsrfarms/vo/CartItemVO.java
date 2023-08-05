package org.nsrfarms.vo;

import java.io.Serializable;
import java.time.Instant;

import org.nsrfarms.entity.CartItem;
import org.springframework.data.annotation.CreatedDate;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Data
@ToString
@Getter
@Setter
@NoArgsConstructor
public class CartItemVO implements Serializable {
	
	
	public CartItemVO(CartItem cartItem) {
		this.id = cartItem.getId();
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

	@JsonIgnore
	@CreatedDate
	private Instant cartCreatedTimeStamp;
	
	private Double itemListAmount;
	
	private Double itemSaleAmount;
	
	private Double discountAmount;
	
}

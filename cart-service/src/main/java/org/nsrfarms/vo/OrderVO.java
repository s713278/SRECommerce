package org.nsrfarms.vo;

import java.time.Instant;
import java.util.List;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Component
@Data
@ToString
@NoArgsConstructor
public class OrderVO {
	private Long id;
	
	private Integer quanity;
	
	private Instant cartCreatedTimeStamp;
	
	private Instant orderedTimeStamp;
	
	private List<CartItemVO> cartItems;
	
	@JsonIgnore
	private Double orderTotalAmount;
	
	@JsonIgnore
	private Double orderDiscount;
	
	@JsonIgnore
	private Double orderAmount;
	
	@JsonIgnore
	private Double shippingAmount;
}

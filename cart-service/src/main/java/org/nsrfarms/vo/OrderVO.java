package org.nsrfarms.vo;

import java.time.Instant;
import java.util.List;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
public class OrderVO {
	private Long id;
	
	private Integer quanity;
	
	private Instant cartCreatedTimeStamp;
	
	private Instant orderedTimeStamp;
	
	private List<CartItemVO> cartItems;
}

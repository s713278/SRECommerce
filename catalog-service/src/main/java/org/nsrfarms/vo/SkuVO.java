package org.nsrfarms.vo;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class SkuVO {
	private Long id;
	private String name;
	private String description;
	private Double listPrice;
	private Double salePrice;
	private Double wholesalePrice;

}

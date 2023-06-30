package org.nsrfarms.vo;

import java.util.List;

import org.nsrfarms.entity.Sku;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class ProductVO {
	private Long id;
	private String name;
	private String description;
	private List<Sku> skus;

}

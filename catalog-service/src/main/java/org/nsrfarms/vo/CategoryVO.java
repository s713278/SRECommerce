package org.nsrfarms.vo;

import java.util.List;

import org.nsrfarms.entity.Product;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
public class CategoryVO {
	private Long id;
	private String name;
	private String description;
	private List<Product> products;
}

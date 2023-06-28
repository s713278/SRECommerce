package org.nsrfarms.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.wildfly.common.annotation.NotNull;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
@Entity
public class Sku {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@NotNull
	private String name;

	private String description;
	private Double listPrice;
	private Double salePrice;
	private Double wholesalePrice;
}

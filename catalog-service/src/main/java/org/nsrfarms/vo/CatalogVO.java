package org.nsrfarms.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.ToString;

@Schema(description = "Catalog Model Inforamtion")
@Data
@ToString
public class CatalogVO {
	private Long id;
	
	@Schema(description = "Catalog Name")
	private String name;
	
	@Schema(description = "Catalog Description")
	private String description;

}

package org.nsrfarms.mapper;

import org.nsrfarms.entity.Catalog;
import org.nsrfarms.entity.Category;
import org.nsrfarms.entity.Product;
import org.nsrfarms.entity.Sku;
import org.nsrfarms.vo.CatalogVO;
import org.nsrfarms.vo.CategoryVO;
import org.nsrfarms.vo.ProductVO;
import org.nsrfarms.vo.SkuVO;

//@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CatalogMapper {

	CatalogVO toVO(Catalog catalog);

	CategoryVO toVO(Category category);

	ProductVO toVO(Product product);

	SkuVO toVO(Sku sku);

	// @Mapping(target = "id", ignore = true)
	Catalog toEntity(CatalogVO catalogVO);

	// @Mapping(target = "id", ignore = true)
	Category toEntity(CategoryVO categoryVO);

	// @Mapping(target = "id", ignore = true)
	Product toEntity(ProductVO productVO);

	// @Mapping(target = "id", ignore = true)
	Sku toEntity(SkuVO skuVO);
}
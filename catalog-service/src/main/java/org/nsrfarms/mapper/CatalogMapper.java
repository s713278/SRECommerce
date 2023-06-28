package org.nsrfarms.mapper;

import java.util.Optional;

import org.mapstruct.Mapper;
import org.nsrfarms.entity.Catalog;
import org.nsrfarms.entity.Category;
import org.nsrfarms.vo.CatalogVO;
import org.nsrfarms.vo.CategoryVO;

@Mapper(componentModel = "spring")
public interface CatalogMapper {
	CatalogVO catalogTocatalogVO(Optional<Catalog> optional);

	Catalog catalogVOTocatalog(CatalogVO catalogVO);

	CategoryVO categoryTocategoryVO(Catalog category);

	Category categoryVOTocategory(CategoryVO categoryVO);
}
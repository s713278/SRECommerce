/**
 * 
 */
package org.nsrfarms.service;

import org.nsrfarms.entity.Product;
import org.nsrfarms.vo.CatalogVO;
import org.nsrfarms.vo.CategoryVO;
import org.nsrfarms.vo.ProductVO;
import org.nsrfarms.vo.SkuVO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * @author Kuntaswa
 *
 */
public interface CatalogService {

	CatalogVO getCatalog(Long id);

	CategoryVO getCategory(Long id);

	ProductVO getProduct(Long id);

	SkuVO getSku(Long id);
	
	Page<Product> getAllProducts(Pageable pageable);
}

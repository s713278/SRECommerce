/**
 * 
 */
package org.nsrfarms.service;

import org.nsrfarms.vo.CatalogVO;
import org.nsrfarms.vo.CategoryVO;
import org.nsrfarms.vo.ProductVO;
import org.nsrfarms.vo.SkuVO;

/**
 * @author Kuntaswa
 *
 */
public interface CatalogService {

	CatalogVO getCatalog(Long id);

	CategoryVO getCategory(Long id);

	ProductVO getProduct(Long id);

	SkuVO getSku(Long id);
}

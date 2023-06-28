/**
 * 
 */
package org.nsrfarms.service;

import org.nsrfarms.mapper.CatalogMapper;
import org.nsrfarms.repository.CatalogRepository;
import org.nsrfarms.vo.CatalogVO;
import org.nsrfarms.vo.CategoryVO;
import org.nsrfarms.vo.ProductVO;
import org.nsrfarms.vo.SkuVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Kuntaswa
 *
 */
@Service
public class CatalogServiceImpl implements CatalogService {

	/**
	 * 
	 */
	@Autowired
	private CatalogRepository catalogRepository;
	
	@Autowired
	CatalogMapper catalogMapper;
	
	public CatalogServiceImpl() {
		// TODO Auto-generated constructor stub
	}

	public CatalogVO getCatalog(Long id) {
		return catalogMapper.catalogTocatalogVO(catalogRepository.findById(id));
	}

	public CategoryVO getCategory(Long id) {
		return null;
	}

	public ProductVO getProduct(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	public SkuVO getSku(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

}

/**
 * 
 */
package org.nsrfarms.service;

import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.nsrfarms.entity.Catalog;
import org.nsrfarms.entity.Category;
import org.nsrfarms.entity.Product;
import org.nsrfarms.entity.Sku;
import org.nsrfarms.mapper.CatalogMapper;
import org.nsrfarms.repository.CatalogRepository;
import org.nsrfarms.repository.CategoryRepository;
import org.nsrfarms.repository.ProductRepository;
import org.nsrfarms.repository.SkuRepository;
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
	private CategoryRepository categoryRepository;
	
	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private SkuRepository skuRepository;

	@Autowired
	private CatalogMapper catalogMapper;

	public CatalogServiceImpl() {
	}

	public CatalogVO getCatalog(Long id) {
		CatalogVO catalogVO = new CatalogVO();
		Optional<Catalog> optional = catalogRepository.findById(id);
		if (optional.isPresent()) {
			catalogVO = catalogMapper.toVO(optional.get());
		}
		return catalogVO;
	}

	public CategoryVO getCategory(Long id) {
		CategoryVO categoryVO = new CategoryVO();
		Optional<Category> optional = categoryRepository.findById(id);
		if (optional.isPresent()) {
			categoryVO = catalogMapper.toVO(optional.get());
		}
		return categoryVO;
	}

	public ProductVO getProduct(Long id) {
		Product product = productRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Product not found"));
		return catalogMapper.toVO(product);
	}

	public SkuVO getSku(Long id) {
		Sku sku = skuRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Sku not found"));
		return catalogMapper.toVO(sku);
	}

}

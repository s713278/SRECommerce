/**
 * 
 */
package org.nsrfarms.service;

import java.util.Optional;

import org.nsrfarms.entity.Catalog;
import org.nsrfarms.entity.Category;
import org.nsrfarms.entity.Product;
import org.nsrfarms.entity.Sku;
import org.nsrfarms.exception.InvalidPriceException;
import org.nsrfarms.exception.ResourceNotFoundException;
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
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import jakarta.persistence.EntityNotFoundException;

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

	@Transactional(readOnly=true)
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
		Sku sku = skuRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Sku not found"));
		return catalogMapper.toVO(sku);
	}
	
	/**
	 * 
	 * @param skuVO
	 * @return
	 */
	public SkuVO createCatalog(SkuVO skuVO ) {
		if(skuVO.getListPrice() <=0 || skuVO.getListPrice() >10000) {
			throw new InvalidPriceException("Item price should be greate than 0 and lesser than 10000");
		}
		Sku sku = catalogMapper.toEntity(skuVO);
		sku = skuRepository.save(sku);
		return catalogMapper.toVO(sku);
	}
	
	@Override
	public Page<Product> getAllProducts(Pageable pageable) {
		 Page<Product> products = productRepository.findAll(pageable);
	return products;
	}
}

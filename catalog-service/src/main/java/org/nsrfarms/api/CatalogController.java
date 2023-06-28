package org.nsrfarms.api;

import org.nsrfarms.service.CatalogService;
import org.nsrfarms.vo.CatalogVO;
import org.nsrfarms.vo.CategoryVO;
import org.nsrfarms.vo.ProductVO;
import org.nsrfarms.vo.SkuVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/catalog")
public class CatalogController {
	private Logger LOGGER= LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private CatalogService catalogService;
	
	@GetMapping("/{id}")
	@ResponseBody 
	public CatalogVO getCatalog(@PathVariable Long id) {
		return catalogService.getCatalog(id);
	}
	
	@GetMapping("category/{id}")
	@ResponseBody 
	public CategoryVO getCategory(@PathVariable Long id) {
		return catalogService.getCategory(id);
	}
	
	@GetMapping("product/{id}")
	@ResponseBody 
	public ProductVO getProduct(@PathVariable Long id) {
		return catalogService.getProduct(id);
	}
	
	
	@GetMapping("sku/{id}")
	@ResponseBody 
	public SkuVO getSku(@PathVariable Long id) {
		return catalogService.getSku(id);
	}

	@GetMapping("getById/{id}")
	@ResponseBody 
	public String getCatalogInfo(@PathVariable String id) {
		return "Hey !! I am Catalog Service and Provide you Catalog Information from " + id;
	}
	
	@GetMapping("/wish")
	@ResponseBody
	public String wish(@RequestParam String name) {
		return "Hi "+name;
	}
	
	/**
	 * <p>URL:  http://localhost:8082/catalog/add/123/123</p>
	 * <p>API Gateway URL : http://localhost:9090/catalog-service/catalog/add/11/11 </p>
	 * @param a
	 * @param b
	 * @return
	 */
	@GetMapping("/add/{a}/{b}")
	@ResponseBody
	public Integer sum(@PathVariable Integer a,@PathVariable Integer b) {
		LOGGER.info(" Number#1: {a}, Number#2: {b}",a,b);
		return  a+b;
	}
}

package org.nsrfarms.api;

import java.time.LocalDateTime;
import java.util.List;

import org.nsrfarms.entity.Product;
import org.nsrfarms.exception.ErrorDetails;
import org.nsrfarms.exception.ResourceNotFoundException;
import org.nsrfarms.service.CatalogService;
import org.nsrfarms.vo.CatalogVO;
import org.nsrfarms.vo.CategoryVO;
import org.nsrfarms.vo.ProductVO;
import org.nsrfarms.vo.SkuVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.context.request.WebRequest;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.Data;

@Tag(name = "Catalog Cotroller")

@RestController
@RequestMapping("/catalog")
public class CatalogController {
	private Logger LOGGER = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private CatalogService catalogService;

	/**
	 * <p>
	 * URL: http://localhost:8082/catalog/123
	 * </p>
	 * <p>
	 * API Gateway URL : http://localhost:9090/catalog-service/catalog/11
	 * </p>
	 * 
	 * @param id
	 * @return
	 */
	@Operation(summary = "Get Catalog REST API")
	@ApiResponse(responseCode = "200", description = "Catalog if fetched from database")
	@GetMapping("/{id}")
	@ResponseBody
	public ResponseEntity<CatalogVO> getCatalog(@PathVariable Long id) {
		return new ResponseEntity<CatalogVO>(catalogService.getCatalog(id), HttpStatus.OK);
	}

	/**
	 * <p>
	 * URL: http://localhost:8082/catalog/category/123
	 * </p>
	 * <p>
	 * API Gateway URL : http://localhost:9090/catalog-service/category/category/11
	 * </p>
	 * 
	 * @param id
	 * @return
	 */
	@GetMapping("category/{id}")
	@ResponseBody
	public CategoryVO getCategory(@PathVariable Long id) {
		return catalogService.getCategory(id);
	}

	/**
	 * <p>
	 * URL: http://localhost:8082/catalog/product/123
	 * </p>
	 * <p>
	 * API Gateway URL : http://localhost:9090/catalog-service/category/product/11
	 * </p>
	 * 
	 * @param id
	 * @return
	 */
	@GetMapping("product/{id}")
	@ResponseBody
	public ProductVO getProduct(@PathVariable Long id) {
		return catalogService.getProduct(id);
	}

	/**
	 * <p>
	 * URL: http://localhost:8082/catalog/sku/123
	 * </p>
	 * <p>
	 * API Gateway URL : http://localhost:9090/catalog-service/category/sku/11
	 * </p>
	 * 
	 * @param id
	 * @return
	 */
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
		return "Hi " + name;
	}

	/**
	 * <p>
	 * URL: http://localhost:8082/catalog/add/123/123
	 * </p>
	 * <p>
	 * API Gateway URL : http://localhost:9090/catalog-service/catalog/add/11/11
	 * </p>
	 * 
	 * @param a
	 * @param b
	 * @return
	 */
	@GetMapping("/add/{a}/{b}")
	@ResponseBody
	public Integer sum(@PathVariable Integer a, @PathVariable Integer b) {
		LOGGER.info(" Number#1: {a}, Number#2: {b}", a, b);
		return a + b;
	}

	@GetMapping("/products")
	@ResponseBody
	public Page<Product> getProducts(@RequestParam(defaultValue = "0") int page,
			@RequestParam(defaultValue = "10") int size, @RequestParam(defaultValue = "name") String sortBy) {
		Pageable pageable = PageRequest.of(page, size, Sort.by(sortBy));
		return catalogService.getAllProducts(pageable);
	}

	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<ErrorDetails> handleResourceNotFoundException(WebRequest request,
			ResourceNotFoundException exception) {
		ErrorDetails details = new ErrorDetails(LocalDateTime.now(), exception.getMessage(),
				request.getDescription(false), "ITEM_NOT_FOUND");
		ResponseEntity<ErrorDetails> re = new ResponseEntity<ErrorDetails>(details, HttpStatus.NOT_FOUND);
		return re;
	}

	@Autowired
	private RestTemplate restTemplate;

	@PostMapping("/add")
	@ResponseBody
	public Output postExample() {
		String apiUrl = "http://localhost:9090/cart-service/math/add";
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		Input input = new Input();
		input.setA(10);
		input.setB(25);
		HttpEntity<Input> requestEntity = new HttpEntity<>(input, headers);
		return restTemplate.postForObject(apiUrl, requestEntity, Output.class);
	}

	@GetMapping("/get")
	@ResponseBody
	public List<Integer> getExample() {
		String uri = "http://localhost:9090/cart-service/math/get/3";
		ResponseEntity<List<Integer>> result = restTemplate.getForObject(uri, ResponseEntity.class);
		return result.getBody();
	}

	@Data
	class Input {
		int a;
		int b;

	}

	@Data
	class Output {
		public Output(int i) {
			this.result = i;
		}

		int result;

	}
}

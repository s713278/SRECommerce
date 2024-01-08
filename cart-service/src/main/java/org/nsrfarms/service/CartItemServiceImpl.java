package org.nsrfarms.service;

import org.nsrfarms.feignclients.CommonFeignClient;
import org.nsrfarms.mapper.CartItemMapper;
import org.nsrfarms.vo.CartItemVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@Service
public class CartItemServiceImpl implements CartItemService {
	
	private Logger LOGGER= LoggerFactory.getLogger(this.getClass());
	
	private int count  =1;

	@Autowired
	private CartItemMapper cartItemMapper;
	
	@Autowired
	private CommonFeignClient commonFeignClient;

	
	/**
	 * <p>
	 * This is demonstration of circuit breaker design pattern
	 * </p>
	 */
	@CircuitBreaker(name="catalogService",fallbackMethod = "fallbackGetSum")
	public Integer sum(Integer a, Integer b) {
		LOGGER.info("Count ::"+count);
		count++;
		return commonFeignClient.sum(a, b);
	}
	
	public Integer fallbackGetSum(Integer a, Integer b,Throwable th) {
		LOGGER.error("Throwable ::"+th);
		return 0;
	}

	public void addItem(CartItemVO cartItemVO) {
		
	}

	public void updateItem(CartItemVO cartItemVO) {
		// TODO Auto-generated method stub
		
	}

	public void removeItem(CartItemVO cartItemVO) {
		// TODO Auto-generated method stub
		
	}

}

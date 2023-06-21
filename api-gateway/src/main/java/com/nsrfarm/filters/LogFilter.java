package com.nsrfarm.filters;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.web.server.ServerWebExchange;

import reactor.core.publisher.Mono;

public class LogFilter implements GlobalFilter {
	
	private Logger LOGGER= LoggerFactory.getLogger(this.getClass());

	@Override
	public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
		ServerHttpRequest httpRequest =  exchange.getRequest();
		LOGGER.info("Pre Logging :"+httpRequest.getQueryParams());
		return chain.filter(exchange).then(Mono.fromRunnable(()->{
			ServerHttpResponse httpResponse = exchange.getResponse();
			LOGGER.info("Post Logging :"+httpResponse.getStatusCode());
		}));
	}

}

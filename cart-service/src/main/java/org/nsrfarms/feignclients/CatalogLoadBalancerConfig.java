package org.nsrfarms.feignclients;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
import org.springframework.context.annotation.Bean;

import feign.Feign;

@LoadBalancerClient(value="CATALOG-SERVICE")
public class CatalogLoadBalancerConfig {

	@LoadBalanced
	@Bean
	public Feign.Builder geignBuilder(){
		return Feign.builder();
	}
}

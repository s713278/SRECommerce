package org.nsrfarms.order.service.impl;

import org.nsrfarms.order.entity.repository.OrderRepository;
import org.nsrfarms.order.service.OrderService;
import org.nsrfarms.order.service.dto.OrderDTO;
import org.nsrfarms.order.service.mapper.OrderMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Service Implementation for managing
 * {@link com.mycompany.gateway.domain.Order}.
 */
@Service
@Transactional
public class OrderServiceImpl implements OrderService {

	private final Logger log = LoggerFactory.getLogger(OrderServiceImpl.class);

	private final OrderRepository orderRepository;

	private final OrderMapper orderMapper;

	public OrderServiceImpl(OrderRepository orderRepository, OrderMapper orderMapper) {
		this.orderRepository = orderRepository;
		this.orderMapper = orderMapper;
	}

	@Override
	public Mono<OrderDTO> save(OrderDTO orderDTO) {
		log.debug("Request to save Order : {}", orderDTO);
		return orderRepository.save(orderMapper.toEntity(orderDTO)).map(orderMapper::toDto);
	}

	@Override
	public Mono<OrderDTO> update(OrderDTO orderDTO) {
		log.debug("Request to update Order : {}", orderDTO);
		return orderRepository.save(orderMapper.toEntity(orderDTO)).map(orderMapper::toDto);
	}

	@Override
	public Mono<OrderDTO> partialUpdate(OrderDTO orderDTO) {
		log.debug("Request to partially update Order : {}", orderDTO);

		return orderRepository.findById(orderDTO.getId()).map(existingOrder -> {
			orderMapper.partialUpdate(existingOrder, orderDTO);

			return existingOrder;
		}).flatMap(orderRepository::save).map(orderMapper::toDto);
	}

	@Override
	@Transactional(readOnly = true)
	public Flux<OrderDTO> findAll(Pageable pageable) {
		log.debug("Request to get all Orders");
		return orderRepository.findAllBy(pageable).map(orderMapper::toDto);
	}

	public Mono<Long> countAll() {
		return orderRepository.count();
	}

	@Override
	@Transactional(readOnly = true)
	public Mono<OrderDTO> findOne(Long id) {
		log.debug("Request to get Order : {}", id);
		return orderRepository.findById(id).map(orderMapper::toDto);
	}

	@Override
	public Mono<Void> delete(Long id) {
		log.debug("Request to delete Order : {}", id);
		return orderRepository.deleteById(id);
	}
}

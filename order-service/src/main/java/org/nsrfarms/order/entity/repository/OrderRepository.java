package org.nsrfarms.order.entity.repository;

import org.nsrfarms.order.entity.Order;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Spring Data R2DBC repository for the Order entity.
 */
@SuppressWarnings("unused")
@Repository
public interface OrderRepository extends ReactiveCrudRepository<Order, Long>, OrderRepositoryInternal {
	Flux<Order> findAllBy(Pageable pageable);

	@Query("SELECT * FROM jhi_order entity WHERE entity.amount_id = :id")
	Flux<Order> findByAmount(Long id);

	@Query("SELECT * FROM jhi_order entity WHERE entity.amount_id IS NULL")
	Flux<Order> findAllWhereAmountIsNull();

	@Query("SELECT * FROM jhi_order entity WHERE entity.payment_id = :id")
	Flux<Order> findByPayment(Long id);

	@Query("SELECT * FROM jhi_order entity WHERE entity.payment_id IS NULL")
	Flux<Order> findAllWherePaymentIsNull();

	@Query("SELECT * FROM jhi_order entity WHERE entity.shiping_address_id = :id")
	Flux<Order> findByShipingAddress(Long id);

	@Query("SELECT * FROM jhi_order entity WHERE entity.shiping_address_id IS NULL")
	Flux<Order> findAllWhereShipingAddressIsNull();

	@Override
	<S extends Order> Mono<S> save(S entity);

	@Override
	Flux<Order> findAll();

	@Override
	Mono<Order> findById(Long id);

	@Override
	Mono<Void> deleteById(Long id);
}

interface OrderRepositoryInternal {
	<S extends Order> Mono<S> save(S entity);

	Flux<Order> findAllBy(Pageable pageable);

	Flux<Order> findAll();

	Mono<Order> findById(Long id);
	// this is not supported at the moment because of
	// https://github.com/jhipster/generator-jhipster/issues/18269
	// Flux<Order> findAllBy(Pageable pageable, Criteria criteria);
}

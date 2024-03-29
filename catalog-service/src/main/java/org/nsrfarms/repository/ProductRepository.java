package org.nsrfarms.repository;

import org.nsrfarms.entity.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ProductRepository extends CrudRepository<Product, Long> ,PagingAndSortingRepository<Product, Long> {
}

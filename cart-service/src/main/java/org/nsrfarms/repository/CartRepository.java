package org.nsrfarms.repository;

import org.nsrfarms.entity.CartItem;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartRepository extends CrudRepository<CartItem, Long> {

}

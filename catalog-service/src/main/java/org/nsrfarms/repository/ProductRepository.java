package org.nsrfarms.repository;

import org.nsrfarms.entity.Category;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Category, Long> {

}

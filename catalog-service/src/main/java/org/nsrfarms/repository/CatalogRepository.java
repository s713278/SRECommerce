package org.nsrfarms.repository;

import org.nsrfarms.entity.Catalog;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CatalogRepository extends CrudRepository<Catalog, Long>, PagingAndSortingRepository<Catalog, Long> {

}

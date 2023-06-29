package org.nsrfarms.repository;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.nsrfarms.entity.Catalog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
public class CatalogRepositoryTest {

	@Autowired
	private CatalogRepository catalogRepository;

	// @Test
	void testSave() {
		fail("Not yet implemented");
	}

	@Test
	void failGetCatalogItemById() {
		Optional<Catalog> catalog = catalogRepository.findById(111l);
		assertFalse(!catalog.isPresent());
	}

	@Test
	void passGetCatalogItemById() {
		Optional<Catalog> catalog = catalogRepository.findById(1l);
		assertTrue(catalog.isPresent());
	}

	// @Test
	void testCount() {
		fail("Not yet implemented");
	}

}

package org.nsrfarms.repository;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.nsrfarms.entity.Catalog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class CatalogRepositoryTest {

	@Autowired
	private CatalogRepository catalogRepository;

	//@Test
	void testSave() {
		fail("Not yet implemented");
	}

	@Test
	void failGetCatalogItemById() {
		Optional<Catalog> catalog = catalogRepository.findById(111l);
		assertNull(catalog);
	}

	//@Test
	void testCount() {
		fail("Not yet implemented");
	}

}

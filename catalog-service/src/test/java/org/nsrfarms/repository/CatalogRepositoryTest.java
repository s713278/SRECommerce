package org.nsrfarms.repository;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.nsrfarms.entity.Catalog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
public class CatalogRepositoryTest {

	private static final long NO_OF_RECORDS = 2;
	
	

	@Autowired
	private CatalogRepository catalogRepository;

	// @Test
	void testSave() {
		fail("Not yet implemented");
	}

	@Test
	void failInvalidCount() {
		long actualCount = catalogRepository.count();
		assertNotEquals(1, actualCount);
	}

	@Test 
	void passValidCount() {
		long actualCount = catalogRepository.count();
		System.out.println("actualCount \t"+actualCount);
		assertEquals(NO_OF_RECORDS, actualCount);
	}

	@Test
	void failGetCatalogItemById() {
		Optional<Catalog> catalog = catalogRepository.findById(111l);
		assertTrue(catalog.isEmpty());
	}

	@Test
	void failGetCatalogItemByNegativeId() {
		Optional<Catalog> catalog = catalogRepository.findById(-100L);
		assertTrue(catalog.isEmpty());
	}

	@Test
	void passGetCatalogItemById() {
		Optional<Catalog> catalog = catalogRepository.findById(1l);
		assertTrue(catalog.isPresent());
	}

	@Test
	void passUpdateCatalogItemById() {
		Optional<Catalog> catalog = catalogRepository.findById(1l);
		assertTrue(catalog.isPresent());
		Catalog entity = catalog.get();
		entity.setDescription("TEST DESC");
		entity = catalogRepository.save(entity);
		System.out.println("#########################################################    Aftet Updating "
				+ entity.getDescription());
		Optional<Catalog> modifiedCatalog = catalogRepository.findById(1l);
		assertEquals("TEST DESC", modifiedCatalog.get().getDescription());
	}

}

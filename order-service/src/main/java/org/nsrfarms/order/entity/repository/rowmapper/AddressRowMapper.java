package org.nsrfarms.order.entity.repository.rowmapper;

import java.util.function.BiFunction;

import org.nsrfarms.order.entity.Address;
import org.springframework.stereotype.Service;

import io.r2dbc.spi.Row;

/**
 * Converter between {@link Row} to {@link Address}, with proper type
 * conversions.
 */
@Service
public class AddressRowMapper implements BiFunction<Row, String, Address> {

	private final ColumnConverter converter;

	public AddressRowMapper(ColumnConverter converter) {
		this.converter = converter;
	}

	/**
	 * Take a {@link Row} and a column prefix, and extract all the fields.
	 * 
	 * @return the {@link Address} stored in the database.
	 */
	@Override
	public Address apply(Row row, String prefix) {
		Address entity = new Address();
		entity.setId(converter.fromRow(row, prefix + "_id", Long.class));
		entity.setStreet1(converter.fromRow(row, prefix + "_street_1", String.class));
		entity.setStreet2(converter.fromRow(row, prefix + "_street_2", String.class));
		entity.setCity(converter.fromRow(row, prefix + "_city", String.class));
		entity.setDistict(converter.fromRow(row, prefix + "_distict", String.class));
		// entity.setState(converter.fromRow(row, prefix + "_state", State.class));
		// entity.setCountry(converter.fromRow(row, prefix + "_country",
		// Country.class));
		entity.setPostalCode(converter.fromRow(row, prefix + "_postal_code", String.class));
		entity.setPhoneNumber(converter.fromRow(row, prefix + "_phone_number", String.class));
		return entity;
	}
}

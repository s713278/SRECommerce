package org.nsrfarms.order.entity.repository.rowmapper;

import java.time.LocalDate;
import java.util.function.BiFunction;

import org.nsrfarms.order.entity.Order;
import org.springframework.stereotype.Service;

import io.r2dbc.spi.Row;

/**
 * Converter between {@link Row} to {@link Order}, with proper type conversions.
 */
@Service
public class OrderRowMapper implements BiFunction<Row, String, Order> {

	private final ColumnConverter converter;

	public OrderRowMapper(ColumnConverter converter) {
		this.converter = converter;
	}

	/**
	 * Take a {@link Row} and a column prefix, and extract all the fields.
	 * 
	 * @return the {@link Order} stored in the database.
	 */
	@Override
	public Order apply(Row row, String prefix) {
		Order entity = new Order();
		entity.setId(converter.fromRow(row, prefix + "_id", Long.class));
		entity.setRequiredDate(converter.fromRow(row, prefix + "_required_date", LocalDate.class));
		entity.setBuyerId(converter.fromRow(row, prefix + "_buyer_id", String.class));
		entity.setAmountId(converter.fromRow(row, prefix + "_amount_id", Long.class));
		entity.setPaymentId(converter.fromRow(row, prefix + "_payment_id", Long.class));
		entity.setShipingAddressId(converter.fromRow(row, prefix + "_shiping_address_id", Long.class));
		return entity;
	}
}

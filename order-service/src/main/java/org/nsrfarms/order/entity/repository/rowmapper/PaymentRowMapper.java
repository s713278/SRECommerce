package org.nsrfarms.order.entity.repository.rowmapper;

import io.r2dbc.spi.Row;
import java.time.ZonedDateTime;
import java.util.function.BiFunction;

import org.nsrfarms.order.entity.Payment;
import org.nsrfarms.order.entity.enumaration.PaymentType;
import org.springframework.stereotype.Service;

/**
 * Converter between {@link Row} to {@link Payment}, with proper type conversions.
 */
@Service
public class PaymentRowMapper implements BiFunction<Row, String, Payment> {

    private final ColumnConverter converter;

    public PaymentRowMapper(ColumnConverter converter) {
        this.converter = converter;
    }

    /**
     * Take a {@link Row} and a column prefix, and extract all the fields.
     * @return the {@link Payment} stored in the database.
     */
    @Override
    public Payment apply(Row row, String prefix) {
        Payment entity = new Payment();
        entity.setId(converter.fromRow(row, prefix + "_id", Long.class));
        entity.setType(converter.fromRow(row, prefix + "_type", PaymentType.class));
        entity.setDate(converter.fromRow(row, prefix + "_date", ZonedDateTime.class));
        entity.setTransactionRef(converter.fromRow(row, prefix + "_transaction_ref", String.class));
        entity.setBillingAddressId(converter.fromRow(row, prefix + "_billing_address_id", Long.class));
        return entity;
    }
}

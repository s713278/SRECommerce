package org.nsrfarms.order.entity.repository.rowmapper;

import io.r2dbc.spi.Row;
import java.util.function.BiFunction;

import org.nsrfarms.order.entity.BillAmount;
import org.springframework.stereotype.Service;

/**
 * Converter between {@link Row} to {@link BillAmount}, with proper type conversions.
 */
@Service
public class BillAmountRowMapper implements BiFunction<Row, String, BillAmount> {

    private final ColumnConverter converter;

    public BillAmountRowMapper(ColumnConverter converter) {
        this.converter = converter;
    }

    /**
     * Take a {@link Row} and a column prefix, and extract all the fields.
     * @return the {@link BillAmount} stored in the database.
     */
    @Override
    public BillAmount apply(Row row, String prefix) {
        BillAmount entity = new BillAmount();
        entity.setId(converter.fromRow(row, prefix + "_id", Long.class));
        entity.setItemsTotal(converter.fromRow(row, prefix + "_items_total", Double.class));
        entity.setStateTax(converter.fromRow(row, prefix + "_state_tax", Double.class));
        entity.setCentralTax(converter.fromRow(row, prefix + "_central_tax", Double.class));
        entity.setPlatFirmCharges(converter.fromRow(row, prefix + "_plat_firm_charges", Double.class));
        entity.setItemsDiscount(converter.fromRow(row, prefix + "_items_discount", Double.class));
        entity.setOrderDiscount(converter.fromRow(row, prefix + "_order_discount", Double.class));
        entity.setTotalAmount(converter.fromRow(row, prefix + "_total_amount", Double.class));
        return entity;
    }
}

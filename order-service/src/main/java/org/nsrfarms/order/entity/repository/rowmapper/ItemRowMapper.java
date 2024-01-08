package org.nsrfarms.order.entity.repository.rowmapper;

import io.r2dbc.spi.Row;
import java.util.function.BiFunction;

import org.nsrfarms.order.entity.Item;
import org.springframework.stereotype.Service;

/**
 * Converter between {@link Row} to {@link Item}, with proper type conversions.
 */
@Service
public class ItemRowMapper implements BiFunction<Row, String, Item> {

    private final ColumnConverter converter;

    public ItemRowMapper(ColumnConverter converter) {
        this.converter = converter;
    }

    /**
     * Take a {@link Row} and a column prefix, and extract all the fields.
     * @return the {@link Item} stored in the database.
     */
    @Override
    public Item apply(Row row, String prefix) {
        Item entity = new Item();
        entity.setId(converter.fromRow(row, prefix + "_id", Long.class));
        entity.setSkuId(converter.fromRow(row, prefix + "_sku_id", String.class));
        entity.setQuantity(converter.fromRow(row, prefix + "_quantity", Integer.class));
        entity.setPrice(converter.fromRow(row, prefix + "_price", Double.class));
        entity.setDiscount(converter.fromRow(row, prefix + "_discount", Double.class));
        entity.setOrderId(converter.fromRow(row, prefix + "_order_id", Long.class));
        return entity;
    }
}

package org.nsrfarms.order.entity.repository.rowmapper;

import io.r2dbc.spi.Row;
import java.util.function.BiFunction;

import org.nsrfarms.order.entity.StatuUpdate;
import org.nsrfarms.order.entity.enumaration.Status;
import org.springframework.stereotype.Service;

/**
 * Converter between {@link Row} to {@link StatuUpdate}, with proper type conversions.
 */
@Service
public class StatuUpdateRowMapper implements BiFunction<Row, String, StatuUpdate> {

    private final ColumnConverter converter;

    public StatuUpdateRowMapper(ColumnConverter converter) {
        this.converter = converter;
    }

    /**
     * Take a {@link Row} and a column prefix, and extract all the fields.
     * @return the {@link StatuUpdate} stored in the database.
     */
    @Override
    public StatuUpdate apply(Row row, String prefix) {
        StatuUpdate entity = new StatuUpdate();
        entity.setId(converter.fromRow(row, prefix + "_id", Long.class));
        entity.setStatus(converter.fromRow(row, prefix + "_status", Status.class));
        entity.setDescription(converter.fromRow(row, prefix + "_description", String.class));
        entity.setOrderId(converter.fromRow(row, prefix + "_order_id", Long.class));
        return entity;
    }
}

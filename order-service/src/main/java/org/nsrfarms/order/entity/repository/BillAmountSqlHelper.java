package org.nsrfarms.order.entity.repository;

import java.util.ArrayList;
import java.util.List;
import org.springframework.data.relational.core.sql.Column;
import org.springframework.data.relational.core.sql.Expression;
import org.springframework.data.relational.core.sql.Table;

public class BillAmountSqlHelper {

    public static List<Expression> getColumns(Table table, String columnPrefix) {
        List<Expression> columns = new ArrayList<>();
        columns.add(Column.aliased("id", table, columnPrefix + "_id"));
        columns.add(Column.aliased("items_total", table, columnPrefix + "_items_total"));
        columns.add(Column.aliased("state_tax", table, columnPrefix + "_state_tax"));
        columns.add(Column.aliased("central_tax", table, columnPrefix + "_central_tax"));
        columns.add(Column.aliased("plat_firm_charges", table, columnPrefix + "_plat_firm_charges"));
        columns.add(Column.aliased("items_discount", table, columnPrefix + "_items_discount"));
        columns.add(Column.aliased("order_discount", table, columnPrefix + "_order_discount"));
        columns.add(Column.aliased("total_amount", table, columnPrefix + "_total_amount"));

        return columns;
    }
}

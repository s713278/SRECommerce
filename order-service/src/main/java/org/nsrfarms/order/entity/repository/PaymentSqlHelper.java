package org.nsrfarms.order.entity.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.relational.core.sql.Column;
import org.springframework.data.relational.core.sql.Expression;
import org.springframework.data.relational.core.sql.Table;

public class PaymentSqlHelper {

	public static List<Expression> getColumns(Table table, String columnPrefix) {
		List<Expression> columns = new ArrayList<>();
		columns.add(Column.aliased("id", table, columnPrefix + "_id"));
		columns.add(Column.aliased("type", table, columnPrefix + "_type"));
		columns.add(Column.aliased("date", table, columnPrefix + "_date"));
		columns.add(Column.aliased("transaction_ref", table, columnPrefix + "_transaction_ref"));

		columns.add(Column.aliased("billing_address_id", table, columnPrefix + "_billing_address_id"));
		return columns;
	}
}

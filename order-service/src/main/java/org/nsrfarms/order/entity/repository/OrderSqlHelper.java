package org.nsrfarms.order.entity.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.relational.core.sql.Column;
import org.springframework.data.relational.core.sql.Expression;
import org.springframework.data.relational.core.sql.Table;

public class OrderSqlHelper {

	public static List<Expression> getColumns(Table table, String columnPrefix) {
		List<Expression> columns = new ArrayList<>();
		columns.add(Column.aliased("id", table, columnPrefix + "_id"));
		columns.add(Column.aliased("required_date", table, columnPrefix + "_required_date"));
		columns.add(Column.aliased("buyer_id", table, columnPrefix + "_buyer_id"));

		columns.add(Column.aliased("amount_id", table, columnPrefix + "_amount_id"));
		columns.add(Column.aliased("payment_id", table, columnPrefix + "_payment_id"));
		columns.add(Column.aliased("shiping_address_id", table, columnPrefix + "_shiping_address_id"));
		return columns;
	}
}

package org.nsrfarms.order.entity.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.relational.core.sql.Column;
import org.springframework.data.relational.core.sql.Expression;
import org.springframework.data.relational.core.sql.Table;

public class AddressSqlHelper {

	public static List<Expression> getColumns(Table table, String columnPrefix) {
		List<Expression> columns = new ArrayList<>();
		columns.add(Column.aliased("id", table, columnPrefix + "_id"));
		columns.add(Column.aliased("street_1", table, columnPrefix + "_street_1"));
		columns.add(Column.aliased("street_2", table, columnPrefix + "_street_2"));
		columns.add(Column.aliased("city", table, columnPrefix + "_city"));
		columns.add(Column.aliased("distict", table, columnPrefix + "_distict"));
		columns.add(Column.aliased("state", table, columnPrefix + "_state"));
		columns.add(Column.aliased("country", table, columnPrefix + "_country"));
		columns.add(Column.aliased("postal_code", table, columnPrefix + "_postal_code"));
		columns.add(Column.aliased("phone_number", table, columnPrefix + "_phone_number"));

		return columns;
	}
}

package org.nsrfarms.order.entity.repository;

import java.util.List;

import org.nsrfarms.order.entity.Order;
import org.nsrfarms.order.entity.repository.rowmapper.AddressRowMapper;
import org.nsrfarms.order.entity.repository.rowmapper.BillAmountRowMapper;
import org.nsrfarms.order.entity.repository.rowmapper.OrderRowMapper;
import org.nsrfarms.order.entity.repository.rowmapper.PaymentRowMapper;
import org.springframework.data.domain.Pageable;
import org.springframework.data.r2dbc.convert.R2dbcConverter;
import org.springframework.data.r2dbc.core.R2dbcEntityOperations;
import org.springframework.data.r2dbc.core.R2dbcEntityTemplate;
import org.springframework.data.r2dbc.repository.support.SimpleR2dbcRepository;
import org.springframework.data.relational.core.sql.Column;
import org.springframework.data.relational.core.sql.Comparison;
import org.springframework.data.relational.core.sql.Condition;
import org.springframework.data.relational.core.sql.Conditions;
import org.springframework.data.relational.core.sql.Expression;
import org.springframework.data.relational.core.sql.Select;
import org.springframework.data.relational.core.sql.SelectBuilder.SelectFromAndJoinCondition;
import org.springframework.data.relational.core.sql.Table;
import org.springframework.data.relational.repository.support.MappingRelationalEntityInformation;
import org.springframework.r2dbc.core.DatabaseClient;
import org.springframework.r2dbc.core.RowsFetchSpec;

import io.r2dbc.spi.Row;
import io.r2dbc.spi.RowMetadata;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Spring Data R2DBC custom repository implementation for the Order entity.
 */
@SuppressWarnings("unused")
class OrderRepositoryInternalImpl extends SimpleR2dbcRepository<Order, Long> implements OrderRepositoryInternal {

    private final DatabaseClient db;
    private final R2dbcEntityTemplate r2dbcEntityTemplate;
    private final EntityManager entityManager;

    private final BillAmountRowMapper billamountMapper;
    private final PaymentRowMapper paymentMapper;
    private final AddressRowMapper addressMapper;
    private final OrderRowMapper orderMapper;

    private static final Table entityTable = Table.aliased("order", "e");
    private static final Table amountTable = Table.aliased("bill_amount", "amount");
    private static final Table paymentTable = Table.aliased("payment", "payment");
    private static final Table shipingAddressTable = Table.aliased("address", "shipingAddress");

    public OrderRepositoryInternalImpl(
        R2dbcEntityTemplate template,
        EntityManager entityManager,
        BillAmountRowMapper billamountMapper,
        PaymentRowMapper paymentMapper,
        AddressRowMapper addressMapper,
        OrderRowMapper orderMapper,
        R2dbcEntityOperations entityOperations,
        R2dbcConverter converter
    ) {
        super(
            new MappingRelationalEntityInformation(converter.getMappingContext().getRequiredPersistentEntity(Order.class)),
            entityOperations,
            converter
        );
        this.db = template.getDatabaseClient();
        this.r2dbcEntityTemplate = template;
        this.entityManager = entityManager;
        this.billamountMapper = billamountMapper;
        this.paymentMapper = paymentMapper;
        this.addressMapper = addressMapper;
        this.orderMapper = orderMapper;
    }

    @Override
    public Flux<Order> findAllBy(Pageable pageable) {
        return createQuery(pageable, null).all();
    }

    RowsFetchSpec<Order> createQuery(Pageable pageable, Condition whereClause) {
        List<Expression> columns = OrderSqlHelper.getColumns(entityTable, "e");
        columns.addAll(BillAmountSqlHelper.getColumns(amountTable, "amount"));
        columns.addAll(PaymentSqlHelper.getColumns(paymentTable, "payment"));
        columns.addAll(AddressSqlHelper.getColumns(shipingAddressTable, "shipingAddress"));
        SelectFromAndJoinCondition selectFrom = Select
            .builder()
            .select(columns)
            .from(entityTable)
            .leftOuterJoin(amountTable)
            .on(Column.create("amount_id", entityTable))
            .equals(Column.create("id", amountTable))
            .leftOuterJoin(paymentTable)
            .on(Column.create("payment_id", entityTable))
            .equals(Column.create("id", paymentTable))
            .leftOuterJoin(shipingAddressTable)
            .on(Column.create("shiping_address_id", entityTable))
            .equals(Column.create("id", shipingAddressTable));
        // we do not support Criteria here for now as of https://github.com/jhipster/generator-jhipster/issues/18269
        String select = entityManager.createSelect(selectFrom, Order.class, pageable, whereClause);
        return db.sql(select).map(this::process);
    }

    @Override
    public Flux<Order> findAll() {
        return findAllBy(null);
    }

    @Override
    public Mono<Order> findById(Long id) {
        Comparison whereClause = Conditions.isEqual(entityTable.column("id"), Conditions.just(id.toString()));
        return createQuery(null, whereClause).one();
    }

    private Order process(Row row, RowMetadata metadata) {
        Order entity = orderMapper.apply(row, "e");
        entity.setAmount(billamountMapper.apply(row, "amount"));
        entity.setPayment(paymentMapper.apply(row, "payment"));
        entity.setShipingAddress(addressMapper.apply(row, "shipingAddress"));
        return entity;
    }

    @Override
    public <S extends Order> Mono<S> save(S entity) {
        return super.save(entity);
    }
}

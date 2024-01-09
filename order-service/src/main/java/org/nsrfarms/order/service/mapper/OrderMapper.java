package org.nsrfarms.order.service.mapper;

import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.nsrfarms.order.entity.Address;
import org.nsrfarms.order.entity.BillAmount;
import org.nsrfarms.order.entity.Order;
import org.nsrfarms.order.entity.Payment;
import org.nsrfarms.order.service.dto.AddressDTO;
import org.nsrfarms.order.service.dto.BillAmountDTO;
import org.nsrfarms.order.service.dto.OrderDTO;
import org.nsrfarms.order.service.dto.PaymentDTO;

/**
 * Mapper for the entity {@link Order} and its DTO {@link OrderDTO}.
 */
@Mapper(componentModel = "spring")
public interface OrderMapper extends EntityMapper<OrderDTO, Order> {
	@Mapping(target = "amount", source = "amount", qualifiedByName = "billAmountId")
	@Mapping(target = "payment", source = "payment", qualifiedByName = "paymentId")
	@Mapping(target = "shipingAddress", source = "shipingAddress", qualifiedByName = "addressId")
	OrderDTO toDto(Order s);

	@Named("billAmountId")
	@BeanMapping(ignoreByDefault = true)
	@Mapping(target = "id", source = "id")
	BillAmountDTO toDtoBillAmountId(BillAmount billAmount);

	@Named("paymentId")
	@BeanMapping(ignoreByDefault = true)
	@Mapping(target = "id", source = "id")
	PaymentDTO toDtoPaymentId(Payment payment);

	@Named("addressId")
	@BeanMapping(ignoreByDefault = true)
	@Mapping(target = "id", source = "id")
	AddressDTO toDtoAddressId(Address address);

}

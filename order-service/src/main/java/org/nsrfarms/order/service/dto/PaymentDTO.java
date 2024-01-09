package org.nsrfarms.order.service.dto;

import java.io.Serializable;
import java.time.ZonedDateTime;
import java.util.Objects;

import org.nsrfarms.order.entity.enumaration.PaymentType;

/**
 * A DTO for the {@link com.mycompany.gateway.domain.Payment} entity.
 */
@SuppressWarnings("common-java:DuplicatedBlocks")
public class PaymentDTO implements Serializable {

	private Long id;

	private PaymentType type;

	private ZonedDateTime date;

	private String transactionRef;

	private AddressDTO billingAddress;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public PaymentType getType() {
		return type;
	}

	public void setType(PaymentType type) {
		this.type = type;
	}

	public ZonedDateTime getDate() {
		return date;
	}

	public void setDate(ZonedDateTime date) {
		this.date = date;
	}

	public String getTransactionRef() {
		return transactionRef;
	}

	public void setTransactionRef(String transactionRef) {
		this.transactionRef = transactionRef;
	}

	public AddressDTO getBillingAddress() {
		return billingAddress;
	}

	public void setBillingAddress(AddressDTO billingAddress) {
		this.billingAddress = billingAddress;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (!(o instanceof PaymentDTO)) {
			return false;
		}

		PaymentDTO paymentDTO = (PaymentDTO) o;
		if (this.id == null) {
			return false;
		}
		return Objects.equals(this.id, paymentDTO.id);
	}

	@Override
	public int hashCode() {
		return Objects.hash(this.id);
	}

	// prettier-ignore
	@Override
	public String toString() {
		return "PaymentDTO{" + "id=" + getId() + ", type='" + getType() + "'" + ", date='" + getDate() + "'"
				+ ", transactionRef='" + getTransactionRef() + "'" + ", billingAddress=" + getBillingAddress() + "}";
	}
}

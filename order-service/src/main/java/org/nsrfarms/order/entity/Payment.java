package org.nsrfarms.order.entity;

import java.io.Serializable;
import java.time.ZonedDateTime;

import org.nsrfarms.order.entity.enumaration.PaymentType;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;

import jakarta.persistence.Column;
import jakarta.persistence.Table;

/**
 * A Payment.
 */
@Table(name = "payment")
public class Payment implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id")
	private Long id;

	@Column(name = "type")
	private PaymentType type;

	@Column(name = "date")
	private ZonedDateTime date;

	@Column(name = "transaction_ref")
	private String transactionRef;

	@Transient
	private Address billingAddress;

	@Transient
	private Order order;

	@Column(name = "billing_address_id")
	private Long billingAddressId;

	// jhipster-needle-entity-add-field - JHipster will add fields here

	public Long getId() {
		return this.id;
	}

	public Payment id(Long id) {
		this.setId(id);
		return this;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public PaymentType getType() {
		return this.type;
	}

	public Payment type(PaymentType type) {
		this.setType(type);
		return this;
	}

	public void setType(PaymentType type) {
		this.type = type;
	}

	public ZonedDateTime getDate() {
		return this.date;
	}

	public Payment date(ZonedDateTime date) {
		this.setDate(date);
		return this;
	}

	public void setDate(ZonedDateTime date) {
		this.date = date;
	}

	public String getTransactionRef() {
		return this.transactionRef;
	}

	public Payment transactionRef(String transactionRef) {
		this.setTransactionRef(transactionRef);
		return this;
	}

	public void setTransactionRef(String transactionRef) {
		this.transactionRef = transactionRef;
	}

	public Address getBillingAddress() {
		return this.billingAddress;
	}

	public void setBillingAddress(Address address) {
		this.billingAddress = address;
		this.billingAddressId = address != null ? address.getId() : null;
	}

	public Payment billingAddress(Address address) {
		this.setBillingAddress(address);
		return this;
	}

	public Order getOrder() {
		return this.order;
	}

	public void setOrder(Order order) {
		if (this.order != null) {
			this.order.setPayment(null);
		}
		if (order != null) {
			order.setPayment(this);
		}
		this.order = order;
	}

	public Payment order(Order order) {
		this.setOrder(order);
		return this;
	}

	public Long getBillingAddressId() {
		return this.billingAddressId;
	}

	public void setBillingAddressId(Long address) {
		this.billingAddressId = address;
	}

	// jhipster-needle-entity-add-getters-setters - JHipster will add getters and
	// setters here

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (!(o instanceof Payment)) {
			return false;
		}
		return getId() != null && getId().equals(((Payment) o).getId());
	}

	@Override
	public int hashCode() {
		// see
		// https://vladmihalcea.com/how-to-implement-equals-and-hashcode-using-the-jpa-entity-identifier/
		return getClass().hashCode();
	}

	// prettier-ignore
	@Override
	public String toString() {
		return "Payment{" + "id=" + getId() + ", type='" + getType() + "'" + ", date='" + getDate() + "'"
				+ ", transactionRef='" + getTransactionRef() + "'" + "}";
	}
}

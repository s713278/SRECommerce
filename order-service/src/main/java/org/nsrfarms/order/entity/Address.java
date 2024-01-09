package org.nsrfarms.order.entity;

import java.io.Serializable;

import org.nsrfarms.order.entity.enumaration.Country;
import org.nsrfarms.order.entity.enumaration.State;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;

import jakarta.persistence.Column;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

/**
 * A Address.
 */
@Table(name = "address")
public class Address implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id")
	private Long id;

	@NotNull(message = "must not be null")
	@Column(name = "street_1")
	private String street1;

	@Column(name = "street_2")
	private String street2;

	@NotNull(message = "must not be null")
	@Column(name = "city")
	private String city;

	@NotNull(message = "must not be null")
	@Column(name = "distict")
	private String distict;

	@NotNull(message = "must not be null")
	@Column(name = "state")
	private State state;

	@NotNull(message = "must not be null")
	@Column(name = "country")
	private Country country;

	@NotNull(message = "must not be null")
	@Column(name = "postal_code")
	private String postalCode;

	@NotNull(message = "must not be null")
	@Column(name = "phone_number")
	private String phoneNumber;

	@Transient
	private Order order;

	@Transient
	private Payment payment;

	// jhipster-needle-entity-add-field - JHipster will add fields here

	public Long getId() {
		return this.id;
	}

	public Address id(Long id) {
		this.setId(id);
		return this;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getStreet1() {
		return this.street1;
	}

	public Address street1(String street1) {
		this.setStreet1(street1);
		return this;
	}

	public void setStreet1(String street1) {
		this.street1 = street1;
	}

	public String getStreet2() {
		return this.street2;
	}

	public Address street2(String street2) {
		this.setStreet2(street2);
		return this;
	}

	public void setStreet2(String street2) {
		this.street2 = street2;
	}

	public String getCity() {
		return this.city;
	}

	public Address city(String city) {
		this.setCity(city);
		return this;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getDistict() {
		return this.distict;
	}

	public Address distict(String distict) {
		this.setDistict(distict);
		return this;
	}

	public void setDistict(String distict) {
		this.distict = distict;
	}

	public State getState() {
		return this.state;
	}

	public Address state(State state) {
		this.setState(state);
		return this;
	}

	public void setState(State state) {
		this.state = state;
	}

	public Country getCountry() {
		return this.country;
	}

	public Address country(Country country) {
		this.setCountry(country);
		return this;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

	public String getPostalCode() {
		return this.postalCode;
	}

	public Address postalCode(String postalCode) {
		this.setPostalCode(postalCode);
		return this;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public String getPhoneNumber() {
		return this.phoneNumber;
	}

	public Address phoneNumber(String phoneNumber) {
		this.setPhoneNumber(phoneNumber);
		return this;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public Order getOrder() {
		return this.order;
	}

	public void setOrder(Order order) {
		if (this.order != null) {
			this.order.setShipingAddress(null);
		}
		if (order != null) {
			order.setShipingAddress(this);
		}
		this.order = order;
	}

	public Address order(Order order) {
		this.setOrder(order);
		return this;
	}

	public Payment getPayment() {
		return this.payment;
	}

	public void setPayment(Payment payment) {
		if (this.payment != null) {
			this.payment.setBillingAddress(null);
		}
		if (payment != null) {
			payment.setBillingAddress(this);
		}
		this.payment = payment;
	}

	public Address payment(Payment payment) {
		this.setPayment(payment);
		return this;
	}

	// jhipster-needle-entity-add-getters-setters - JHipster will add getters and
	// setters here

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (!(o instanceof Address)) {
			return false;
		}
		return getId() != null && getId().equals(((Address) o).getId());
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
		return "Address{" + "id=" + getId() + ", street1='" + getStreet1() + "'" + ", street2='" + getStreet2() + "'"
				+ ", city='" + getCity() + "'" + ", distict='" + getDistict() + "'" + ", state='" + getState() + "'"
				+ ", country='" + getCountry() + "'" + ", postalCode='" + getPostalCode() + "'" + ", phoneNumber='"
				+ getPhoneNumber() + "'" + "}";
	}
}

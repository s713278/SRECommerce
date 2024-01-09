package org.nsrfarms.order.service.dto;

import java.io.Serializable;
import java.util.Objects;

import org.nsrfarms.order.entity.enumaration.Country;
import org.nsrfarms.order.entity.enumaration.State;

import jakarta.validation.constraints.NotNull;

/**
 * A DTO for the {@link com.mycompany.gateway.domain.Address} entity.
 */
public class AddressDTO implements Serializable {

	private Long id;

	@NotNull(message = "must not be null")
	private String street1;

	private String street2;

	@NotNull(message = "must not be null")
	private String city;

	@NotNull(message = "must not be null")
	private String distict;

	@NotNull(message = "must not be null")
	private State state;

	@NotNull(message = "must not be null")
	private Country country;

	@NotNull(message = "must not be null")
	private String postalCode;

	@NotNull(message = "must not be null")
	private String phoneNumber;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getStreet1() {
		return street1;
	}

	public void setStreet1(String street1) {
		this.street1 = street1;
	}

	public String getStreet2() {
		return street2;
	}

	public void setStreet2(String street2) {
		this.street2 = street2;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getDistict() {
		return distict;
	}

	public void setDistict(String distict) {
		this.distict = distict;
	}

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (!(o instanceof AddressDTO)) {
			return false;
		}

		AddressDTO addressDTO = (AddressDTO) o;
		if (this.id == null) {
			return false;
		}
		return Objects.equals(this.id, addressDTO.id);
	}

	@Override
	public int hashCode() {
		return Objects.hash(this.id);
	}

	// prettier-ignore
	@Override
	public String toString() {
		return "AddressDTO{" + "id=" + getId() + ", street1='" + getStreet1() + "'" + ", street2='" + getStreet2() + "'"
				+ ", city='" + getCity() + "'" + ", distict='" + getDistict() + "'" + ", state='" + getState() + "'"
				+ ", country='" + getCountry() + "'" + ", postalCode='" + getPostalCode() + "'" + ", phoneNumber='"
				+ getPhoneNumber() + "'" + "}";
	}
}

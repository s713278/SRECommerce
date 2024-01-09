package org.nsrfarms.order.entity;

import java.io.Serializable;

import org.nsrfarms.order.entity.enumaration.Status;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Table;

/**
 * A StatuUpdate.
 */
@Table(name = "statu_update")
public class StatuUpdate implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id")
	private Long id;

	@Column(name = "status")
	private Status status;

	@Column(name = "description")
	private String description;

	@Transient
	@JsonIgnoreProperties(value = { "amount", "payment", "shipingAddress", "items" }, allowSetters = true)
	private Order order;

	@Column(name = "order_id")
	private Long orderId;

	// jhipster-needle-entity-add-field - JHipster will add fields here

	public Long getId() {
		return this.id;
	}

	public StatuUpdate id(Long id) {
		this.setId(id);
		return this;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Status getStatus() {
		return this.status;
	}

	public StatuUpdate status(Status status) {
		this.setStatus(status);
		return this;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public String getDescription() {
		return this.description;
	}

	public StatuUpdate description(String description) {
		this.setDescription(description);
		return this;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Order getOrder() {
		return this.order;
	}

	public void setOrder(Order order) {
		this.order = order;
		this.orderId = order != null ? order.getId() : null;
	}

	public StatuUpdate order(Order order) {
		this.setOrder(order);
		return this;
	}

	public Long getOrderId() {
		return this.orderId;
	}

	public void setOrderId(Long order) {
		this.orderId = order;
	}

	// jhipster-needle-entity-add-getters-setters - JHipster will add getters and
	// setters here

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (!(o instanceof StatuUpdate)) {
			return false;
		}
		return getId() != null && getId().equals(((StatuUpdate) o).getId());
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
		return "StatuUpdate{" + "id=" + getId() + ", status='" + getStatus() + "'" + ", description='"
				+ getDescription() + "'" + "}";
	}
}

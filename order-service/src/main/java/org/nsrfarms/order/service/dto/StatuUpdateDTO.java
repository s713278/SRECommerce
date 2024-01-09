package org.nsrfarms.order.service.dto;

import java.io.Serializable;
import java.util.Objects;

import org.nsrfarms.order.entity.enumaration.Status;

/**
 * A DTO for the {@link com.mycompany.gateway.domain.StatuUpdate} entity.
 */
@SuppressWarnings("common-java:DuplicatedBlocks")
public class StatuUpdateDTO implements Serializable {

	private Long id;

	private Status status;

	private String description;

	private OrderDTO order;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public OrderDTO getOrder() {
		return order;
	}

	public void setOrder(OrderDTO order) {
		this.order = order;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (!(o instanceof StatuUpdateDTO)) {
			return false;
		}

		StatuUpdateDTO statuUpdateDTO = (StatuUpdateDTO) o;
		if (this.id == null) {
			return false;
		}
		return Objects.equals(this.id, statuUpdateDTO.id);
	}

	@Override
	public int hashCode() {
		return Objects.hash(this.id);
	}

	// prettier-ignore
	@Override
	public String toString() {
		return "StatuUpdateDTO{" + "id=" + getId() + ", status='" + getStatus() + "'" + ", description='"
				+ getDescription() + "'" + ", order=" + getOrder() + "}";
	}
}

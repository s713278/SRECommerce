package org.nsrfarms.order.entity;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;

/**
 * A Item.
 */
@jakarta.persistence.Table(name = "item")
public class Item implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id")
	private Long id;

	@Column(name = "sku_id")
	private String skuId;

	@Column(name = "quantity")
	private Integer quantity;

	@Column(name = "price")
	private Double price;

	@Column(name = "discount")
	private Double discount;

	@Transient
	@JsonIgnoreProperties(value = { "amount", "payment", "shipingAddress", "items" }, allowSetters = true)
	private Order order;

	@Column(name = "order_id")
	private Long orderId;

	// jhipster-needle-entity-add-field - JHipster will add fields here

	public Long getId() {
		return this.id;
	}

	public Item id(Long id) {
		this.setId(id);
		return this;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSkuId() {
		return this.skuId;
	}

	public Item skuId(String skuId) {
		this.setSkuId(skuId);
		return this;
	}

	public void setSkuId(String skuId) {
		this.skuId = skuId;
	}

	public Integer getQuantity() {
		return this.quantity;
	}

	public Item quantity(Integer quantity) {
		this.setQuantity(quantity);
		return this;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Double getPrice() {
		return this.price;
	}

	public Item price(Double price) {
		this.setPrice(price);
		return this;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Double getDiscount() {
		return this.discount;
	}

	public Item discount(Double discount) {
		this.setDiscount(discount);
		return this;
	}

	public void setDiscount(Double discount) {
		this.discount = discount;
	}

	public Order getOrder() {
		return this.order;
	}

	public void setOrder(Order order) {
		this.order = order;
		this.orderId = order != null ? order.getId() : null;
	}

	public Item order(Order order) {
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
		if (!(o instanceof Item)) {
			return false;
		}
		return getId() != null && getId().equals(((Item) o).getId());
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
		return "Item{" + "id=" + getId() + ", skuId='" + getSkuId() + "'" + ", quantity=" + getQuantity() + ", price="
				+ getPrice() + ", discount=" + getDiscount() + "}";
	}
}

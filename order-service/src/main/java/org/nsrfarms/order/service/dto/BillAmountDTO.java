package org.nsrfarms.order.service.dto;

import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the {@link com.mycompany.gateway.domain.BillAmount} entity.
 */
@SuppressWarnings("common-java:DuplicatedBlocks")
public class BillAmountDTO implements Serializable {

	private Long id;

	private Double itemsTotal;

	private Double stateTax;

	private Double centralTax;

	private Double platFirmCharges;

	private Double itemsDiscount;

	private Double orderDiscount;

	private Double totalAmount;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Double getItemsTotal() {
		return itemsTotal;
	}

	public void setItemsTotal(Double itemsTotal) {
		this.itemsTotal = itemsTotal;
	}

	public Double getStateTax() {
		return stateTax;
	}

	public void setStateTax(Double stateTax) {
		this.stateTax = stateTax;
	}

	public Double getCentralTax() {
		return centralTax;
	}

	public void setCentralTax(Double centralTax) {
		this.centralTax = centralTax;
	}

	public Double getPlatFirmCharges() {
		return platFirmCharges;
	}

	public void setPlatFirmCharges(Double platFirmCharges) {
		this.platFirmCharges = platFirmCharges;
	}

	public Double getItemsDiscount() {
		return itemsDiscount;
	}

	public void setItemsDiscount(Double itemsDiscount) {
		this.itemsDiscount = itemsDiscount;
	}

	public Double getOrderDiscount() {
		return orderDiscount;
	}

	public void setOrderDiscount(Double orderDiscount) {
		this.orderDiscount = orderDiscount;
	}

	public Double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(Double totalAmount) {
		this.totalAmount = totalAmount;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (!(o instanceof BillAmountDTO)) {
			return false;
		}

		BillAmountDTO billAmountDTO = (BillAmountDTO) o;
		if (this.id == null) {
			return false;
		}
		return Objects.equals(this.id, billAmountDTO.id);
	}

	@Override
	public int hashCode() {
		return Objects.hash(this.id);
	}

	// prettier-ignore
	@Override
	public String toString() {
		return "BillAmountDTO{" + "id=" + getId() + ", itemsTotal=" + getItemsTotal() + ", stateTax=" + getStateTax()
				+ ", centralTax=" + getCentralTax() + ", platFirmCharges=" + getPlatFirmCharges() + ", itemsDiscount="
				+ getItemsDiscount() + ", orderDiscount=" + getOrderDiscount() + ", totalAmount=" + getTotalAmount()
				+ "}";
	}
}

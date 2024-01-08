package org.nsrfarms.order.entity;

import java.io.Serializable;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;

import jakarta.persistence.Column;
import jakarta.persistence.Table;

/**
 * A BillAmount.
 */
@Table(name="bill_amount")
public class BillAmount implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name="id")
    private Long id;

    @Column(name="items_total")
    private Double itemsTotal;

    @Column(name="state_tax")
    private Double stateTax;

    @Column(name="central_tax")
    private Double centralTax;

    @Column(name="plat_firm_charges")
    private Double platFirmCharges;

    @Column(name="items_discount")
    private Double itemsDiscount;

    @Column(name="order_discount")
    private Double orderDiscount;

    @Column(name="total_amount")
    private Double totalAmount;

    @Transient
    private Order order;

    // jhipster-needle-entity-add-field - JHipster will add fields here

    public Long getId() {
        return this.id;
    }

    public BillAmount id(Long id) {
        this.setId(id);
        return this;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getItemsTotal() {
        return this.itemsTotal;
    }

    public BillAmount itemsTotal(Double itemsTotal) {
        this.setItemsTotal(itemsTotal);
        return this;
    }

    public void setItemsTotal(Double itemsTotal) {
        this.itemsTotal = itemsTotal;
    }

    public Double getStateTax() {
        return this.stateTax;
    }

    public BillAmount stateTax(Double stateTax) {
        this.setStateTax(stateTax);
        return this;
    }

    public void setStateTax(Double stateTax) {
        this.stateTax = stateTax;
    }

    public Double getCentralTax() {
        return this.centralTax;
    }

    public BillAmount centralTax(Double centralTax) {
        this.setCentralTax(centralTax);
        return this;
    }

    public void setCentralTax(Double centralTax) {
        this.centralTax = centralTax;
    }

    public Double getPlatFirmCharges() {
        return this.platFirmCharges;
    }

    public BillAmount platFirmCharges(Double platFirmCharges) {
        this.setPlatFirmCharges(platFirmCharges);
        return this;
    }

    public void setPlatFirmCharges(Double platFirmCharges) {
        this.platFirmCharges = platFirmCharges;
    }

    public Double getItemsDiscount() {
        return this.itemsDiscount;
    }

    public BillAmount itemsDiscount(Double itemsDiscount) {
        this.setItemsDiscount(itemsDiscount);
        return this;
    }

    public void setItemsDiscount(Double itemsDiscount) {
        this.itemsDiscount = itemsDiscount;
    }

    public Double getOrderDiscount() {
        return this.orderDiscount;
    }

    public BillAmount orderDiscount(Double orderDiscount) {
        this.setOrderDiscount(orderDiscount);
        return this;
    }

    public void setOrderDiscount(Double orderDiscount) {
        this.orderDiscount = orderDiscount;
    }

    public Double getTotalAmount() {
        return this.totalAmount;
    }

    public BillAmount totalAmount(Double totalAmount) {
        this.setTotalAmount(totalAmount);
        return this;
    }

    public void setTotalAmount(Double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public Order getOrder() {
        return this.order;
    }

    public void setOrder(Order order) {
        if (this.order != null) {
            this.order.setAmount(null);
        }
        if (order != null) {
            order.setAmount(this);
        }
        this.order = order;
    }

    public BillAmount order(Order order) {
        this.setOrder(order);
        return this;
    }

    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof BillAmount)) {
            return false;
        }
        return getId() != null && getId().equals(((BillAmount) o).getId());
    }

    @Override
    public int hashCode() {
        // see https://vladmihalcea.com/how-to-implement-equals-and-hashcode-using-the-jpa-entity-identifier/
        return getClass().hashCode();
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "BillAmount{" +
            "id=" + getId() +
            ", itemsTotal=" + getItemsTotal() +
            ", stateTax=" + getStateTax() +
            ", centralTax=" + getCentralTax() +
            ", platFirmCharges=" + getPlatFirmCharges() +
            ", itemsDiscount=" + getItemsDiscount() +
            ", orderDiscount=" + getOrderDiscount() +
            ", totalAmount=" + getTotalAmount() +
            "}";
    }
}

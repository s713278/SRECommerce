package org.nsrfarms.order.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.validation.constraints.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;

/**
 * A Order.
 */
@jakarta.persistence.Table(name="order")
public class Order implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name="id")
    private Long id;

    @NotNull(message = "must not be null")
    @Column(name="required_date")
    private LocalDate requiredDate;

    @NotNull(message = "must not be null")
    @Column(name="buyer_id")
    private String buyerId;

    @Transient
    private BillAmount amount;

    @Transient
    private Payment payment;

    @Transient
    private Address shipingAddress;

    @Transient
    @JsonIgnoreProperties(value = { "order" }, allowSetters = true)
    private Set<Item> items = new HashSet<>();

    @Column(name="amount_id")
    private Long amountId;

    @Column(name="payment_id")
    private Long paymentId;

    @Column(name="shiping_address_id")
    private Long shipingAddressId;

    // jhipster-needle-entity-add-field - JHipster will add fields here

    public Long getId() {
        return this.id;
    }

    public Order id(Long id) {
        this.setId(id);
        return this;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getRequiredDate() {
        return this.requiredDate;
    }

    public Order requiredDate(LocalDate requiredDate) {
        this.setRequiredDate(requiredDate);
        return this;
    }

    public void setRequiredDate(LocalDate requiredDate) {
        this.requiredDate = requiredDate;
    }

    public String getBuyerId() {
        return this.buyerId;
    }

    public Order buyerId(String buyerId) {
        this.setBuyerId(buyerId);
        return this;
    }

    public void setBuyerId(String buyerId) {
        this.buyerId = buyerId;
    }

    public BillAmount getAmount() {
        return this.amount;
    }

    public void setAmount(BillAmount billAmount) {
        this.amount = billAmount;
        this.amountId = billAmount != null ? billAmount.getId() : null;
    }

    public Order amount(BillAmount billAmount) {
        this.setAmount(billAmount);
        return this;
    }

    public Payment getPayment() {
        return this.payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
        this.paymentId = payment != null ? payment.getId() : null;
    }

    public Order payment(Payment payment) {
        this.setPayment(payment);
        return this;
    }

    public Address getShipingAddress() {
        return this.shipingAddress;
    }

    public void setShipingAddress(Address address) {
        this.shipingAddress = address;
        this.shipingAddressId = address != null ? address.getId() : null;
    }

    public Order shipingAddress(Address address) {
        this.setShipingAddress(address);
        return this;
    }

    public Set<Item> getItems() {
        return this.items;
    }

    public void setItems(Set<Item> items) {
        if (this.items != null) {
            this.items.forEach(i -> i.setOrder(null));
        }
        if (items != null) {
            items.forEach(i -> i.setOrder(this));
        }
        this.items = items;
    }

    public Order items(Set<Item> items) {
        this.setItems(items);
        return this;
    }

    public Order addItem(Item item) {
        this.items.add(item);
        item.setOrder(this);
        return this;
    }

    public Order removeItem(Item item) {
        this.items.remove(item);
        item.setOrder(null);
        return this;
    }

    public Long getAmountId() {
        return this.amountId;
    }

    public void setAmountId(Long billAmount) {
        this.amountId = billAmount;
    }

    public Long getPaymentId() {
        return this.paymentId;
    }

    public void setPaymentId(Long payment) {
        this.paymentId = payment;
    }

    public Long getShipingAddressId() {
        return this.shipingAddressId;
    }

    public void setShipingAddressId(Long address) {
        this.shipingAddressId = address;
    }

    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Order)) {
            return false;
        }
        return getId() != null && getId().equals(((Order) o).getId());
    }

    @Override
    public int hashCode() {
        // see https://vladmihalcea.com/how-to-implement-equals-and-hashcode-using-the-jpa-entity-identifier/
        return getClass().hashCode();
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "Order{" +
            "id=" + getId() +
            ", requiredDate='" + getRequiredDate() + "'" +
            ", buyerId='" + getBuyerId() + "'" +
            "}";
    }
}

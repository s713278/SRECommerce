package org.nsrfarms.order.service.dto;

import jakarta.validation.constraints.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

/**
 * A DTO for the {@link com.mycompany.gateway.domain.Order} entity.
 */
@SuppressWarnings("common-java:DuplicatedBlocks")
public class OrderDTO implements Serializable {

    private Long id;

    @NotNull(message = "must not be null")
    private LocalDate requiredDate;

    @NotNull(message = "must not be null")
    private String buyerId;

    private BillAmountDTO amount;

    private PaymentDTO payment;

    private AddressDTO shipingAddress;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getRequiredDate() {
        return requiredDate;
    }

    public void setRequiredDate(LocalDate requiredDate) {
        this.requiredDate = requiredDate;
    }

    public String getBuyerId() {
        return buyerId;
    }

    public void setBuyerId(String buyerId) {
        this.buyerId = buyerId;
    }

    public BillAmountDTO getAmount() {
        return amount;
    }

    public void setAmount(BillAmountDTO amount) {
        this.amount = amount;
    }

    public PaymentDTO getPayment() {
        return payment;
    }

    public void setPayment(PaymentDTO payment) {
        this.payment = payment;
    }

    public AddressDTO getShipingAddress() {
        return shipingAddress;
    }

    public void setShipingAddress(AddressDTO shipingAddress) {
        this.shipingAddress = shipingAddress;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof OrderDTO)) {
            return false;
        }

        OrderDTO orderDTO = (OrderDTO) o;
        if (this.id == null) {
            return false;
        }
        return Objects.equals(this.id, orderDTO.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id);
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "OrderDTO{" +
            "id=" + getId() +
            ", requiredDate='" + getRequiredDate() + "'" +
            ", buyerId='" + getBuyerId() + "'" +
            ", amount=" + getAmount() +
            ", payment=" + getPayment() +
            ", shipingAddress=" + getShipingAddress() +
            "}";
    }
}

package org.example.natureland.entety;

import jakarta.persistence.*;
import org.example.natureland.enums.Status;

@Entity
@Table(name = "orders")
public class Orders {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "id_client")
    private int clientId;

    @Column(name = "first_name")
    private String first_name;

    @Column(name = "last_name")
    private String last_name;

    @Column(name = "address")
    private String address;

    @Column(name = "phone_number")
    private String phone_number;

    @Column(name = "cart_elements")
    private String cart_elements;

    @Column(name = "payment_method")
    private String payment_method;

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private Status status;

    public Orders() {
    }

    public int getId() {
        return this.id;
    }

    public int getClientId() {
        return this.clientId;
    }

    public String getFirst_name() {
        return this.first_name;
    }

    public String getLast_name() {
        return this.last_name;
    }

    public String getAddress() {
        return this.address;
    }

    public String getPhone_number() {
        return this.phone_number;
    }

    public String getCart_elements() {
        return this.cart_elements;
    }

    public String getPayment_method() {
        return this.payment_method;
    }

    public Status getStatus() {
        return this.status;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setClientId(int id_client) {
        this.clientId = id_client;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public void setCart_elements(String cart_elements) {
        this.cart_elements = cart_elements;
    }

    public void setPayment_method(String payment_method) {
        this.payment_method = payment_method;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof Orders)) return false;
        final Orders other = (Orders) o;
        if (!other.canEqual((Object) this)) return false;
        if (this.getId() != other.getId()) return false;
        if (this.getClientId() != other.getClientId()) return false;
        final Object this$first_name = this.getFirst_name();
        final Object other$first_name = other.getFirst_name();
        if (this$first_name == null ? other$first_name != null : !this$first_name.equals(other$first_name))
            return false;
        final Object this$last_name = this.getLast_name();
        final Object other$last_name = other.getLast_name();
        if (this$last_name == null ? other$last_name != null : !this$last_name.equals(other$last_name)) return false;
        final Object this$address = this.getAddress();
        final Object other$address = other.getAddress();
        if (this$address == null ? other$address != null : !this$address.equals(other$address)) return false;
        final Object this$phone_number = this.getPhone_number();
        final Object other$phone_number = other.getPhone_number();
        if (this$phone_number == null ? other$phone_number != null : !this$phone_number.equals(other$phone_number))
            return false;
        final Object this$cart_elements = this.getCart_elements();
        final Object other$cart_elements = other.getCart_elements();
        if (this$cart_elements == null ? other$cart_elements != null : !this$cart_elements.equals(other$cart_elements))
            return false;
        final Object this$payment_method = this.getPayment_method();
        final Object other$payment_method = other.getPayment_method();
        if (this$payment_method == null ? other$payment_method != null : !this$payment_method.equals(other$payment_method))
            return false;
        final Object this$status = this.getStatus();
        final Object other$status = other.getStatus();
        if (this$status == null ? other$status != null : !this$status.equals(other$status)) return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof Orders;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        result = result * PRIME + this.getId();
        result = result * PRIME + this.getClientId();
        final Object $first_name = this.getFirst_name();
        result = result * PRIME + ($first_name == null ? 43 : $first_name.hashCode());
        final Object $last_name = this.getLast_name();
        result = result * PRIME + ($last_name == null ? 43 : $last_name.hashCode());
        final Object $address = this.getAddress();
        result = result * PRIME + ($address == null ? 43 : $address.hashCode());
        final Object $phone_number = this.getPhone_number();
        result = result * PRIME + ($phone_number == null ? 43 : $phone_number.hashCode());
        final Object $cart_elements = this.getCart_elements();
        result = result * PRIME + ($cart_elements == null ? 43 : $cart_elements.hashCode());
        final Object $payment_method = this.getPayment_method();
        result = result * PRIME + ($payment_method == null ? 43 : $payment_method.hashCode());
        final Object $status = this.getStatus();
        result = result * PRIME + ($status == null ? 43 : $status.hashCode());
        return result;
    }

    public String toString() {
        return "Orders(id=" + this.getId() + ", id_client=" + this.getClientId() + ", first_name=" + this.getFirst_name() + ", last_name=" + this.getLast_name() + ", address=" + this.getAddress() + ", phone_number=" + this.getPhone_number() + ", cart_elements=" + this.getCart_elements() + ", payment_method=" + this.getPayment_method() + ", status=" + this.getStatus() + ")";
    }
}
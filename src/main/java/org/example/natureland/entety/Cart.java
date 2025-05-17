package org.example.natureland.entety;


import jakarta.persistence.*;

@Entity
@Table(name = "cart")
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "productid") // this is your foreign key column
    private Products product;

    @Column(name = "personid")
    private int personid;
    @Column(name = "amount")
    private int amount;

    public Cart() {
    }

    public int getId() {
        return this.id;
    }

    public Products getProduct() {
        return this.product;
    }

    public int getPersonid() {
        return this.personid;
    }

    public int getAmount() {
        return this.amount;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setProduct(Products product) {
        this.product = product;
    }

    public void setPersonid(int personID) {
        this.personid = personID;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof Cart)) return false;
        final Cart other = (Cart) o;
        if (!other.canEqual((Object) this)) return false;
        if (this.getId() != other.getId()) return false;
        final Object this$product = this.getProduct();
        final Object other$product = other.getProduct();
        if (this$product == null ? other$product != null : !this$product.equals(other$product)) return false;
        if (this.getPersonid() != other.getPersonid()) return false;
        if (this.getAmount() != other.getAmount()) return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof Cart;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        result = result * PRIME + this.getId();
        final Object $product = this.getProduct();
        result = result * PRIME + ($product == null ? 43 : $product.hashCode());
        result = result * PRIME + this.getPersonid();
        result = result * PRIME + this.getAmount();
        return result;
    }

    public String toString() {
        return "Cart(id=" + this.getId() + ", product=" + this.getProduct() + ", personID=" + this.getPersonid() + ", amount=" + this.getAmount() + ")";
    }
}

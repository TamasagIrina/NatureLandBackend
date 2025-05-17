package org.example.natureland.entety;

import jakarta.persistence.*;

@Entity
@Table(name = "products")
public class Products {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "product_name")
    String productName;

    @Column(name = "product_brand")
    String productBrand;

    @Column(name = "product_description")
    String productDescription;

    @Column(name = "product_price")
    Double productPrice;

    @Column(name = "product_img")
    String productImg;


    public Products() {
    }


    public int getId() {
        return this.id;
    }

    public String getProductName() {
        return this.productName;
    }

    public String getProductBrand() {
        return this.productBrand;
    }

    public String getProductDescription() {
        return this.productDescription;
    }

    public Double getProductPrice() {
        return this.productPrice;
    }

    public String getProductImg() {
        return this.productImg;
    }



    public void setId(int id) {
        this.id = id;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setProductBrand(String productBrand) {
        this.productBrand = productBrand;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public void setProductPrice(Double productPrice) {
        this.productPrice = productPrice;
    }

    public void setProductImg(String productImg) {
        this.productImg = productImg;
    }



    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof Products)) return false;
        final Products other = (Products) o;
        if (!other.canEqual((Object) this)) return false;
        if (this.getId() != other.getId()) return false;
        final Object this$productName = this.getProductName();
        final Object other$productName = other.getProductName();
        if (this$productName == null ? other$productName != null : !this$productName.equals(other$productName))
            return false;
        final Object this$productBrand = this.getProductBrand();
        final Object other$productBrand = other.getProductBrand();
        if (this$productBrand == null ? other$productBrand != null : !this$productBrand.equals(other$productBrand))
            return false;
        final Object this$productDescription = this.getProductDescription();
        final Object other$productDescription = other.getProductDescription();
        if (this$productDescription == null ? other$productDescription != null : !this$productDescription.equals(other$productDescription))
            return false;
        final Object this$productPrice = this.getProductPrice();
        final Object other$productPrice = other.getProductPrice();
        if (this$productPrice == null ? other$productPrice != null : !this$productPrice.equals(other$productPrice))
            return false;
        final Object this$productImg = this.getProductImg();
        final Object other$productImg = other.getProductImg();
        if (this$productImg == null ? other$productImg != null : !this$productImg.equals(other$productImg))
            return false;

        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof Products;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        result = result * PRIME + this.getId();
        final Object $productName = this.getProductName();
        result = result * PRIME + ($productName == null ? 43 : $productName.hashCode());
        final Object $productBrand = this.getProductBrand();
        result = result * PRIME + ($productBrand == null ? 43 : $productBrand.hashCode());
        final Object $productDescription = this.getProductDescription();
        result = result * PRIME + ($productDescription == null ? 43 : $productDescription.hashCode());
        final Object $productPrice = this.getProductPrice();
        result = result * PRIME + ($productPrice == null ? 43 : $productPrice.hashCode());
        final Object $productImg = this.getProductImg();
        result = result * PRIME + ($productImg == null ? 43 : $productImg.hashCode());

        return result;
    }

    public String toString() {
        return "Products(id=" + this.getId() + ", productName=" + this.getProductName() + ", productBrand=" + this.getProductBrand() + ", productDescription=" + this.getProductDescription() + ", productPrice=" + this.getProductPrice() + ", productImg=" + this.getProductImg() +  ")";
    }
}

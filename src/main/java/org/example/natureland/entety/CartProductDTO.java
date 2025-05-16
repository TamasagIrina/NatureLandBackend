package org.example.natureland.entety;

import org.example.natureland.entety.Cart;

public class CartProductDTO {
    private int cartId;
    private int amount;
    private String productName;
    private String productBrand;
    private String productImg;
    private String productDescription;
    private double productPrice;

    public CartProductDTO(Cart cart) {
        this.cartId = cart.getId();
        this.amount = cart.getAmount();

        Products p = cart.getProduct();
        this.productName = p.getProductName();
        this.productBrand = p.getProductBrand();
        this.productImg = p.getProductImg();
        this.productDescription = p.getProductDescription();
        this.productPrice = p.getProductPrice();
    }


    public int getCartId() {
        return cartId;
    }

    public void setCartId(int cartId) {
        this.cartId = cartId;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductBrand() {
        return productBrand;
    }

    public void setProductBrand(String productBrand) {
        this.productBrand = productBrand;
    }

    public String getProductImg() {
        return productImg;
    }

    public void setProductImg(String productImg) {
        this.productImg = productImg;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }



}

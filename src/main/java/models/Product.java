package models;

import java.math.BigDecimal;

public class Product {
    private int quantity;
    private String name;
    private BigDecimal price, totalCost;


    public String getName() {
        return name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public BigDecimal getTotalCost() {
        return totalCost;
    }

    public int getQuantity() {
        return quantity;
    }

    public Product setName(String name) {
        this.name = name;
        return this;
    }

    public Product setPrice(String price) {
        this.price = new BigDecimal(price);
        return this;
    }

    public Product setTotalCost(String totalCost) {
        this.totalCost = new BigDecimal(totalCost);
        return this;
    }

    public Product setQuantity(int quantity) {
        this.quantity = quantity;
        return this;
    }

    public void increaseQuantity(Product product) {
        this.quantity += product.getQuantity();
        this.totalCost = price.multiply(BigDecimal.valueOf(quantity));
    }

    public String toString(){
        return String.format("%s: %d x %.2f = %.2f", name, quantity, price, totalCost);
    }
}

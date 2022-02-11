package models;

public class Product {
    private int quantity;
    private String name;
    private double price, totalCost;


    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public double getTotalCost() {
        return totalCost;
    }

    public int getQuantity() {
        return quantity;
    }

    public Product setName(String name) {
        this.name = name;
        return this;
    }

    public Product setPrice(double price) {
        this.price = price;
        return this;
    }

    public Product setTotalCost(double totalCost) {
        this.totalCost = totalCost;
        return this;
    }

    public Product setQuantity(int quantity) {
        this.quantity = quantity;
        return this;
    }

    public void increaseQuantity(Product product) {
        this.quantity += product.getQuantity();
    }

    public String toString(){
        return name + ": " + quantity + " x " + price + " = " + totalCost;
    }
}

package models;

import java.util.ArrayList;
import java.util.List;

public class ProductList {
    private List<Product> addedProducts;

    public ProductList(){
        addedProducts =new ArrayList<>();
    }

    public void addProduct(Product product){
        addedProducts.add(product);
    }
    public boolean productAlreadyIn(Product product){
        if(addedProducts.isEmpty()){
            return false;
        }
        for (Product added: addedProducts)
            if (added.getName().equals(product.getName()))
                return true;
        return false;
    }

    public void increaseQuantity(Product product) {
        for(Product added: addedProducts){
            if(added.getName().equals(product.getName())){
                added.increaseQuantity(product);
            }
        }
    }


    public List<Product> getAddedProducts() {
        return addedProducts;
    }
}

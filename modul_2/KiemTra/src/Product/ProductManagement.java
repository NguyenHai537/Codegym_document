package Product;

import Customer.Customer;

import java.util.ArrayList;
import java.util.List;

public class ProductManagement {
    private List<Product> products;


    private static final ProductManagement productManagement = new ProductManagement();

    private ProductManagement(){
        products = new ArrayList<>();
    }

    public static ProductManagement getProductManagement() {
        return productManagement;
    }

    public List<Product> getProduct() {
        return products;
    }

    public void  addProduct(Product product){
        products.add(product);
    }

    public Product searchById(String id){
        Product result =null;
        for (Product product: products
        ) {
            if ( product.getProductID().equals(id)){
                result = product;
            }
        }
        return result;
    }

    @Override
    public String toString() {
        return "ProductManagement{" +
                "products=" + products +
                '}';
    }
}

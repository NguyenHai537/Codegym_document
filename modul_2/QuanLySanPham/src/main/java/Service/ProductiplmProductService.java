package Service;

import Model.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductiplmProductService implements ProductService{

    private static Map<Integer, Product> products;

    static {
        products = new HashMap<>();
        products.put(1,new Product(1,"Car" , 100000,"Toy" ,"USA"));
        products.put(2,new Product(2,"Conan" , 5500,"Manga" ,"Japan"));
        products.put(3,new Product(3,"Oishi" , 3000,"Snack" ,"Japan"));
        products.put(4,new Product(4,"Iphone" , 500000,"Smartphone" ,"USA"));
        products.put(5,new Product(5,"Lock&Lock" , 600000,"Bottle holder" ,"VietNam"));
        products.put(6,new Product(6,"Dell" , 800000,"Laptop" ,"USA"));
    }


    @Override
    public List<Product> list() {
        return new ArrayList<>(products.values());
    }

    @Override
    public boolean create(Product product) {
        products.put(product.getId(),product);
        return true;
    }

    @Override
    public boolean update(Product product) {
        products.put(product.getId(),product);
        return true;
    }

    @Override
    public boolean remove(Product product) {
        products.remove(product.getId());
        return true;
    }

    @Override
    public Product searchByID(int id) {
        Product product = products.get(id);
        return product;
    }

    @Override
    public List<Product> searchByName(String name) {
        List<Product> listProduct = new ArrayList<>();

        for (Integer p: products.keySet()) {
            if(products.get(p).getName().contains(name)){
                listProduct.add(products.get(p));
            }
        }
        return listProduct;
    }
}

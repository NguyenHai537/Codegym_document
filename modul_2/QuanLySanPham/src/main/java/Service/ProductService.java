package Service;

import Model.Product;

import java.util.List;

public interface ProductService {
     List<Product> list();

    boolean create(Product product);

    boolean update(Product product);

    boolean remove(Product product);

    Product searchByID(int id);

    List<Product> searchByName(String name);
}

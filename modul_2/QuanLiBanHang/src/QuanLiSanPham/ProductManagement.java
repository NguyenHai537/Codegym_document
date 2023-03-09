package QuanLiSanPham;

import java.util.ArrayList;
import java.util.Collections;
public class ProductManagement {
    private ArrayList<Product> listProduct;

    private static ProductManagement productManagement = new ProductManagement();

    private ProductManagement(){
        listProduct = new ArrayList<>();
    }

    public static ProductManagement getProductManagement() {
        return productManagement;
    }

    public static void setProductManagement(ProductManagement productManagement) {
        ProductManagement.productManagement = productManagement;
    }

    public void addProduct (Product product){
        listProduct.add(product);
    }
    public boolean removeProduct ( String idProduct){
        for (Product product: listProduct
        ) {
            if ( product.getIdListProduct().equals(idProduct)){
                listProduct.remove(product);
                return true;
            }
        }
        return false;
    }

    public boolean fixProduct(String idProduct, String idSanPham, String nameSanPham,int priceSanPham){
        for (Product product: listProduct
        ) {
            if ( product.getIdSanPham().equals(idProduct)){
                product.setIdSanPham(idSanPham);
                product.setNameSanPham(nameSanPham);
                product.setPriceSanPham(priceSanPham);
                return true;
            }
        }
        return false;
    }

    public void display(){
        System.out.println(listProduct);
    }

    public Product searchById(String id){
        for (Product product: listProduct
             ) {
            if ( product.getIdSanPham().equals(id)){
                return product;
            }
        }
        return null;
    }

    public void searchByName(String nameSanPham){
        ArrayList<Product> listName = new ArrayList<>();
        for (Product product: listProduct
        ) {
            if ( product.getNameSanPham().equals(nameSanPham)){
                listName.add(product);
            }
        }
        System.out.println(listName);
    }

    public void sortProductIncreaseByPrice(){
        ComparatorProduct comparatorProduct = new ComparatorProduct();

        listProduct.sort(comparatorProduct);
        System.out.println(listProduct);
    }

    public void sortProductDecreaseByPrice(){
        ComparatorProduct comparatorProduct = new ComparatorProduct();
        Collections.sort(listProduct,comparatorProduct.reversed());
        System.out.println(listProduct);
    }


    @Override
    public String toString() {
        return "ProductManager{" +
                "listProduct=" + listProduct +
                '}';
    }

}

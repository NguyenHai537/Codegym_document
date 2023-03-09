package QuanLiHoadon2;

import QuanLiSanPham.Product;
import QuanLiSanPham.ProductManagement;

public class BuyingProduct {

    private String productID;
    private Product product;
    private int quantity;
    private double discount;



    public BuyingProduct(String productID, int quantity, double discount) {
        this.productID = productID;
        this.quantity = quantity;
        this.discount = discount;
        this.product = ProductManagement.getProductManagement().searchById(productID);
    }

    public String getProductID() {
        return productID;
    }

    public void setProductID(String productID) throws Exception {
        if (ProductManagement.getProductManagement().searchById(productID) == null){
            throw new Exception("Product ID not found!");
        }

        this.productID = productID;
    }

    public Product getProduct() {
        return  this.product = ProductManagement.getProductManagement().searchById(productID);
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public double getPrice(){
        return getProduct().getPriceSanPham();
    }
    public double getSubTotal(){
        return getPrice() * this.quantity * (1 - this.discount);
    }



    @Override
    public String toString() {
        return productID + " | " +
                getProduct().getNameSanPham() + " | " +
                getPrice() + " | " +
                getQuantity() + " | " +
                getSubTotal();
    }
}

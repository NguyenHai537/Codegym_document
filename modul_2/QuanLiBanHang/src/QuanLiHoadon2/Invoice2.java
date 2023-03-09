package QuanLiHoadon2;

import QuanLiKhachHang.Customer;
import QuanLiKhachHang.CustomerManagement;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Invoice2 {

    private int invoiceID;
    private Date date;
    private String customerID;
    private List<BuyingProduct> buyingProducts;

    public Invoice2(int invoiceID,  String customerID) {
        this.invoiceID = invoiceID;
        this.date = new Date();
        this.customerID = customerID;
        buyingProducts = new ArrayList<>();
    }

    public Invoice2() {}

    public int getInvoiceID() {
        return invoiceID;
    }

    public void setInvoiceID(int invoiceID) {
        this.invoiceID = invoiceID;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getCustomerID() {
        return customerID;
    }

    public void setCustomerID(String customerID) {
        this.customerID = customerID;
    }

    public void addBuyingProduct(BuyingProduct buyingProduct){
        buyingProducts.add(buyingProduct);
    }

    public List<BuyingProduct> getBuyingProducts() {
        return buyingProducts;
    }

    public Customer getCustomer(){
        return CustomerManagement.getCustomerManagement().searchById(getCustomerID());
    }

    public String getDetail(){
        String result="";
        for (BuyingProduct buyingProduct: getBuyingProducts()
             ) {
            result += buyingProduct.toString() + "\n";
        }
        return result;
    }

    public double getTotalPrice(){
        double totalPrice = 0.0d;
        for (BuyingProduct buyingproduct: getBuyingProducts()
             ) {
            totalPrice += buyingproduct.getSubTotal();
        }
        return totalPrice;
    }




    @Override
    public String toString() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
        return "Invoice" + "\n"+
                "Invoice date: " +  simpleDateFormat.format(getDate()) + "\n" +
                "Customer Information: " + getCustomer().toString() + "\n" +
                "Detail: " + "\n" +
                 getDetail() + "\n" +
                "Total Price: " + getTotalPrice();
        

    }
}

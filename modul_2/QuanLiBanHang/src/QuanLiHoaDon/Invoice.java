package QuanLiHoaDon;


import QuanLiKhachHang.CustomerManagement;
import QuanLiSanPham.ProductManagement;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Invoice {

    private String idProduct;
    private int idInvoice;
    private Date date;
    private String customerId;

    private Map<String,Integer> dsSanPham = new HashMap<String,Integer>();

    public Invoice (){}

    public Invoice(int idInvoice ,String customerId )  {
        this.idInvoice = idInvoice;
        this.customerId = customerId;
        this.date = new Date();
    }


    public int getIdInvoice() {
        return idInvoice;
    }

    public void setIdInvoice(int idInvoice) {
        this.idInvoice = idInvoice;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public void addSp(String idsp , Integer sl){
        dsSanPham.put(idsp,sl);
    }

    public String getDate (){
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("hh:mm:ss dd-M-yyyy");
        String strDate = formatter.format(date);
        return strDate;
    }
    public String getNameCustomer(){
        CustomerManagement customerManagement = CustomerManagement.getCustomerManagement();
         return customerManagement.searchById(getCustomerId()).getName();
    }


    public String getIngormationProduct (){
        ProductManagement productManagement = ProductManagement.getProductManagement();
        String result = "";

        for (String key: dsSanPham.keySet()
             ) {
           result += productManagement.searchById(key).getNameSanPham() + " : " + productManagement.searchById(key).getPriceSanPham() + " x " +
                   dsSanPham.get(key) + " = " + productManagement.searchById(key).getPriceSanPham() *
                   dsSanPham.get(key) + "\n";
        }
        return result;
    }

    public int getTotalPrice(){
        ProductManagement productManagement = ProductManagement.getProductManagement();
        int sumTotal = 0;
        for (String key: dsSanPham.keySet()
             ) {
            sumTotal += productManagement.searchById(key).getPriceSanPham() * dsSanPham.get(key);
        }
        return sumTotal;
    }





    @Override
    public String toString() {
        String result = "";
         result +=   "---Invoice---" + "\n" +
                "Invoice ID : " + idInvoice + "\n" +
                "Invoice Date: " + getDate() + "\n" +
                "Bill to: " + getNameCustomer() + "\n" +
                 "Detail: " + "\n" +
                 getIngormationProduct() + "\n" +
                 "Total Price = " +  getTotalPrice();
         return result;

    }
}

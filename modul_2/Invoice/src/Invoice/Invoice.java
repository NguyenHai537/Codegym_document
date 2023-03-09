package Invoice;

import java.util.Date;
import java.util.List;

public class Invoice {
    private String customerID;
    private Date date;
    private int invoiceID;
    private String productName;
    private double productPrice;
    private int productQuantity;
    private List<String> listProduct;


    public Invoice(){}

    public Invoice(String customerID, Date date, int invoiceID, String productName, double productPrice, int productQuantity) {
        this.customerID = customerID;
        this.date = date;
        this.invoiceID = invoiceID;
        this.productName = productName;
        this.productPrice = productPrice;
        this.productQuantity = productQuantity;
    }



}

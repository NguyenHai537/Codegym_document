package Invoice;

import Coach.Coach;
import Coach.CoachManagenment;
import Customer.Customer;
import Customer.CustomerManagement;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Invoice {
    private String invoiceId;
    private  String customerID;
    private Date invoiceDate;
    private Map<String,Integer> tripBill = new HashMap<String,Integer>();

    public Invoice(){}

    public Invoice(String invoiceId , String customerID){
        this.invoiceId = invoiceId;
        this.customerID= customerID;
        this.invoiceDate = new Date();
    }


    public void setInvoiceDate(Date invoiceDate) {
        this.invoiceDate = invoiceDate;
    }

    public Date getInvoiceDate() {
        return invoiceDate;
    }

    public String getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(String invoiceId) {
        this.invoiceId = invoiceId;
    }

    public String getCustomerID() {
        return customerID;
    }

    public void setCustomerID(String customerID) {
        this.customerID = customerID;
    }


    public void addHashMap(String coachID , int seatNumber){
        tripBill.put(coachID,seatNumber);
    }

    public void setTripBill(Map<String, Integer> tripBill) {
        this.tripBill = tripBill;
    }

    public String getStringDate(){
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        String strDate = formatter.format(getInvoiceDate());
        return strDate;
    }

    @Override
    public String toString() {
        String result = "";
        result +=   "----Invoice----" + "\n" +
                "|"+"Invoice ID : " + getInvoiceId() + "\n" +
                "|"+"Invoice Date: " + getStringDate() + "\n" +
                "|"+"Customer Information: " + getCustomerInformation() + "\n" +
                "|"+"Detail: " + "\n" +
                getInformationDetail() + "\n" +
                "|"+"Total Price = " +  getTotalPrice() + "\n";
        return result;

    }

    private double getTotalPrice() {
        CoachManagenment coachManagenment = CoachManagenment.getCoachManagenment();
         double total = 0;
        for (String key: tripBill.keySet()
             ) {
            total += coachManagenment.searchById(key).getPriceOfSeat() * tripBill.get(key);
        }
        return total;

    }

    private String getInformationDetail() {
        CoachManagenment coachManagenment = CoachManagenment.getCoachManagenment();
        String strInforCoach="";

        for (String key: tripBill.keySet()
             ) {
             Coach coach = coachManagenment.searchById(key);
             strInforCoach += "Tên xe: "+ coach.getName() + ", " +"Biển số xe: "+ coach.getLicensePlate()+", " + "Nơi xuất phát: "+ coach.getPlaceOfDeparture()+
                     ", " +"Nơi đến: "+ coach.getDestination()+ "," + "\n"+ coach.getPriceOfSeat() + " x " + tripBill.get(key) +
                     " = " + (coach.getPriceOfSeat() * tripBill.get(key)) + "\n";
        }
        return strInforCoach;
    }

    private String getCustomerInformation() {
        String customerInformation = "";
        CustomerManagement customerManagement = CustomerManagement.getCustomerManagement();
        Customer customer =customerManagement.searchByID(getCustomerID());
        customerInformation = customer.getName() + " - " + customer.getPhoneNumber() + " - " +
                customer.getAddress();
        return customerInformation;
    }

    public String getInformation(){
        String strInfor = "";
        CoachManagenment coachManagenment = CoachManagenment.getCoachManagenment();
        for (String key: tripBill.keySet()
             ) {
            strInfor += key+","+tripBill.get(key)+",";
        }
        return strInfor;
    }

    public String toFile(){
        return invoiceId+","+customerID+","+getInformation()+getStringDate();
    }


}

package Customer;

public class Customer {
    private String customerID;

    private String customerName;

    private String customerAge;

    private double customerWallet;

    public Customer() {
    }

    public Customer(String customerID, String customerName, String customerAge, double customerWallet) {
        this.customerID = customerID;
        this.customerName = customerName;
        this.customerAge = customerAge;
        this.customerWallet = customerWallet;
    }

    public String getCustomerID() {
        return customerID;
    }

    public void setCustomerID(String customerID) {
        this.customerID = customerID;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerAge() {
        return customerAge;
    }

    public void setCustomerAge(String customerAge) {
        this.customerAge = customerAge;
    }

    public double getCustomerWallet() {
        return customerWallet;
    }

    public void setCustomerWallet(double customerWallet) {
        this.customerWallet = customerWallet;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "customerID='" + customerID + '\'' +
                ", customerName='" + customerName + '\'' +
                ", customerAge='" + customerAge + '\'' +
                ", customerWallet=" + customerWallet +
                '}';
    }
}

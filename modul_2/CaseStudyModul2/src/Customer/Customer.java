package Customer;

public class Customer {
    private String customerID;

    private String phoneNumber;
    private String name;

    private String address;

    public Customer(){}

    public Customer(String customerID, String name,  String phoneNumber,String address) {
        this.customerID = customerID;
        this.phoneNumber = phoneNumber;
        this.name = name;
        this.address= address;

    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getCustomerID() {
        return customerID;
    }

    public void setCustomerID(String customerID) {
        this.customerID = customerID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "CustomerID='" + customerID + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                '}' + "\n";
    }

    public String toFile(){
        return customerID+","+name+","+phoneNumber+","+address;
    }
}

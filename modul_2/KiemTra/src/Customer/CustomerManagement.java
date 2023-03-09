package Customer;

import Store.Store;

import java.util.ArrayList;
import java.util.List;

public class CustomerManagement {

    private List<Customer> customers;


    private static final CustomerManagement customerManagement = new CustomerManagement();

    private CustomerManagement(){
        customers = new ArrayList<>();
    }

    public static CustomerManagement getCustomerManagement() {
        return customerManagement;
    }

    public List<Customer> getCustomers() {
        return customers;
    }

    public void  addCustomer(Customer customer){
        customers.add(customer);
    }

    public Customer searchById(String id){
        Customer result =null;
        for (Customer customer: customers
        ) {
            if ( customer.getCustomerID().equals(id)){
                result = customer;
            }
        }
        return result;
    }

    @Override
    public String toString() {
        return "CustomerManagement{" +
                "customers=" + customers +
                '}';
    }
}

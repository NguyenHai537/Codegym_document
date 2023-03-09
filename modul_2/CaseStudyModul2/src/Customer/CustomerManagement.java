package Customer;

import javax.imageio.IIOException;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CustomerManagement {
    private List<Customer> listCustomer;

    public static CustomerManagement customerManagement = new CustomerManagement();

    private CustomerManagement(){
        listCustomer = new ArrayList<>();
    }

    public List<Customer> getListCustomer() {
        return listCustomer;
    }

    public static CustomerManagement getCustomerManagement() {
        return customerManagement;
    }

    public void addCustomer(Customer customer){
        listCustomer.add(customer);
    }

    public Customer searchByID(String id){
        for (Customer customer: listCustomer
             ) {
            if ( customer.getCustomerID().equals(id)){
                return customer;
            }
        }
        return null;
    }

    public boolean removeCustomer(String id){
        Customer customer = customerManagement.searchByID(id);
        if( customer != null){
            listCustomer.remove(customer);
            return true;
        }else
            return false;
    }

    public boolean fixCustomer ( String id , String name , String phoneNumber , String address){
        Customer customer = customerManagement.searchByID(id);
        if ( customer != null){
            customer.setName(name);
            customer.setPhoneNumber(phoneNumber);
            customer.setAddress(address);

            return true;
        }else
            return false;
    }

    public List<Customer> searchByName( String name){
        List<Customer> listName = new ArrayList<>();
        for (Customer customer: listCustomer
             ) {
            if (customer.getName().equals(name)){
                listName.add(customer);
            }
        }
        return listName;
    }

    public void saveToFile(){
        String line;
        BufferedWriter bufferedWriter;
        try {
            File file = new File("CustomerSave.txt");
            bufferedWriter = new BufferedWriter(new FileWriter(file));
            for (Customer customer: listCustomer
                 ) {
                line = customer.toFile();
                bufferedWriter.write(line);
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public void readFile(){
        String line;
        BufferedReader bufferedReader;
        try {
            bufferedReader = new BufferedReader( new FileReader("CustomerSave.txt"));
            while ((line = bufferedReader.readLine()) != null){
                List<String> readCustomer = parseCsvLine(line);

                Customer customer = new Customer(readCustomer.get(0) , readCustomer.get(1), readCustomer.get(2),readCustomer.get(3));
                listCustomer.add(customer);

            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    private List<String> parseCsvLine(String cvsline) {
        List<String> listString = new ArrayList<>();
        if ( cvsline != null){
            String [] splitString = cvsline.split(",");
            int lenght = splitString.length;
            for (int i = 0 ; i < lenght ; i++){
                listString.add(splitString[i]);
            }
        }
        return listString;
    }

    public List<Customer> sortCustomerByName(){
        ComparatorCustomer comparatorCustomer = new ComparatorCustomer();
        listCustomer.sort(comparatorCustomer);
        return listCustomer;
    }

    @Override
    public String toString() {
        return
                "ListCustomer=" + listCustomer +
                '}';
    }
}

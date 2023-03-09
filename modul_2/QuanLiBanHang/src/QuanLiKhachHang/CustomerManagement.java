package QuanLiKhachHang;

import QuanLiSanPham.Product;

import javax.imageio.IIOException;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CustomerManagement {
    private ArrayList<Customer> listCustomer;

    private static CustomerManagement customerManagement = new CustomerManagement();

    private CustomerManagement(){
        listCustomer = new ArrayList<>();
    }

    public static CustomerManagement getCustomerManagement() {
        return customerManagement;
    }

    public static void setCustomerManagement(CustomerManagement customerManagement) {
        CustomerManagement.customerManagement = customerManagement;
    }

    public void addCustomer(Customer customer){
        listCustomer.add(customer);
    }

    public boolean fixCustomer(String id,String newId, String name, String address,int age){
        for (Customer customer: listCustomer
        ) {
            if ( customer.getId().equals(id)){
                customer.setId(newId);
                customer.setName(name);
                customer.setAddress(address);
                customer.setAge(age);
                return true;
            }
        }
        return false;
    }

    public boolean removeCustomer( String id){
        for (Customer customer: listCustomer
             ) {
            if ( customer.getId().equals(id)){
                listCustomer.remove(customer);
                return true;
            }
        }
        return false;
    }
    public Customer searchById( String id){
        for (Customer customer: listCustomer
             ) {
            if (customer.getId().equals(id)){
                return customer;

            }
        }
        return null;
    }

    public List<Customer> searchByName(String name){
        List<Customer> list = new ArrayList<>();
        for (Customer customer: listCustomer
             ) {
            if ( customer.getName().equals(name)){
                list.add(customer);
            }
        }
        return list;
    }

    public void saveToFile() {
        String line;
        BufferedWriter bufferedWriter;
        try {
            File file = new File("CustomerSave.txt");
            bufferedWriter = new BufferedWriter(new FileWriter(file));

            for (Customer customer : listCustomer
            ) {
                line = customer.toFile();
                bufferedWriter.write(line);
                bufferedWriter.newLine();
            }

            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public  void readCustomer(){
        try {
            String line;
            BufferedReader bufferedReader = new BufferedReader(new FileReader("CustomerSave.txt"));
            while ((line = bufferedReader.readLine()) != null){
                List<String> readCustomer = parseCsvLine(line);
                Customer customer = new Customer(readCustomer.get(0),readCustomer.get(1), Integer.parseInt(readCustomer.get(3)),readCustomer.get(2));
                customerManagement.addCustomer(customer);
            }
            bufferedReader.close();

        }catch (Exception e){
            e.printStackTrace();
        }

    }

    public static List<String> parseCsvLine(String csvLine){
        List<String> result = new ArrayList<>();
        if ( csvLine != null){
            String [] split  = csvLine.split(",");
            int length = split.length;
            for (int i = 0; i < split.length; i++) {
                result.add(split[i]);
            }
        }
        return result;
    }


    @Override
    public String toString() {
        return "CustomerManagement{" +
                "listCustomer=" + listCustomer +
                '}';
    }
}

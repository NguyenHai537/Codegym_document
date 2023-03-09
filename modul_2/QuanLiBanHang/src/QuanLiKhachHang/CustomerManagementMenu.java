package QuanLiKhachHang;

import java.util.Scanner;

public class CustomerManagementMenu {

    public CustomerManagementMenu(){}

    Scanner sc = new Scanner(System.in);
    CustomerManagement customerManagement = CustomerManagement.getCustomerManagement();

   public void menu(){
       int choice = 0;
       do {
           System.out.println("-------Menu Customer-------");
           System.out.println("1. Add Customer");
           System.out.println("2. Remove Customer by Id");
           System.out.println("3. Fix Customer");
           System.out.println("4. Search Customer By ID");
           System.out.println("5. Search Customer By Name");
           System.out.println("6. Display List Customer");
           System.out.println("7. Save to file Customer");
           System.out.println("0. Exit");
           System.out.println("Enter your choice: ");
            choice = sc.nextInt();sc.nextLine();

           switch (choice){
               case 1 ->addCustomer();
               case 2 ->removeCustomer();
               case 3 ->fixCustomer();
               case 4 ->searchCustomerById();
               case 5 ->searchCustomerByName();
               case 6 ->displayCustomer();
               case 7 ->saveToFile();
               default -> System.out.println("Your choice not found!");
           }


       }while (choice!=0);
   }

    private void saveToFile() {
       customerManagement.saveToFile();
    }

    private void displayCustomer() {
        System.out.println(customerManagement);
    }

    private void searchCustomerByName() {
        System.out.println("Enter a name want search: ");
        String name = sc.nextLine();

        System.out.println(customerManagement.searchByName(name));
    }

    private void searchCustomerById() {
        System.out.println("Enter Id want search: ");
        String id = sc.nextLine();

        System.out.println(customerManagement.searchById(id));
    }

    private void fixCustomer() {
        System.out.println("Enter Id Customer you want fix:");
        String id = sc.nextLine();
        System.out.println("Enter new Id  you want fix:");
        String newId = sc.nextLine();
        System.out.println("Enter new Name  you want fix:");
        String newName = sc.nextLine();
        System.out.println("Enter new Address you want fix:");
        String newAddress = sc.nextLine();
        System.out.println("Enter new Age you want fix:");
        int newAge = sc.nextInt();sc.nextLine();

        customerManagement.fixCustomer(id,newId,newName,newAddress,newAge);

    }

    private void removeCustomer() {
        System.out.println("Enter ID customer:");
        String id = sc.nextLine();

        customerManagement.removeCustomer(id);

    }

    private void addCustomer() {
        System.out.println("Enter Id Customer:");
        String id = sc.nextLine();
        while (customerManagement.searchById(id) !=null){
            System.out.println("Id đã tồn tại.Vui lòng nhập lại: ");
            id = sc.nextLine();
        }
        System.out.println("Enter Name Customer :");
        String name = sc.nextLine();
        System.out.println("Enter Address Customer:");
        String address = sc.nextLine();
        System.out.println("Enter Age Customer:");
        int age = sc.nextInt();sc.nextLine();

        Customer customer = new Customer(id ,name,age,address);

        customerManagement.addCustomer(customer);

    }
}

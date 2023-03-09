package Customer;

import Store.Store;
import Store.StoreManagement;

import java.util.Scanner;

public class CustomerManagementMenu {
    Scanner sc = new Scanner(System.in);

    CustomerManagement customerManagement = CustomerManagement.getCustomerManagement();

    public  void menu(){
        int choice = 0;
        do {
            System.out.println("------Customer------");
            System.out.println("1. Add Customer");
            System.out.println("2. Display List Customer");
            System.out.println("0. Exit");
            System.out.println("Enter your choice: ");
            choice = sc.nextInt();sc.nextLine();

            switch(choice){
                case 1 -> menuAddCustomer();
                case 2 -> menuDisplay();
                default ->  {
                    if ( choice !=0){
                        System.out.println("Lựa chọn của bạn chưa đúng. Vui lòng nhập lại: ");
                    }
                }
            }

        }while (choice!=0);
    }

    private void menuDisplay() {
        System.out.println(customerManagement);
    }

    private void menuAddCustomer() {
        System.out.println("Nhập ID Customer: ");
        String customerID = sc.nextLine();
        while (checkID(customerID)){
            System.out.println("ID đã tồn tại! Vui lòng nhập lại ID mới:");
            customerID = sc.nextLine();
        }

        System.out.println("Nhập tên khách hàng: ");
        String customerName = sc.nextLine();
        System.out.println("Nhập tuổi: ");
        String customerAge = sc.nextLine();
        System.out.println("Nhập số tiền trong tài khoản: ");
        double customerTotalMoney = sc.nextDouble();sc.nextLine();
        while (customerTotalMoney <0){
            System.out.println("Số tiền nhập không hợp lệ. Vui lòng nhập lại:");
            customerTotalMoney = sc.nextDouble();sc.nextLine();
        }

        Customer customer = new Customer(customerID,customerName,customerAge,customerTotalMoney);
        customerManagement.addCustomer(customer);

    }

    private boolean checkID(String customerID) {
        Customer customer =customerManagement.searchById(customerID);
        if ( customer!= null){
            return true;
        }else
            return false;
    }
}

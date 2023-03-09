import QuanLiHoaDon.Invoice;
import QuanLiHoaDon.InvoiceManagementMenu;
import QuanLiKhachHang.CustomerManagement;
import QuanLiKhachHang.CustomerManagementMenu;
import QuanLiSanPham.ProductManagementMenu;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws ParseException {
        Scanner sc = new Scanner(System.in);
        ProductManagementMenu productManagementMenu = new ProductManagementMenu();
        CustomerManagementMenu customerManagementMenu = new CustomerManagementMenu();
        InvoiceManagementMenu invoiceManagementMenu = new InvoiceManagementMenu();
        CustomerManagement customerManagement = CustomerManagement.getCustomerManagement();
        customerManagement.readCustomer();


        int choice = 0;
        do {

            System.out.println("----Menu----");
            System.out.println("1. Menu Product");
            System.out.println("2. Menu Customer");
            System.out.println("3. Menu Invoice");
            System.out.println("0. Exit");
            System.out.println("Enter your choice: ");
             choice = sc.nextInt();

             switch (choice){
                 case 1 -> productManagementMenu.menu();
                 case 2 -> customerManagementMenu.menu();
                 case 3 -> invoiceManagementMenu.menu();
                 default -> System.out.println("Your choice not found!");
             }

        }while (choice !=0);



    }




}
import Customer.CustomerManagement;
import Customer.CustomerManagementMenu;
import Product.ProductManagement;
import Product.ProductManagementMenu;
import Shopping.ShoppingMenu;
import Store.StoreManagement;
import Store.StoreManagementMenu;

import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        StoreManagementMenu storeManagementMenu = new StoreManagementMenu();
        CustomerManagementMenu customerManagementMenu = new CustomerManagementMenu();
        ProductManagementMenu productManagementMenu = new ProductManagementMenu();
        ShoppingMenu shoppingMenu = new ShoppingMenu();

        int choice;
        do {
            System.out.println("========MENU========");
            System.out.println("1. Menu Customer");
            System.out.println("2. Menu Product");
            System.out.println("3. Menu Store");
            System.out.println("4. Go to the shopping");
            System.out.println("0. Exit");
            System.out.println("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1 -> customerManagementMenu.menu();
                case 2 -> productManagementMenu.menu();
                case 3 -> storeManagementMenu.menu();
                case 4 -> shoppingMenu.shopping();
                default -> {
                    if (choice != 0) {
                        System.out.println("Lựa chọn của bạn chưa đúng. Vui lòng nhập lại!");
                    }
                }
            }
        } while (choice != 0);
    }
}
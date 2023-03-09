import Coach.CoachManagementMenu;
import Coach.CoachManagenment;
import Customer.CustomerManagement;
import Customer.CustomerManagementMenu;
import Customer.ValidatePhone;
import Invoice.InvoiceManagement;
import Invoice.InvoiceManagementMenu;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        CoachManagementMenu coachManagementMenu = new CoachManagementMenu();
        CustomerManagementMenu customerManagementMenu = new CustomerManagementMenu();
        InvoiceManagementMenu invoiceManagementMenu = new InvoiceManagementMenu();

        int choice;
        do {
            System.out.println("========MENU========");
            System.out.println("1. Menu Coach");
            System.out.println("2. Menu Customer");
            System.out.println("3. Menu Invoice");
            System.out.println("0. Exit");
            System.out.println("Enter your choice: ");
            choice = sc.nextInt();sc.nextLine();

            switch (choice){
                case 1-> coachManagementMenu.menu();
                case 2-> customerManagementMenu.menu();
                case 3-> invoiceManagementMenu.menu();
                default -> {
                        if ( choice !=0){
                            System.out.println("Lựa chọn của bạn chưa đúng. Vui lòng nhập lại!");
                        }
                    }
                }
        }while (choice!=0);

    }
}
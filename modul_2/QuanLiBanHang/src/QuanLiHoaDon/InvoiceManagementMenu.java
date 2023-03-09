package QuanLiHoaDon;

import java.util.Scanner;

public class InvoiceManagementMenu {

    Scanner sc = new Scanner(System.in);
    InvoiceManagement invoiceManagement = InvoiceManagement.getInvoiceManagement();

    public InvoiceManagementMenu(){}

    public void menu(){
        int choice = 0;
        do {
            System.out.println("------Menu Invoice------");
            System.out.println("1. Add Invoice");
            System.out.println("2. Remove Invoice");
            System.out.println("3. Search Invoice By Id");
            System.out.println("4. Display List Invoice");
            System.out.println("0. Exit");
            System.out.println("Enter your choice: ");
            choice = sc.nextInt();sc.nextLine();

            switch (choice){
                case 1 -> addInvoice();
                case 2 -> removeInvoice();
                case 3 -> searchInvoice();
                case 4 -> display();
                default -> System.out.println("Your choice not found!");
            }

        }while (choice !=0);
    }

    private void addInvoice() {
        System.out.println("Enter Id Invoice: ");
        int idInvoice = sc.nextInt();sc.nextLine();
        System.out.println("Enter ID Customer:");
        String idCustomer = sc.nextLine();
        System.out.println("Nhập số lượng món hàng muốn mua: ");
        int number = sc.nextInt();sc.nextLine();
        Invoice invoice = new Invoice(idInvoice , idCustomer);
        for (int i = 0 ; i < number ; i++){
            System.out.println("Nhập ID sản phẩm thứ " + (i+1) +":");
            String idsanpham = sc.nextLine();
            System.out.println("Nhập số lượng sản phẩm muốn : ");
            Integer sl = sc.nextInt();sc.nextLine();
            invoice.addSp(idsanpham , sl);
        }

        invoiceManagement.addInvoice(invoice);
    }

    private void removeInvoice() {
        System.out.println("Enter ID Invoice");
        int idInvoice = sc.nextInt();

        invoiceManagement.removeInvoice(idInvoice);
    }

    private void searchInvoice() {
        System.out.println("Enter ID Invoice");
        int idInvoice = sc.nextInt();

        invoiceManagement.searchInvoice(idInvoice);

    }

    private void display() {
        System.out.println(invoiceManagement);

    }

}

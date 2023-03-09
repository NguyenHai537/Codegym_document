package Product;

import Customer.Customer;
import Customer.CustomerManagement;

import java.util.Scanner;

public class ProductManagementMenu {
    Scanner sc = new Scanner(System.in);

    ProductManagement productManagement = ProductManagement.getProductManagement();

    public  void menu(){
        int choice = 0;
        do {
            System.out.println("------Product------");
            System.out.println("1. Add Product");
            System.out.println("2. Display List Product");
            System.out.println("0. Exit");
            System.out.println("Enter your choice: ");
            choice = sc.nextInt();sc.nextLine();

            switch(choice){
                case 1 -> menuAddProduct();
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
        System.out.println(productManagement);
    }

    private void menuAddProduct() {
        System.out.println("Nhập ID Product: ");
        String productID = sc.nextLine();
        while (checkID(productID)){
            System.out.println("ID đã tồn tại! Vui lòng nhập lại ID mới:");
            productID = sc.nextLine();
        }

        System.out.println("Nhập tên sản phẩm: ");
        String productName = sc.nextLine();
        System.out.println("Nhập giá sản phẩm: ");
        double productPrice = sc.nextDouble();sc.nextLine();
        while (productPrice <0){
            System.out.println("Số tiền nhập không hợp lệ. Vui lòng nhập lại:");
            productPrice = sc.nextDouble();sc.nextLine();
        }
        System.out.println("Nhập số lượng sản phẩm: ");
        int productQuantity = sc.nextInt();sc.nextLine();
        while (productQuantity <0){
            System.out.println("Số lượng nhập không hợp lệ. Vui lòng nhập lại:");
            productQuantity = sc.nextInt();sc.nextLine();
        }

        System.out.println("Nhập ID Store: ");
        String storeID = sc.nextLine();
        while (checkID(storeID)){
            System.out.println("ID đã tồn tại! Vui lòng nhập lại ID mới:");
            storeID = sc.nextLine();
        }

        Product product = new Product(productID,productName,productPrice,productQuantity,storeID);
        productManagement.addProduct(product);
    }

    private boolean checkID(String productID) {
        Product product =productManagement.searchById(productID);
        if ( product!= null){
            return true;
        }else
            return false;
    }
}

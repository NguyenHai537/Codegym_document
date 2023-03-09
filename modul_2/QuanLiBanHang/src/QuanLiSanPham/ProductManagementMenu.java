package QuanLiSanPham;

import java.util.Scanner;

public class ProductManagementMenu {

    public ProductManagementMenu(){}

    ProductManagement productManagement = ProductManagement.getProductManagement();

    Scanner sc = new Scanner(System.in);

    public void menu(){
        int choice = 0;
        do {
            System.out.println("--------Menu Product--------");
            System.out.println("1. Add product");
            System.out.println("2. Remove  product");
            System.out.println("3. Fix product");
            System.out.println("4. Search product by name");
            System.out.println("5. Sort Product Increase By Price");
            System.out.println("6. SortProductDecreaseByPrice");
            System.out.println("7. Display list product");
            System.out.println("0. Exit");
            System.out.println("Enter your choice: ");
            choice = sc.nextInt();sc.nextLine();

            switch (choice){
                case 1 -> addproduct();
                case 2 -> removeproduct();
                case 3 -> fixproduct();
                case 4 -> searchproduct();
                case 5 -> sortproductIncrese();
                case 6 -> sortproductDecrese();
                case 7 -> displayproduct();
                default -> System.out.println("Your choice not found!");

            }

        }while (choice!=0);


    }

    private void displayproduct() {
        productManagement.display();
    }

    private void sortproductDecrese() {
        productManagement.sortProductDecreaseByPrice();
    }

    private void sortproductIncrese() {
        productManagement.sortProductIncreaseByPrice();
    }

    private void searchproduct() {
        System.out.println("Enter product name you want search:");
        String nameSearach = sc.nextLine();

        productManagement.searchByName(nameSearach);


    }

    private void fixproduct() {
        System.out.println("Enter product ID:");
        String productID = sc.nextLine();
        System.out.println("Enter ID want fix:");
        String sanphamFix = sc.nextLine();
        System.out.println("Enter name want fix:");
        String nameFix = sc.nextLine();
        System.out.println("Enter price want fix:");
        int priceFix = sc.nextInt();sc.nextLine();

        productManagement.fixProduct(productID,sanphamFix,nameFix,priceFix);
    }

    private void removeproduct() {
        System.out.println("Enter product ID:");
        String productID = sc.nextLine();

        productManagement.removeProduct(productID);
    }

    private void addproduct() {
        System.out.println("Enter number product in list:");
        String productID = sc.nextLine();
        System.out.println("Enter the ID product :");
        String sanpham = sc.nextLine();
        System.out.println("Enter a name product :");
        String name = sc.nextLine();
        System.out.println("Enter a price product:");
        int price = sc.nextInt();sc.nextLine();

        Product product = new Product(productID,sanpham,name,price);

        productManagement.addProduct(product);
    }
}

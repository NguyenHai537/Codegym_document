package Store;

import Product.Product;
import Product.ProductManagement;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StoreManagementMenu {

    Scanner sc = new Scanner(System.in);

    ProductManagement productManagement = ProductManagement.getProductManagement();

    StoreManagement storeManagement = StoreManagement.getStoreManagement();

    public  void menu(){
        int choice = 0;
        do {
            System.out.println("------Cuong Store------");
            System.out.println("1. Add Coach");
            System.out.println("2. Display List Coach");
            System.out.println("3. List Product of Store");
            System.out.println("0. Exit");
            System.out.println("Enter your choice: ");
            choice = sc.nextInt();sc.nextLine();

            switch(choice){
                case 1 -> menuAdd();
                case 2 -> menuDisplay();
                case 3 -> listProduct();
                default ->  {
                    if ( choice !=0){
                        System.out.println("Lựa chọn của bạn chưa đúng. Vui lòng nhập lại: ");
                    }
                }
            }

        }while (choice!=0);
    }

    private void listProduct() {
        System.out.println("Nhập ID Store cần xem sản phẩm: ");
        String storeID = sc.nextLine();
        while (checkID(storeID)){
            System.out.println("ID đã tồn tại! Vui lòng nhập lại ID mới:");
            storeID = sc.nextLine();
        }
        List<Product> products = new ArrayList<>();
        for (Product product: productManagement.getProduct()
             ) {
            if (product.getStoreID().equals(storeID)){
                products.add(product);
            }
        }

        System.out.println(products);

    }

    private void menuDisplay() {
        System.out.println(storeManagement);
    }

    private void menuAdd() {
        System.out.println("Nhập ID Store: ");
        String storeID = sc.nextLine();
        while (checkID(storeID)){
            System.out.println("ID đã tồn tại! Vui lòng nhập lại ID mới:");
            storeID = sc.nextLine();
        }
        
        System.out.println("Nhập tên cửa hàng: ");
        String storeName = sc.nextLine();
        System.out.println("Nhập chủ cửa hàng: ");
        String storeOwner = sc.nextLine();
        System.out.println("Nhập tổng tiền của cửa hàng: ");
        double storeTotalMoney = sc.nextDouble();sc.nextLine();
        while (storeTotalMoney <0){
            System.out.println("Số tiền nhập không hợp lệ. Vui lòng nhập lại:");
            storeTotalMoney = sc.nextDouble();sc.nextLine();
        }

        Store store = new Store(storeID,storeName,storeOwner,storeTotalMoney);
        storeManagement.addStore(store);
    }

    private boolean checkID(String storeID) {
            Store store =storeManagement.searchById(storeID);
            if ( store!= null){
                return true;
            }else
                return false;
        }



}

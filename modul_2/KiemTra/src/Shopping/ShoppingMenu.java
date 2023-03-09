package Shopping;

import Customer.Customer;
import Customer.CustomerManagement;
import Product.Product;
import Product.ProductManagement;
import Store.Store;
import Store.StoreManagement;

import java.util.Scanner;

public class ShoppingMenu {

    Scanner sc = new Scanner(System.in);

    CustomerManagement customerManagement = CustomerManagement.getCustomerManagement();
    ProductManagement productManagement = ProductManagement.getProductManagement();
    StoreManagement storeManagement = StoreManagement.getStoreManagement();

    public  void shopping(){

        int choice = 0;
        do {
            System.out.println("------Shopping------");
            System.out.println("1. Go to shopping");
            System.out.println("0. Exit");
            choice = sc.nextInt();sc.nextLine();

            switch(choice){
                case 1 -> goToShopping();
                default ->  {
                    if ( choice !=0){
                        System.out.println("Lựa chọn của bạn chưa đúng. Vui lòng nhập lại: ");
                    }
                }
            }

        }while (choice!=0);

    }

    private void goToShopping() {
        System.out.println("Nhập ID sản phẩm muốn : ");
        String productID = sc.nextLine();



        System.out.println("Nhập số lượng muốn : ");
        int quantity = sc.nextInt();sc.nextLine();

        System.out.println("Nhập ID khách hàng: ");
        String customerID = sc.nextLine();

        if (customerManagement.searchById(customerID).getCustomerWallet() <= 0){
            System.out.println("Số tiền trong tài khoản không đủ. Không thể thực hiện thanh toán!");
        }else {
            Product product = productManagement.searchById(productID);
            product.setProductQuantity(product.getProductQuantity() - quantity);
            Customer customer = customerManagement.searchById(customerID);
            customer.setCustomerWallet(customer.getCustomerWallet() - product.getProductPrice());
            Store store = storeManagement.searchById(product.getStoreID());
            store.setStoreTotalMoney(store.getStoreTotalMoney() + product.getProductPrice());
            System.out.println("Thanh toán thành công");
        }
    }

}

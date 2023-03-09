package Customer;

import java.util.List;
import java.util.Scanner;

public class CustomerManagementMenu {
    Scanner sc = new Scanner(System.in);
    CustomerManagement customerManagement = CustomerManagement.getCustomerManagement();

    public CustomerManagementMenu(){
        customerManagement.readFile();
    }

    public void menu(){
        int choice = 0;
        do {
            System.out.println("------Menu Customer------");
            System.out.println("1. Add Customer");
            System.out.println("2. Remove Customer By ID");
            System.out.println("3. Fix Customer By ID");
            System.out.println("4. Search Customer By ID");
            System.out.println("5. Search Customer By Name");
            System.out.println("6. Save to File");
            System.out.println("7. Sort Customer By Name");
            System.out.println("8. Display List Customer");
            System.out.println("0. Exit");
            System.out.println("Enter your choice:");
            choice = sc.nextInt();sc.nextLine();

            switch (choice){
                case 1 -> menuAdd();
                case 2 -> menuRemove();
                case 3 -> menuFix();
                case 4 -> menuSearchById();
                case 5 -> menuSearchbyName();
                case 6 -> menuSaveToFile();
                case 7 -> menuSortByName();
                case 8 -> menuDisplay();
                default ->  {
                    if ( choice !=0){
                        System.out.println("Lựa chọn của bạn chưa đúng. Vui lòng nhập lại: ");
                    }
                }
            }

        }while (choice !=0);
    }

    private void menuSortByName() {
        System.out.println(customerManagement.sortCustomerByName());
    }

    private void menuDisplay() {
        System.out.println(customerManagement);
    }

    private void menuSaveToFile() {
        customerManagement.saveToFile();
    }

    private void menuSearchbyName() {
        System.out.println("Nhập tên cần tìm kiếm: ");
        String name = sc.nextLine();
        if(menucheckName(name)){
            System.out.println(customerManagement.searchByName(name));
        }else
            System.out.println("Tên bạn nhập không tồn tại!");

    }

    private boolean menucheckName(String name) {
        List<Customer> lists = customerManagement.searchByName(name);
        for (Customer customer: lists
             ) {
            if ( customer.getName().equals(name)){
                return true;
            }
        }
        return false;
    }

    private void menuSearchById() {
        System.out.println("Nhập ID cần tìm kiếm: ");
        String id = sc.nextLine();
        Customer customer = customerManagement.searchByID(id);
        if (customer != null){
            System.out.println(customer);
        }else
            System.out.println("ID không tồn tại!");
    }

    private void menuFix() {
        System.out.println("Nhập ID Customer muốn sửa: ");
        String idFix = sc.nextLine();
        Customer customer = customerManagement.searchByID(idFix);
        if ( customer !=null){
            System.out.println("Nhập tên mới: ");
            String newName = sc.nextLine();
            System.out.println("Nhập số điện thoại mới: ");
            String newPhoneNumber = sc.nextLine();
            newPhoneNumber = checkPhoneNumber(newPhoneNumber);
            System.out.println("Nhập địa chỉ: ");
            String newAddress = sc.nextLine();


            customer.setName(newName);
            customer.setPhoneNumber(newPhoneNumber);
            customer.setAddress(newAddress);


            System.out.println("Đã sửa xong");

        }else
            System.out.println("ID không tồn tại");

    }

    private String checkPhoneNumber(String phoneNumber) {
        String result;
        boolean isPhoneNumber = checkValidate(phoneNumber);
        while (!isPhoneNumber){
            System.out.println("Số điện thoại bạn nhập chưa đúng!");
            System.out.println("Vui lòng nhập lại theo hướng dẫn sau: ");
            System.out.println("VD: 0Yxxxxxxxx hoặc 0Yxxxxxxxxx");
            System.out.println("Với Y: là các số 9,8,7,3,2,6");
            System.out.println("Với x: gồm 8 hoặc 9 chữ số từ 0-9");
            phoneNumber = sc.nextLine();
            isPhoneNumber =checkValidate(phoneNumber);
        }
        result = phoneNumber;
        return result;
    }

    private boolean checkValidate(String regex) {
        ValidatePhone validatePhone = new ValidatePhone();
        return validatePhone.validate(regex);
    }

    private void menuRemove() {
        System.out.println("Nhập ID Customer muốn xóa: ");
        String id = sc.nextLine();
        if ( checkID(id)){
            customerManagement.removeCustomer(id);
        }else
            System.out.println("ID không tồn tại!");
    }

    private boolean checkID(String id) {
        Customer customer = customerManagement.searchByID(id);
        if ( customer != null){
            return true;
        }else
            return false;
    }

    private void menuAdd() {
        System.out.println("Nhập ID Customer:");
        String id = sc.nextLine();
        while (checkID(id)){
            System.out.println("ID đã tồn tại. Vui lòng nhập lại: ");
            id = sc.nextLine();
        }
        System.out.println("Nhập tên:");
        String name = sc.nextLine();
        System.out.println("Nhập số điện thoại:");
        String phone = sc.nextLine();
        phone = checkPhoneNumber(phone);
        boolean isExist = checkExist(phone);
        while (isExist){
            System.out.println("Số điện thoại đã tồn tại. Vui lòng nhập lại: ");
            phone = sc.nextLine();
            phone = checkPhoneNumber(phone);
            isExist =checkExist(phone);

        }
        System.out.println("Nhập địa chỉ:");
        String address = sc.nextLine();


        Customer customer = new Customer(id, name,phone,address);
        customerManagement.addCustomer(customer);
    }



    private boolean checkExist(String phone) {
        for (Customer customer: customerManagement.getListCustomer()
             ) {
           if(customer.getPhoneNumber().equals(phone)){
               return true;
           }
        }
        return false;
    }
}

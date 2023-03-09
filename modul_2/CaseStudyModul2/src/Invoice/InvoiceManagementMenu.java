package Invoice;

import Coach.Coach;
import Coach.CoachManagenment;
import Customer.Customer;
import Customer.CustomerManagement;

import java.util.Date;
import java.util.Scanner;

public class InvoiceManagementMenu {
    InvoiceManagement invoiceManagement = InvoiceManagement.getInvoiceManagement();
    Scanner sc = new Scanner(System.in);

    public InvoiceManagementMenu(){
        invoiceManagement.readFile();
    }

    public void menu(){
        int choice;
        do {
            System.out.println("-----Menu Invoice-----");
            System.out.println("1. Add Invoice");
            System.out.println("2. Remove Invoice By ID");
            System.out.println("3. Fix Invoice By ID");
            System.out.println("4. Search Invoice By ID");
            System.out.println("5. Save to File");
            System.out.println("6. Display List Invoice");
            System.out.println("0. Exit");
            System.out.println("Enter your choice: ");
            choice = sc.nextInt();sc.nextLine();

            switch (choice){
                case 1 -> menuAdd();
                case 2 -> menuRemove();
                case 3 -> menuFix();
                case 4 -> menuSearch();
                case 5 -> menuSaveToFile();
                case 6 -> menuDisplay();
                default ->  {
                    if ( choice !=0){
                        System.out.println("Lựa chọn của bạn chưa đúng. Vui lòng nhập lại!");
                    }
                }
            }
            CoachManagenment.getCoachManagenment().saveToFile();

        }while (choice!=0);
    }


    private void menuDisplay() {
        System.out.println(invoiceManagement);
    }

    private void menuSaveToFile() {
        invoiceManagement.savetoFile();
    }

    private void menuSearch() {
        System.out.println("Nhập ID Invoice cần tìm kiếm: ");
        String id = sc.nextLine();
        Invoice invoice = invoiceManagement.searchInvoiceByID(id);

        if ( invoice != null){
            System.out.println(invoice);
        }else
            System.out.println("ID không tồn tại!");

    }

    private void menuFix() {
        System.out.println("Nhập ID Invoice muốn sửa: ");
        String idInvoice = sc.nextLine();
        Invoice invoice = invoiceManagement.searchInvoiceByID(idInvoice);
        Date newDate = new Date();
        invoice.setInvoiceDate(newDate);

    }


    private void menuRemove() {
        System.out.println("Nhập ID Invoice muốn xóa: ");
        String id = sc.nextLine();

        if(invoiceManagement.removeInvoiceByID(id)){
            System.out.println("Đã xóa xong");
        }else
            System.out.println("ID không tồn tại!");
    }

    private boolean checkIDInvoice(String id) {
        Invoice invoice = invoiceManagement.searchInvoiceByID(id);
        if ( invoice != null){
            return true;
        }
        return false;
    }

    private void menuAdd() {
        CoachManagenment coachManagenment  = CoachManagenment.getCoachManagenment();
        System.out.println("Nhập ID Invoice: ");
        String idInvoice = sc.nextLine();
        while (checkIDInvoice(idInvoice)){
            System.out.println("ID đã tồn tại. Vui lòng nhập lại ID mới: ");
            idInvoice = sc.nextLine();
            checkIDInvoice(idInvoice);
        }
        System.out.println("Nhập ID Customer: ");
        String idCustomer = sc.nextLine();
        while (!chechIDCustomer(idCustomer)){
            System.out.println("ID Customer không tồn tại. Vui lòng nhập lại: ");
            idCustomer = sc.nextLine();
            chechIDCustomer(idCustomer);
        }
        Invoice invoice = new Invoice(idInvoice,idCustomer);
        int choiceNumber;
        do {
            System.out.println("Nhập ID Coach: ");
            String idCoach = sc.nextLine();
            while (!checkIdCoach(idCoach) || getSeat(idCoach) ==0){
                if (!checkIdCoach(idCoach)){
                    System.out.println("ID Coach không tồn tại.Vui lòng nhập lại: ");
                    idCoach=sc.nextLine();
                    checkIdCoach(idCoach);
                }
                if (getSeat(idCoach) ==0){
                    System.out.println("Xe đã hết chỗ nhập xe khác. ");
                    idCoach = sc.nextLine();
                    checkIdCoach(idCoach);
                }
            }

            System.out.println("Nhập số lượng ghế muốn đặt: ");
            int numberSeat = sc.nextInt();sc.nextLine();
            while (!checkExistSeat(idCoach,numberSeat)){
                System.out.println("Số lượng ghế bạn đặt vượt quá số chỗ còn trống. Vui lòng nhập lại");
                numberSeat = sc.nextInt();sc.nextLine();
                checkExistSeat(idCoach,numberSeat);
            }
            invoice.addHashMap(idCoach,numberSeat);
            updateSeat(idCoach,numberSeat);

            System.out.println("Bạn có muốn tiếp tục đặt vé không?");
            System.out.println("Có: nhấn 1/ Không: nhấn 0");
             choiceNumber = sc.nextInt();sc.nextLine();
        }while (choiceNumber !=0);

        invoiceManagement.addInvoice(invoice);
    }

    private int getSeat(String idCoach) {
       return CoachManagenment.getCoachManagenment().searchById(idCoach).getSeat();
    }

    private void updateSeat(String id,int numberSeat) {
        int seat = CoachManagenment.getCoachManagenment().searchById(id).getSeat();
        CoachManagenment.getCoachManagenment().searchById(id).setSeat(seat -numberSeat);
    }

    private boolean chechIDCustomer(String id) {
         Customer customer = CustomerManagement.getCustomerManagement().searchByID(id);
         if ( customer != null){
             return true;
         }else
             return false;
    }

    private boolean checkExistSeat(String idCoach , int seatNumber) {
        Coach coach = CoachManagenment.getCoachManagenment().searchById(idCoach);
        if ( coach.getSeat() == 0){

        }
        if ( coach.getSeat() >0 && seatNumber < coach.getSeat()){
            return true;
        }
        return false;
    }

    private boolean checkIdCoach(String id) {
        Coach coach= CoachManagenment.getCoachManagenment().searchById(id);
         if ( coach != null){
             return true;
         }
         return false;
    }


}


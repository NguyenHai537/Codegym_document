package Coach;

import java.util.Scanner;

public class CoachManagementMenu {
    Scanner sc = new Scanner(System.in);
    CoachManagenment coachManagenment = CoachManagenment.getCoachManagenment();
    public  CoachManagementMenu(){
        coachManagenment.readFile();
    }

    public  void menu(){
        int choice = 0;
        do {
            System.out.println("------Menu Coach------");
            System.out.println("1. Add Coach");
            System.out.println("2. Remove Coach By ID");
            System.out.println("3. Fix Coach By ID");
            System.out.println("4. Search Coach By ID");
            System.out.println("5. Sort Coach Increase By Price");
            System.out.println("6. Sort Coach Decrease By Price");
            System.out.println("7. Save to File");
            System.out.println("8. Display List Coach");
            System.out.println("0. Exit");
            System.out.println("Enter your choice: ");
            choice = sc.nextInt();sc.nextLine();

            switch(choice){
                case 1 -> menuAdd();
                case 2 -> menuRemove();
                case 3 -> menuFix();
                case 4 -> menuSearch();
                case 5 -> menuSortIncrease();
                case 6 -> menuSortDecrease();
                case 7 -> menuSavetoFile();
                case 8 -> menuDisplay();
                default ->  {
                    if ( choice !=0){
                        System.out.println("Lựa chọn của bạn chưa đúng. Vui lòng nhập lại: ");
                    }
                }
            }

        }while (choice!=0);
    }

    private void menuDisplay() {
        System.out.println(coachManagenment);
    }

    private void menuSavetoFile() {
        coachManagenment.saveToFile();
        System.out.println("Đã lưu File thành công");
    }

    private void menuSortDecrease() {
        System.out.println(coachManagenment.sortCoachDecreaseByPrice());
    }

    private void menuSortIncrease() {
        System.out.println(coachManagenment.sortCoachIncreaseByPrice());
    }

    private void menuSearch() {
        System.out.println("Nhập ID Coach muốn tìm kiếm: ");
        String coachID = sc.nextLine();
        Coach coach = coachManagenment.searchById(coachID);

        if ( coach != null){
            System.out.println(coach);
        }else
            System.out.println("ID Coach không tồn tại!");
    }

    private void menuFix() {
        System.out.println("Nhập ID Coach muốn thay đổi: ");
        String coachID = sc.nextLine();

        if ( checkID(coachID)){
            System.out.println("Nhập tên mới: ");
            String newName = sc.nextLine();
            System.out.println("Nhập biển số mới: ");
            String newLicensePlate = sc.nextLine();
            newLicensePlate = checkLicensePlate(newLicensePlate);
            boolean isExsit = checkExist(newLicensePlate);
            while (isExsit){
                System.out.println("Biển số đã tồn tại! Vui lòng nhập lại: ");
                newLicensePlate= sc.nextLine();
                newLicensePlate=checkLicensePlate(newLicensePlate);
                isExsit= checkExist(newLicensePlate);
            }
            System.out.println("Nhập giá mới: ");
            double newPrice = sc.nextDouble();sc.nextLine();
            System.out.println("Nhập số ghế : ");
            int newSeat = sc.nextInt();sc.nextLine();
            System.out.println("Nhập điểm xuất phát mới : ");
            String newPlace = sc.nextLine();
            System.out.println("Nhập điểm đến mới : ");
            String newDestination = sc.nextLine();

            coachManagenment.fixCoachByID(coachID,newName,newLicensePlate,newPrice,newSeat,newPlace,newDestination);

        }else {
            System.out.println("ID Coach không tồn tại!");
        }
    }

    private String checkLicensePlate(String regex) {
        String result;
        boolean isValidate =checkValidate(regex);
        while (!isValidate){
            System.out.println("Biển số bạn nhập chưa đúng!");
            System.out.println("Vui lòng nhập lại giống theo mẫu sau đây: ");
            System.out.println("VD: xxY-xxx.xx");

            System.out.println("Với x: Là một số / Y: Là một chữ cái in hoa.");
            regex = sc.nextLine();
            isValidate =checkValidate(regex);
        }
        result = regex;
        return result;
    }

    private boolean checkValidate( String regex) {
        ValidateLicensePlate validateLicensePlate = new ValidateLicensePlate();
        return validateLicensePlate.validate(regex);
    }

    private void menuRemove() {
        System.out.println("Nhập ID Coach muốn xóa: ");
        String coachID = sc.nextLine();

        if ( checkID(coachID)){
            coachManagenment.removeById(coachID);
            System.out.println("Đã xóa xong");
        }else
            System.out.println("ID Coach không tồn tại! ");

    }

    private void menuAdd() {
        System.out.println("Nhập ID Coach: ");
        String coachID = sc.nextLine();
        while (checkID(coachID)){
            System.out.println("ID đã tồn tại! Vui lòng nhập lại ID mới:");
            coachID = sc.nextLine();
        }
        System.out.println("Nhập tên xe: ");
        String nameCoach = sc.nextLine();
        System.out.println("Nhập biển số xe : ");
        String licensePlate = sc.nextLine();
        licensePlate = checkLicensePlate(licensePlate);
        boolean isExsit = checkExist(licensePlate);
        while (isExsit){
            System.out.println("Biển số đã tồn tại! Vui lòng nhập lại: ");
            licensePlate= sc.nextLine();
            licensePlate=checkLicensePlate(licensePlate);
            isExsit= checkExist(licensePlate);
        }

        System.out.println("Nhập giá mỗi chỗ: ");
        double price = sc.nextDouble();sc.nextLine();
        System.out.println("Nhập tổng số ghế: ");
        int seat = sc.nextInt();sc.nextLine();
        System.out.println("Nhập điểm xuất phát: ");
        String place = sc.nextLine();
        System.out.println("Nhập điểm đến: ");
        String destination = sc.nextLine();

       Coach coach = new Coach(coachID,nameCoach,licensePlate,price,seat,place,destination);
       coachManagenment.addCoach(coach);
    }

    private boolean checkExist(String licensePlate) {
        for (Coach coach: coachManagenment.getListCoach()
             ) {
            if ( coach.getLicensePlate().equals(licensePlate)){
                return true;
            }
        }
        return false;

    }

    private boolean checkID(String id) {
        Coach coach =coachManagenment.searchById(id);
        if ( coach!= null){
            return true;
        }else
            return false;
    }
}

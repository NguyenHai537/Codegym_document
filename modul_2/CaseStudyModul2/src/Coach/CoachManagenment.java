package Coach;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CoachManagenment {
    private List<Coach> listCoach;

    private static final CoachManagenment coachManagenment = new CoachManagenment();

    private CoachManagenment(){
        listCoach = new ArrayList<>();
    }

    public static CoachManagenment getCoachManagenment() {
        return coachManagenment;
    }

    public List<Coach> getListCoach() {
        return listCoach;
    }

    public void  addCoach(Coach coach){
        listCoach.add(coach);
    }

    public Coach searchById(String id){
        Coach result =null;
        for (Coach coach: listCoach
             ) {
            if ( coach.getCoachID().equals(id)){
                result = coach;
            }
        }
        return result;
    }

    public boolean removeById(String id){
        Coach coachRemove = searchById(id);
        if(coachRemove != null){
            listCoach.remove(coachRemove);
            return true;
        }
        return false;
    }

    public boolean fixCoachByID( String id, String name , String licensePlate , double priceOfSeat , int seat ,String placeOfDeparture ,String destination){
        Coach coachFix = searchById(id);
        if ( coachFix != null){
            coachFix.setName(name);
            coachFix.setLicensePlate(licensePlate);
            coachFix.setPriceOfSeat(priceOfSeat);
            coachFix.setSeat(seat);
            coachFix.setPlaceOfDeparture(placeOfDeparture);
            coachFix.setDestination(destination);
            return true;
        }
        return false;
    }

    public List<Coach> sortCoachIncreaseByPrice(){
        ComparatorCoach comparatorCoach = new ComparatorCoach();
        listCoach.sort(comparatorCoach);
        return listCoach;
    }

    public List<Coach> sortCoachDecreaseByPrice(){
        ComparatorCoach comparatorCoach = new ComparatorCoach();
        listCoach.sort(comparatorCoach.reversed());
        return listCoach;
    }

    public void saveToFile(){
        String line;
        BufferedWriter bufferedWriter;
        try {
            File file = new File("CoachSave.txt");
            bufferedWriter = new BufferedWriter(new FileWriter(file));
            for (Coach coach: listCoach
                 ) {
                line = coach.toFile();
                bufferedWriter.write(line);
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void readFile(){
        String line;
        BufferedReader bufferedReader;
        try {
            bufferedReader = new BufferedReader(new FileReader("CoachSave.txt"));
            while ((line=bufferedReader.readLine()) != null){
                List<String> readCoach = parseCsvLine(line);

                Coach coach = new Coach(readCoach.get(0),readCoach.get(1),readCoach.get(2),Double.parseDouble(readCoach.get(3)),Integer.parseInt(readCoach.get(4)),
                        readCoach.get(5),readCoach.get(6));
                listCoach.add(coach);
            }

        }catch (IOException e){
            e.printStackTrace();
        }

    }

    private List<String> parseCsvLine(String csvLine) {
        List<String> result = new ArrayList<>();
        if ( csvLine != null){
            String [] splitLine = csvLine.split(",");
            int lenght = splitLine.length;
            for (int i = 0 ; i< lenght ; i++){
                result.add(splitLine[i]);
            }
        }
        return result;
    }

    @Override
    public String toString() {
        return "ListCoach={ " + listCoach +
                '}';
    }
}

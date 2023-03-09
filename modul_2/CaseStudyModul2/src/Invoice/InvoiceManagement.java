package Invoice;

import Coach.CoachManagenment;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class InvoiceManagement {
    private List<Invoice> listInvoice;

    private static InvoiceManagement invoiceManagement = new InvoiceManagement();

    private InvoiceManagement(){
        listInvoice = new ArrayList<>();
    }

    public List<Invoice> getListInvoice() {
        return listInvoice;
    }

    public static InvoiceManagement getInvoiceManagement() {
        return invoiceManagement;
    }

    public void addInvoice(Invoice invoice){
        listInvoice.add(invoice);
    }

    public Invoice searchInvoiceByID( String id){
        Invoice result = null;
        for (Invoice invoice: listInvoice
             ) {
            if (invoice.getInvoiceId().equals(id)){
                result= invoice;
            }
        }
        return result;
    }

    public boolean removeInvoiceByID(String id){
        Invoice invoice = invoiceManagement.searchInvoiceByID(id);
        if (  invoice!= null){
            listInvoice.remove(invoice);
            return true;
        }
        return false;
    }

    public boolean fixInvoiceByID(String id, String customerID ){
        Invoice invoice = invoiceManagement.searchInvoiceByID(id);
        if ( invoice!=null){
            invoice.setCustomerID(customerID);

            return true;
        }
        return false;
    }

    public void savetoFile(){
        String line;
        BufferedWriter bufferedWriter;
        try{
            File file = new File("InvoiceSave.txt");
            bufferedWriter = new BufferedWriter(new FileWriter(file));
            for (Invoice invoice: listInvoice
                 ) {
                line = invoice.toFile();
                bufferedWriter.write(line);
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
    
    public void readFile(){
        String line;
        BufferedReader bufferedReader;
        try {
            bufferedReader = new BufferedReader(new FileReader("InvoiceSave.txt"));
            while ((line = bufferedReader.readLine()) !=null){
                List<String> readFile = parCsvLine(line);
                Invoice invoice = new Invoice(readFile.get(0), readFile.get(1));
                for (int i = 2 ; i < readFile.size() - 1 ; i+=2){
                    invoice.addHashMap(readFile.get(i),Integer.parseInt(readFile.get(i+1)));
//                    int seat = CoachManagenment.getCoachManagenment().searchById(readFile.get(i)).getSeat();
//                    CoachManagenment.getCoachManagenment().searchById(readFile.get(i)).setSeat(seat - Integer.parseInt(readFile.get(i+1)));
                }

                invoice.setInvoiceDate(convertDate(readFile.get(readFile.size()-1)));
                invoiceManagement.addInvoice(invoice);
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }
    private Date convertDate(String stringDate) {
        Date date = null;
        try {
            SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
             date = formatter.parse(stringDate);
        }catch (Exception e){
            e.printStackTrace();
        }
        return date;
    }
    private List<String> parCsvLine(String line) {
        List<String> listString = new ArrayList<>();
        if ( line != null){
            String [] splitString = line.split(",");
            int length = splitString.length;
            for (int i = 0 ; i < length ; i++){
                listString.add(splitString[i]);
            }
        }
        return listString;
    }

    @Override
    public String toString() {
        return "ListInvoice=" + listInvoice +
                '}';
    }
}

package QuanLiHoaDon;

import java.util.ArrayList;

public class InvoiceManagement {
    private ArrayList<Invoice> listInvoice;

    private static InvoiceManagement invoiceManagement = new InvoiceManagement();

    public static InvoiceManagement getInvoiceManagement() {
        return invoiceManagement;
    }

    public void setInvoiceManagement(InvoiceManagement invoiceManagement) {
        this.invoiceManagement = invoiceManagement;
    }

    private InvoiceManagement(){
        listInvoice = new ArrayList<>();
    }

    public void addInvoice(Invoice invoice){
        listInvoice.add(invoice);
    }

    public boolean removeInvoice(int idInvoice){
        for (Invoice invoice: listInvoice
             ) {
            if ( invoice.getIdInvoice() == idInvoice){
                listInvoice.remove(invoice);
                return true;
            }

        }
        return false;
    }

    public Invoice searchInvoice ( int idInvoice){
        for (Invoice invoice:listInvoice
             ) {
            if ( invoice.getIdInvoice() ==idInvoice){
                return invoice;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return "----InvoiceManagement----" + "\n" +
                 listInvoice ;

    }
}

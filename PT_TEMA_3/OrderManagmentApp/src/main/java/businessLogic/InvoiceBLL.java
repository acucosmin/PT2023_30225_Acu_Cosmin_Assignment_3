package businessLogic;

import dataAccess.InvoiceDAO;
import dataAccess.ProductDAO;
import fileWriter.FileWriter;
import model.Invoice;

import java.util.List;
import java.util.NoSuchElementException;


public class InvoiceBLL {

    private InvoiceDAO invoiceDAO ;
    private FileWriter fw;
//constructorul factura cu acelasi nume ca si clasa
    public InvoiceBLL(){
        invoiceDAO = new InvoiceDAO();
        fw = new FileWriter(); // asta pentru fisier
    }
// functie care cauta factura unui client in functie de id
    public Invoice findInvoiceById(int id) {
        Invoice pr = invoiceDAO.findById(id);
        if (pr == null) { //daca nu am  arunc o exceptie
            throw new NoSuchElementException("The invoice with id =" + id + " was not found!");
        }
        return pr;
    }
//functie care cauta toate facturile
    public List<Invoice> findAllInvoices(){
        List<Invoice> arr = invoiceDAO.findAll();
        if (arr.size() == 0) //daca nu am pt cine cauta arunc exceptie
            throw new NoSuchElementException("There are no invoices in the DB");
        return arr;
    }
//inserez in factura data ca parametru
    public void insertInvoice(Invoice invoice){
        if (validateInvoice(invoice)) {

            invoiceDAO.insert(invoice);
            Invoice inv = invoiceDAO.findAll().get(invoiceDAO.getRowCount() - 1);
            fw.writeLog(inv.toString());
        }
    }
//actualizez o factura data ca parametru
    public void updateInvoice(Invoice invoice){
        if (validateInvoice(invoice))
            invoiceDAO.update(invoice);
    }
//sterg o factura data ca parametru
    public void deleteInvoice(Invoice invoice){
        Invoice inv = invoiceDAO.findById(invoice.getId());
        if (inv == null)
            throw new NoSuchElementException("The invoice with id =" + invoice.getId()+ " was not found!");
        invoiceDAO.delete(invoice.getId());
    }

    /**
     * Checks if the Invoice is valid
     * @param i
     * @return boolean
     */
    //la fel ca pentru client verific daca e valid ce pun pentru factura
    public boolean validateInvoice(Invoice i){
        boolean valid = true; //presupun ca e tot bine
        StringBuilder sb = new StringBuilder();
        ProductDAO productDAO = new ProductDAO();
        sb.append("|");
//pun o conditie pentru care ar putea valid sa isi schimba valoarea
        if(productDAO.getStockForId(i.getIdproduct()) < i.getQuantity()){
            sb.append(" Not enough supply for this Invoice |");
            valid = false;
        }

        if(!valid){
            System.out.println(sb);
        }
//returnez valid si o sa am ori false ori true in functie de ce am avut la verificarile anterioare
        return valid;
    }
}

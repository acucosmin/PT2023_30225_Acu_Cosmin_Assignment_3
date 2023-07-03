package businessLogic;

import dataAccess.ClientDAO;
import model.Client;

import javax.lang.model.type.NullType;
import java.util.List;
import java.util.NoSuchElementException;

public class ClientBLL {

    private ClientDAO clientDAO;
//constructor cu acelasi nume ca si clasa
    public ClientBLL() {
        this.clientDAO = new ClientDAO();
    }
//functie care returneaza lista de clienți găsiți în baza de date
    public List<Client> findAllClients(){
        List<Client> arr = clientDAO.findAll();
        if (arr.size() == 0) //daca n am clienti se arunca o exceptie
            throw new NoSuchElementException("There are no customers in the DB");
        return arr;
    }
//functia care imi cauta clientii in functie de id
    public Client findCustomerById(int id) {
        Client cus = clientDAO.findById(id);
        if (cus == null) { //daca dau la intrare un client cu id neexistent arunc o exceptie
            throw new NoSuchElementException("The customer with id =" + id + " was not found!");
        }
        return cus;
    }
//functie care insereaza un client in baza de date
    public void insertClient(Client client){
        if (validateClient(client)) { //daca clientul e oke (informatia valida)
            clientDAO.insert(client); //inserez
        }
    }
//funtie care actualizeaza informatiile despre un client dat
    public void updateClient(Client client){
        if (validateClient(client)) //daca clientul e oke (informatia valida)
            clientDAO.update(client); // actualizez
    }
//functie care imi sterge un client dupa id
    public void deleteClient(int ID){
        clientDAO.delete(ID);
    }

    /**
     * Checks if the Client is valid
     * @param c
     * @return boolean
     */

//cu functia asta verific daca ce am despre un client dat la parametrii e valid sau nu
    public boolean validateClient(Client c){
        boolean valid = true; //presupun ca e ok tot
        StringBuilder sb = new StringBuilder();
        sb.append("|");
//daca clientul e null
        if(c == null){
            sb.append(" Customer is null | "); //mesaj
            valid = false; //schimb valoarea lui valid pe fals
        }
// daca clientul nu are macar  16 ani nu e ok si iar ii dau la valid fals
        if(c.getAge() < 16){
            sb.append(" Customer is not over 16 yr old |");
            valid = false;
        }

        if(!valid){
            System.out.println(sb);
        }
 //returnez valid si o sa am ori false ori true in functie de ce am avut la verificarile anterioare
        return valid;
    }
}

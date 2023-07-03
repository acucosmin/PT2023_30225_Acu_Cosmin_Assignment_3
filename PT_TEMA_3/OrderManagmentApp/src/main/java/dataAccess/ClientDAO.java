package dataAccess;

import model.Client;

import java.util.List;
//doar aplic mostenirea
public class ClientDAO extends AbstractDAO<Client>{
//verific cu functia asta daca exista id ul cerut undeva
    /*public boolean checkIdExists(int id){

        List<Client> list = findAll();
        for(Client client: list){
            if(client.getId() == id)
                return true;
        }
        return false;
    }*/
}

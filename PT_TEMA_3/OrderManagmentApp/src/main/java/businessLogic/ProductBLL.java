package businessLogic;

import dataAccess.ProductDAO;
import model.Client;
import model.Product;

import java.util.List;
import java.util.NoSuchElementException;

public class ProductBLL {

    private ProductDAO productDAO;
//constructor cu acelasi nume ca si clasa
    public ProductBLL() {
        this.productDAO = new ProductDAO();
    }
// functie care cauta un produs in functie de id dat ca parametru
    public Product findProductById(int id) {
        Product pr = productDAO.findById(id);
        if (pr == null) { //daca nu exista id ul arunc o exceptie
            throw new NoSuchElementException("The product with id =" + id + " was not found!");
        }
        return pr;
    }
//functie care imi cauta toate produsele
    public List<Product> findAllProducts(){
        List<Product> arr = productDAO.findAll();
        if (arr.size() == 0) //daca nu am nimic arunc o exceptie
            throw new NoSuchElementException("There are no customers in the DB");
        return arr;
    }
//functie care insereaza un produs dat ca parametru
    public void insertProduct(Product product){
        if (validateProduct(product)) { //daca e ok
            productDAO.insert(product); //inserez
        }
    }
//functie care actualizeaza un produs dat ca parametru
    public void updateProduct(Product product){
        if (validateProduct(product))//daca e ok
            productDAO.update(product); //actualizez
    }
//functie care imi sterge un produs dupa id ul dat ca parametru
    public void deleteProduct(int ID){
        productDAO.delete(ID);
    }

    /**
     * Checks if the Product is valid
     * @param p
     * @return boolean
     */

    public boolean validateProduct(Product p){
        boolean valid = true; //prespun ca e tot bine
        StringBuilder sb = new StringBuilder();
        sb.append("|");
//pun verificari pentru care nu ar mai fi bine
        if(p == null){
            sb.append(" Product is null | ");
            valid = false;
        }
//nu pot da ceva negatuv deci daca am negatuv valid isi schimba valoarea in false
        if(p.getSupply() < 0){
            sb.append(" Supply cannot be a negative number |");
            valid = false;
        }

        if(!valid){
            System.out.println(sb);
        }
//returnez valid si o sa am ori false ori true in functie de ce am avut la verificarile anterioare
        return valid;
    }
}

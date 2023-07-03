package model;
//clasa factura
public class Invoice {
    //pentru fiecare am id, id client, id produs si cantitatea produselor
    private int id;
    private int idclient;
    private int idproduct;
    private int quantity;
//constructor cu acelasi nume ca si clasa
    public Invoice(int id, int idclient, int idproduct, int quantity) {
        this.id = id;
        this.idclient = idclient;
        this.idproduct = idproduct;
        this.quantity = quantity;
    }

    public Invoice(){

    }
//doar gettere si settere pt id, idclient, id produs si cantitate
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdclient() {
        return idclient;
    }

    public void setIdclient(int idclient) {
        this.idclient = idclient;
    }

    public int getIdproduct() {
        return idproduct;
    }

    public void setIdproduct(int idproduct) {
        this.idproduct = idproduct;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
//mwtoda string tostring unde afisez frumos
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("The invoice with ID: ");
        sb.append(id);
        sb.append(" made by the client with ID: ");
        sb.append(idclient);
        sb.append(" from the product with the ID of: ");
        sb.append(idproduct);
        sb.append(" in the quantity of: ");
        sb.append(quantity);
        sb.append(", was made.\n");
        return String.valueOf(sb);
    }
}

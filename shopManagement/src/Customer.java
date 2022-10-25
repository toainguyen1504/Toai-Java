/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


public class Customer {
    int id;
    String name, address;
    int phonenumber, shoesid;

    public Customer() {
    }

    public Customer(int id, String name, String address, int phonenumber, int shoesid) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.phonenumber = phonenumber;
        this.shoesid = shoesid;
    }

    public Customer(String name, String address, int phonenumber, int shoesid) {
        this.name = name;
        this.address = address;
        this.phonenumber = phonenumber;
        this.shoesid = shoesid;
    }

    public Customer(int id, String name, String address, int phonenumber) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.phonenumber = phonenumber;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(int phonenumber) {
        this.phonenumber = phonenumber;
    }

    public int getShoesid() {
        return shoesid;
    }

    public void setShoesid(int shoesid) {
        this.shoesid = shoesid;
    }
    
    
}

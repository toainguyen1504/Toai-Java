/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


public class Shoes {
    int shoesid, quantity;
    String brand, nameofshoes;
    Double size, price, total;

    public Shoes() {
    }

    public Shoes(int shoesid, int quantity, String brand, String nameofshoes, Double size, Double price, Double total) {
        this.shoesid = shoesid;
        this.quantity = quantity;
        this.brand = brand;
        this.nameofshoes = nameofshoes;
        this.size = size;
        this.price = price;
        this.total = total;
    }

    public Shoes(int quantity, String brand, String nameofshoes, Double size, Double price, Double total) {
        this.quantity = quantity;
        this.brand = brand;
        this.nameofshoes = nameofshoes;
        this.size = size;
        this.price = price;
        this.total = total;
    }

    public int getShoesid() {
        return shoesid;
    }

    public void setShoesid(int shoesid) {
        this.shoesid = shoesid;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getNameofshoes() {
        return nameofshoes;
    }

    public void setNameofshoes(String nameofshoes) {
        this.nameofshoes = nameofshoes;
    }

    public Double getSize() {
        return size;
    }

    public void setSize(Double size) {
        this.size = size;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }
    
    
}

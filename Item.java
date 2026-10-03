/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Maypa_PPD2_LE;

import java.io.Serializable;

/**
 *
 * @author VICTUS
 */
public class Item implements Serializable {
    
    private String ItemName, deliveryDate;
    private int quantity;
    
    //def con
    Item() {
        ItemName = deliveryDate = "";
        quantity = 0;
    }
    
    // w para
    Item(String N,String D, int Q){
        setItem(N, D, Q);
    }
    
    // copy con
    Item (Item I) {
        ItemName = I.ItemName;
        deliveryDate = I.deliveryDate;
        quantity = I.quantity;
        
    }
    
    // set Item
    public void setItem (String N, String D, int Q) {
        ItemName = N;
        deliveryDate = D;
        quantity = Q;
    }
    
    public void setItem (String ItemName) {
        this.ItemName = ItemName;
    }
    
    
    // setters
    public void setItemName (String N) {ItemName = N;}
    public void setdeliveryDate (String D) {deliveryDate = D;}
    public void setquantity (int Q) {quantity = Q;}
    
    // getters
    public Item getItem() {return this;}
    public String getItemName() {return ItemName;}
    public int getquantity() {return quantity;}
    public String getdeliveryDate() {return deliveryDate;}
    
    @Override
    public String toString() {
    return ItemName + " " + quantity ;
}
    
    
}



/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Maypa_PPD2_LE;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 *
 * @author VICTUS
 */
public class ItemArrayObj {
    
    private Item ItemArray[];
    private int size;
    
    private ArrayList<Item> items = new ArrayList<>();
    
    
    //def con
    public ItemArrayObj() {
        ItemArray = new Item[500];
        size =0;
    }
    
    // add item
    public void AddItem (Item item) {
        if(ItemArray == null) {
            ItemArray = new Item[500];
        }
        if (size < ItemArray.length) {
            ItemArray[size] = item;
            size++;
        } else {
            System.out.print("Inventory is full. Cannot add more items.");
        }
    }
    
    public Item getItem(int index) {
        if (index < 0 || index >= size) {
            return null;
        }
        return ItemArray[index];
    }
    
    
    // item list
    public ArrayList<Item> listItems() {
        ArrayList<Item> pList = new ArrayList();
        for (int i=0; i<size; i++) pList.add(ItemArray[i]);
        return pList;
    }
    
    // to string
    public String toString() {
        String str = "";
        for (int i=0; i< size; i++) {
            str += "Item [" +(i+1)+ "] " + ItemArray[i] + "\n";
        }        
        return str;
    }
    
    public String toStringToFile() {
    StringBuilder str = new StringBuilder();
    for (int i=0; i<size; i++) {
        Item item = ItemArray[i];
        str.append(item.getItemName()).append(",")
            .append(item.getquantity()).append("\n");
    }
        return str.toString();
    }
    
    // to delete
    public boolean deleteItem(int index) {
        if (index < 0 || index >= size) {
            return false;
        }
        
        for (int i = index; i < size -1 ; i++) {
            ItemArray[i] = ItemArray[i + 1];
        }
        ItemArray[size -1] = null;
        size --;
        return true;
    }
    
    public boolean addItemAt(int index, Item item) {
        if (index < 0 || index > size || size >= ItemArray.length){
            return false;
        }
        for (int i=size; i> index; i--) {
            ItemArray[i] = ItemArray[i-1];
        }
        
        ItemArray[index] = item;
        size++;
        return true;
        
    }
    
   
    // update item
    public boolean updateItem(int index, Item updatedItem) {
        if (index < 0 || index >= size) {
            return false;
        }
        ItemArray[index] = updatedItem;
        return true;
    }
    
    public int getSize() {
        return size;
    }
    
    public void saveToFile() throws IOException {
        saveToFile("Inventory.csv");
    }
    
    public void saveToFile(String filename) throws IOException {
        try (PrintWriter writer = new PrintWriter(new FileWriter(filename))) {
            writer.println("ItemName, Quantity, DeliveryDate");
            
            for (int i=0; i<size; i++) {
                Item item = ItemArray[i];
                writer.println(String.format("%s, %d, %s",
                        item.getItemName(),
                        item.getquantity(),
                        item.getdeliveryDate()));
            }
        }
    }
    
    public void loadFromFile(String filename) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line = reader.readLine();            
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length >= 3) {
                    AddItem(new Item(
                    parts[0].trim(),
                    parts[2].trim(),
                    Integer.parseInt(parts[1].trim())
                 ));         
                }
            }
        }
    }
        
    
}

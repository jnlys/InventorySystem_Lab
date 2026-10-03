/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Maypa_PPD2_LE;

import java.util.ArrayList;

/**
 *
 * @author VICTUS
 */
public class LowStockChecker {
    
    private int threshold;
    
    public LowStockChecker() {
        this.threshold = 0;
    }
    
    public void setThreshold(int threshold) {
        this.threshold = threshold;
    }
    
    public int getThreshold(){
        return threshold; 
    }
    
    public LowStockChecker(int threshold) {
        this.threshold = threshold;
    }
    
    public ArrayList<Item> checkLowStock(ArrayList<Item> items) {
        ArrayList<Item> lowStockItems = new ArrayList<>();
        for (Item item : items) {
            if (item.getquantity() < threshold) {
                lowStockItems.add(item);
            }
        }
        return lowStockItems;
    }
    
    
    
    public void LowStockChecker(ArrayList<Item> items) {
        for (Item item : items) {
            if (item.getquantity() < threshold) {
                System.out.println(item);
            }
        }
    }
    
    
    
}

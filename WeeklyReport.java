/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Maypa_PPD2_LE;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.WeekFields;
import java.util.ArrayList;
import java.util.Locale;

/**
 *
 * @author VICTUS
 */
public class WeeklyReport {
    
    public static final int LOW_STOCK_THRESHOLD = 10;
    public static final int OUT_OF_STOCK_THRESHOLD = 0;
    
    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
    
    public String checkStockStatus(Item item) {
        int quantity = item.getquantity();
        if (quantity <= OUT_OF_STOCK_THRESHOLD) {
            return "Out of Stock";
        } else if (quantity <= LOW_STOCK_THRESHOLD) {
            return "Low Stock";
        } else {
            return "In Stock";
        }
    }
    
    public int getLowStockCount(ItemArrayObj inventory) {
        int count = 0;
        for (Item item : inventory.listItems()) {
            if (item.getquantity() > OUT_OF_STOCK_THRESHOLD &&
                 item.getquantity() <= LOW_STOCK_THRESHOLD) {
                count ++;
            }
        }
        return count;
    }
    
    public int getOutOfStockCount(ItemArrayObj inventory) {
        int count = 0;
        for (Item item : inventory.listItems()) {
            if (item.getquantity() <= OUT_OF_STOCK_THRESHOLD) {
                count++;
            }
        }
        return count;
    }
    
    public void generate(ArrayList<Item> items) {
        LocalDate now = LocalDate.now();
        WeekFields weekFields = WeekFields.of(Locale.getDefault());
        int currentWeek = now.get(weekFields.weekOfWeekBasedYear());
        int currentYear = now.getYear();
        
        System.out.println("=== WEEKLY REPORT ===");
        for (Item item : items) {
            LocalDate date = LocalDate.parse(item.getdeliveryDate(), formatter);
            int itemWeek = date.get(weekFields.weekOfWeekBasedYear());
            int itemYear = date.getYear();
            
            if (itemWeek == currentWeek && itemYear == currentYear) {
                System.out.print(item);
            }
        }
    }
    
}

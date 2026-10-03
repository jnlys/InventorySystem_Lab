/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Maypa_PPD2_LE;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.WeekFields;
import java.util.ArrayList;
import java.util.*;
import java.util.Locale;

/**
 *
 * @author VICTUS
 */
public class MonthlyReport extends WeeklyReport {
    
    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
    
    public List<Item> getReorderRecommendataions(ItemArrayObj inventory) {
        List<Item> recommendations = new ArrayList<>();
        for (Item item : inventory.listItems()) {
            if (item.getquantity() <= LOW_STOCK_THRESHOLD) {
                recommendations.add(item);
            }
        }
        return recommendations;
    }
    
    public String getReorderRecommendataionsText(ItemArrayObj inventory){
        List<Item> items = getReorderRecommendataions(inventory);
        if (items.isEmpty()) {
            return "No reorder reccomendations at this time.";
        }
        
        StringBuilder sb = new StringBuilder("=== REORDER RECOMMENDATIONS ===");
        for (Item item : items) {
            sb.append(String.format("%-30s (Current: %d, Recommended: %d)\n",
                    item.getItemName(),
                    item.getquantity(),
                    item.getdeliveryDate()));
        }
        return sb.toString();
        
    }
    
    
    public void generate(ArrayList<Item> items) {
        LocalDate now = LocalDate.now();
        int currentMonth = now.getMonthValue();
        int currentYear = now.getYear();
        
        System.out.println("=== MONTHLY REPORT ===");
        for (Item item : items) {
            LocalDate date = LocalDate.parse(item.getdeliveryDate(), formatter);
            int itemMonth = date.getMonthValue();
            int itemYear = date.getYear();
            
            if (itemMonth == currentMonth && itemYear == currentYear) {
                System.out.print(item);
            }
        }
    }
    
}

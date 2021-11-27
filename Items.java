/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;

import java.util.*;
import java.util.stream.Collectors;

/**
 *
 * @author shajith
 */
public class Items {

    //declaring arraylist
    static ArrayList<Items> items = new ArrayList<Items>();
    //declaring data members
    int itemId;
    String itemDescription, itemBrand;
    int itemRate;
    Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        //for calling unstatic feilds inside the static block
        Items it = new Items();
        Scanner sc = new Scanner(System.in);

        int choice;
        char yesNo;
        do {
            System.out.println("\t\t ITEM DETAILS APP ");
            System.out.println("\t\t^^^^^^^^^^^^^^^^^^\n");
            System.out.println("\n1.Add items.\n2.Display All Items.\n3.Display items brand name starts with 'T'.\n4.Sort Item List by Rate(Descending Order).");
            System.out.println("Enter your choice:");
            choice = Integer.parseInt(sc.nextLine());

            switch (choice) {
                case 1:
                    System.out.println("\t1.Add items.\n");
                    it.itemEntry();
                    break;
                case 2:
                    System.out.println("\t2.Display All Items.");
                    it.itemDisplay();
                    break;
                case 3:
                    System.out.println("\t3. Items Brand Name Starts with'T'");
                    it.filterByBrandT();
                    break;
                case 4:
                    System.out.println("\t4.Sorted Item List By Rate (Descending)");
                    it.sortByRate();
                    break;
                default:
                    System.out.println("Invalid Choice");
                    break;
            }
            System.out.println("If you want to continue Press 'Y'");
            yesNo = sc.nextLine().charAt(0);

        } while (yesNo == 'Y' || yesNo == 'y');
    }

    public void itemEntry() {

        System.out.println("Enter the number of items You want to Add:");
        int limit = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < limit; i++) {
            System.out.println("Enter the item ID:");
            itemId = Integer.parseInt(sc.nextLine());
            System.out.println("Enter the item Description:");
            itemDescription = sc.nextLine();
            System.out.println("Enter the item Brand:");
            itemBrand = sc.nextLine();
            System.out.println("Enter the Item Rate:");
            itemRate = Integer.parseInt(sc.nextLine());

            items.add(new Items(itemId, itemDescription, itemBrand, itemRate));
        }
        System.out.println("Items Added Successsfully...");
    }

    public void itemDisplay() {
        if (!items.isEmpty()) {
            System.out.println(String.format("%-20s%-20s%-20s%-20s%n", "itemId", "itemDescription", "itemBrand", "itemRate"));
            for (Items data : items) {
                System.out.println(data);
            }
        } else {
            System.out.println("Item List Is Empty");
        }
    }

    public void filterByBrandT() {
        //using Stream        
        List<Items> filteredlist = this.items.stream().filter(i -> i.itemBrand.toLowerCase().startsWith("t")).collect(Collectors.toList());
        // filteredlist=this.items.stream().filter(i -> i.itemBrand.startsWith("T")).collect(Collectors.toList());
        if (!filteredlist.isEmpty()) {
            System.out.println(String.format("%-20s%-20s%-20s%-20s%n", "itemId", "itemDescription", "itemBrand", "itemRate"));
            for (Items data : filteredlist) {
                System.out.println(data);
            }
        } else {
            System.out.println("No Brand Name Starts with 'T'");
        }
    }

    public void sortByRate() {
        ArrayList<Items> sortedList = (ArrayList) items.clone();
        sortedList.sort((Items i1, Items i2) -> i2.itemRate - i1.itemRate);
        if (!sortedList.isEmpty()) {
            System.out.println(String.format("%-20s%-20s%-20s%-20s%n", "itemId", "itemDescription", "itemBrand", "itemRate"));
            for (Items data : sortedList) {
                System.out.println(data);
            }
        }
    }

    //default costructor, parameterized constructor,and toString method
    private Items() {
    }

    public Items(int itemId, String itemDescription, String itemBrand, int itemRate) {
        this.itemId = itemId;
        this.itemDescription = itemDescription;
        this.itemBrand = itemBrand;
        this.itemRate = itemRate;
    }

    @Override
    public String toString() {
        return String.format("%-20s%-20s%-20s%-20s%n", itemId, itemDescription, itemBrand, itemRate);
    }

}

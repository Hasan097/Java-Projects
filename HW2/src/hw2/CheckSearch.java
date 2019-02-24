/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hw2;


public class CheckSearch {
    public static void printProducts(Catalog cat){                         //Under the Catalog object "cat" we call the list of the product L
        for(int i = 0; i < cat.L.size(); i++)                       //and display when called.
            System.out.println(cat.L.get(i).toString());
    }
    
    public static void main(String args[]){
        Catalog check = new Catalog();
        System.out.println("first check for empty list:");
        printProducts(check);
        System.out.println("check complete.");
        //check.L.add("T-Shirt","Cloths",3.5,30);
        //Catalog first = new Catalog("T-Shirt","Cloths",3.5,30);
    }
}

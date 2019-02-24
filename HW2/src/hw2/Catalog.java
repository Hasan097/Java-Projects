/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hw2;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.Iterator;


public class Catalog implements Iterable<Product>{
    ArrayList<Product> lop;                 //Arraylist of product LOP
    Predicate<Product> prime;               //Predicate of the product named prime
    List<Product> L;                        //List L of the product
    
    public Catalog(){
        this.lop = new ArrayList<>();       //Sets default vaues to the product's array list
        
    }
    
    public void add (Product prod){         //Add a Product to the list.
        lop.add(prod);
    }
    
    public void setCondition(Predicate<Product> cond){
        this.prime = cond;                  //Set Prime to the cond to get new filters.
    }
    
    private class CatIterator implements Iterator<Product>{
        Iterator<Product> n;                //Iterate n.
        Predicate<Product> cond;            //Product predicate cond
        int index = 0;                      //Index for Iterating through the list of products
        
        public CatIterator(Predicate<Product> huh){
            this.cond = huh;                //Constructor to set the default filters.
        }

        @Override
        public boolean hasNext() {          
            while(index < L.size()){        
                if(cond.test(L.get(index))){    //checks if the value of the product is valid
                    index ++;                   // +1 to the index as a match is made
                    return true;                // return true for the match if found
                }
            }
            return false;
        }

        @Override
        public Product next() {             //Here the next operator works with the hasNext operator to return the next product if true
            if(hasNext())
                return L.get(index);
            return null;                    //else return a null
        }  
    }
    
    @Override
    public Iterator<Product> iterator() {
        return new CatIterator(this.prime); //returns the object of CatIterator with the prime predicate.
    }
}

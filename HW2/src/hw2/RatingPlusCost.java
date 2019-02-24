/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hw2;

import java.util.function.Predicate;

public class RatingPlusCost implements Predicate<Product>{

    float minrate;
    float maxcost;
        
    public RatingPlusCost(){                                    //constructor to initialize values to the variables
        minrate = (float) 2.5;
        maxcost = (float) 74.99;
    }
    
    
    @Override
    public boolean test(Product t) {
        if(t.getcost() < maxcost && t.getrat() > minrate)       //true if the product has a higher rating and a lower cost
            return true;
        return false;
    }
}

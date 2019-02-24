/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hw2;

import java.util.function.Predicate;


public class NoTest implements Predicate <Product>{
    
    @Override
    public boolean test(Product t) {                    //Applying default method, return true.
        return true;
    }
}

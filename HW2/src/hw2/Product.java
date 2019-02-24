/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hw2;

/**
 *
 * @author Administrator
 */
public class Product {

    String name;
    String category;
    float rating;
    float cost;
    
    public Product(String dummy, String cate, float n, float m){      //Constructor to set the values to default.
        rating = n;
        cost = m;
        name = dummy;
        category = cate;
    }
    
    public String getname(){        //Getter for name
        return name;
    }
    
    public String getcat(){         //Getter for category
        return category;
    }
    
    public float getrat(){          //Getter for rating
        return rating;
    }
    
    public float getcost(){         //Getter for cost
        return cost;
    }
    
    public String toString(){       //Return values in specific order
        return name + " " + category + " " + rating + " " + cost;
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hw1;

/**
 *
 * @author Administrator
 */
public class Freezing {

    final static int FREEZING = 32;
    public static int freezing(int temps[], int numTemp){
        int ct = 0;
        for (int i = 0; i < numTemp; i++){
            if (temps[i] < FREEZING) {
                ct++;
            }
        }
        return ct;
    }
    public static void main(String[] args) {
        int temperatures[] = {10, 50, 33, 5, -3};
        int size = 5;
        System.out.print("#readings below freezing: ");
        System.out.println(freezing(temperatures, size));
    }
    
}

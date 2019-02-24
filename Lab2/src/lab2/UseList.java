/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author villa
 */
public class UseList {
// Display the students
    static void printList(List<Student> list) {
        // System.out.print() can print Student objects, but
        // it just doesn't give you nice output until you override toString()
        // in the Student class
        for(int i = 0; i < list.size(); i++)
            System.out.println(list.get(i).toString());
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws CloneNotSupportedException {
        // TODO code application logic here
        ArrayList<Student> students = new ArrayList<>();
        Scanner stdin = new Scanner(System.in);
        Student s1 = new Student("Mel B", 1);
        Student s2 = new Student("Cal X", 4);
        students.add(s1);
        students.add(s2);
        System.out.println("Initial list: ");
        printList(students);
        
        
        Student s3 = (Student) s2.clone();
    
        
        
        System.out.println("List includes Cal X: " + students.contains(s3));
        students.remove(s3);
        System.out.println("After removing Cal X: ");
        printList(students);
   
  
        students.add(s3);
        Collections.sort(students);
        System.out.println("After sorting");
        printList(students);
    }
}
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab2;

/**
 *
 * @author Administrator
 */
public class Student implements Cloneable, Comparable<Student>{
    String name;
    int num;
    
    public Student(String dummy, int n){
        this.name = dummy;
        this.num = n;
    }
    public String toString(){
        return this.name + this.num;
    }
    
    protected Object clone() throws CloneNotSupportedException{
        return super.clone();
    }
    
    public boolean equals(Object other){
        if(other == null)
            return false;
        if(other instanceof Student)
        {   
            Student f = (Student) other;
            if(f.name.equals(this.name) && f.num == this.num)
            {
                other.hashCode();
                return true;
            }
        }
        return false;
    }
    
   public int compareTo(Student s){
      return this.name.compareTo(s.name);
   }
   
   
}

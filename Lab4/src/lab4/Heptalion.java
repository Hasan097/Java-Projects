/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab4;

/**
 *
 * @author Administrator
 */
public class Heptalion {

    /**
     * @param args the command line arguments
     */
    char [][]board = new char [][]
            {
                {'a','b','a'},
                {'a','c','c'},
                {'b','c','b'}
            };
    char sym1 = 'a',sym2 = 'c';
    
    public boolean method(int cor1, int cor2, int cor3, int cor4){
        
        if(cor1 >= 3 && cor2 >= 3 && cor3 >= 3 && cor4 >= 3)            //Checks if its in range
            return false;
        
        if(board[cor1][cor2] == sym1 && board[cor3][cor4] == sym2)      //checks for a match
            return true;
        return false;
    }
}

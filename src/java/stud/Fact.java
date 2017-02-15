/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stud;

/**
 *
 * @author shiva
 */
public class Fact {
    
    static public Long getFact(long x)
    {
        long sum=1;
        while(x>1)
        {
            sum=sum*x;
            x--;
        }
        
        return sum;
    }
    
    public static void main(String ...args)
    {
    System.out.print("fact =="+Fact.getFact(5));
    }
    
}

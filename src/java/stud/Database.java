/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stud;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author shiva
 */
public class Database {
    
    public static void main(String ...args)
    {
        Database data=new Database();
        
       if( data.authenticate(101, "qw")){
           System.out.println("authenticated");}
       else{
       System.out.println("invalid");
       }
        
        
    }
    
    static Connection  getDBConnection()
    {
        try{
       Class.forName("com.mysql.jdbc.Driver");  
 return DriverManager.getConnection(  
"jdbc:mysql://localhost:3306/aastha","root","toor");  

  
        }
        catch(Exception sq){
        }
    
          return null;
}
    
   static  public boolean authenticate(int id,String pwd)
    {
        try{
        Connection con=getDBConnection();
        PreparedStatement ps=con.prepareStatement("select * from student where id=? and pwd=?");
        
        ps.setInt(1, id);
        ps.setString(2, pwd);
        
       ResultSet rs= ps.executeQuery();
       
       if(rs.next())
       {
           return true;
       }
        
        }catch(SQLException sq){ sq.printStackTrace();}
        
        
    return false;
    }
    
    void showData()
    {
        try{
        Connection con=getDBConnection();
        
        Statement stmt=con.createStatement();
        
            ResultSet rs= stmt.executeQuery("select * from student;");
            
            while(rs.next())
            {
                System.out.println(rs.getString("id")+rs.getString("pwd"));
            }
        
        
        
        }catch(SQLException sq)
        {
        
        }
        
    
    }
}

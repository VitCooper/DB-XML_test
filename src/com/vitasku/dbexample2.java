/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vitasku;

import static java.lang.Character.UnicodeBlock.forName;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author vitco
 */

public class dbexample2 {

    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
 //may be error without real DB so we have set exceptions      
 Class.forName("org.postgresql.Driver");
        //Reflection - link with driver directly
        //java.sql.Driver dr;
        //Using Interfaces are:
        // java.sql.Driver
        // java.sql.Connection
        // java.sql.Statement
        // java.sql.ResultSet
        // java.sql.PreparedStatement
//        Contact nContact = new Contact(12, "Tester", "Test2", "tester@test.nul", "+7-111-222-3333");
//        System.out.println("Send SQL request to Insert new line into the table CM_CONTACT:");
//        testInsert(nContact);
         System.out.println("Send SQL request to Select all lines from the table CM_CONTACT:");
        testSelect();
         System.out.println("Send SQL request to Update the last line into the table CM_CONTACT:");
        testUpdate();
        System.out.println("Update is Completed!");
         System.out.println("Send SQL request to Select Final status of the table CM_CONTACT:");
        testSelect();
    }
    private static void testSelect() throws ClassNotFoundException {
        List<Contact> result = new ArrayList<>();
        
        
        String url = "jdbc:postgresql://localhost:5432/contactdb";
     try {
        Connection con = DriverManager.getConnection(url, "postgres", "passw0rd");
        //URL + Login + password
        //System.out.println(.getClass().getCanonicalName());
        Statement stmt = null;
        ResultSet rs = null;
        //some usefull examples:
//        String sqlReq1 = "SELECT * FROM cm_contact WHERE contact_id =";   
//        String cntId = "0";
//        String sqlSend = sqlReq1 + cntId;
//         System.out.println("Sending SQL request " + sqlSend);
        try {
            
        stmt = con.createStatement();
        rs = stmt.executeQuery("SELECT * FROM cm_contact");
        
       // List<Contact> result = new ArrayList<Contact>();
        while (rs.next()) {
                   Long contactId = rs.getLong("contact_id");
                   String surName = rs.getString("sur_name");
                   String givenName = rs.getString("giv_name");
                   String eMail = rs.getString("email");
                   String mPhone = rs.getString("mob_phone");
            
              Contact contact = new Contact(contactId, surName, givenName, eMail, mPhone);
              result.add(contact);
                }
         for(Contact cnt : result) {
                System.out.println(cnt);
                // распечатать список контактов из базы, который описан в классе contact.java
                                            }
            rs.close();
            stmt.close();
        } finally {
         con.close();
        }
    }  catch (SQLException ex) {
              ex.printStackTrace();
              }  
   
}

    private static void testInsert(Contact contact) {
        String url = "jdbc:postgresql://localhost:5432/contactdb";
        
        try {
         Connection con = DriverManager.getConnection(url, "postgres", "passw0rd");
        
         PreparedStatement stmt = null;
         ResultSet rs = null;
         try {
           con.setAutoCommit(false);
//          stmt = con.prepareStatement("INSERT INTO cm_contact "
//                    + "(sur_name, giv_name, email, mob_phone) values (?,?,?,?)");
  stmt = con.prepareStatement("INSERT INTO cm_contact "
                    + "(sur_name, giv_name, email, mob_phone) values (?,?,?,?)", new String[] {"contact_id"});        
                //    new String[] ("contact_id"));
          
          for (int i = 1;  i < 2;  i ++){
                 
          stmt.setString(1, contact.getSurName());
          stmt.setString(2, contact.getGivenName());
          stmt.setString(3, contact.geteMail());
          stmt.setString(4, contact.getmPhone());
          // stmt.setDate(5, contact.getDate());
          stmt.executeUpdate();
                 
          }
//          rs = stmt.getGeneratedKeys();
          // Let's look at the process:
 
//             if(rs.next()){
//             Long contactId = rs.getLong("contact_id");
//              System.out.println("Contact: " + contactId);  // here was sout!  
//                         
//             }    
             con.commit();   //if we need to save all changes in DB 
             // con.rollback(); //if not save - just a test
         //    rs.close();
        } finally {
             if(stmt != null) {
                 stmt.close();
             }
             con.close();
         }
        
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        
    }
    
    private static void testUpdate() throws ClassNotFoundException {
        String url = "jdbc:postgresql://localhost:5432/contactdb";
        // SQL request for PostgreSQL DB:
//        --UPDATE CM_CONTACT
//        --SET SUR_NAME = 'Сидоров', GIV_NAME = 'Василий', EMAIL = 'info@vasya.com', 
//        --MOB_PHONE = '+7-921-111-4444'
//        --WHERE contact_id=4;
//UPDATE CM_CONTACT
//SET SUR_NAME = 'Ivanov',
//	GIV_NAME = 'Petr',
//	EMAIL = 'pivan@maila.net',
//	MOB_PHONE = '+7-999-897-6235'
//WHERE CONTACT_ID = 25;
        try {
         Connection con = DriverManager.getConnection(url, "postgres", "passw0rd");
        
         PreparedStatement stmt = null;
         String contactId = "27";
         
         try {
             
           
           System.out.println("The Last New Line in CM_Contact Table is: " + contactId);  // here was sout!  
//                         
//             }    
          stmt = con.prepareStatement("UPDATE CM_CONTACT SET SUR_NAME = 'Ivanov', "
                    + "GIV_NAME = 'Petr', EMAIL = 'pivan@maila.net', MOB_PHONE = '+7-999-897-6235' "
                    + "WHERE CONTACT_ID =" + contactId);
                //stmt = con.prepareStatement("UPDATE cm_contact "
                //    + "(sur_name, giv_name, email, mob_phone) values (?,?,?,?)", new String[] {"contact_id"});        
      
                stmt.executeUpdate();
              
        } finally {
             if(stmt != null) {
                 stmt.close();
             }
             con.close();
         }
        
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        
    }

    
    
    
    
}

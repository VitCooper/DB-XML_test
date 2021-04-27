/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vitasku;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author vitco
 */
public class AddNewLine {
    
// Переменные для примера
String firstName = "Dmitry";
String lastName = "Chekhov";
String phone = "+7-987-111-2233";
String email = "dmitry@pisem.net";
 
// Запрос с указанием мест для параметров в виде знака "?"
String sql = "INSERT INTO JC_CONTACT (FIRST_NAME, LAST_NAME, PHONE, EMAIL) VALUES (?, ?, ?,?)";

/*
Это Пока не работает???

// Создание запроса. Переменная con - это объект типа Connection
PreparedStatement stmt = con.prepareStatement(sql);
 
// Установка параметров
stmt.setString(1, firstName);
stmt.setString(2, lastName);
stmt.setString(3, phone);
stmt.setString(4, email);
 
// Выполнение запроса
stmt.executeUpdate();
*/

private void testDatabase() {
        try {
            Class.forName("org.postgresql.Driver");
            String url = "jdbc:postgresql://localhost:5432/contactdb";
            String login = "postgres";
            String password = "passw0rd";
            Connection con = DriverManager.getConnection(url, login, password);
            try {
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT * FROM JC_CONTACT");
                while (rs.next()) {
                    String str = rs.getString("contact_id") + ":" + rs.getString(2);
                    System.out.println("Contact:" + str);
                    
                    
                }
                rs.close();
                stmt.close();
            } finally {
                con.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}

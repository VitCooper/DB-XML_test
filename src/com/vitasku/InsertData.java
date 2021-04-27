/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vitasku;

/**
 *
 * @author vitco
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertData {

    public static void main(String[] args) {
        InsertData m = new InsertData();

        try {
            Class.forName("org.postgresql.Driver");
            String url = "jdbc:postgresql://localhost:5432/contactdb";
            String login = "postgres";
            String password = "passw0rd";
            Connection con = DriverManager.getConnection(url, login, password);

            // Демонстрация использования транзакций
            try {
                // Шаг первый - выставляем свойство AutoCommit в false
                con.setAutoCommit(false);
                // В цикле вставлем несколько записей
                for (int i = 0; i < 5; i++) {
                    long contactId = m.insert(con, "FirstName_" + i, "LastName_" + i, "phone", "email");
                    System.out.println("CONTACT_ID:" + contactId);
                }
                // Завершаем транзакцию - подтверждаем
                con.commit();
                // Вызов rollback отменит все внесенные изменения
                //con.rollback();
                
                // Возвращаем свойство AutoCommit в true
                con.setAutoCommit(true);
                
                // Можно проверить результат
                m.select(con);
            } finally {
                con.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private long insert(Connection con, String firstName, String lastName, String phone, String email) throws SQLException {
        long contactId = -1;
        PreparedStatement stmt = con.prepareStatement(
                "INSERT INTO jc_contact (first_name, last_name, phone, email) VALUES (?, ?, ?, ?)",
                new String[]{"contact_id"});
        stmt.setString(1, firstName);
        stmt.setString(2, lastName);
        stmt.setString(3, phone);
        stmt.setString(4, email);
        stmt.executeUpdate();

        ResultSet gk = stmt.getGeneratedKeys();
        while (gk.next()) {
            contactId = gk.getLong("CONTACT_ID");
        }
        stmt.close();

        return contactId;
    }

    private void select(Connection con) throws SQLException {
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM jc_contact");
        while (rs.next()) {
            String str = rs.getString("contact_id") + ":" + rs.getString(2);
            System.out.println("Contact:" + str);
        }
        rs.close();
        stmt.close();
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.mail.ales_2003.convector.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author admin
 */
public class SimpleDB 
{
    public static void main(String[] args) {
        SimpleDB m = new SimpleDB();
        m.testDatabase();
    }
 
    private void testDatabase() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/convectordb";
            String login = "root";
            String password = "root";
            Connection con = DriverManager.getConnection(url, login, password);
            try {
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT * FROM convectors");
                while (rs.next()) {
                    String str = rs.getString("conv_id") + ":" + rs.getString(2)+"x"+ rs.getString(3)+"x"+ rs.getString(4)+"x"+ rs.getString(5)+"x"+ rs.getString(6);
                    System.out.println("Convector №" + str);
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
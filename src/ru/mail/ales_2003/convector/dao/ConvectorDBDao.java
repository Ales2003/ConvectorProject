/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.mail.ales_2003.convector.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import ru.mail.ales_2003.convector.entity.Convector;

/**
 *
 * @author admin
 */
public class ConvectorDBDao implements ConvectorDAO {
          
    public Connection con;

    public ConvectorDBDao () throws Exception {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/convectordb";
            String login = "root";
            String password = "root";
            con = DriverManager.getConnection(url, login, password);
        } catch (ClassNotFoundException e) {
            throw new Exception(e);
        } catch (SQLException e) {
            throw new Exception(e);
        }
    }
        
    @Override
    public Long addConvector(Convector convector) {
        Long convectorId = -1l;
        try {
            PreparedStatement stmt = null;
            try {
                stmt = con.prepareStatement(
                        "INSERT INTO convectors "
                        + "(length, width, depth, price, power) "
                        + "VALUES (?, ?, ?, ?, ?)", new String[] {"conv_id"} );
                stmt.setInt(1, convector.getLength());
                stmt.setInt(2, convector.getWidth());
                stmt.setInt(3, convector.getDepth());
                stmt.setInt(4, convector.getPrice());
                stmt.setInt(5, convector.getPower());
                stmt.execute();
                ResultSet gk = stmt.getGeneratedKeys();
                if(gk.next()) {
                // Получаем поле contact_id
                convectorId = gk.getLong("conv_id");
                }
               
            } finally {
                if (stmt != null) {
                    stmt.close();
                }
            }
        } catch (SQLException sQLException) {
        }
        return convectorId;
    }
    
    
    @Override
    public void updateConvector(Convector convector) {
       
         
         
         try {
            PreparedStatement stmt = null;
            try {
            stmt = con.prepareStatement(
                    "UPDATE convectors SET " +
                    "length=?, width=?, depth=?, " +
                    "price=?, power=?" +
                    "WHERE conv_id=?");
            stmt.setInt(1, convector.getLength());
            stmt.setInt(2, convector.getWidth());
            stmt.setInt(3, convector.getDepth());
            stmt.setInt(4, convector.getPrice());
            stmt.setInt(5, convector.getPower());
            stmt.setLong(6, convector.getConvectorId());
            stmt.execute();
            } finally {
                if (stmt != null) {
                    stmt.close();
                }
            }
            
        } catch (SQLException sQLException) {
        }
    }

    @Override
    public void deleteConvector(Long convectorId) {
        try {
            PreparedStatement stmt = null;
            try {
            stmt = con.prepareStatement(
                    "DELETE FROM convectors " +
                    "WHERE conv_id=?");
            stmt.setLong(1, convectorId);
            stmt.execute();
        } finally {
            if (stmt != null) {
                stmt.close();
            }
        }
            
        } catch (SQLException sQLException) {
        }
    }

    @Override
    public Convector getConvector(Long convectorId) {
        Convector convector = null;
        ResultSet rs = null;
        try {
            PreparedStatement stmt = null;
            try {
            stmt = con.prepareStatement(
                    "SELECT * FROM convectors " +
                    "WHERE conv_id=?");
            stmt.setLong(1, convectorId);
            rs = stmt.executeQuery();
            convector = new Convector(rs);
        } finally {
            if (rs != null) {
                 rs.close();
             }
             if (stmt != null) {
                 stmt.close();
             }
        }
            
        } catch (SQLException sQLException) {
        }
        return convector;
    }

    @Override
    public List<Convector> findConvectors() {
        List<Convector> convectors = new ArrayList<Convector>();
        Convector convector = null;
        ResultSet rs = null;
        try {
            Statement stmt = null;
            try {
            stmt = con.createStatement();
            rs = stmt.executeQuery("SELECT * FROM convectors ");
            while (rs.next()) {
                convector = new Convector(rs);
                convectors.add(convector);
            }
            }
            finally {
                if (rs != null) {
                     rs.close();
                 }
                 if (stmt != null) {
                     stmt.close();
                 }
            }
            
            } catch (Exception e) {
            }
        return convectors;
    }
}

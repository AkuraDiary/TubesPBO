/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bibd.tubespbo.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author asthiseta
 */
public class DbConnection {

    public Connection connection;

    public void openConnection() {
        try {

            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/logisticmanagementsys",
                    "bibd", "rawrbibd"
            );
            System.out.println("Connection to SQL has been established.");

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public int executeStatement(String query) {
        int resultcount = 0;
        Statement stmnt;
        try {
            stmnt = connection.createStatement();
            resultcount = stmnt.executeUpdate(query);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return resultcount;
    }

    public int executeStatement(PreparedStatement statement) {
        int resultcount = 0;
        Statement stmnt;
        try {
            resultcount = statement.executeUpdate(); //stmnt.executeUpdate(st);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return resultcount;
    }

    public ResultSet getData(PreparedStatement statement) {
        ResultSet rs = null;
        try {
            rs = statement.executeQuery();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return rs;
    }

    public ResultSet getData(String query) {
        Statement stmnt;
        ResultSet rs = null;

        try {
            stmnt = connection.createStatement();
            rs = stmnt.executeQuery(query);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return rs;
    }

    public void closeConnection() {
        try {
            connection.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public PreparedStatement prepareStatement(String query) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}

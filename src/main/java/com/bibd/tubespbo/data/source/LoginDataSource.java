/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bibd.tubespbo.data.source;

import com.bibd.tubespbo.data.DbConnection;
import com.bibd.tubespbo.data.model.EmployeeModel;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author rafid
 */
public class LoginDataSource {

    DbConnection db;

    public LoginDataSource(DbConnection db) {
        this.db = db;
    }

    public EmployeeModel doLogin(String email, String password) {
        try {

            db.openConnection();
            String query = "SELECT idEmployee, nama, noHP, email, role, status, idWarehouse"
                    + "FROM Employees WHERE email= ? AND password = ?";
            PreparedStatement statement = db.connection.prepareStatement(query);

            statement.setString(1, email);
            statement.setString(2, password);

            ResultSet rs = db.getData(statement);

            // parsing
            int idEmp = rs.getInt("idEmployee");
            String nama = rs.getString("nama");
            String noHp = rs.getString("noHp");
            String emailEmp = rs.getString("email");
            String role = rs.getString("role");
            String status = rs.getString("status");

            EmployeeModel data = new EmployeeModel(idEmp, nama, noHp, emailEmp, role, status);
            
            int idWarehouse = rs.getInt("idWarehouse");
            if(idWarehouse != 0){
                data.setIdWarehouse(idWarehouse);
            }
             return data;
            
        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
            return null;
        } finally {

            db.closeConnection();
        }

    }
}

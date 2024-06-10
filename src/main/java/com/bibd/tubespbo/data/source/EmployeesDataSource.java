/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bibd.tubespbo.data.source;

import com.bibd.tubespbo.data.DbConnection;
import com.bibd.tubespbo.data.model.EmployeeModel;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author asthiseta
 */
public class EmployeesDataSource {

    DbConnection db;

    public EmployeesDataSource(DbConnection db) {
        this.db = db;
    }

    public ArrayList<EmployeeModel> getAllEmployee() {
        ArrayList<EmployeeModel> allEmployee = new ArrayList<>();
        try {
            db.openConnection();
            String query = "SELECT idEmployee, nama, noHp, email, role, status, idWarehouse FROM employees";
            ResultSet rs = db.getData(query);

            EmployeeModel data;// = null;

//            if (rs == null) {
//                return allEmployee;
//            }

            while (rs.next()) {

                int idEmp = rs.getInt("idEmployee");
                String namaEmp = rs.getString("nama");
                String nohpEmp = rs.getString("noHp");
                String email = rs.getString("email");
                String role = rs.getString("role");
                String status = rs.getString("status");
                int idWarehouse = rs.getInt("idWarehouse");

                data = new EmployeeModel(idEmp, namaEmp, nohpEmp, email, role, status);

                if (idWarehouse != 0) {
                    data.setIdWarehouse(idWarehouse);
                }

                allEmployee.add(data);

            }

        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
            return null;
        } finally {
            db.closeConnection();
        }
        return allEmployee;
    }

    public EmployeeModel getEmpbyid(String id) {
        try {
            db.openConnection();
            String query = "SELECT idEmployee, nama, noHp, email, role, status, idWarehouse, password"
                    + " FROM employees WHERE idEmployee = '" + id + "'";

            ResultSet rs = db.getData(query);

            EmployeeModel data = null;

            if (rs == null) {
                return data;
            }

            while (rs.next()) {
                int idEmp = rs.getInt("idEmployee");
                String nama = rs.getString("nama");
                String noHp = rs.getString("noHp");
                String emailEmp = rs.getString("email");
                String role = rs.getString("role");
                String status = rs.getString("status");
                int idWarehouse = rs.getInt("idWarehouse");

                data = new EmployeeModel(idEmp, nama, noHp, emailEmp, role, status);

                if (idWarehouse != 0) {
                    data.setIdWarehouse(idWarehouse);
                }

            }
            return data;

        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
            return null;
        } finally {
            db.closeConnection();
        }

    }

    //insert dan update belum 
    //Rapid D.
    public int insertEmployee(String nama, String noHp, String email, String role, String status, String pass) {

        try {
            db.openConnection();

            String query = "INSERT INTO employees (nama, noHp, email, role, status, password) VALUES"
                    + "('" + nama + "', '" + noHp + "', '" + email + "', '" + role + "', '" + status + "', "+pass+" )";
            int result = db.executeStatement(query);
            return result;

        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
            return -1;

        } finally {
            db.closeConnection();
        }

    }

    // Rapid D.
    public int updateEmployee(String nama, String noHp, String email,
            String role, String status, int id) {
        try {
            db.openConnection();
            String query = "UPDATE employees SET nama ='" + nama + "',  noHp ='" + noHp + "', email = '" + email + "', "
                    + "role = '" + role + "',  status='" + status + "' "
                    + "WHERE idEmployee = " + id;
            return db.executeStatement(query);
        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
            return -1;
        } finally {
            db.closeConnection();
        }
    }
    
   

}

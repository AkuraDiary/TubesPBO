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

            EmployeeModel data = null;

            if (rs == null) {
                return allEmployee;
            }

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
//            String query = "INSERT INTO employee (nama, nohp, email, role, status) VALUES (?, ?, ?, ?, ?)";

//            executeStatement pr = db.executeStatement(query);
//            PreparedStatement pr = db.connection.prepareStatement(query);
//            String namaemp = nama;
//            String noHpemp = noHp;
//            String emailemp = email;
//            String roleemp = role;
//            String statusemp = status;
//            pr.setString(1, nama);
//            pr.setString(2, noHp);
//            pr.setString(3, email);
//            pr.setString(4, role);
//            pr.setString(5, status);
            int result = db.executeStatement(query);
            return result;
//            return null;

//            // Jika eksekusi berhasil, kembalikan objek EmployeeModel
//            if (result > 0) {
//                return new EmployeeModel(nama, noHp, email, role, status);
//            } else {
//                return null;
//            }
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

//            PreparedStatement pr = db.connection.prepareStatement(query);
            return db.executeStatement(query);
        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
            return -1;
        } finally {
            db.closeConnection();
        }
    }
    
   

}

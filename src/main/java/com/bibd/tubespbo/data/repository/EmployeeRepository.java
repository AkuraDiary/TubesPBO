/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bibd.tubespbo.data.repository;

import com.bibd.tubespbo.data.model.EmployeeModel;
import com.bibd.tubespbo.data.source.EmployeesDataSource;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author asthiseta
 */
public class EmployeeRepository {

    EmployeesDataSource employeeDataSource;

    public EmployeeRepository(EmployeesDataSource employeeDataSource) {
        this.employeeDataSource = employeeDataSource;
    }

    public ArrayList<EmployeeModel> getEmployeeAsManager() {
        return new ArrayList<>();
    }

    public int updateDataEmployee(EmployeeModel em) {
        // TODO

        try {
            return employeeDataSource.updateEmployee(
            em.getNama(),
            em.getNoHp(), 
            em.getEmail(), 
            em.getRole(), 
            em.getStatus(), 
            em.getId()
            );
        } catch (Exception e) {
            System.out.println("Employee Repo " + e.getLocalizedMessage());
            return -1;
        }

    }

    public int addNewEmployee(EmployeeModel em) {
        try{
            return employeeDataSource.insertEmployee(
                    em.getNama(), 
                    em.getNoHp(), 
                    em.getEmail(), 
                    em.getRole(), 
                    em.getStatus(), 
                    em.getPass()
            );
            
        }catch (Exception e){
            System.out.println("Employee Repo " + e.getLocalizedMessage());
            return -1;    
        }
        
    }

}

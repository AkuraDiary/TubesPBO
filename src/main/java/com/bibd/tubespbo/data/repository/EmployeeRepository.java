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

    public ArrayList<EmployeeModel> getEmployeeAsManager() {
        return new ArrayList<>();
    }

    public int updateDataEmployee(EmployeeModel selectedDataEmployee) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bibd.tubespbo.data.repository;

import com.bibd.tubespbo.data.model.EmployeeModel;
import com.bibd.tubespbo.data.model.WarehouseModel;
import com.bibd.tubespbo.data.source.EmployeesDataSource;
import com.bibd.tubespbo.data.source.WarehouseDataSource;
import com.bibd.tubespbo.util.Statics;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author asthiseta
 */
public class EmployeeRepository {

    EmployeesDataSource employeeDataSource;
    WarehouseDataSource warehouseDataSource;

    public EmployeeRepository(EmployeesDataSource employeeDataSource, WarehouseDataSource warehouseDataSource) {
        this.warehouseDataSource = warehouseDataSource;
        this.employeeDataSource = employeeDataSource;
    }
    
    public ArrayList<WarehouseModel> getAllWarehouse(){
        return warehouseDataSource.getAllWarehouse();
    }

    public ArrayList<EmployeeModel> getEmployeeAsManager() {
        
        ArrayList<EmployeeModel> listAllEmployee = employeeDataSource.getAllEmployee();
        ArrayList<EmployeeModel> filteredEmployee = new ArrayList<>();
        
        for(EmployeeModel em : listAllEmployee){
            if(!em.getRole().equals(Statics.EMPLOYEE_ROLE_MANAGER)){
                filteredEmployee.add(em);
            }
            
        }
        return filteredEmployee;
    }

    public int updateDataEmployee(EmployeeModel em) {
        try {
            return employeeDataSource.updateEmployee(
            em.getNama(),
            em.getNoHp(), 
            em.getEmail(), 
            em.getRole(), 
            em.getStatus(), 
            em.getId(),
            em.getIdWarehouse(),
            em.getPass()
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
                    em.getPass(),
                    em.getIdWarehouse()
                   
            );
            
        }catch (Exception e){
            System.out.println("Employee Repo " + e.getLocalizedMessage());
            return -1;    
        }
        
    }

}

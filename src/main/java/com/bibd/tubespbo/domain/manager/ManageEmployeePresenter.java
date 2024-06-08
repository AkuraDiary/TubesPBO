/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bibd.tubespbo.domain.manager;

import com.bibd.tubespbo.data.model.EmployeeModel;
import com.bibd.tubespbo.data.repository.EmployeeRepository;
import java.util.ArrayList;

/**
 *
 * @author asthiseta
 */
public class ManageEmployeePresenter {

    EmployeeRepository employeeRepository;

    public ManageEmployeePresenter(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public ArrayList<EmployeeModel> listEmployee = new ArrayList<>();

    public void getAllEmplyoees() {
        this.listEmployee = employeeRepository.getEmployeeAsManager();
    }

    EmployeeModel selectedDataEmployee;

    int statusUpdateEmployee = 0; // 0 default state; -1 error ; -2 not selected 

    public void updateDataEmployee() {
        if (selectedDataEmployee == null) {
            statusUpdateEmployee = -2;
            return;
        }
        statusUpdateEmployee = employeeRepository.updateDataEmployee(selectedDataEmployee);
    }

    public void resetSelectedDataEmployee() {
        statusUpdateEmployee = 0;
        selectedDataEmployee = null;
    }

    int statusAddNewEmployee = 0;

    public void resetAddEmployeeState() {
        statusAddNewEmployee = 0;
    }

    public void addNewEmployee(EmployeeModel em) {
        statusAddNewEmployee = employeeRepository.addNewEmployee(em);
    }

    public void setSelectedEmployee(int empId) {
        selectedDataEmployee = listEmployee.stream()
                .filter(item -> item.getId() == empId)
                .findFirst()
                .orElse(null);
    }
}

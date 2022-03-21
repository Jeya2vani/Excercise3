package com.example.springmongodb.controller;

import com.example.springmongodb.dto.EmployeeResponse;
import com.example.springmongodb.entity.Address;
import com.example.springmongodb.entity.Employee;
import com.example.springmongodb.repository.AddressRepository;
import com.example.springmongodb.repository.EmployeeRepository;
import com.example.springmongodb.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("EmployeeDetails")
public class EmployeeController {
    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    EmployeeService employeeService;

    @GetMapping("/findEmployee")
    public List<Employee> findAll(){
        return employeeRepository.findAll();
    }
    @GetMapping("/findAddress")
    public List<Address> findAllAddress(){
        return addressRepository.findAll();
    }
    @GetMapping("/findEmployeeResponse")
    public List<EmployeeResponse> employeeResponseList1(){
        return employeeService.getAllEmployee();
    }
    @GetMapping("/findAddressResponse")
    public List<EmployeeResponse> employeeResponseList2(){
        return employeeService.getAllEmployeeAddress();
    }
}

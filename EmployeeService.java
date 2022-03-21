package com.example.springmongodb.service;

import com.example.springmongodb.dto.EmployeeResponse;
import com.example.springmongodb.entity.Address;
import com.example.springmongodb.entity.Employee;
import com.example.springmongodb.repository.AddressRepository;
import com.example.springmongodb.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private AddressRepository addressRepository;

    public EmployeeResponse getEmployee(Employee employee)
    {
        EmployeeResponse employeeResponse=new EmployeeResponse();
        employeeResponse.setName(employee.getName());
        return employeeResponse;
    }
    public EmployeeResponse getEmployeeAddress(Address address)
    {
        EmployeeResponse employeeResponse=new EmployeeResponse();
        employeeResponse.setDoorno(address.getDoorno());
        employeeResponse.setStreet(address.getStreet());
        employeeResponse.setCity(address.getCity());
        employeeResponse.setState(address.getState());
        return employeeResponse;
    }
    public List<EmployeeResponse> getAllEmployee() {
        List<Employee> employees=employeeRepository.findAll();
        return employees.stream().map(this::getEmployee).collect(Collectors.toList());
    }
    public List<EmployeeResponse> getAllEmployeeAddress(){
        List<Employee> employees=employeeRepository.findAll();
        List<Address> addresses=addressRepository.findAll();
        return addresses.stream().map(this::getEmployeeAddress).collect(Collectors.toList());
    }

    /*public EmployeeResponse getNewEmployee()
    {
        Employee employee=new Employee();
        Address address=new Address();
        //List<Address> addressList=addressRepository.findAll();
        EmployeeResponse employeeResponse=new EmployeeResponse();
        employeeResponse.setName(employee.getName());
        employeeResponse.setDoorno(address.getDoorno());
        employeeResponse.setStreet(address.getStreet());
        employeeResponse.setCity(address.getCity());
        employeeResponse.setState(address.getState());
        //addressList.stream().map(x->employeeResponse).collect(Collectors.toList());
        return employeeResponse;
    }
    public List<EmployeeResponse> getNewEmployees(){
        List<Employee> employeeList=employeeRepository.findAll();
        List<Address> addressList=addressRepository.findAll();
        EmployeeResponse e1= (EmployeeResponse) employeeList.stream().map(x -> getNewEmployee()).collect(Collectors.toList());
        EmployeeResponse e2= (EmployeeResponse) addressList.stream().map(x->e1).collect(Collectors.toList());
        EmployeeResponse e3= (EmployeeResponse) employeeList.stream().map(x->e2).collect(Collectors.toList());
        return (List<EmployeeResponse>) e3;
    }*/
}

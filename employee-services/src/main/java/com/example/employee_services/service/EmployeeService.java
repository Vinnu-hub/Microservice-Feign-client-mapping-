package com.example.employee_services.service;

import com.example.employee_services.entity.Employee;
import com.example.employee_services.feignclient.AddressClient;
import com.example.employee_services.repo.EmployeeRepo;
import com.example.employee_services.response.AddressResponse;
import com.example.employee_services.response.EmployeeResponse;
import feign.FeignException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepo employeeRepo;

    @Autowired
    private ModelMapper mapper;

    @Autowired
    private AddressClient addressClient;

    public EmployeeResponse getEmployeeById(int id) {
        // Fetch employee by ID
        Optional<Employee> employeeOpt = employeeRepo.findById(id);
        Employee employee = employeeOpt.orElseThrow(() -> new RuntimeException("Employee not found"));

        EmployeeResponse employeeResponse = mapper.map(employee, EmployeeResponse.class);

        try {
            // Call to the Feign client to get address
            ResponseEntity<AddressResponse> addressResponse = addressClient.getAddressByEmployeeId(id);
            employeeResponse.setAddressResponse(addressResponse.getBody());
        } catch (FeignException e) {
            // Log the error and handle it accordingly
            System.err.println("Error fetching address: " + e.getMessage());
            employeeResponse.setAddressResponse(null); // or set a default address response
        }

        return employeeResponse;
    }
}

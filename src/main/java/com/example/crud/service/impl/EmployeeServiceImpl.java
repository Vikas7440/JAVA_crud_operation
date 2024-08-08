package com.example.crud.service.impl;

import com.example.crud.dto.EmployeeDto;
import com.example.crud.entity.Employee;
import com.example.crud.exception.ResourceNotFoundException;
import com.example.crud.mapper.EmployeeMapper;
import com.example.crud.repository.EmployeeRepository;
import com.example.crud.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;

    @Override
    public EmployeeDto createEmployee(EmployeeDto employeeDto) {

        Employee employee = EmployeeMapper.mapToEmployee(employeeDto);
        Employee saveEmployee = employeeRepository.save(employee);
        return EmployeeMapper.mapToEmployeeDto(saveEmployee);
    }

    @Override
    public EmployeeDto getEmployeeById(Long employeeId) {
        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(() -> new ResourceNotFoundException("Employee is not exist with given id : "));

        return EmployeeMapper.mapToEmployeeDto(employee);
    }
}

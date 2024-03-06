package com.mindex.challenge.service.impl;

import com.mindex.challenge.dao.EmployeeRepository;
import com.mindex.challenge.data.Employee;
import com.mindex.challenge.service.EmployeeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

/**Employee service class method logic*/
@Service
public class EmployeeServiceImpl implements EmployeeService {

    private static final Logger LOG = LoggerFactory.getLogger(EmployeeServiceImpl.class);

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public Employee create(Employee employee) {
        LOG.debug("Creating employee [{}]", employee);

        /*Generate random UUID for employee id*/
        employee.setEmployeeId(UUID.randomUUID().toString());

        /*Inserts employee into DB*/
        employeeRepository.insert(employee);

        return employee;
    }

    @Override
    public Employee read(String id) {
        LOG.debug("Creating employee with id [{}]", id);
        Employee employee = employeeRepository.findByEmployeeId(id);

        if (employee == null) {
            throw new RuntimeException("Invalid employeeId: " + id);
        }

        return employee;
    }

    @Override
    public Employee update(Employee employee) {
        LOG.debug("Updating employee [{}]", employee);

        return employeeRepository.save(employee);
    }


    public int getNumberOfReports(String employeeId) {
       /*Variable will store # of total reports*/
        int totalReports = 0;


        Employee employee = this.read(employeeId);
        if (employee == null) {
            throw new RuntimeException("Null employee!");
        }

        /*Get direct reports from employee and store them in a list*/
        List<Employee> reports = employee.getDirectReports();

        /*Using recursion we will pass each employee id from the reports list
        through the getNumberOfReports method and add the
         numberOfReports + 1 to the current totalReports integer */
        if (reports != null) {
            for (Employee reportingEmployee : reports) {
                totalReports += 1 + getNumberOfReports(reportingEmployee.getEmployeeId());
            }
        }

        return totalReports;
    }
}

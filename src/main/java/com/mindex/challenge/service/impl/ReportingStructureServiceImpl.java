package com.mindex.challenge.service.impl;

import com.mindex.challenge.data.Employee;
import com.mindex.challenge.data.ReportingStructure;
import com.mindex.challenge.service.EmployeeService;
import com.mindex.challenge.service.ReportingStructureService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**ReportingStructure service class method logic*/
@Service
public class ReportingStructureServiceImpl implements ReportingStructureService {

    private static final Logger LOG = LoggerFactory.getLogger(ReportingStructureServiceImpl.class);

    @Autowired
    private EmployeeService employeeService;

    /*Retrieve employee by employee id,
    retrieve number of reports by employee id
    return new object containing employee and totalreport objects
     */
    @Override
    public ReportingStructure read(String employeeId) {

        LOG.debug("Reading reportingStructure with employeeId: [{}]", employeeId);
        /**Create employee object by calling the read method from employeeService and passing the employee's id as a parameter*/
        Employee employee = employeeService.read(employeeId);
        int totalReports = employeeService.getNumberOfReports(employeeId);

        return new ReportingStructure(employee, totalReports);
    }
}

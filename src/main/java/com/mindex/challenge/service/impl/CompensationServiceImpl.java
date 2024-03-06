package com.mindex.challenge.service.impl;

import com.mindex.challenge.dao.CompensationRepository;
import com.mindex.challenge.data.Compensation;
import com.mindex.challenge.data.Employee;
import com.mindex.challenge.service.CompensationService;
import com.mindex.challenge.service.EmployeeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**Compensation service class method logic*/
@Service
public class CompensationServiceImpl implements CompensationService {
    private static final Logger LOG = LoggerFactory.getLogger(CompensationServiceImpl.class);
    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private CompensationRepository compensationRepository;

    /*Retrieve the passed emplyee id,
    set the employee object to the previously found employee object,
    then insert the compensation object into the compensation table */
    @Override
    public Compensation create(Compensation compensation) {
        LOG.debug("Creating compensation [{}]", compensation);
        Employee employee = employeeService.read(compensation.getEmployee().getEmployeeId());
        compensation.setEmployee(employee);
        compensationRepository.insert(compensation);

        return compensation;
    }

    /*Retrieve id and store in employee object,
    search for employee object in compensation table,
    return compensation object
     */
    @Override
    public Compensation read(String id) {
        LOG.debug("Reading compensation with id [{}]", id);
        Employee employee = employeeService.read(id);

        Compensation compensation = compensationRepository.findByEmployee(employee);

        if (compensation == null) {
            throw new RuntimeException("Invalid employeeId: " + id);
        }

        return compensation;
    }
}

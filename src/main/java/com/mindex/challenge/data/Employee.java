package com.mindex.challenge.data;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;

import java.util.List;

/**Employee data model leveraging SpringBoot annotations to generate and achieve cleaner code*/
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class Employee {
   @Id
    private String employeeId;
    private String firstName;
    private String lastName;
    private String position;
    private String department;
    @DBRef(lazy=true)
    private List<Employee> directReports;

}

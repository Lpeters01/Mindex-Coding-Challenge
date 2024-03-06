package com.mindex.challenge.data;

import lombok.*;


/**ReportingStructure data model leveraging SpringBoot annotations to generate and achieve cleaner code*/
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class ReportingStructure {
    private Employee employee;
    private int numberOfReports;
}

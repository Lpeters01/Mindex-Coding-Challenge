package com.mindex.challenge.data;

import lombok.*;

import java.util.Objects;

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

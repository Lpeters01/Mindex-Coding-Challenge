package com.mindex.challenge.data;

import lombok.*;
import org.springframework.data.mongodb.core.mapping.DBRef;

import java.time.LocalDateTime;

/**Compensation data model leveraging SpringBoot annotations to generate and achieve cleaner code*/
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class Compensation {
    @DBRef(lazy = true)
    private Employee employee;
    private String salary;
    private LocalDateTime effectiveDate;
}

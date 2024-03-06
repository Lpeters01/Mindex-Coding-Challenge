package com.mindex.challenge.data;

import lombok.*;
import org.springframework.data.mongodb.core.mapping.DBRef;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.Objects;

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

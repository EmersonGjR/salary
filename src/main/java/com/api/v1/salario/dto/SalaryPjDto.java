package com.api.v1.salario.dto;

import lombok.Data;

@Data
public class SalaryPjDto {
    private Double salary;
    private Double discounts;
    private Double tax;
}

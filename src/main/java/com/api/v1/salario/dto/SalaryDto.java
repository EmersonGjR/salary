package com.api.v1.salario.dto;

import lombok.Data;

@Data
public class SalaryDto {
    private Double salary;
    private Double discounts;
    private Boolean vt;
    private Boolean irrf;
    private Boolean inss;
}

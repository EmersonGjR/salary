package com.api.v1.salario.service;

import com.api.v1.salario.dto.SalaryDto;
import com.api.v1.salario.dto.SalaryPjDto;

public interface AppSerivce {
    String computing(SalaryDto salaryDto);

    String computingPj(SalaryPjDto salaryPjDto);
}

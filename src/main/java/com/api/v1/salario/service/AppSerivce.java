package com.api.v1.salario.service;

import com.api.v1.salario.dto.SalaryDto;
import com.api.v1.salario.dto.SalaryPjDto;
import org.springframework.http.ResponseEntity;

public interface AppSerivce {
//    String computing(SalaryDto salaryDto);
    ResponseEntity<Object> computingPj(SalaryPjDto salaryPjDto);
    ResponseEntity<Object> computing(SalaryDto salaryDto);
//    String computingPj(SalaryPjDto salaryPjDto);
}

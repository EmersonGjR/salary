package com.api.v1.salario.controller;

import com.api.v1.salario.dto.SalaryDto;
import com.api.v1.salario.dto.SalaryDtoRec;
import com.api.v1.salario.dto.SalaryPjDto;
import com.api.v1.salario.dto.SalaryVacDto;
import com.api.v1.salario.service.AppSerivce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "/api")
public class ApiController {
    @Autowired
    AppSerivce appSerivce;
    @PostMapping("/calculatorCLT")
    @ResponseBody
    public ResponseEntity<Object> compute(@RequestBody SalaryDto salaryDto) {
        return appSerivce.computing(salaryDto);
    }
    @PostMapping("/calculatorPJ")
    @ResponseBody
    public ResponseEntity<Object> computePj(@RequestBody SalaryPjDto salaryPjDto) {
        return appSerivce.computingPj(salaryPjDto);
    }
    @PostMapping("/calculatorVAC")
    @ResponseBody
    public ResponseEntity<Object> computeVac(@RequestBody SalaryVacDto salaryVacDto){
        return appSerivce.computingVacation(salaryVacDto);
    }
    @PostMapping("/calculatorREC")
    @ResponseBody
    public ResponseEntity<Object> computeRec(@RequestBody SalaryDtoRec salaryDtoRec){
        return appSerivce.computingRec(salaryDtoRec);
    }
}

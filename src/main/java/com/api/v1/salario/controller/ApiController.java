package com.api.v1.salario.controller;

import com.api.v1.salario.dto.SalaryDto;
import com.api.v1.salario.dto.SalaryPjDto;
import com.api.v1.salario.service.AppSerivce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
//    @PostMapping(value = "/calculatorClt", produces = "application/json")
//    @ResponseBody
//    public ResponseEntity<String> compute(@RequestBody SalaryDto salaryDto) {
//        String result = appSerivce.computing(salaryDto);
//        return ResponseEntity.status(HttpStatus.OK).body(result);
//    }
    @PostMapping("/calculatorCLT")
    @ResponseBody
    public String compute(@RequestBody SalaryDto salaryDto) {
            return appSerivce.computing(salaryDto);
    }
    @PostMapping("/calculatorPJ")
    @ResponseBody
    public String computePj(@RequestBody SalaryPjDto salaryPjDto) {
        return appSerivce.computingPj(salaryPjDto);
    }


}

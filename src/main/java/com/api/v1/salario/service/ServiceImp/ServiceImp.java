package com.api.v1.salario.service.ServiceImp;

import com.api.v1.salario.dto.SalaryDto;
import com.api.v1.salario.dto.SalaryPjDto;
import com.api.v1.salario.service.AppSerivce;
import com.api.v1.salario.service.Calculus;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;

@Service
public class ServiceImp implements AppSerivce {
//    @Override
//    public String computingPj(SalaryPjDto salaryPjDto){
//        double salary = salaryPjDto.getSalary();
//        double discounts = 0;
//        double tax = 0;
//        if(salaryPjDto.getDiscounts() != null){
//            discounts = salaryPjDto.getDiscounts();
//        }
//        if(salaryPjDto.getTax() != null){
//            tax = salaryPjDto.getTax();
//        }
//        double result = salary - discounts - tax;
//        DecimalFormat decimalFormat = new DecimalFormat("#,##0.00");
//        decimalFormat.setRoundingMode(RoundingMode.DOWN);
//        return decimalFormat.format(result);
//    }
        //    @Override
//    public String computing(SalaryDto salaryDto){
//        double discounts = 0;
//        Calculus calculus = new Calculus();
//        calculus.setSalary(salaryDto.getSalary());
//        if(salaryDto.getDiscounts() != null){
//            discounts = salaryDto.getDiscounts();
//        }
//        double result = calculus.getSalary() - discounts;
//        DecimalFormat decimalFormat = new DecimalFormat("#,##0.00");
//        decimalFormat.setRoundingMode(RoundingMode.DOWN);
//        return decimalFormat.format(result);
//    }
    @Override
    public ResponseEntity<Object> computingPj(SalaryPjDto salaryPjDto){
        DecimalFormat decimalFormat = new DecimalFormat("#,##0.00");
        decimalFormat.setRoundingMode(RoundingMode.DOWN);
        Map<String, String> data = new HashMap<>();
        double discounts = 0;
        double tax = 0;
        if(salaryPjDto.getDiscounts() != null){ discounts = salaryPjDto.getDiscounts(); }
        if(salaryPjDto.getTax() != null){ tax = salaryPjDto.getTax(); }
        double result = salaryPjDto.getSalary() - discounts - tax;
        data.put("salaryB", decimalFormat.format(salaryPjDto.getSalary()));
        data.put("discounts", decimalFormat.format(discounts));
        data.put("tax", decimalFormat.format(tax));
        data.put("salary", decimalFormat.format(result));
        return new ResponseEntity<>(data, HttpStatus.OK);
    }
    @Override
    public ResponseEntity<Object> computing(SalaryDto salaryDto){
        DecimalFormat decimalFormat = new DecimalFormat("#,##0.00");
        decimalFormat.setRoundingMode(RoundingMode.DOWN);
        Map<String, String> data = new HashMap<>();
        Calculus calculus = new Calculus();
        double discounts = 0.0;
        if(salaryDto.getDiscounts() != null){ discounts = salaryDto.getDiscounts(); }
        calculus.setSalary(salaryDto.getSalary());
        double inss = calculus.inssDes(salaryDto.getSalary());
        data.put("salaryB", decimalFormat.format(salaryDto.getSalary()));
        data.put("inss", decimalFormat.format(inss));
        data.put("irrf", decimalFormat.format(calculus.irrfDes(inss, salaryDto.getSalary())));
        data.put("salary", decimalFormat.format(calculus.getSalary() - discounts));
        data.put("discounts", decimalFormat.format(discounts));
        return new ResponseEntity<>(data, HttpStatus.OK);
    }
}

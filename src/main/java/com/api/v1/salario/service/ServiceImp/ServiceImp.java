package com.api.v1.salario.service.ServiceImp;

import com.api.v1.salario.dto.SalaryDto;
import com.api.v1.salario.dto.SalaryPjDto;
import com.api.v1.salario.service.AppSerivce;
import com.api.v1.salario.service.Calculus;
import org.springframework.stereotype.Service;

import java.math.RoundingMode;
import java.text.DecimalFormat;

@Service
public class ServiceImp implements AppSerivce {

    @Override
    public String computing(SalaryDto salaryDto){
        double discounts = 0;
        Calculus calculus = new Calculus();
        calculus.setSalary(salaryDto.getSalary());
        if(salaryDto.getDiscounts() != null){
            discounts = salaryDto.getDiscounts();
        }
        double result = calculus.getSalary() - discounts;
        DecimalFormat decimalFormat = new DecimalFormat("#,##0.00");
        decimalFormat.setRoundingMode(RoundingMode.DOWN);
        return decimalFormat.format(result);
    }
    @Override
    public String computingPj(SalaryPjDto salaryPjDto){
        double salary = salaryPjDto.getSalary();
        double discounts = 0;
        double tax = 0;
        /*double discounts = salaryPjDto.getDiscounts() != null ? salaryPjDto.getDiscounts() : 0;
        double tax = salaryPjDto.getTax() != null ? salaryPjDto.getTax() : 0;*/
        if(salaryPjDto.getDiscounts() != null){
            discounts = salaryPjDto.getDiscounts();
        }
        if(salaryPjDto.getTax() != null){
            tax = salaryPjDto.getTax();
        }

        double result = salary - discounts - tax;
        DecimalFormat decimalFormat = new DecimalFormat("#,##0.00");
        decimalFormat.setRoundingMode(RoundingMode.DOWN);
        return decimalFormat.format(result);
    }
}

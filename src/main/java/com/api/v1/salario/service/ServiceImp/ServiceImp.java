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
        Calculus calculus = new Calculus();
        calculus.setSalary(salaryDto.getSalary());
        double result = calculus.getSalary() - salaryDto.getDiscounts();
        DecimalFormat decimalFormat = new DecimalFormat("#,##0.00");
        decimalFormat.setRoundingMode(RoundingMode.DOWN);
        return decimalFormat.format(result);
    }
    @Override
    public String computingPj(SalaryPjDto salaryPjDto){
        double result = salaryPjDto.getSalary() - salaryPjDto.getDiscounts() - salaryPjDto.getTax();
        DecimalFormat decimalFormat = new DecimalFormat("#,##0.00");
        decimalFormat.setRoundingMode(RoundingMode.DOWN);
        return decimalFormat.format(result);
    }
}

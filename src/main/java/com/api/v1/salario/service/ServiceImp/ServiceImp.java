package com.api.v1.salario.service.ServiceImp;

import com.api.v1.salario.dto.SalaryDto;
import com.api.v1.salario.dto.SalaryPjDto;
import com.api.v1.salario.dto.SalaryVacDto;
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
    @Override
    public ResponseEntity<Object> computingPj(SalaryPjDto salaryPjDto){
        DecimalFormat decimalFormat = new DecimalFormat("#,##0.00");
        decimalFormat.setRoundingMode(RoundingMode.DOWN);
        Map<String, String> data = new HashMap<>();
        double discounts = 0.0;
        double tax = 0.0;
        double vt = 0.0;
        if(salaryPjDto.getVt()){ vt = salaryPjDto.getSalary() * 0.06; }
        if(salaryPjDto.getDiscounts() != null){ discounts = salaryPjDto.getDiscounts(); }
        if(salaryPjDto.getTax() != null){ tax = salaryPjDto.getTax(); }
        double result = salaryPjDto.getSalary() - discounts - tax - vt;
        data.put("salaryB", decimalFormat.format(salaryPjDto.getSalary()));
        data.put("discounts", decimalFormat.format(discounts));
        data.put("tax", decimalFormat.format(tax));
        data.put("vt", decimalFormat.format(vt));
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
        double vt = 0.0;
        double inss = 0.0;
        double irrf = 0.0;
        if(salaryDto.getInss()){ inss = calculus.inssDes(salaryDto.getSalary()); }
        if(salaryDto.getIrrf()){ irrf =  calculus.irrfDes(calculus.inssDes(salaryDto.getSalary()), salaryDto.getSalary());}
        if(salaryDto.getVt()){ vt = calculus.vt(salaryDto.getSalary()); }
        if(salaryDto.getDiscounts() != null){ discounts = salaryDto.getDiscounts(); }
        calculus.setSalary(salaryDto.getSalary());
        data.put("vt", decimalFormat.format(vt));
        data.put("salaryB", decimalFormat.format(salaryDto.getSalary()));
        data.put("inss", decimalFormat.format(inss));
        data.put("irrf", decimalFormat.format(irrf));
        if(salaryDto.getIrrf() && salaryDto.getInss()) {
            data.put("salary", decimalFormat.format(calculus.getSalary() - discounts - vt));
        }else{
            data.put("salary", decimalFormat.format(salaryDto.getSalary() - irrf - inss - discounts - vt));
        }
        data.put("discounts", decimalFormat.format(discounts));
        return new ResponseEntity<>(data, HttpStatus.OK);
    }
    @Override
    public ResponseEntity<Object> computingVacation(SalaryVacDto salaryVacDto){
        DecimalFormat decimalFormat = new DecimalFormat("#,##0.00");
        decimalFormat.setRoundingMode(RoundingMode.DOWN);
        Map<String, String> data = new HashMap<>();
        Calculus calculus = new Calculus();
        double oneThree = salaryVacDto.getSalary() + (salaryVacDto.getSalary() * 0.33);
        double inss = calculus.inssDes(oneThree);
        double irrf = calculus.irrfDes(inss, oneThree);
        data.put("salaryB", decimalFormat.format(salaryVacDto.getSalary()));
        data.put("oneThree", decimalFormat.format(oneThree));
        data.put("irrf", decimalFormat.format(irrf));
        data.put("inss", decimalFormat.format(inss));
        data.put("salary", decimalFormat.format(oneThree - inss - irrf));
        return new ResponseEntity<>(data, HttpStatus.OK);
    }
}

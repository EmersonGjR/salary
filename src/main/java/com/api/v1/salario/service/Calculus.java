package com.api.v1.salario.service;

import lombok.Getter;
import lombok.Setter;

public class Calculus {
    @Setter
    private Double salary;
    public double vt(double valor){
        return valor * 0.06;
    }
    public double inssDes(double valor){
        if(valor < 1320.01){
            return valor * 0.075;
        }else if(valor < 2571.30){
            return (valor - 1320.01)* 0.09 + 99;
        }else if(valor < 3856.95){
            return (valor - 2571.30)* 0.12 + 99 + 112.62;
        }else if(valor < 7507.50){
            return (valor - 3856.95)* 0.14 + 99 + 112.62 + 154.28;
        }
        return 877.25;
    }
    public double irrfDes(double inss, double valor){
        double result = valor - inss;
        if(result < 2112.01) return 0;
        else if(result < 2826.66){
            return ((result * 7.5)/100) - 158.40;
        }else if(result < 3751.07){
            return ((result * 15)/100) - 370.40;
        }else if(result < 4664.69){
            return ((result * 22.5) / 100) - 651.73;
        }
        return ((result * 27.5) / 100) - 884.96;
    }
    public Double getSalary(){
        return (salary - inssDes(salary)) - irrfDes(inssDes(salary), salary);
    }
}

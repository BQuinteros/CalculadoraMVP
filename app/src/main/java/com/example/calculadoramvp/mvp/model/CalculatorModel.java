package com.example.calculadoramvp.mvp.model;

import static com.example.calculadoramvp.utils.Utils.EMPTY_STRING;
import static com.example.calculadoramvp.utils.Utils.ZERO_FLOAT;

public class CalculatorModel {
    private String firstOperand;
    private String secondOperand;
    private String operator;
    private float result;

    public CalculatorModel(){
        firstOperand = EMPTY_STRING;
        secondOperand = EMPTY_STRING;
        operator = EMPTY_STRING;
        result = ZERO_FLOAT;
    }

    public void cleanVisor() {
        firstOperand = EMPTY_STRING;
        secondOperand = EMPTY_STRING;
        operator = EMPTY_STRING;
        result = 0;
    }

    public void setFirstOperand(String firstOperand) {
        this.firstOperand = firstOperand;
    }

    public void setSecondOperand(String secondOperand) {
        this.secondOperand = secondOperand;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public void setResult(float result) { this.result = result; }

    public String getFirstOperand() {
        return firstOperand;
    }

    public String getSecondOperand() {
        return secondOperand;
    }

    public String getOperator() {
        return operator;
    }

    public float getResult() {
        return result;
    }
}

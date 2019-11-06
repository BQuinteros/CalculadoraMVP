package com.example.calculadoramvp.mvp.model;

import static com.example.calculadoramvp.utils.Utils.EMPTY_STRING;

public class CalculatorModel {

    private String firstOperand;
    private String secondOperand;
    private String operator;
    private float result;

    public void cleanVisor() {
        firstOperand = EMPTY_STRING;
        secondOperand = EMPTY_STRING;
        operator = EMPTY_STRING;
        result = 0;
    }

    public CalculatorModel(){
        firstOperand = EMPTY_STRING;
        secondOperand = EMPTY_STRING;
        operator = EMPTY_STRING;
        result = 0;
    }

    public void setFirstOperand(String operand_1) {
        this.firstOperand = operand_1;
    }

    public void setSecondOperand(String operand_2) {
        this.secondOperand = operand_2;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public void setResult(float result) {
        this.result = result;
    }

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

package com.example.calculadoramvp.mvp.model;

import static com.example.calculadoramvp.Utils.EMPTY_STRING;

public class CalculatorModel {

    private String operand_1;
    private String operand_2;
    private String operator;
    private float result;

    public void cleanVisor() {
        operand_1 = EMPTY_STRING;
        operand_2 = EMPTY_STRING;
        operator = EMPTY_STRING;
        result = 0;
    }

    public CalculatorModel(){
        operand_1 = EMPTY_STRING;
        operand_2 = EMPTY_STRING;
        operator = EMPTY_STRING;
        result = 0;
    }

    public void setOperand_1(String operand_1) {
        this.operand_1 = operand_1;
    }

    public void setOperand_2(String operand_2) {
        this.operand_2 = operand_2;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public void setResult(float result) {
        this.result = result;
    }

    public String getOperand_1() {
        return operand_1;
    }

    public String getOperand_2() {
        return operand_2;
    }

    public String getOperator() {
        return operator;
    }

    public float getResult() {
        return result;
    }
}

package com.example.calculadoramvp.mvp.presenter;

import com.example.calculadoramvp.mvp.model.CalculatorModel;
import com.example.calculadoramvp.mvp.view.CalculatorView;

import android.widget.Toast;

import static com.example.calculadoramvp.Utils.EMPTY_STRING;
import static com.example.calculadoramvp.Utils.TOAST_MSG_FIRST_OPERAND;

public class CalculatorPresenter {

    CalculatorView view;
    CalculatorModel model;


    public CalculatorPresenter(CalculatorModel model, CalculatorView view){
        this.model = model;
        this.view = view;
    }

    public void onNumberPressed(String number){

        if (model.getOperand_1()==""){
            model.setOperand_1(number);
            view.setVisor(number);
        }
        else if (model.getOperand_1() != EMPTY_STRING && model.getOperator()=="") {
            model.setOperand_1(model.getOperand_1() + number);
            view.setVisor(model.getOperand_1());
        }
        else {
            model.setOperand_2(model.getOperand_2() + number);
            view.setVisor(model.getOperand_1() + model.getOperator() + model.getOperand_2());
        }
    }

    public void onOperatorPressed(String operator){

        if (model.getOperand_1() != EMPTY_STRING && model.getOperand_2()==EMPTY_STRING){
            model.setOperator(operator);
            view.setVisor(model.getOperand_1()+model.getOperator());
        }
        else {
            Toast.makeText(view , TOAST_MSG_FIRST_OPERAND, Toast.LENGTH_SHORT).show();
        }
    }

    public void onEqualsPressed(){

        if (model.getOperator()=="+"){
            model.setResult(Integer.parseInt(model.getOperand_1()) + Integer.parseInt(model.getOperand_2()));
            view.showResult(model.getResult());
        }

    }
}


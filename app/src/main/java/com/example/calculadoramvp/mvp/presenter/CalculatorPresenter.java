package com.example.calculadoramvp.mvp.presenter;
import com.example.calculadoramvp.mvp.model.CalculatorModel;
import com.example.calculadoramvp.mvp.view.CalculatorView;
import android.widget.Toast;
import static com.example.calculadoramvp.utils.Utils.EMPTY_STRING;
import static com.example.calculadoramvp.utils.Utils.PLUS;
import static com.example.calculadoramvp.utils.Utils.TOAST_MSG_FIRST_OPERAND;

public class CalculatorPresenter {
    CalculatorView view;
    CalculatorModel model;


    public CalculatorPresenter(CalculatorModel model, CalculatorView view){
        this.model = model;
        this.view = view;
    }

    public void onNumberPressed(String number){
        if (model.getFirstOperand()==EMPTY_STRING){
            model.setFirstOperand(number);
            view.setVisor(number);
        }
        else if (model.getFirstOperand() != EMPTY_STRING && model.getOperator()==EMPTY_STRING) {
            model.setFirstOperand(model.getFirstOperand() + number);
            view.setVisor(model.getFirstOperand());
        }
        else {
            model.setSecondOperand(model.getSecondOperand() + number);
            view.setVisor(model.getFirstOperand() + model.getOperator() + model.getSecondOperand());
        }
    }

    public void onOperatorPressed(String operator){
        if (model.getFirstOperand() != EMPTY_STRING && model.getSecondOperand()==EMPTY_STRING){
            model.setOperator(operator);
            view.setVisor(model.getFirstOperand()+model.getOperator());
        }
        else {
            Toast.makeText(view , TOAST_MSG_FIRST_OPERAND, Toast.LENGTH_SHORT).show();
        }
    }

    public void onEqualsPressed(){
        if (model.getOperator()==PLUS){
            model.setResult(Integer.parseInt(model.getFirstOperand()) + Integer.parseInt(model.getSecondOperand()));
            view.showResult(model.getResult());
        }
        //TODO others operations like minus, multiplication and division

    }
}


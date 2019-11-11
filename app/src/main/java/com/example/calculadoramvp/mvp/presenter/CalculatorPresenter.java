package com.example.calculadoramvp.mvp.presenter;

import com.example.calculadoramvp.R;
import com.example.calculadoramvp.mvp.model.CalculatorModel;
import com.example.calculadoramvp.mvp.view.CalculatorView;

import static com.example.calculadoramvp.utils.Utils.DIVIDE;
import static com.example.calculadoramvp.utils.Utils.EMPTY_STRING;
import static com.example.calculadoramvp.utils.Utils.MINUS;
import static com.example.calculadoramvp.utils.Utils.MULTIPLICATION;
import static com.example.calculadoramvp.utils.Utils.PLUS;
import static com.example.calculadoramvp.utils.Utils.ZERO;
import static com.example.calculadoramvp.utils.Utils.ZERO_FLOAT;

public class CalculatorPresenter {
    private CalculatorView view;
    private CalculatorModel model;

    public CalculatorPresenter(CalculatorModel model, CalculatorView view) {
        this.model = model;
        this.view = view;
    }

    public void onNumberPressed(String number) {
        if (model.getResult() != 0 && model.getOperator().equals(EMPTY_STRING)){
                model.cleanVisor();
                view.setVisor(EMPTY_STRING);
        }
        if (model.getFirstOperand().equals(EMPTY_STRING) && model.getOperator().equals(EMPTY_STRING)) {
            model.setFirstOperand(number);
            view.setVisor(number);
        } else if (!model.getFirstOperand().equals(EMPTY_STRING) && model.getOperator().equals(EMPTY_STRING)) {
            model.setFirstOperand(model.getFirstOperand() + number);
            view.setVisor(model.getFirstOperand());
        } else {
            model.setSecondOperand(model.getSecondOperand() + number);
            view.setVisor(model.getFirstOperand() + model.getOperator() + model.getSecondOperand());
        }
    }

    public void onOperatorPressed(String operator) {
        if (model.getResult() == 0) {
            if (!model.getFirstOperand().equals(EMPTY_STRING) && model.getSecondOperand().equals(EMPTY_STRING)) {
                model.setOperator(operator);
                view.setVisor(model.getFirstOperand() + model.getOperator());
            }
        }else {
            view.setVisor(EMPTY_STRING);
            model.setFirstOperand(Float.toString(model.getResult()));
            model.setOperator(operator);
            model.setResult(ZERO_FLOAT);
            view.setVisor(model.getFirstOperand() + model.getOperator());
        }
    }

    public void onEqualsPressed() {
        if (model.getOperator() != EMPTY_STRING){
            switch (model.getOperator()) {
                case PLUS:
                    model.setResult(Float.parseFloat(model.getFirstOperand()) + Float.parseFloat(model.getSecondOperand()));
                    break;
                case MINUS:
                    model.setResult(Float.parseFloat(model.getFirstOperand()) - Float.parseFloat(model.getSecondOperand()));
                    break;
                case MULTIPLICATION:
                    model.setResult(Float.parseFloat(model.getFirstOperand()) * Float.parseFloat(model.getSecondOperand()));
                    break;
                case DIVIDE:
                    if (!model.getSecondOperand().equals(ZERO)){
                        model.setResult(Float.parseFloat(model.getFirstOperand()) / Float.parseFloat(model.getSecondOperand()));}
                    else{
                        view.showMessageOperation(R.string.toast_msg_divide);
                        view.setVisor(EMPTY_STRING);
                        }
                default:
                    break;
            }
        view.showResult(String.valueOf(model.getResult()));
        model.setSecondOperand(EMPTY_STRING);
        model.setOperator(EMPTY_STRING);
        }
    }

    public void onClearPressed(){
        if (!model.getSecondOperand().equals(EMPTY_STRING)){
            model.setSecondOperand(model.getSecondOperand().substring(0,model.getSecondOperand().length()-1));
            view.setVisor(model.getFirstOperand() + model.getOperator() + model.getSecondOperand());
        }
        else if (!model.getOperator().equals(EMPTY_STRING)){
            model.setOperator(EMPTY_STRING);
            view.setVisor(model.getFirstOperand());
        }
        else if (!model.getFirstOperand().equals(EMPTY_STRING)){
            model.setFirstOperand(model.getFirstOperand().substring(0,model.getFirstOperand().length()-1));
            view.setVisor(model.getFirstOperand());
        }
    }

    public void onClearAllPressed(){
        model.cleanVisor();
        view.setVisor(EMPTY_STRING);
        view.showResult(EMPTY_STRING);
    }
}


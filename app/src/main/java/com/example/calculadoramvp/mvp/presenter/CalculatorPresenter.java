package com.example.calculadoramvp.mvp.presenter;

import com.example.calculadoramvp.mvp.model.CalculatorModel;
import com.example.calculadoramvp.mvp.view.CalculatorView;

public class CalculatorPresenter {
    private CalculatorModel model;
    private CalculatorView view;

    public CalculatorPresenter(CalculatorModel model, CalculatorView view){
        this.model = model;
        this.view = view;
    }

    public void onButtonPressed(){
        //TODO
        /*IF IS =
        IN MODEL I REALIZE A COUNT
        MODIFIED THE VIEW TO SHOW THE RESULT
        IF IS NOT =
        IN THE VIEW SHOW NUMBERS*/
    }

    public void onResetButtonPressed(){

    }

}

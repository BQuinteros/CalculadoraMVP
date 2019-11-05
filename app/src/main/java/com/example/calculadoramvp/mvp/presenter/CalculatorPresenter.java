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
        //SI ES UN =
        //modelo realizo la cuenta
        //view muestro el resultado
        //SI ES DISTINTO
        //view muestro numero
    }

    public void onResetButtonPressed(){

    }

}

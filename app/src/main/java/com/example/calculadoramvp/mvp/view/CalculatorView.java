package com.example.calculadoramvp.mvp.view;

import android.app.Activity;
import android.widget.TextView;
import com.example.calculadoramvp.R;

import butterknife.BindView;
import butterknife.ButterKnife;



public class CalculatorView extends ActivityView {

    @BindView(R.id.visor_operation) TextView visorOperation;
    @BindView(R.id.visor_result) TextView visorResult;

    public CalculatorView(Activity activity){
        super(activity);
        ButterKnife.bind(this,activity);
    }

    public void setVisor(String visor) {

        visorOperation.setText(visor);
    }


    public void showResult(float result) {

        visorResult.setText(String.valueOf(result));
    }


}
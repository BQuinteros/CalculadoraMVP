package com.example.calculadoramvp.mvp.view;

import android.app.Activity;
import android.widget.Button;
import android.widget.TextView;
import com.example.calculadoramvp.R;
import com.example.calculadoramvp.mvp.view.base.ActivityView;
import butterknife.BindView;
import butterknife.ButterKnife;

public class CalculatorView extends ActivityView {
    @BindView(R.id.visor_operation) TextView visorOperation;
    @BindView(R.id.visor_result) TextView visorResult;
    @BindView(R.id.button_equal) Button equals;

    public CalculatorView(Activity activity){
        super(activity);
        ButterKnife.bind(this, activity);
        equals.setEnabled(false);
    }

    public void setVisor(String visor) {
        visorOperation.setText(visor);
    }

    public void showResult(float result) {
        visorResult.setText(String.valueOf(result));
    }

    public void enableEquals(){
        equals.setEnabled(true);
    }

    public void disableEquals(){
        equals.setEnabled(false);
    }


}
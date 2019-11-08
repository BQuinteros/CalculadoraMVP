package com.example.calculadoramvp.mvp.view;

import android.app.Activity;
import android.widget.TextView;
import android.widget.Toast;

import com.example.calculadoramvp.R;
import com.example.calculadoramvp.mvp.view.base.ActivityView;
import butterknife.BindView;
import butterknife.ButterKnife;

import static com.example.calculadoramvp.utils.Utils.TOAST_ERROR_OPERATOR_MSG;
import static com.example.calculadoramvp.utils.Utils.TOAST_MSG_DIVIDE;

public class CalculatorView extends ActivityView {

    @BindView(R.id.visor_operation) TextView visorOperation;
    @BindView(R.id.visor_result) TextView visorResult;

    public CalculatorView(Activity activity){
        super(activity);
        ButterKnife.bind(this, activity);
    }

    public void setVisor(String visor) {
        visorOperation.setText(visor);
    }

    public void showResult(float result) {
        visorResult.setText(String.valueOf(result));
    }

    public void showMessageOperation(){
        Toast.makeText( getContext(), TOAST_ERROR_OPERATOR_MSG, Toast.LENGTH_SHORT).show();
    }

    public void showMessageDivide(){
        Toast.makeText( getContext(), TOAST_MSG_DIVIDE, Toast.LENGTH_SHORT).show();
    }
}
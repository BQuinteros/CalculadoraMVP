package com.example.calculadoramvp.activity;

import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.example.calculadoramvp.R;
import com.example.calculadoramvp.mvp.model.CalculatorModel;
import com.example.calculadoramvp.mvp.presenter.CalculatorPresenter;
import com.example.calculadoramvp.mvp.view.CalculatorView;

public class MainActivity extends AppCompatActivity {
    private CalculatorPresenter presenter;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        presenter = new CalculatorPresenter(new CalculatorModel(), new CalculatorView(this));
    }
}

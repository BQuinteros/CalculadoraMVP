package com.example.calculadoramvp.activity;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.example.calculadoramvp.R;
import com.example.calculadoramvp.mvp.model.CalculatorModel;
import com.example.calculadoramvp.mvp.presenter.CalculatorPresenter;
import com.example.calculadoramvp.mvp.view.CalculatorView;

public class MainActivity extends AppCompatActivity {
    private CalculatorPresenter presenter;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        presenter = new CalculatorPresenter(new CalculatorModel(), new CalculatorView(this));
    }
}

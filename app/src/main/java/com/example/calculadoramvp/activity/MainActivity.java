package com.example.calculadoramvp.activity;

import android.graphics.Point;
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

import static com.example.calculadoramvp.utils.Utils.DIVIDE;
import static com.example.calculadoramvp.utils.Utils.EIGHT;
import static com.example.calculadoramvp.utils.Utils.FIVE;
import static com.example.calculadoramvp.utils.Utils.FOUR;
import static com.example.calculadoramvp.utils.Utils.MINUS;
import static com.example.calculadoramvp.utils.Utils.NINE;
import static com.example.calculadoramvp.utils.Utils.ONE;
import static com.example.calculadoramvp.utils.Utils.PLUS;
import static com.example.calculadoramvp.utils.Utils.SEVEN;
import static com.example.calculadoramvp.utils.Utils.SIX;
import static com.example.calculadoramvp.utils.Utils.THREE;
import static com.example.calculadoramvp.utils.Utils.TWO;
import static com.example.calculadoramvp.utils.Utils.ZERO;

public class MainActivity extends AppCompatActivity {
    private CalculatorPresenter presenter;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        presenter = new CalculatorPresenter(new CalculatorModel(), new CalculatorView(this));
    }

    @OnClick(R.id.button_zero)
    public void onButtonZeroPressed(){
        presenter.onNumberPressed(ZERO);
    }

    @OnClick(R.id.button_one)
    public void onButtonOnePressed(){
        presenter.onNumberPressed(ONE);
    }

    @OnClick(R.id.button_two)
    public void onButtonTwoPressed(){
        presenter.onNumberPressed(TWO);
    }

    @OnClick(R.id.button_three)
    public void onButtonThreePressed(){
        presenter.onNumberPressed(THREE);
    }

    @OnClick(R.id.button_four)
    public void onButtonFourPressed(){
        presenter.onNumberPressed(FOUR);
    }

    @OnClick(R.id.button_five)
    public void onButtonFivePressed(){
        presenter.onNumberPressed(FIVE);
    }
    @OnClick(R.id.button_six)
    public void onButtonSixPressed(){
        presenter.onNumberPressed(SIX);
    }

    @OnClick(R.id.button_seven)
    public void onButtonSevenPressed(){
        presenter.onNumberPressed(SEVEN);
    }

    @OnClick(R.id.button_eight)
    public void onButtonEightPressed(){
        presenter.onNumberPressed(EIGHT);
    }

    @OnClick(R.id.button_nine)
    public void onButtonNinePressed(){
        presenter.onNumberPressed(NINE);
    }

    @OnClick(R.id.button_equal)
    public void onButtonEqualPressed(){
        presenter.onEqualsPressed();
    }

    @OnClick(R.id.button_share)
    public void onButtonDividePressed(){
        presenter.onOperatorPressed(DIVIDE);
    }

    @OnClick(R.id.button_point)
    public void onButtonPointPressed(){
    }

    @OnClick(R.id.button_sum)
    public void onButtonSumPressed(){
        presenter.onOperatorPressed(PLUS);
    }

    @OnClick(R.id.button_subtract)
    public void onButtonSubtractPressed(){
        presenter.onOperatorPressed(MINUS);
    }
}

package com.example.calculadoramvp.mvp.presenter;

import com.example.calculadoramvp.mvp.model.CalculatorModel;
import com.example.calculadoramvp.mvp.view.CalculatorView;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static com.example.calculadoramvp.utils.Utils.DIVIDE;
import static com.example.calculadoramvp.utils.Utils.FOUR;
import static com.example.calculadoramvp.utils.Utils.MINUS;
import static com.example.calculadoramvp.utils.Utils.MULTIPLICATION;
import static com.example.calculadoramvp.utils.Utils.ONE;
import static com.example.calculadoramvp.utils.Utils.PLUS;
import static com.example.calculadoramvp.utils.Utils.THREE;
import static com.example.calculadoramvp.utils.Utils.TWO;
import static com.example.calculadoramvp.utils.Utils.ZERO;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

public class CalculatorPresenterTest {

    private static final float ONE_FLOAT = 1;
    private static final float ZERO_FLOAT = 0f;
    private static final float SIX_FLOAT = 6;
    private static final float TWO_FLOAT = 2;
    private static final String EMPTY_STRING = "";
    private static final String ONE_STRING = "1";
    private static final String PLUS = "+";

    private CalculatorPresenter presenter;
    @Mock private CalculatorModel model;
    @Mock private CalculatorView view;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        when(model.getFirstOperand()).thenReturn(EMPTY_STRING);
        when(model.getSecondOperand()).thenReturn(EMPTY_STRING);
        when(model.getResult()).thenReturn(ZERO_FLOAT);
        when(model.getOperator()).thenReturn(EMPTY_STRING);

        presenter = new CalculatorPresenter(model, view);
    }

    @Test
    public void onNumberPressedTestResultIsDistinctZeroAndNotHaveFirstOperand(){
        when(model.getResult()).thenReturn(ONE_FLOAT);
        presenter.onNumberPressed(ONE_STRING);
        verify(model).cleanVisor();
        verify(model).setFirstOperand(ONE_STRING);
    }

    @Test
    public void onNumberPressedTestResultIsDistinctZeroAndHaveFirstOperand(){
        when(model.getResult()).thenReturn(ONE_FLOAT);
        when(model.getFirstOperand()).thenReturn(ONE_STRING);
        presenter.onNumberPressed(ONE_STRING);
        verify(model).cleanVisor();
        verify(model).setFirstOperand(ONE_STRING + ONE_STRING);
    }

    @Test
    public void onNumberPressedTestResultIsZeroAndNotHaveFirstOperand(){
        when(model.getResult()).thenReturn(ZERO_FLOAT);
        presenter.onNumberPressed(ONE_STRING);
        verify(model,times(0)).cleanVisor();
        verify(model).setFirstOperand(ONE_STRING);
    }

    @Test
    public void onNumberPressedTestResultIsZeroAndHaveFirstOperand(){
        when(model.getFirstOperand()).thenReturn(ONE_STRING);
        when(model.getResult()).thenReturn(ZERO_FLOAT);
        presenter.onNumberPressed(ONE_STRING);
        verify(model,times(0)).cleanVisor();
        verify(model).setFirstOperand(ONE_STRING + ONE_STRING);
    }

    @Test
    public void onNumberPressedTestResultIsZeroAndHaveOperator(){
        when(model.getOperator()).thenReturn(PLUS);
        when(model.getSecondOperand()).thenReturn(ONE_STRING);
        presenter.onNumberPressed(ONE_STRING);
        verify(model,times(0)).cleanVisor();
        verify(model).setSecondOperand(ONE_STRING + ONE_STRING);
    }

    @Test
    public void onClearAllPressedTest(){
        presenter.onClearAllPressed();
        verify(model, times(1)).cleanVisor();
        verify(view).setVisor(EMPTY_STRING);
    }

    @Test
    public void onOperatorPressedWithZeroResultAndFirsOperandNotEmptyTest(){
        when(model.getResult()).thenReturn(ZERO_FLOAT);
        when(model.getFirstOperand()).thenReturn(ONE);
        presenter.onOperatorPressed(PLUS);
        verify(model).setOperator(PLUS);
    }

    @Test
    public void onOperatorPressedWithZeroResultAndFirstOperandEmpty(){
        when(model.getResult()).thenReturn(ZERO_FLOAT);
        when(model.getFirstOperand()).thenReturn(EMPTY_STRING);
        presenter.onOperatorPressed(PLUS);
        assertEquals(EMPTY_STRING, model.getOperator());
    }

    @Test
    public void onOperatorPressedWithNonZeroResult(){
        when(model.getResult()).thenReturn(ONE_FLOAT);
        presenter.onOperatorPressed(DIVIDE);
        verify(model).setFirstOperand(Float.toString(ONE_FLOAT));
        verify(model).setOperator(DIVIDE);
    }

    @Test
    public void onEqualsPressedWithNoOperator(){
        when(model.getOperator()).thenReturn(EMPTY_STRING);
        presenter.onEqualsPressed();
        verify(model).getOperator();
        verifyNoMoreInteractions(model);
    }

    @Test
    public void onEqualsPressedWithPlusOperator(){
        when(model.getFirstOperand()).thenReturn(ONE);
        when(model.getSecondOperand()).thenReturn(ONE);
        when(model.getOperator()).thenReturn(PLUS);
        presenter.onEqualsPressed();
        verify(model).setResult(TWO_FLOAT);
    }

    @Test
    public void onEqualsPressedWithMinusOperator(){
        when(model.getFirstOperand()).thenReturn(THREE);
        when(model.getSecondOperand()).thenReturn(ONE);
        when(model.getOperator()).thenReturn(MINUS);
        presenter.onEqualsPressed();
        verify(model).setResult(TWO_FLOAT);
    }

    @Test
    public void onEqualsPressedWithMultiplicationOperator(){
        when(model.getFirstOperand()).thenReturn(THREE);
        when(model.getSecondOperand()).thenReturn(TWO);
        when(model.getOperator()).thenReturn(MULTIPLICATION);
        presenter.onEqualsPressed();
        verify(model).setResult(SIX_FLOAT);
    }

    @Test
    public void onEqualsPressedWithDivideOperator(){
        when(model.getFirstOperand()).thenReturn(FOUR);
        when(model.getSecondOperand()).thenReturn(TWO);
        when(model.getOperator()).thenReturn(DIVIDE);
        presenter.onEqualsPressed();
        verify(model).setResult(TWO_FLOAT);
    }

    @Test
    public void onEqualsPressedWithDivideOperatorButZeroDivisor(){
        when(model.getFirstOperand()).thenReturn(FOUR);
        when(model.getSecondOperand()).thenReturn(ZERO);
        when(model.getOperator()).thenReturn(DIVIDE);
        presenter.onEqualsPressed();
        verify(view).setVisor(EMPTY_STRING);
        verify(view).showMessageOperation(R.string.toast_msg_divide);
    }

    @Test
    public void onClearPressedSecondOperand(){
        when(model.getFirstOperand()).thenReturn(FOUR);
        when(model.getSecondOperand()).thenReturn("22");
        when(model.getOperator()).thenReturn(DIVIDE);
        presenter.onClearPressed();
        verify(model).setSecondOperand(TWO);
        verify(view).setVisor(model.getFirstOperand() + model.getOperator() + model.getSecondOperand());
    }

    @Test
    public void onClearPressedOperator(){
        when(model.getFirstOperand()).thenReturn(FOUR);
        when(model.getOperator()).thenReturn(PLUS);
        presenter.onClearPressed();
        verify(model).setOperator(EMPTY_STRING);
        verify(view).setVisor(FOUR + EMPTY_STRING);
    }

    @Test
    public void onClearFirstOperand(){
        when(model.getFirstOperand()).thenReturn(FOUR);
        presenter.onClearPressed();
        verify(model).setFirstOperand(EMPTY_STRING);
        verify(view).setVisor(model.getFirstOperand());

    }
}

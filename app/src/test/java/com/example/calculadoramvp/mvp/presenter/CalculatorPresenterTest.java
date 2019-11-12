package com.example.calculadoramvp.mvp.presenter;

import com.example.calculadoramvp.mvp.model.CalculatorModel;
import com.example.calculadoramvp.mvp.view.CalculatorView;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class CalculatorPresenterTest {

    private static final float ONE_FLOAT = 1;
    private static final float ZERO_FLOAT = 0;
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
}

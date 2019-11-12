package com.example.calculadoramvp.mvp.presenter;

import com.example.calculadoramvp.mvp.model.CalculatorModel;
import com.example.calculadoramvp.mvp.view.CalculatorView;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class CalculatorPresenterTest {

    private static final float ONE_FLOAT = 1;
    private static final float ZERO_FLOAT = 0;
    private static final String EMPTY_STRING = "";

    private CalculatorPresenter presenter;
    @Mock private CalculatorModel model;
    @Mock private CalculatorView view;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        presenter = new CalculatorPresenter(model, view);
    }

    @Test
    public void onNumberPressedTest(){
        when(model.getResult()).thenReturn(ONE_FLOAT);
        when(model.getOperator()).thenReturn(EMPTY_STRING);

        verify(model).cleanVisor();
    }
}

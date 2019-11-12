package com.example.calculadoramvp.mvp.model;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import static com.example.calculadoramvp.utils.Utils.EMPTY_STRING;
import static com.example.calculadoramvp.utils.Utils.ONE;
import static com.example.calculadoramvp.utils.Utils.PLUS;
import static com.example.calculadoramvp.utils.Utils.TWO;
import static com.example.calculadoramvp.utils.Utils.ZERO_FLOAT;
import static junit.framework.TestCase.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class ModelTest {

    private CalculatorModel mockModel;

    @Before
    public void setup() {
        mockModel = new CalculatorModel();
    }
    @Test
    public void cleanVisorTest(){
        mockModel.cleanVisor();

        assertEquals(EMPTY_STRING, mockModel.getFirstOperand());
        assertEquals(EMPTY_STRING, mockModel.getSecondOperand());
        assertEquals(EMPTY_STRING, mockModel.getOperator());
        assertEquals(ZERO_FLOAT, mockModel.getResult());
    }

    @Test
    public void operatorTest(){
        mockModel.setOperator(PLUS);
        assertEquals(PLUS, mockModel.getOperator());
    }

    @Test
    public void firstOperandTest(){
        mockModel.setFirstOperand(ONE);
        assertEquals(ONE, mockModel.getFirstOperand());
    }

    @Test
    public void secondOperandTest(){
        mockModel.setSecondOperand(TWO);
        assertEquals(TWO, mockModel.getSecondOperand());
    }

    @Test
    public void resultTest(){
        mockModel.setResult(ZERO_FLOAT);
        assertEquals(ZERO_FLOAT, mockModel.getResult());
    }
}

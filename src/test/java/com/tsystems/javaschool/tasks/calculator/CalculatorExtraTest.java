package com.tsystems.javaschool.tasks.calculator;

import org.junit.Assert;
import org.junit.Test;

public class CalculatorExtraTest {

    private Calculator calc = new Calculator();

    @Test
    public void evaluate() {
        //given
        String input = "    ";
        String expectedResult = null;

        //run
        String result = calc.evaluate(input);

        //assert
        Assert.assertEquals(expectedResult, result);
    }

    @Test
    public void evaluate1() {
        //given
        String input = "+-";
        String expectedResult = null;

        //run
        String result = calc.evaluate(input);

        //assert
        Assert.assertEquals(expectedResult, result);
    }

    @Test
    public void evaluate2() {
        //given
        String input = "45+";
        String expectedResult = null;

        //run
        String result = calc.evaluate(input);

        //assert
        Assert.assertEquals(expectedResult, result);
    }

    @Test
    public void evaluate3() {
        //given
        String input = "45";
        String expectedResult = "45";

        //run
        String result = calc.evaluate(input);

        //assert
        Assert.assertEquals(expectedResult, result);
    }

    @Test
    public void evaluate4() {
        //given
        String input = "4*5+2";
        String expectedResult = "22";

        //run
        String result = calc.evaluate(input);

        //assert
        Assert.assertEquals(expectedResult, result);
    }

    @Test
    public void evaluate5() {
        //given
        String input = "4*5+2+2";
        String expectedResult = "24";

        //run
        String result = calc.evaluate(input);

        //assert
        Assert.assertEquals(expectedResult, result);
    }

    @Test
    public void evaluate6() {
        //given
        String input = "2*3*4*5";
        String expectedResult = "120";

        //run
        String result = calc.evaluate(input);

        //assert
        Assert.assertEquals(expectedResult, result);
    }

    @Test
    public void evaluate7() {
        //given
        String input = "2*3*4";
        String expectedResult = "24";

        //run
        String result = calc.evaluate(input);

        //assert
        Assert.assertEquals(expectedResult, result);
    }

    @Test
    public void evaluate8() {
        //given
        String input = "2*6/3";
        String expectedResult = "4";

        //run
        String result = calc.evaluate(input);

        //assert
        Assert.assertEquals(expectedResult, result);
    }

    @Test
    public void evaluate9() {
        //given
        String input = "2*6/3*10";
        String expectedResult = "40";

        //run
        String result = calc.evaluate(input);

        //assert
        Assert.assertEquals(expectedResult, result);
    }

    @Test
    public void evaluate10() {
        //given
        String input = "2+7+3+10+8";
        String expectedResult = "30";

        //run
        String result = calc.evaluate(input);

        //assert
        Assert.assertEquals(expectedResult, result);
    }


    @Test
    public void evaluate11() {
        //given
        String input = "2.0+7";
        String expectedResult = "9";

        //run
        String result = calc.evaluate(input);

        //assert
        Assert.assertEquals(expectedResult, result);
    }

    @Test
    public void evaluate12() {
        //given
        String input = "2.0*7.0+3.0";
        String expectedResult = "17";

        //run
        String result = calc.evaluate(input);

        //assert
        Assert.assertEquals(expectedResult, result);
    }

    @Test
    public void evaluate13() {
        //given
        String input = "20/2-7+3*4";
        String expectedResult = "15";

        //run
        String result = calc.evaluate(input);

        //assert
        Assert.assertEquals(expectedResult, result);
    }

    @Test
    public void evaluate14() {
        //given
        String input = "10*(7+4)";
        String expectedResult = "110";

        //run
        String result = calc.evaluate(input);

        //assert
        Assert.assertEquals(expectedResult, result);
    }

    @Test
    public void evaluate15() {
        //given
        String input = "10/(12-10+3)*4";
        String expectedResult = "8";

        //run
        String result = calc.evaluate(input);

        //assert
        Assert.assertEquals(expectedResult, result);
    }

    @Test
    public void evaluate16() {
        //given
        String input = "(3+1)*(7-2)/(1+3)";
        String expectedResult = "5";

        //run
        String result = calc.evaluate(input);

        //assert
        Assert.assertEquals(expectedResult, result);
    }

    @Test
    public void evaluate17() {
        //given
        String input = "10/(12-10+3)*4+3*(7-2)";
        String expectedResult = "23";

        //run
        String result = calc.evaluate(input);

        //assert
        Assert.assertEquals(expectedResult, result);
    }

    @Test
    public void evaluate18() {
        //given
        String input = "(3*2+2)*(3+2)+(4*5)";
        String expectedResult = "60";

        //run
        String result = calc.evaluate(input);

        //assert
        Assert.assertEquals(expectedResult, result);
    }

    @Test
    public void evaluate19() {
        //given
        String input = "10/(12-10+3)*4+3*(7-2)+(5+2)*6";
        String expectedResult = "65";

        //run
        String result = calc.evaluate(input);

        //assert
        Assert.assertEquals(expectedResult, result);
    }

    @Test
    public void evaluate20() {
        //given
        String input = "10/5*4+3*5";
        String expectedResult = "23";

        //run
        String result = calc.evaluate(input);

        //assert
        Assert.assertEquals(expectedResult, result);
    }

    @Test
    public void evaluate21() {
        //given
        String input = "12*1+3.0612";
        String expectedResult = "15.0612";

        //run
        String result = calc.evaluate(input);

        //assert
        Assert.assertEquals(expectedResult, result);
    }

    @Test
    public void evaluate22() {
        //given
        String input = "12/2+2.0610";
        String expectedResult = "8.061";

        //run
        String result = calc.evaluate(input);

        //assert
        Assert.assertEquals(expectedResult, result);
    }

    @Test
    public void evaluate23() {
        //given
        String input = "-3+5";
        String expectedResult = "2";

        //run
        String result = calc.evaluate(input);

        //assert
        Assert.assertEquals(expectedResult, result);
    }

    @Test
    public void evaluate24() {
        //given
        String input = "-3*5-20-6";
        String expectedResult = "-41";

        //run
        String result = calc.evaluate(input);

        //assert
        Assert.assertEquals(expectedResult, result);
    }

    @Test
    public void evaluate25() {
        //given
        String input = "5*(-5+2)";
        String expectedResult = "-15";

        //run
        String result = calc.evaluate(input);

        //assert
        Assert.assertEquals(expectedResult, result);
    }

    @Test
    public void evaluate26() {
        //given
        String input = "5*(-5-2)";
        String expectedResult = "-35";

        //run
        String result = calc.evaluate(input);

        //assert
        Assert.assertEquals(expectedResult, result);
    }

    @Test
    public void evaluate27() {
        //given
        String input = "3.020000+5*2";
        String expectedResult = "13.02";

        //run
        String result = calc.evaluate(input);

        //assert
        Assert.assertEquals(expectedResult, result);
    }

    @Test
    public void evaluate28() {
        //given
        String input = "3.02+1.2";
        String expectedResult = "4.22";

        //run
        String result = calc.evaluate(input);

        //assert
        Assert.assertEquals(expectedResult, result);
    }

    @Test
    public void evaluate29() {
        //given
        String input = "3.02*4.3";
        String expectedResult = "12.986";

        //run
        String result = calc.evaluate(input);

        //assert
        Assert.assertEquals(expectedResult, result);
    }

    @Test
    public void evaluate30() {
        //given
        String input = "0+6";
        String expectedResult = "6";

        //run
        String result = calc.evaluate(input);

        //assert
        Assert.assertEquals(expectedResult, result);
    }

    @Test
    public void evaluate31() {
        //given
        String input = "(5-5)/6";
        String expectedResult = "0";

        //run
        String result = calc.evaluate(input);

        //assert
        Assert.assertEquals(expectedResult, result);
    }

    @Test
    public void evaluate32() {
        //given
        String input = "10*3.01+1.21";
        String expectedResult = "31.31";

        //run
        String result = calc.evaluate(input);

        //assert
        Assert.assertEquals(expectedResult, result);
    }

    @Test
    public void evaluate33() {
        //given
        String input = "10*1/3*10";
        String expectedResult = "33.3333";

        //run
        String result = calc.evaluate(input);

        //assert
        Assert.assertEquals(expectedResult, result);
    }

    @Test
    public void evaluate34() {
        //given
        String input = "0/(2-2)";
        String expectedResult = null;

        //run
        String result = calc.evaluate(input);

        //assert
        Assert.assertEquals(expectedResult, result);
    }

    @Test
    public void evaluate35() {
        //given
        String input = "2/129.456349*4";
        String expectedResult = "0.0618";

        //run
        String result = calc.evaluate(input);

        //assert
        Assert.assertEquals(expectedResult, result);
    }

}
package test.java.UnitTesting.calculator;


import main.java.UnitTesting.UnitTesting.calculator.Calculator;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;
//конвенцията е от java нататък да използваме същите пакети
// имаме пакет java с пакети
// и пакет tests с пакети съшите
//scr - main - java - packages
// scr - test - java - packages

//другата конвенция е да завършват имената на Test

// когато имаме тестове, не е вече необходимо всеки метод да го тестваме в мейн метода,
//като го пускаме да разпечата в конзолата,
// а вместо това Cclulator класа му тестваме всички метои в CalculatorTest класа

public class CalculatorTest {

    private Calculator calc;
    @Before
    public void prepare(){
         calc = new Calculator();
    }

    @Test
    public void testSum() {
        int sum = calc.sum(5, 4);
        Assert.assertEquals(9, sum);
    }

    @Test
    public void testMultiply() {
        int mult = calc.multiply(5, 4);
        Assert.assertEquals(20, mult);
    }

}
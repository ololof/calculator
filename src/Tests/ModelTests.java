package Tests;

import org.junit.Assert;
import org.junit.*;
import sample.Model;

import static sample.Model.error;

public class ModelTests {

    Model model = new Model();

    public String doubleToString(double expectedValue){
        return String.valueOf(expectedValue);
    }

    @Test
    public void smoke() {
        model.enterNumber("10", "5");
        Assert.assertEquals(doubleToString(2), model.calculation());
        Assert.assertFalse(error);
    }

    @Test
    public void smokeSign() {
        model.enterNumber("-10", "5");
        Assert.assertEquals(doubleToString(-2), model.calculation());
        Assert.assertFalse(error);
    }

    @Test
    public void fractionalPointDelimiter() {
        model.enterNumber("0.2", "0.1");
        Assert.assertEquals(doubleToString(2), model.calculation());
        Assert.assertFalse(error);
    }

    @Test()
    public void fractionalCommaDelimeter() {
        model.enterNumber("1,1", "1");
        Assert.assertFalse(error);
        //will be implemented in the next version
    }


    @Test
    public void emptyDividend() {
        model.enterNumber("", "1");
        Assert.assertTrue(error);
    }

    @Test
    public void emptyDivider() {
        model.enterNumber("1", "");
        Assert.assertTrue(error);
    }

    @Test
    public void emptyDividendDivider() {
        model.enterNumber("", "");
        Assert.assertTrue(error);
    }

    @Test
    public void incorrectDividend() {
        model.enterNumber("test 123", "");
        Assert.assertTrue(error);
    }

    @Test
    public void incorrectDivider() {
        model.enterNumber("1", "test 123");
        Assert.assertTrue(error);
    }


}
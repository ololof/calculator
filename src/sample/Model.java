package sample;


public class Model {
    /*Dividend and divider and result division variables
    The static variable error controls the presence of errors*/
    private double numX;
    private double numY;
    private double divide;
    public static boolean error = false;


    public String calculation() {
        return String.valueOf(divide);

    }
//Method of finding the result of division and  the handling of divide by zero and the accuracy of data entry
    public void enterNumber(String x, String y) {
        try {
            numX = Double.parseDouble(x);
            numY = Double.parseDouble(y);
            divide = numX / numY;
            error = false;
            if (numY == 0) throw new ArithmeticException();
        } catch (ArithmeticException | NumberFormatException e) {

            error = true;
        }


    }
}
package ir.ac.aut.ceit.cn.Calculation;

public class Calculator {

    public CalculationResponse add(double a, double b) {
        Long t1 = System.nanoTime();
        double result = a + b;
        Long t2 = System.nanoTime();
        return new CalculationResponse(result, t2-t1,true);
    }

    public CalculationResponse sub(double a, double b) {
        Long t1 = System.nanoTime();
        double result = a - b;
        Long t2 = System.nanoTime();
        return new CalculationResponse(result, t2-t1,true);
    }

    public CalculationResponse div(double a, double b) {
        double result;
        boolean isValid = true;
        Long t1 = System.nanoTime();
        if(b != 0) {
            result = a / b;
            isValid = true;
        }
        else {
            result = 0;
            isValid = false;
        }
        Long t2 = System.nanoTime();
        return new CalculationResponse(result, t2-t1, isValid);
    }

    public CalculationResponse mul(double a, double b) {
        Long t1 = System.nanoTime();
        double result = a * b;
        Long t2 = System.nanoTime();
        return new CalculationResponse(result, t2-t1,true);
    }

    public CalculationResponse sin(double a) {
        Long t1 = System.nanoTime();
        double result = Math.sin(a);
        Long t2 = System.nanoTime();
        return new CalculationResponse(result, t2-t1,true);
    }

    public CalculationResponse cos(double a) {
        Long t1 = System.nanoTime();
        double result = Math.cos(a);
        Long t2 = System.nanoTime();
        return new CalculationResponse(result, t2-t1,true);
    }

    public CalculationResponse tan(double a) {
        double result;
        boolean isValid = true;
        Long t1 = System.nanoTime();
        try {
            result = Math.tan(a);
            isValid = true;
        }
        catch (ArithmeticException e) {
            result = 0;
            isValid = false;
        }
        Long t2 = System.nanoTime();
        return new CalculationResponse(result, t2-t1,isValid);
    }

    public CalculationResponse cot(double a) {
        double result;
        boolean isValid = true;
        Long t1 = System.nanoTime();
        try {
            if (Math.tan(a) != 0) {
                result = 1 / Math.tan(a);
                isValid = true;
            } else {
                result = 0;
                isValid = false;
            }
        }
        catch (ArithmeticException e) {
            result = 0;
            isValid = false;
        }
        Long t2 = System.nanoTime();
        return new CalculationResponse(result, t2-t1,isValid);
    }


// TODO handle floating point
}

package ir.ac.aut.ceit.cn.Calculation;

public class Calculator {

    public CalculationResponse add(double a, double b) {
        Long t1 = System.nanoTime();
        double result = a + b;
        Long t2 = System.nanoTime();
        return new CalculationResponse(result, t2-t1);
    }

    public CalculationResponse sub(double a, double b) {
        Long t1 = System.nanoTime();
        double result = a - b;
        Long t2 = System.nanoTime();
        return new CalculationResponse(result, t2-t1);
    }

    public CalculationResponse div(double a, double b) {
        Long t1 = System.nanoTime();
        double result = a / b;
        Long t2 = System.nanoTime();
        return new CalculationResponse(result, t2-t1);
    }

    public CalculationResponse mul(double a, double b) {
        Long t1 = System.nanoTime();
        double result = a * b;
        Long t2 = System.nanoTime();
        return new CalculationResponse(result, t2-t1);
    }

    public CalculationResponse sin(double a) {
        Long t1 = System.nanoTime();
        double result = Math.sin(a);
        Long t2 = System.nanoTime();
        return new CalculationResponse(result, t2-t1);
    }

    public CalculationResponse cos(double a) {
        Long t1 = System.nanoTime();
        double result = Math.cos(a);
        Long t2 = System.nanoTime();
        return new CalculationResponse(result, t2-t1);
    }

    public CalculationResponse tan(double a) {
        Long t1 = System.nanoTime();
        double result = Math.tan(a);
        Long t2 = System.nanoTime();
        return new CalculationResponse(result, t2-t1);
    }

    public CalculationResponse cot(double a) {
        Long t1 = System.nanoTime();
        double result = 1 / Math.tan(a);
        Long t2 = System.nanoTime();
        return new CalculationResponse(result, t2-t1);
    }



}

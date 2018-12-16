package ir.ac.aut.ceit.cn.Calculation;

public class CalculationResponse {
    private double result;
    private long calculationTime;

    public CalculationResponse(double result, long calculationTime) {
        this.result = result;
        this.calculationTime = calculationTime;
    }

    public double getResult() {
        return result;
    }

    public long getCalculationTime() {
        return calculationTime;
    }

    @Override
    public String toString() {
        return "[result: " + String.valueOf(result) + " time: " + String.valueOf(calculationTime) + "ns]";
    }
}

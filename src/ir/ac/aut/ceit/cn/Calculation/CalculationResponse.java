package ir.ac.aut.ceit.cn.Calculation;

public class CalculationResponse {
    private double result;
    private long calculationTime;
    private boolean isValid;

    public CalculationResponse(double result, long calculationTime, boolean isValid) {
        this.result = result;
        this.calculationTime = calculationTime;
        this.isValid = isValid;
    }

    public double getResult() {
        return result;
    }

    public long getCalculationTime() {
        return calculationTime;
    }
    public String getCalculationTimeString() {
        return String.valueOf(calculationTime) + "ns";
    }

    public boolean isValid() {
        return isValid;
    }

    @Override
    public String toString() {
        return "[result: " + String.valueOf(result) + " time: " + String.valueOf(calculationTime) + "ns] : isValid:" + isValid;
    }
}

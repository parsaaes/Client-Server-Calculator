package ir.ac.aut.ceit.cn.Protocol;


import java.util.ArrayList;

public class ParsedExpression {
    private Operator operator;
    private ArrayList<Double> operands = new ArrayList<>();

    public ParsedExpression(Operator operator) {
        this.operator = operator;
    }

    public void addOperand(double x) {
        operands.add(x);
    }

    public Operator getOperator() {
        return operator;
    }

    public ArrayList<Double> getOperands() {
        return operands;
    }

    @Override
    public String toString() {
        return "ParsedExpression{" +
                "operator=" + operator +
                ", operands=" + operands +
                '}';
    }
}

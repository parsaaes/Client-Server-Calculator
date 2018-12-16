package ir.ac.aut.ceit.cn.Protocol;


public class Parser {
    private static String PROTOCOL_FIRST_LINE = "Calculation Request:";
    private static String EXP_DELIMITER = "\\$";
    private static int EXP_LINE_NO = 1;

    public boolean preIsValid(Message message) {
        return  message != null &&
                message.getBody().size() >= 2 &&
                message.getBody().get(0) != null &&
                message.getBody().get(0).contains(PROTOCOL_FIRST_LINE) &&
                message.getBody().get(1) != null &&
                message.getBody().get(1).length() > 1;
    }

    // $ operator $ op1 $ op2 $
    public ParsedExpression getExpression(Message message) {
        ParsedExpression parsedExpression = null;

        if(!preIsValid(message)) {
            System.out.println("cannot parse because it's not a valid message.");
            return null;
        }

        String[] splitted = message.getBody().get(EXP_LINE_NO).replaceAll("\\s+","").split(EXP_DELIMITER);
        if(splitted.length < 2) {
            System.out.println("cannot parse because it doesn't have valid expression syntax");
            return null;
        }

        // splitted[0] is empty string
        for (int i = 1; i < splitted.length; i++) {
            if(i == 1) {
                parsedExpression = makeExpression(splitted[i].trim());
            }
            else {
                if(parsedExpression != null) {
                    try {
                        parsedExpression.addOperand(Double.valueOf(splitted[i]));
                    }
                    catch (NumberFormatException e) {
                        System.out.println("cannot parse because of an invalid operand");
                        return null;
                    }
                }
            }
        }

        if(checkOperandNumber(parsedExpression) == false) {
            System.out.println("cannot parse because of incomplete operand set");
            return null;
        }
        return parsedExpression;
    }

    private boolean checkOperandNumber(ParsedExpression parsedExpression) {
        if(parsedExpression.getOperands() == null || parsedExpression.getOperands().size() < 1) {
            return false;
        }
        if(parsedExpression.getOperator() == Operator.ADD) {
            return (parsedExpression.getOperands().size() >= 2) &&
                    parsedExpression.getOperands().get(0) != null &&
                    parsedExpression.getOperands().get(1) != null;
        }
        if(parsedExpression.getOperator() == Operator.SUB) {
            return (parsedExpression.getOperands().size() >= 2) &&
                    parsedExpression.getOperands().get(0) != null &&
                    parsedExpression.getOperands().get(1) != null;
        }
        if(parsedExpression.getOperator() == Operator.MUL) {
            return (parsedExpression.getOperands().size() >= 2) &&
                    parsedExpression.getOperands().get(0) != null &&
                    parsedExpression.getOperands().get(1) != null;
        }
        if(parsedExpression.getOperator() == Operator.DIV) {
            return (parsedExpression.getOperands().size() >= 2) &&
                    parsedExpression.getOperands().get(0) != null &&
                    parsedExpression.getOperands().get(1) != null;
        }
        if(parsedExpression.getOperator() == Operator.SIN) {
            return (parsedExpression.getOperands().size() >= 1) &&
                    parsedExpression.getOperands().get(0) != null;
        }
        if(parsedExpression.getOperator() == Operator.COS) {
            return (parsedExpression.getOperands().size() >= 1) &&
                    parsedExpression.getOperands().get(0) != null;
        }
        if(parsedExpression.getOperator() == Operator.TAN) {
            return (parsedExpression.getOperands().size() >= 1) &&
                    parsedExpression.getOperands().get(0) != null;
        }
        if(parsedExpression.getOperator() == Operator.COT) {
            return (parsedExpression.getOperands().size() >= 1) &&
                    parsedExpression.getOperands().get(0) != null;
        }
        return false;
    }

    private ParsedExpression makeExpression(String operator) {
        if(operator.toLowerCase().equals("add")) {
            return new ParsedExpression(Operator.ADD);
        }

        if(operator.toLowerCase().equals("subtract") || operator.toLowerCase().equals("sub")) {
            return new ParsedExpression(Operator.SUB);
        }

        if(operator.toLowerCase().equals("divide") || operator.toLowerCase().equals("div")) {
            return new ParsedExpression(Operator.DIV);
        }

        if(operator.toLowerCase().equals("multiply") || operator.toLowerCase().equals("mul")) {
            return new ParsedExpression(Operator.MUL);
        }

        if(operator.toLowerCase().equals("sin")) {
            return new ParsedExpression(Operator.SIN);
        }

        if(operator.toLowerCase().equals("cos")) {
            return new ParsedExpression(Operator.COS);
        }

        if(operator.toLowerCase().equals("tan")) {
            return new ParsedExpression(Operator.TAN);
        }

        if(operator.toLowerCase().equals("cot")) {
            return new ParsedExpression(Operator.COT);
        }

        System.out.println("Invalid operand detected. I think you need Adding :P");
        return new ParsedExpression(Operator.ADD);
    }
}

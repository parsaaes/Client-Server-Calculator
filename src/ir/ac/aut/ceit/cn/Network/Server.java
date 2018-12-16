package ir.ac.aut.ceit.cn.Network;

import ir.ac.aut.ceit.cn.Calculation.CalculationResponse;
import ir.ac.aut.ceit.cn.Calculation.Calculator;
import ir.ac.aut.ceit.cn.Protocol.Message;
import ir.ac.aut.ceit.cn.Protocol.ParsedExpression;
import ir.ac.aut.ceit.cn.Protocol.Parser;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server extends NetworkPeer implements Runnable {
    private int port;
    private ServerSocket serverSocket;
    private String NAME = "Server";

    private Parser parser = new Parser();
    private Calculator calculator = new Calculator();


    public Server(int port) {
        this.port = port;
    }

    public void run() {
        Socket socket;
        ObjectOutputStream objectOutputStream;
        ObjectInputStream objectInputStream;
        try {
            serverSocket = new ServerSocket(port);
            socket = serverSocket.accept();
            printLog(String.valueOf(socket.getLocalAddress()) + " connected");
            objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
            objectInputStream = new ObjectInputStream(socket.getInputStream());
            while (true) {
                Message input = (Message) objectInputStream.readObject();
                ParsedExpression exp = parser.getExpression(input);
                CalculationResponse calculationResponse = null;
                if(exp != null) {
                    calculationResponse = doCalculation(exp);
                }
                else {
                    calculationResponse = new CalculationResponse(0,0,false);
                }
                printLog("got: " + input);
                // printLog(calculationResponse.toString());
                Message output = new Message("Calculation Response:\n$ " +
                        calculationResponse.getCalculationTimeString() + " $ " +
                        String.valueOf(calculationResponse.getResult()) + " $ " + "isValid:" + calculationResponse.isValid());
                objectOutputStream.writeObject(output);
            }
        } catch (IOException e) {
            System.err.println("no IO detected :( maybe there is no client using me :'(");
        } catch (ClassNotFoundException e) {
            System.err.println("class casting problem :-?");
        }
    }

    private CalculationResponse doCalculation(ParsedExpression exp) {
        switch (exp.getOperator()) {
            case ADD:
                return calculator.add(exp.getOperands().get(0),exp.getOperands().get(1));
            case SUB:
                return calculator.sub(exp.getOperands().get(0),exp.getOperands().get(1));
            case MUL:
                return calculator.mul(exp.getOperands().get(0),exp.getOperands().get(1));
            case DIV:
                return calculator.div(exp.getOperands().get(0),exp.getOperands().get(1));
            case SIN:
                return calculator.sin(exp.getOperands().get(0));
            case COS:
                return calculator.cos(exp.getOperands().get(0));
            case TAN:
                return calculator.tan(exp.getOperands().get(0));
            case COT:
                return calculator.cot(exp.getOperands().get(0));
        }
        return null;
    }


    @Override
    protected void printLog(String text) {
        System.out.println("[" + NAME + ": ] " + text);
    }



    public static void main(String[] args) {
        new Server(12345).run();
    }
}

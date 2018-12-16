package ir.ac.aut.ceit.cn;

import ir.ac.aut.ceit.cn.Calculation.Calculator;
import ir.ac.aut.ceit.cn.Network.Client;
import ir.ac.aut.ceit.cn.Network.Server;

public class Main {

    public static void main(String[] args) {
	Thread client = new Thread(new Client("127.0.0.1",12345));
	Thread server = new Thread(new Server(12345));
	server.start();
	client.start();

//        Calculator calculator = new Calculator();
//        System.out.println(calculator.cos(60));
    }
}

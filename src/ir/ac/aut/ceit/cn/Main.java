package ir.ac.aut.ceit.cn;

import ir.ac.aut.ceit.cn.Calculation.Calculator;
import ir.ac.aut.ceit.cn.Network.Client;
import ir.ac.aut.ceit.cn.Network.Server;
import ir.ac.aut.ceit.cn.Protocol.Message;
import ir.ac.aut.ceit.cn.Protocol.Parser;

public class Main {

    public static void main(String[] args) {
            Thread client = new Thread(new Client("127.0.0.1",12345));
            Thread server = new Thread(new Server(12345));
            server.start();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            client.start();
    }
}

package ir.ac.aut.ceit.cn.Network;

import ir.ac.aut.ceit.cn.Protocol.Message;

import java.io.*;
import java.net.ConnectException;
import java.net.Socket;
import java.util.Scanner;

public class Client extends NetworkPeer implements Runnable {
    private int port;
    private String ip;
    private Socket socket;
    private String NAME = "Client";

    public Client(String ip, int port) {
        this.port = port;
        this.ip = ip;
    }

    public void run() {
        ObjectOutputStream objectOutputStream;
        ObjectInputStream objectInputStream;
        Scanner sc;
        try {
            socket = new Socket(ip, port);
            objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
            objectInputStream = new ObjectInputStream(socket.getInputStream());

            sc = new Scanner(System.in);
            while(true) {
                printLog("enter:");
                String output = sc.nextLine();
                objectOutputStream.writeObject(new Message("Calculation Request:\n" + output));
                Message input = (Message) objectInputStream.readObject();
                printLog("got: " + input.getBody().get(0));
                printLog("got: " + input.getBody().get(1));
            }
        } catch (IOException e) {
            System.err.println("no IO detected :( maybe there is no server waiting for me :'(");
        } catch (ClassNotFoundException e) {
            System.err.println("class casting problem :-?");
        }
    }




    @Override
    protected void printLog(String text) {
        System.out.println("[" + NAME + ": ] " + text);
    }


    public static void main(String[] args) {
        new Client("127.0.0.1",12345).run();
    }
}

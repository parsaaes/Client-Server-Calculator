package ir.ac.aut.ceit.cn.Network;

import ir.ac.aut.ceit.cn.Calculation.Calculator;
import ir.ac.aut.ceit.cn.Protocol.Message;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server extends NetworkPeer implements Runnable {
    private int port;
    private ServerSocket serverSocket;
    private String NAME = "Server";

    private Calculator calculator = new Calculator();


    public Server(int port) {
        this.port = port;
    }

    public void run() {
        Socket socket;
        BufferedReader br;
        BufferedWriter bw;
        ObjectOutputStream objectOutputStream;
        ObjectInputStream objectInputStream;
        try {
            serverSocket = new ServerSocket(port);
            socket = serverSocket.accept();
            printLog(String.valueOf(socket.getInetAddress()) + " connected");
//            bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
//            br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
            objectInputStream = new ObjectInputStream(socket.getInputStream());
            while (true) {
                Message input = (Message) objectInputStream.readObject();
                printLog("got: " + input);
                //sendString(input.toUpperCase(), bw);
                input.setTest("edited B-)");
                objectOutputStream.writeObject(input);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }


    @Override
    protected void printLog(String text) {
        System.out.println("[" + NAME + ": ] " + text);
    }



    public static void main(String[] args) {
        new Server(12345).run();
    }
}

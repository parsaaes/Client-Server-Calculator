package ir.ac.aut.ceit.cn.Network;

import ir.ac.aut.ceit.cn.Protocol.Message;

import java.io.*;
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
        BufferedReader br;
        BufferedWriter bw;
        ObjectOutputStream objectOutputStream;
        ObjectInputStream objectInputStream;
        Scanner sc;
        try {
            socket = new Socket(ip, port);
//            bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
//            br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
            objectInputStream = new ObjectInputStream(socket.getInputStream());

            sc = new Scanner(System.in);
            while(true) {
                printLog("enter:");
                String output = sc.nextLine();
                // sendString(output, bw);
                objectOutputStream.writeObject(new Message());
                Message input = (Message) objectInputStream.readObject();
                printLog("got: " + input);
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
        new Client("127.0.0.1",12345).run();
    }
}

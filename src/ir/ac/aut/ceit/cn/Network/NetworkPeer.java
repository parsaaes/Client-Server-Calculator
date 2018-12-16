package ir.ac.aut.ceit.cn.Network;

import java.io.BufferedWriter;
import java.io.IOException;

public abstract class NetworkPeer {

    protected abstract void printLog(String text);

    protected void sendString(String input, BufferedWriter bw) throws IOException {
        bw.write(input);
        bw.newLine();
        bw.flush();
    }
}

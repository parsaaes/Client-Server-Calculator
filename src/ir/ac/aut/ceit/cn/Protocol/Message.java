package ir.ac.aut.ceit.cn.Protocol;

import java.io.Serializable;
import java.util.ArrayList;

public class Message implements Serializable {
    private ArrayList<String> body = new ArrayList<>();

    public Message(String rawBody) {
        breakIntoLines(rawBody);
    }

    private void breakIntoLines(String rawBody) {
        String[] lines = rawBody.split("\n");
        for (String line : lines) {
            body.add(line);
        }
    }

    public ArrayList<String> getBody() {
        return body;
    }

    @Override
    public String toString() {
        return "Message{" +
                "body=" + body +
                '}';
    }
}

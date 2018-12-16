package ir.ac.aut.ceit.cn.Protocol;

import java.io.Serializable;
import java.util.ArrayList;

public class Message implements Serializable {
    private static final long serialVersionUID = 8900674260590897679L;
    private String rawBody;

    public Message(String rawBody) {
        this.rawBody = rawBody;
    }

    private ArrayList<String> breakIntoLines(String rawBody) {
        ArrayList<String> body = new ArrayList<>();
        String[] lines = rawBody.split("\n");
        for (String line : lines) {
            body.add(line);
        }
        return body;
    }

    public ArrayList<String> getBody() {
        return breakIntoLines(rawBody);
    }

    @Override
    public String toString() {
        return "Message{" +
                "body=" + rawBody +
                '}';
    }
}

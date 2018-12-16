package ir.ac.aut.ceit.cn.Protocol;

import java.io.Serializable;

public class Message implements Serializable {
    private String test = "hi";
    private int hi = 1;

    public void setTest(String test) {
        this.test = test;
    }

    @Override
    public String toString() {
        return test + ":D :D :|";
    }
}

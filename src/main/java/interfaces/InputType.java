package interfaces;

import java.io.Serializable;

public class InputType implements Serializable {
    private static final long serialVersionUID = 101L;
    public String operation;
    public double x1;
    public double x2;

    public InputType(double x1, double x2, String operation) {
        this.x1=x1;
        this.x2=x2;
        this.operation=operation;
    }

    public double getX1() {
        return x1;
    }
    public double getX2(){
        return x2;
    }
}

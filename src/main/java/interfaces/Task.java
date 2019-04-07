package interfaces;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class Task extends UnicastRemoteObject implements TaskInterface {
    private static final long serialVersionUID = 101L;
    private String par;
    public Task(String par) throws RemoteException {
        super();
        this.par=par;
    }

    public ResultType calculate(InputType inputParams) throws RemoteException {
        double zm1, zm2;
        ResultType wynik = new ResultType();
        zm1 = inputParams.getX1();
        zm2 = inputParams.getX2();
        wynik.result_description = "Operation: " + inputParams.operation;
        switch (inputParams.operation) {
            case "mul":
                wynik.result = zm1 * zm2;
                break;
            case "pow":
                wynik.result = Math.pow(zm1,zm2);
                break;
            case "add":
                wynik.result = zm1 + zm2;
                break;
            case "sub":
                wynik.result = zm1-zm2;
                break;
            case "div":
                wynik.result = zm1/zm2;
                break;
            default:
                wynik.result = 0;
                wynik.result_description = "Wrong operation";
                return wynik;
        }
        wynik.result_description=par;
        return wynik;
    }
}


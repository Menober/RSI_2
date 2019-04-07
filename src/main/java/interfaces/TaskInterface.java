package interfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface TaskInterface extends Remote {
    public ResultType calculate(InputType inputParams) throws RemoteException;
}

package Server.remote_object;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface CalcObject2 extends Remote {
	public int[] sort_array(int[] matrix) throws RemoteException;
}

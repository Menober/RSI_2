package Client.remote_object;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface CalcObject3 extends Remote {
	public int[] merge_arrays_and_sort(int[] array_1, int[] array_2) throws RemoteException;
}

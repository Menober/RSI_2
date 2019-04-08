package Server.remote_object;


import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Arrays;

public class CalcObjImpl2 extends UnicastRemoteObject implements CalcObject2 {
	
	private static final long serialVersionUID = 102L;
	
	public CalcObjImpl2() throws RemoteException{
		super();
	}
	
	public int[] sort_array(int[] matrix) throws RemoteException {
		Arrays.sort(matrix);
		return matrix;
	}
	
}

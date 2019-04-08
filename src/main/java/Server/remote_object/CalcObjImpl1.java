package Server.remote_object;


import Server.remote_object.CalcObject1;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Arrays;

public class CalcObjImpl1 extends UnicastRemoteObject implements CalcObject1 {

	private static final long serialVersionUID = 101L;
	
	public CalcObjImpl1() throws RemoteException {
		super();
	}

	public int[] sort_array(int[] matrix) throws RemoteException {
		Arrays.sort(matrix);
		return matrix;
	}

	

}

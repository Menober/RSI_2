package Server.remote_object;


import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Arrays;

public class CalcObjImpl3 extends UnicastRemoteObject implements CalcObject3 {

	private static final long serialVersionUID = 103L;
	
	public CalcObjImpl3() throws RemoteException {
		super();
	}

	public int[] merge_arrays_and_sort(int[] array_1, int[] array_2) throws RemoteException {
		int a1_size = array_1.length;
		int a2_size = array_2.length;
		int[] merged = new int[a1_size + a2_size];
		for(int i=0; i< a1_size ; i++) {
			merged[i] = array_1[i];
		}
		for(int i=0; i<a2_size; i++) {
			merged[i+a1_size] = array_2[i];
		}
		Arrays.sort(merged);
		return merged;
	}

	

}

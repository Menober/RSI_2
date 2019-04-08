

package Server.server;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import Server.remote_object.CalcObjImpl3;

public class MyServer3 {

	public static void main(String[] args) {
		if(args.length == 0) {
			System.out.println("You have to enter RMI object address in the form: //host_address/service_name");
			return;
		}
		
		if(System.getSecurityManager() == null) {
			System.setSecurityManager(new SecurityManager());
		}
		
		try {
			Registry reg = LocateRegistry.createRegistry(1101);
		} catch (RemoteException e1) {
			e1.printStackTrace();
		}
		
		try {
			CalcObjImpl3 implObiektu = new CalcObjImpl3();
			java.rmi.Naming.rebind(args[0], implObiektu);
			System.out.println("Server 3 is registered now :-)");
			System.out.println("Press Crl+C to stop");
		} catch (Exception e) {
			System.out.println("SERVER CAN'T BE REGISTERED!");
			e.printStackTrace();
			return;
		}
	}

}

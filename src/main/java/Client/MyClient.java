package Client;


import interfaces.ResultType;
import interfaces.TaskInterface;
import interfaces.InputType;

import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class MyClient {
    private static String ipAddress = "192.168.1.96";

    public static void main(String[] args) throws RemoteException, MalformedURLException, NotBoundException {
        setUpRegistry(args);

        InputType input=new InputType(2,4,"pow");

        System.out.println(sendTask(input));
    }



    private static String sendTask(InputType input) throws NotBoundException, MalformedURLException, RemoteException {
        TaskInterface task = (TaskInterface) java.rmi.Naming.lookup(ipAddress);
        ResultType wynik = task.calculate(input);
        return ("Result: " + wynik.result+" Method: "+wynik.result_description);
    }

    private static void setUpRegistry(String[] args) throws RemoteException {
        Registry reg;
        if (args.length > 0) {
            reg = LocateRegistry.getRegistry(ipAddress);
        } else {
            reg = LocateRegistry.getRegistry();
        }
    }
}

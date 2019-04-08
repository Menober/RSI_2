package Server;

import interfaces.Task;
import interfaces.TaskInterface;
import sun.rmi.registry.RegistryImpl;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.security.Permission;

public class MyServer {

    private static String ipAddress = "192.168.1.96/f2";
    private static RegistryImpl reg;

    public static void main(String[] args) throws RemoteException {
        if (args.length != 0)
            ipAddress += args[0];
        setUp();
        System.out.println(ipAddress);
        if (args.length == 0)
            implementObject1();
        else
            implementObject2();
    }

    private static void implementObject1() {
        try {
            TaskInterface taskImplementation = new Task("one");
            reg.rebind(ipAddress, taskImplementation);
            System.out.println("Server is registered now");
            System.out.println("Press ctrl c to stop");
        } catch (Exception e) {
            e.printStackTrace();
            return;
        }
    }

    private static void implementObject2() {
        try {
            TaskInterface taskImplementation = new Task("two");
            reg.rebind(ipAddress, taskImplementation);
            System.out.println("Server is registered now");
            System.out.println("Press ctrl c to stop");
        } catch (Exception e) {
            e.printStackTrace();
            return;
        }
    }

    private static void setUp() throws RemoteException {
        System.setProperty("java.security.policy", "srv.policy");
        reg = (RegistryImpl) LocateRegistry.createRegistry(1098);
        if (System.getSecurityManager() == null) {
            System.setSecurityManager(new SecurityManager() {
                @Override
                public void checkPermission(Permission perm) {

                }
            });
        }
    }

}

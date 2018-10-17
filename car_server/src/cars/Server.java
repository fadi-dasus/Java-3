package cars;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Server {
	public static void main(String[] args) throws RemoteException, AlreadyBoundException {
		CarBase carBase = new RemoteCarBase();
		
		Registry registry = LocateRegistry.createRegistry(1099);
		registry.rebind("CarBase", carBase);
		System.out.println(" server is running ");
	}
}

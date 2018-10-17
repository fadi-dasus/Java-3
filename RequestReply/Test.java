import java.rmi.RemoteException;

import tasks.Task;
import tasks.rmi.client.Proxy;

public class Test {
	public static void main(String[] args) throws RemoteException {
		final Proxy proxy = new Proxy();
		proxy.add(new Task("task 1", 8700));
		proxy.add(new Task("task 2", 10000));
		System.out.println(proxy.size());
		System.out.println(proxy.getAndRemoveNextTask());
		System.out.println(proxy.size());
	}
}

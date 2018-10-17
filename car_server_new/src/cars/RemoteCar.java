package cars;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class RemoteCar extends UnicastRemoteObject implements Car {
	private static final long serialVersionUID = 1L;
	private String model;
	private int year;
	private Money price;

	public RemoteCar(String model, int year, Money price) throws RemoteException {
		super();
		this.model = model;
		this.year = year;
		this.price = price;
	}

	@Override
	public String getModel()throws RemoteException {
		return model;
	}

	@Override
	public int getYear() throws RemoteException {
		return year;
	}

	@Override
	public Money getPrice() throws RemoteException {
		return price;
	}

	@Override
	public void setPrice(Money price) throws RemoteException {
		this.price = price;
	}
}

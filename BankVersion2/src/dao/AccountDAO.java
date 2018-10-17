package dao;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Collection;

import model.Account;
import model.AccountNumber;
import model.Customer;

public interface AccountDAO extends Remote {
	public Account create(int regNumber, Customer customer, String currency) throws RemoteException;
	public Account read(AccountNumber accountNumber) throws RemoteException;
	public Collection<Account> readAccountsFor(Customer customer) throws RemoteException;
	public void update(Account account) throws RemoteException;
	public void delete(Account account) throws RemoteException;
}

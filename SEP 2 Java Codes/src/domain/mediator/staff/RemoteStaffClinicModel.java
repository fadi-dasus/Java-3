package domain.mediator.staff;

import java.io.IOException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import domain.model.staff.Employee;

public interface RemoteStaffClinicModel extends Remote
{

   public void addEmployee(String[] employeeData) throws RemoteException;

   public ArrayList<Employee> getEmployeeByname(String name)
         throws RemoteException;

   public void removePatientById(int id) throws RemoteException;

   public String[] reachType() throws RemoteException;

   public void LoadFromDB(String name) throws IOException, RemoteException;

   public ArrayList<Employee> getAllEmployeesFromTheList()
         throws RemoteException;
   
   public Employee getEmployeeById(int id) throws RemoteException;
   public void updateEmployee(Employee employee)  throws RemoteException;

}

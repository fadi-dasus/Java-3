package clients;

import java.io.IOException;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Date;

import domain.mediator.appointment.RemoteAppointmentModel;
import domain.mediator.patient.RemotePatientModel;
import domain.mediator.staff.RemoteStaffClinicModel;
import domain.model.patient.Appointment;
import domain.model.patient.AppointmentList;
import domain.model.patient.Patient;
import domain.model.staff.Employee;

public class Client implements RemoteStaffClinicModel, RemotePatientModel,
      RemoteAppointmentModel
{
   private RemoteStaffClinicModel StaffServer;
   private RemotePatientModel PatientServer;
   private RemoteAppointmentModel AppointmentServer;
   public Client()
   {
      try
      {
         this.StaffServer = (RemoteStaffClinicModel) Naming
               .lookup("rmi://localhost:1099/StaffServer");
         this.PatientServer = (RemotePatientModel) Naming
               .lookup("rmi://localhost:1098/PatientServer");
         this.AppointmentServer = (RemoteAppointmentModel) Naming
               .lookup("rmi://localhost:1097/AppointmentServer");
      }
      catch (MalformedURLException e)
      {
         e.printStackTrace();
      }
      catch (RemoteException e)
      {
         e.printStackTrace();
      }
      catch (NotBoundException e)
      {
         e.printStackTrace();
      }
   }

   public void addEmployee(String[] employeeData) throws RemoteException
   {
      StaffServer.addEmployee(employeeData);
   }

   public ArrayList<Employee> getEmployeeByname(String name)
         throws RemoteException
   {

      return StaffServer.getEmployeeByname(name);
   }

   public void removeStaff(int id) throws RemoteException
   {

      StaffServer.removePatientById(id);
   }

   public String[] reachType() throws RemoteException
   {
      return StaffServer.reachType();
   }

   public void callLoadStaff(String name) throws IOException, RemoteException
   {
      StaffServer.LoadFromDB(name);
   }

   public void callLoadPateint(String name) throws IOException, RemoteException
   {
      PatientServer.LoadFromDB(name);
   }

   public ArrayList<Employee> getAllEmployeesFromTheList()
         throws RemoteException
   {
      return StaffServer.getAllEmployeesFromTheList();

   }

   public void addPatient(String[] patientData) throws RemoteException
   {
      PatientServer.addPatient(patientData);
   }

   public void removePatient(int id) throws RemoteException
   {
      PatientServer.removePatientById(id);
   }

   public ArrayList<Patient> getPatientByName(String name)
         throws RemoteException
   {
      return PatientServer.getPatientByName(name);
   }

   public void callLoadPatient(String name) throws IOException, RemoteException
   {
      PatientServer.LoadFromDB(name);
   }

   public ArrayList<Patient> getAllPatientsFromTheList() throws RemoteException
   {
      return PatientServer.getAllPatientsFromTheList();
   }

   @Override
   public ArrayList<Appointment> getAllBookedAppointments() throws RemoteException
   {

      return AppointmentServer.getAllBookedAppointments();
   }

   @Override
   public AppointmentList getAllFreeAppointment() throws RemoteException
   {
      // TODO Auto-generated method stub
      return AppointmentServer.getAllFreeAppointment();
   }

   @Override
   public void AddAppointmentToDBAndToList(Date date, String brief, int patientId,
         int dateId) throws RemoteException
   {
      AppointmentServer.AddAppointmentToDBAndToList(date, brief, patientId, dateId);

   }

   @Override
   public void removeAppointmentById(int id) throws RemoteException
   {
      AppointmentServer.removeAppointmentById(id);

   }


   @Override
   public int getThisDateId(Date date) throws RemoteException
   {

      return AppointmentServer.getThisDateId(date);
   }

   @Override
   public void removePatientById(int id) throws RemoteException
   {

   }

   @Override
   public void LoadFromDB(String name) throws IOException, RemoteException
   {

   }

   @Override
   public Employee getEmployeeById(int id) throws RemoteException
   {

      return StaffServer.getEmployeeById(id);
   }

   @Override
   public void updateEmployee(Employee employee) throws RemoteException
   {
      StaffServer.updateEmployee(employee);

   }

   @Override
   public void updatePatient(Patient patient) throws RemoteException
   {
      PatientServer.updatePatient(patient);
      
   }

   @Override
   public Patient getPatientByIdFromList(int id) throws RemoteException
   {
      // TODO Auto-generated method stub
      return PatientServer.getPatientByIdFromList(id);
   }



}

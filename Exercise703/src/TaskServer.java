import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class TaskServer extends UnicastRemoteObject implements RemoteTaskList

{
   /**
    * 
    */
   private static final long serialVersionUID = 1L;
   private TaskList taskList;

   public TaskServer() throws RemoteException
   {
      super();
      taskList = new TaskList();
   }

   public static void main(String[] args)
   {

      try
      {
         @SuppressWarnings("unused")
         Registry reg = LocateRegistry.createRegistry(1099);

         TaskServer rmiServer = new TaskServer();

         Naming.rebind("Exercise703", rmiServer);
         System.out.println("the server is ready");
      }
      catch (Exception ex)
      {
         ex.printStackTrace();
      }
   }

   @Override
   public void add(String task) throws RemoteException
   {
     
      taskList.addTask(task);
      System.out.println("the task has been added");
   }

   @Override
   public void remove() throws RemoteException
   {
      taskList.getAndRemoveNext();
      System.out.println("task has been removed");

   }

   @Override
   public int size() throws RemoteException
   {
     return taskList.size();
   }
}

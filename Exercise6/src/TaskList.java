import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;



public class TaskList extends UnicastRemoteObject implements TaskListInterface {
   private ArrayList<Task> tasks;
   
   public static void main(String[] args)
   {
      try
      {
        
         Registry reg = LocateRegistry.createRegistry(1099);
         TaskListInterface rmiServer = new TaskList();
         Naming.rebind("Exercise6", rmiServer);
         System.out.println(" starting the sever ..... ");
      }
      catch (Exception ex)
      {
         ex.printStackTrace();

      }
   }

   public RmiServer() throws RemoteException
   {
      
   }

   
   public TaskList()  {
      
      tasks = new ArrayList<>();
   }
   
   @Override
   public void add(Task task) {
      tasks.add(task);
      System.out.println("tasks: " + tasks);
   }
   
   @Override
   public Task getAndRemoveNextTask() {
      Task r = tasks.remove(0);
      System.out.println("tasks: " + tasks);
      return r;
   }
   
   @Override
   public int size() {
      return tasks.size();
   }
}

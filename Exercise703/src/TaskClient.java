import java.rmi.Naming;
import java.rmi.RemoteException;

public class TaskClient implements RemoteTaskList

{
   private RemoteTaskList remoteTaskList;

   public TaskClient() throws RemoteException
   {
      super();
      try
      {

         remoteTaskList = (RemoteTaskList) Naming
               .lookup("rmi://localhost:1099/Exercise703");

      }
      catch (Exception ex)
      {
         ex.printStackTrace();
      }
   }

   public static void main(String[] args) throws RemoteException
   {TaskClient client = new TaskClient();
   
   
   client.add("fadi");
   
   }

   @Override
   public void add(String task) throws RemoteException
   {
      remoteTaskList.add(task);
      
   }

   @Override
   public void remove() throws RemoteException
   {
      remoteTaskList.remove();
      
   }

   @Override
   public int size() throws RemoteException
   {
    return  remoteTaskList.size();
   }
}

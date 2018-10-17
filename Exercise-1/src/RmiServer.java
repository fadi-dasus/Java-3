import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;



public class RmiServer extends UnicastRemoteObject implements ServerInterface
{

   /**
    * 
    */
   private static final long serialVersionUID = 1L;

   public static void main(String[] args)
   {
      try
      {
         @SuppressWarnings("unused")
         Registry reg = LocateRegistry.createRegistry(1099);
         ServerInterface rmiServer = new RmiServer();
         Naming.rebind("Exercise-1", rmiServer);
         System.out.println(" starting the sever ..... ");
      }
      catch (Exception ex)
      {
         ex.printStackTrace();

      }
   }

   public RmiServer() throws RemoteException
   {
      super();
   }

   @Override
   public String toUpperCase(String msg, Object client) throws RemoteException
   {
      System.out.println("toUpperCase: client = " + client.getClass().getName());
      return msg.toUpperCase();
   }

}

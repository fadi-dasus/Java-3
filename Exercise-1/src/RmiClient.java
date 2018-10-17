import java.io.Serializable;
import java.rmi.Naming;
import java.rmi.RemoteException;

public class RmiClient implements Serializable

{
   /**
    * 
    */
   private static final long serialVersionUID = 1L;
   private ServerInterface server;

   public RmiClient() throws RemoteException
   {
      super();
      try
      {
         server = (ServerInterface) Naming
               .lookup("rmi://localhost:1099/Exercise-1");
         String msg = server.toUpperCase("hello", this);
         System.out.println(msg);
      }
      catch (Exception ex)
      {
         ex.printStackTrace();
      }
   }

   public static void main(String[] args) throws RemoteException
   {
      @SuppressWarnings("unused")
      RmiClient client = new RmiClient();
   }

}

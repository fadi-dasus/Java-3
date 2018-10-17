import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Server
{
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
}

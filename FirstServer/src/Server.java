import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class Server extends UnicastRemoteObject implements RemoteObject, ReplyTo
{
   /**
    * 
    */
   private static final long serialVersionUID = 1L;
   private ArrayList<String> list;

   protected Server() throws RemoteException
   {
      super();
      list = new ArrayList<String>();
   }

   @Override
   public void addMessage(String msg, ReplyTo who) throws RemoteException
   {

      list.add(msg);
      System.out.println(list);
      
      who.replyTo("welcome Fadi");
   }

   public static void main(String[] args)
   {

      try
      {
         @SuppressWarnings("unused")
         Registry reg = LocateRegistry.createRegistry(1100);

         RemoteObject rmiServerOne = new Server();

         Naming.rebind("rmi://10.152.206.77:1100/FadiServer", rmiServerOne);
         System.out.println("the server is ready and waiting for the client");
      }
      catch (Exception ex)
      {
         ex.printStackTrace();
      }
   }

   @Override
   public void replyTo(String msg2)
   {
      System.out.println(msg2);

   }
}

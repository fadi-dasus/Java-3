import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class RemoteMessageServer extends UnicastRemoteObject
      implements RemoteMessageList
{
   /**
    * 
    */
   private static final long serialVersionUID = 1L;
   private ArrayList<String> list;
   public RemoteMessageServer() throws RemoteException
   {
      super();
      list = new ArrayList<String>();

   }

   public static void main(String[] args)
   {
      try
      {
         LocateRegistry.createRegistry(1099);

         RemoteMessageList rmiServer = new RemoteMessageServer();

         Naming.rebind("Exercis702", rmiServer);
         System.out.println("the server is ready");
      }
      catch (Exception ex)
      {
         ex.printStackTrace();
      }

   }

   
   @Override
   public void addMessage(String msg,ReplyTo who)  throws RemoteException
   {
      
      
      System.out.println("te"
            + "the client is = " + who);
      who.replyMessage("thank you");
      list.add(msg);
      System.out.println(list);

   }

  
  

}

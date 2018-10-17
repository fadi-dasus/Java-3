import java.io.Serializable;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class RemoteMessageClient extends UnicastRemoteObject
      implements Serializable, RemoteMessageList, ReplyTo
{

   /**
    * 
    */
   private static final long serialVersionUID = 1L;
   private RemoteMessageList remotemessagelist;

   public RemoteMessageClient() throws RemoteException

   {
      super();
      try
      {

         remotemessagelist = (RemoteMessageList) Naming
               .lookup("rmi://localhost:1099/Exercis702");

      }
      catch (Exception ex)
      {
         ex.printStackTrace();
      }
   }

   public static void main(String[] args) throws RemoteException
   {
      RemoteMessageClient remote = new RemoteMessageClient();
      remote.addMessage("hello", remote);
   }

   @Override
   public void replyMessage(String msg)
   {

      System.out.println(msg);

   }

   @Override
   public void addMessage(String msg, ReplyTo who) throws RemoteException
   {
      remotemessagelist.addMessage(msg, who);

   }
}

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class Message extends UnicastRemoteObject implements Remote 
{

   /**
    * 
    */
   private static final long serialVersionUID = 1L;
   

   public Message() throws RemoteException
   {
      super();
     
   }
   public byte[] doOperatoin(int operationId, byte[] arguments) {
      
      
      
      
      return arguments;
      
   }
   
   
   
//   doOperation (RemoteRef s, int operationId, byte[] arguments)
   

}



import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class RMIClient extends UnicastRemoteObject implements RemoteObject,ReplyTo {
   /**
    * 
    */
   private static final long serialVersionUID = 1L;
   private RemoteObject server;

   protected RMIClient() throws RemoteException, MalformedURLException, NotBoundException {
      super();
      server = (RemoteObject) Naming.lookup("rmi://10.152.206.68:1100/FadiServer");
     
      System.out.println("");

   }

   

   public static void main(String[] args) throws RemoteException, MalformedURLException, NotBoundException {
     
      

      RMIClient rmc = new RMIClient();
      rmc.addMessage("hello", rmc);
}

   @Override
   public void addMessage(String msg, ReplyTo obj) throws RemoteException
   {
      server.addMessage(msg, obj);
      
   }



   @Override
   public void replyTo(String msg2)
   {
   System.out.println(msg2);
      
   }
}

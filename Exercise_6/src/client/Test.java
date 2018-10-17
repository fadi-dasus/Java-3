package client;

import java.rmi.RemoteException;

import tasks.Task;

public class Test
{
   public static void main(String[] args) throws RemoteException
   {
      Task task = new Task("Test task ", 100);
      Proxy p = new Proxy();
      p.add(task);
      
   }

}

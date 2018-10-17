package client;

import java.io.IOException;
import java.rmi.RemoteException;

import requestreply.Message;
import tasks.Task;
import tasks.TaskListInterface;
import util.ByteConverter;

public class Proxy implements TaskListInterface
{
   ByteConverter byt = new ByteConverter();
  
   @Override
   public void add(Task task) throws RemoteException
   {

      Message msg = new Message("1", ByteConverter.toByteArray(task));
      try
      {
         CommunicationModule.doOperation(msg);
      }
      catch (RemoteException e)
      {
         e.printStackTrace();
      }

   }

   @Override
   public Task getAndRemoveNextTask()
   {
      byte[] args = {};
      Message msg = new Message("2", args);
      byte[] returnedTask;
      Task t = null;
      try
      {
         returnedTask = CommunicationModule.doOperation(msg);
         t = (Task) ByteConverter.serializableFromByteArray(returnedTask);
      }
      catch (ClassNotFoundException | IOException e)
      {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }
      return t;
   }

   @Override
   public int size()
   {
      byte[] args = {};
      Message msg = new Message("3", args);
      byte[] returnedSize;
      int size = 0;
      try
      {
         returnedSize = CommunicationModule.doOperation(msg);
         size = ByteConverter.intFromByteArray(returnedSize);
      }
      catch (IOException e)
      {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }

      return size;
   }

}

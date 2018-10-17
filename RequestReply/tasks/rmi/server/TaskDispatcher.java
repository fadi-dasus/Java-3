package tasks.rmi.server;

import requestreply.Message;
import requestreply.server.Recipient;
import tasks.TaskList;

public class TaskDispatcher implements Recipient
{

   public TaskDispatcher(TaskList list)
   {
      // TODO Auto-generated constructor stub
   }

   @Override
   public byte[] interpret(Message message)
   {
      // TODO Auto-generated method stub
      return null;
   }

 
}

package server;

import java.io.IOException;

import requestreply.Message;
import tasks.Task;
import tasks.TaskList;
import util.ByteConverter;

public class TaskDispatcher implements Recipient
{
  
   TaskList taskList;

   public TaskDispatcher(TaskList list)
   {
      this.taskList = list;
   }
   @Override
   public byte[] interpret(Message message) {
      switch (message.getMethod()) {
      case "1":
         try {
            taskList.add((Task) ByteConverter.serializableFromByteArray(message.getArgs()[0]));
         } catch (ClassNotFoundException e) {
            e.printStackTrace();
         } catch (IOException e) {
            e.printStackTrace();
         }
         return null;
      case "2":
         Task t = taskList.getAndRemoveNextTask();
         byte[] task = ByteConverter.toByteArray(t);
         return task;
      case "3":
         byte[] size = ByteConverter.toByteArray(taskList.size());
         return size;
      default:
         return null;
      }


   }
   

}

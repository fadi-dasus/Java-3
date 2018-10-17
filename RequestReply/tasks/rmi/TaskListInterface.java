package tasks.rmi;

import tasks.Task;

public interface TaskListInterface 
{
   void add(Task task);
   Task getAndRemoveNextTask() ;
   int size();

}

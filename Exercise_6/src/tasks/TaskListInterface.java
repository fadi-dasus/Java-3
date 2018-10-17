package tasks;

import java.rmi.RemoteException;

import tasks.Task;

public interface TaskListInterface 
{
   void add(Task task) throws RemoteException;
   Task getAndRemoveNextTask() ;
   int size();

}

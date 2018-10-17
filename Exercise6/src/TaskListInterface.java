import java.rmi.Remote;

public interface TaskListInterface extends Remote
{
   
   void add(Task task);
   Task getAndRemoveNextTask();
   int size();
}

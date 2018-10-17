import java.util.ArrayList;

public class TaskList
{
   private ArrayList<String> tasks;

   public TaskList()
   {
      tasks = new ArrayList<String>();
   }

   public void addTask(String task)
   {
      tasks.add(task);
   }

   public String getAndRemoveNext()
   {
      
    //  String ret = tasks.get(0);
    //  tasks.remove(0);
   //   return ret;
      if( tasks.size() == 0) {
         return null;
      }
      else
      return tasks.remove(0);
   }

   public int size()
   {
      return tasks.size();
   }
}

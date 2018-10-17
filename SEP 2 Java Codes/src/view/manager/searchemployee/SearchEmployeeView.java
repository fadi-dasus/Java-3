
package view.manager.searchemployee;

import java.util.ArrayList;

import controller.employee.manager.*;
import domain.model.staff.Employee;

public interface SearchEmployeeView
{
  
   public void showTable(ArrayList<Employee> employees);
   public void start(SearchEmployeeController searchEmployeeController);
   public String getNameValue();
   
}

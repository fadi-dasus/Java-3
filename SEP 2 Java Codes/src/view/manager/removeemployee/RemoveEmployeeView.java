package view.manager.removeemployee;

import java.util.ArrayList;

import controller.employee.manager.RemoveEmlployeeController;
import domain.model.staff.Employee;



public interface RemoveEmployeeView {
	   public void showTable(ArrayList<Employee> employees);
	   public void start(RemoveEmlployeeController removeEmlployeeController);
	   public String getSearchTxtValue();
	   public void enableRemoveButton(boolean enable);
	   public void setComboboxValue(int[] ides);
	   public int getSelectedItemFromBox();
	  
}

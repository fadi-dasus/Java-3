package view.manager.editemployee;

import java.util.Date;

import controller.employee.manager.EditEmployeeController;

public interface EditEmployeeView {
	public String getSearchTxtValue();

	public void start(EditEmployeeController controller);
	public void setStartDate(Date date);
	public void setGender(String gender);
	public void setEmail(String email);
	public void setTel(String tel);
	public String getName();
	public void setDOB(Date date);
	public void setLastName(String lastName);
	public void setFirstName(String firstName);
	public int getSelectedValueCmbox() ;
	public void setComboboxValue(int[] ides);
	public String getStartDate();
	public String getDate();
	public String getGender();
	public String getEmail();
	public String getTel();
	public String getLastName();
	public String getFirstName();
	

}
package view.secretary.patient.editpatient;

import java.util.Date;

import controller.employee.manager.EditEmployeeController;
import controller.patient.EditPatientController;

public interface EditPatientView
{
  public void start(EditPatientController controller);
  public String getSearchTxtValue();
  public String getFirstName();
  public String getLastName();
  public String getTel() ;
	public String getEmail();
	public String getGender() ;
	public String getDate() ;
	public void setComboboxValue(int[] ides);
	public int getSelectedValueCmbox();
	public void setFirstName(String firstName);
	public void setLastName(String lastName);
	public void setDOB(Date date);
	public String getName();
	public void setTel(String tel);
	public void setEmail(String email);
	public void setGender(String gender);
	public void enableRemoveButton(boolean enable);
}
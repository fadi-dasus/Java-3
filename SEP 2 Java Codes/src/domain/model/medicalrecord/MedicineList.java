package domain.model.medicalrecord;

import java.util.ArrayList;


public class MedicineList {
private ArrayList<Medicine>medicines;

public MedicineList() {
	super();
	this.medicines = new ArrayList<Medicine>();
}

public void addMedicine(Medicine medicine)
{
   medicines.add(medicine);

}

public void removeMedicine(Medicine medicine)
{
   medicines.remove(medicine);

}

public Medicine getMedicineByName(String name)
{
	 for (int i = 0; i < medicines.size(); i++)
	   {
	      if (medicines.get(i).getName().equals(name))
	      {
	         return medicines.get(i);
	      }
	   }
	   System.out.println(
	         " we can not find that Medicine name in the system  : " + name + "!! ");
	   return null;
}

public Medicine getMedicineById(int medicineId)
{
   for (int i = 0; i < medicines.size(); i++)
   {
      if (medicines.get(i).getMedicineId() == medicineId)
      {
         return medicines.get(i);
      }
   }
   System.out.println(
         " we can not find that Medicine id in the system  : " + medicineId + "!! ");
   return null;
}

public Medicine editEmployee(String oldName, String newName)
{
	Medicine medicine = getMedicineByName(oldName);

   return medicine;

}

public Medicine searchMedicineByName(String name)
{
	Medicine medicine = getMedicineByName(name);

   return medicine;

}

public Medicine searchMedicineById(int id)
{
	Medicine medicine = getMedicineById(id);

   return medicine;

}

   public int getNumerOfEmployees() {
      return medicines.size();
   }
}

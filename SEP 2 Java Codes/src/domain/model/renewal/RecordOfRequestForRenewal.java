package domain.model.renewal;

import domain.model.medicalrecord.PrescriptionRecord;

public class RecordOfRequestForRenewal {
private PrescriptionRecord medicine;
private boolean approved;
private int quantity;
private int dailyDosage;
public RecordOfRequestForRenewal(PrescriptionRecord medicine, boolean approved, int quantity, int dailyDosage) {
	super();
	this.medicine = medicine;
	this.approved = approved;
	this.quantity = quantity;
	this.dailyDosage = dailyDosage;
}
public boolean isApproved() {
	return approved;
}
public void setApproved(boolean approved) {
	this.approved = approved;
}
public int getQuantity() {
	return quantity;
}
public void setQuantity(int quantity) {
	this.quantity = quantity;
}
public int getDailyDosage() {
	return dailyDosage;
}
public void setDailyDosage(int dailyDosage) {
	this.dailyDosage = dailyDosage;
}
@Override
public String toString() {
	return "RecordOfRequestForRenewal [approved=" + approved + ", quantity=" + quantity + ", dailyDosage=" + dailyDosage
			+ "]";
}

}

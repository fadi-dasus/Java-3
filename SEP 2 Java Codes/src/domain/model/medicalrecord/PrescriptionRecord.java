package domain.model.medicalrecord;

public class PrescriptionRecord {
private int prescriptionRecordId;
private String dailyDose;
private int quantity;
private Medicine medicine;
public PrescriptionRecord(int prescriptionRecordId, String dailyDose, int quantity, Medicine medicine) {
	super();
	this.prescriptionRecordId = prescriptionRecordId;
	this.dailyDose = dailyDose;
	this.quantity = quantity;
	this.medicine = medicine;
}
public int getPrescriptionRecordId() {
	return prescriptionRecordId;
}
public void setPrescriptionRecordId(int prescriptionRecordId) {
	this.prescriptionRecordId = prescriptionRecordId;
}
public String getDailyDose() {
	return dailyDose;
}
public void setDailyDose(String dailyDose) {
	this.dailyDose = dailyDose;
}
public int getQuantity() {
	return quantity;
}
public void setQuantity(int quantity) {
	this.quantity = quantity;
}
public Medicine getMedicine() {
	return medicine;
}
public void setMedicine(Medicine medicine) {
	this.medicine = medicine;
}
@Override
public String toString() {
	return "PrescriptionRecord [prescriptionRecordId=" + prescriptionRecordId + ", dailyDose=" + dailyDose
			+ ", quantity=" + quantity + ", medicine=" + medicine + "]";
}

}

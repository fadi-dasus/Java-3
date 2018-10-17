package domain.model.medicalrecord;

public class Medicine {
	private int medicineId;
	private String name;
	private String type;
	private String description;

	public Medicine(int medicineId, String name, String type, String description) {
		this.medicineId = medicineId;
		this.name = name;
		this.type = type;
		this.description = description;
	}

	public int getMedicineId() {
		return medicineId;
	}

	public void setMedicineId(int medicineId) {
		this.medicineId = medicineId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	@Override
	public String toString() {
		return "Medicine [medicineId=" + medicineId + ", name=" + name + ", type=" + type + ", description="
				+ description + "]";
	}
}

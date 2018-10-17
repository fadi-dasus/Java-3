package domain.model.staff;

public enum Type {
	Doctor, Secretary, Manager;

	public static String[] enumsToStringArray() {
		String[] results = new String[Type.values().length];
		int count = 0;
		for (Type each : Type.values()) {
			results[count] = each.toString();
			count++;
		}
		return results;
	}

}

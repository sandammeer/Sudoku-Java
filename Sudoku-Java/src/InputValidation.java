

public class InputValidation {
	
	// alternative solution using a regular expression (regex)
	// not tested
	public boolean validateValueWithRegex(String value) {
		boolean isValid = value.matches("^[1-9]");
		System.out.println("Value is 1-9 " + isValid);
		return isValid;
	}
	
	public boolean isValueAllowed(String value, int[] row, int[] col) {
		boolean isValid = true;

		for (int i = 0; i <= row.length; i++) {
			String compareString = Integer.toString(i);

			if (value.equals(compareString)) {
				isValid = false;
			}
		}
		
		for (int i = 0; i <= col.length; i++) {
			String compareString = Integer.toString(i);

			if (value.equals(compareString)) {
				isValid = false;
			}
		}
		return isValid;
	}

}

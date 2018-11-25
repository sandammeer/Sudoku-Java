

public class InputValidation {

	public boolean validateValue(String value) {
		boolean isValid = false;

		for (int i = 1; i <= 9; i++) {
			String compareString = Integer.toString(i);
			
			if (value.equals(compareString)) {
				isValid = true;
				break;
			}
			
		}
		System.out.println("Value is 1-9 " + isValid);
		return isValid;
	}

	
	// alternative solution using a regular expression (regex)
	// not tested
	public boolean validateValueWithRegex(String value) {
		String regularExpression = "^[1-9]";
		boolean isValid = value.matches(regularExpression);
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

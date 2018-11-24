
public class InputValidation {

	public boolean validateValue(String value) {
		boolean isValid = false;

		for (int i = 0; i >= 1 && i <= 9; i++) {
			String compareString = Integer.toString(i);
			isValid = value == compareString;
		}
		return isValid;
	}

	public boolean isValueAllowed(String value, int[] row, int[] col) {
		boolean isValid = true;

		for (int i = 0; i <= row.length; i++) {
			String compareString = Integer.toString(i);

			if (value == compareString) {
				isValid = false;
			}
		}
		
		for (int i = 0; i <= col.length; i++) {
			String compareString = Integer.toString(i);

			if (value == compareString) {
				isValid = false;
			}
		}
		return isValid;
	}

}

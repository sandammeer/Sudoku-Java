import java.awt.event.*;
import javax.swing.*;
import java.util.*;


public class CellInputListener implements ActionListener {

	public void actionPerformed(ActionEvent event) {
		
		// Get the source object that fired the event
		JTextField selectedTextField = (JTextField) event.getSource();
		String text = selectedTextField.getText();

		// Gets the
		int[] position = positionForTextField(selectedTextField);
		int row = position[0];
		int col = position[1];
		
		// Todo: Pass data to Validator
		InputValidation validator = new InputValidation();
		
		boolean isAllowed = validator.isValueAllowed(text, SudokuData.puzzle[row], getArrayForColumn(col));
		System.out.println(isAllowed);
	}

	public int[] getArrayForColumn(int col) {
		
		int[] column = new int[SudokuData.puzzle[0].length];
		
		for(int row = 0; row < SudokuData.puzzle[0].length; row++) {
		    column[row] = SudokuData.puzzle[row][col];
		}
		return column;
	}
	
	private int[] positionForTextField(JTextField textField) {
		int rowSelected = -1;
        int colSelected = -1;
		boolean found = false;
		
		for (int row = 0; row < SudokuData.GRID_SIZE && !found; ++row) {
           for (int col = 0; col < SudokuData.GRID_SIZE && !found; ++col) {
              if (SudokuData.tfCells[row][col] == textField) {
                 rowSelected = row;
                 colSelected = col;
                 found = true;  // break the inner/outer loops
              }
           }
        }
		return new int[]{rowSelected, colSelected};
	}

}

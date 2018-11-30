import java.awt.event.*;
import javax.swing.*;
import java.util.*;


public class CellInputListener implements KeyListener {

	public void keyTyped(KeyEvent e) {
		
		// Get the source object that fired the event
		JTextField selectedTextField = (JTextField) e.getSource();
		String text = selectedTextField.getText();

		// Gets the position of the textfield in the grid
		int[] position = positionForTextField(selectedTextField);
		int row = position[0];
		int col = position[1];
		
		InputValidation validator = new InputValidation();
		
		boolean isAllowed = validator.isValueAllowed(text, SudokuData.puzzle[row], SudokuData.getColumn(col));
		System.out.println(isAllowed);
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

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}

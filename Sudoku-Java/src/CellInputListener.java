import java.awt.event.*;
import javax.swing.*;

public class CellInputListener implements ActionListener {

	public void actionPerformed(ActionEvent event) {

		// Get the source object that fired the event
		JTextField selectedTextField = (JTextField) event.getSource();
		String text = selectedTextField.getText();

		// Gets the
		int[] position = positionForTextField(selectedTextField);

		// Todo: Pass data to Validator
		
	}

	private int[] positionForTextField(JTextField textField) {
		SudokuData data = SudokuData.getInstance();
		int rowSelected = -1;
        int colSelected = -1;
		boolean found = false;
		
		for (int row = 0; row < data.GRID_SIZE && !found; ++row) {
           for (int col = 0; col < data.GRID_SIZE && !found; ++col) {
              if (data.tfCells[row][col] == textField) {
                 rowSelected = row;
                 colSelected = col;
                 found = true;  // break the inner/outer loops
              }
           }
        }
		return new int[]{rowSelected, colSelected};
	}

}

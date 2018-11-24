import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class MainFrame extends JFrame {

	SudokuData data;
	
	public void frameInit() {
		super.frameInit();
		
		setupAppereance();
		setupData();
	}
	
	private void setupAppereance() {
		setTitle("Sudoku");
		setPreferredSize(new Dimension(300, 300));
	}
	
	private void setupData() {
		data = SudokuData.getInstance();
		
		int[][] puzzle = data.puzzle;

		Container cPane = getContentPane();
		cPane.setLayout(new GridLayout(data.GRID_SIZE, data.GRID_SIZE));
		
		JTextField[][] tfCells = data.tfCells;
		
		// Construct 9x9 JTextFields and add to the content-pane
	      for (int row = 0; row < data.GRID_SIZE; ++row) {
	         for (int col = 0; col < data.GRID_SIZE; ++col) {
	            tfCells[row][col] = new JTextField(); // Allocate element of array
	            cPane.add(tfCells[row][col]);            // ContentPane adds JTextField
	            
	            JTextField currentTextField = tfCells[row][col];
	            
	            if (data.states[row][col]) {
	            	styleEditableTextfield(currentTextField);
	               
	               // Add ActionEvent listener to process the input
	               // ... [TODO 4] (Later) ...
	            } else {
	               styleNonEditableTextfield(currentTextField, data.puzzle[row][col]);
	            }
	            
	            // Beautify all the cells
	            currentTextField.setHorizontalAlignment(JTextField.CENTER);
	            currentTextField.setFont(data.FONT_NUMBERS);
	         }
	      }
	}
	
	private void styleEditableTextfield(JTextField textField) {
		textField.setText("");
		textField.setEditable(true);
		textField.setBackground(data.OPEN_CELL_BGCOLOR);
	}
	
	private void styleNonEditableTextfield(JTextField textField, int value) {
		textField.setText(value + "");
		textField.setEditable(false);
		textField.setBackground(data.CLOSED_CELL_BGCOLOR);
		textField.setForeground(data.CLOSED_CELL_TEXT);
	}
	
	public void showSudoku() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pack();
		setVisible(true);
	}

}

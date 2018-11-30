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
		
		int[][] puzzle = SudokuData.puzzle;

		Container cPane = getContentPane();
		cPane.setLayout(new GridLayout(SudokuData.GRID_SIZE, SudokuData.GRID_SIZE));
		
		SudokuCell[][] tfCells = SudokuData.tfCells;
		
		// Construct 9x9 JTextFields and add to the content-pane
	      for (int row = 0; row < SudokuData.GRID_SIZE; ++row) {
	         for (int col = 0; col < SudokuData.GRID_SIZE; ++col) {
	        	 
	            tfCells[row][col] = new SudokuCell(); // Allocate element of array
	            SudokuCell textField = tfCells[row][col];
	            cPane.add(textField);         		  // ContentPane adds JTextField
	            
	            boolean state = SudokuData.states[row][col];
	            
                // Add Keylistener to process the typed key
            	CellInputListener inputListener = new CellInputListener();
            	textField.addKeyListener(inputListener);
            	
	            textField.setNumberPuzzle(SudokuData.puzzle[row][col]);
	            textField.setIsFilled(state);
	         }
	      }
	}
	
	public void showSudoku() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pack();
		setVisible(true);
	}

}

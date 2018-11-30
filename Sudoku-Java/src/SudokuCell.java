import java.awt.*;
import javax.swing.*;


public class SudokuCell extends JTextField {
	
	// Package access
   int row, col;      // row and col of this JTextField

   // More?! For examples,
   int numberPuzzle;  // The puzzle number
   boolean isFilled;  // to be solved?
   int numberGuess;   // The number entered/display
   boolean isValid;

   
   public SudokuCell() {
	   super();
	   
	   setupAppereance();
   }
   
   private void setupAppereance() {
	   setHorizontalAlignment(JTextField.CENTER);
	   setFont(new Font("Monospaced", Font.BOLD, 20));
	   setForeground(Color.BLACK);
   }
   
   public void setNumberPuzzle(int number) {
	   numberPuzzle = number;
   }
   
   public void setIsFilled(boolean editable) {
	   isFilled = editable;
	   
	   if (editable) {
		   setText("");
		   setEditable(true);
		   setBackground(Color.YELLOW);
	   } else {
		   setText(numberPuzzle + "");
		   setEditable(false);
		   setBackground(new Color(240, 240, 240));
	   }
   }
}

import java.awt.Color;
import java.awt.Font;

import javax.swing.JTextField;

public class SudokuData {

	// Eine (versteckte) Klassenvariable vom Typ der eigenen Klasse
	private static SudokuData instance;

	// Verhindere die Erzeugung des Objektes über andere Methoden
	private SudokuData() {
	}

	// Eine Zugriffsmethode auf Klassenebene, welches dir '''einmal''' ein konkretes
	// Objekt erzeugt und dieses zurückliefert.
	private static SudokuData getInstance() {
		if (SudokuData.instance == null) {
			SudokuData.instance = new SudokuData();
		}
		return SudokuData.instance;
	}

	// Constants
	public static final int GRID_SIZE = 9; // Size of the board
	public static final int SUBGRID_SIZE = 3; // Size of the sub-grid

	// Name-constants for UI control (sizes, colors and fonts)
	public static final int CELL_SIZE = 60; // Cell width/height in pixels
	public static final int CANVAS_WIDTH = CELL_SIZE * GRID_SIZE;
	public static final int CANVAS_HEIGHT = CELL_SIZE * GRID_SIZE;
	// Board width/height in pixels
	

	// The game board composes of 9x9 JTextFields,
	// each containing String "1" to "9", or empty String
	static SudokuCell[][] tfCells = new SudokuCell[GRID_SIZE][GRID_SIZE];

	static int[][] puzzle = { 
			{ 5, 3, 4, 6, 7, 8, 9, 1, 2 },
			{ 6, 7, 2, 1, 9, 5, 3, 4, 8 },
			{ 1, 9, 8, 3, 4, 2, 5, 6, 7 },
			{ 8, 5, 9, 7, 6, 1, 4, 2, 3 },
			{ 4, 2, 6, 8, 5, 3, 7, 9, 1 },
			{ 7, 1, 3, 9, 2, 4, 8, 5, 6 },
			{ 9, 6, 1, 5, 3, 7, 2, 8, 4 },
			{ 2, 8, 7, 4, 1, 9, 6, 3, 5 },
			{ 3, 4, 5, 2, 8, 6, 1, 7, 9 } };

	// For testing, open only 2 cells.
	static boolean[][] states = { 
			{ false, false, false, false, false, true, false, false, false },
			{ false, false, false, false, false, false, false, false, true },
			{ false, false, false, false, false, false, false, false, false },
			{ false, false, false, false, false, false, false, false, false },
			{ false, false, false, false, false, false, false, false, false },
			{ false, false, false, false, false, false, false, false, false },
			{ false, false, false, false, false, false, false, false, false },
			{ false, false, false, false, false, false, false, false, false },
			{ false, false, false, false, false, false, false, false, false } };

	public static int[][] getPuzzle() {
		return puzzle;
	}

	public static boolean[][] getStates() {
		return states;
	}

	public static int[] getRow(int index) {
		return puzzle[index];
	}

	public static int[] getColumn(int index) {
		int[] column = new int[puzzle[0].length];

		for (int row = 0; row < puzzle[0].length; row++) {
			column[row] = puzzle[index][index];
		}
		return column;
	}
}

package experiment;

import java.util.HashSet;
import java.util.Set;

/**
 * TestBoard holds the experimental 4x4 grid of TestBoardCells and
 * calculates movement targets. Methods are stubs for now so the
 * movement tests compile and fail.
 */
public class TestBoard {

	/**
	 * Creates the test board.
	 */
	public TestBoard() {
		// stub
	}

	/**
	 * Calculates the legal targets for a move from startCell of exactly
	 * pathlength steps.
	 */
	public void calcTargets(TestBoardCell startCell, int pathlength) {
		// stub
	}

	/**
	 * Returns the cell at the given row and column.
	 */
	public TestBoardCell getCell(int row, int col) {
		return new TestBoardCell(row, col);
	}

	/**
	 * Returns the targets found by the last call to calcTargets.
	 */
	public Set<TestBoardCell> getTargets() {
		return new HashSet<TestBoardCell>();
	}
}

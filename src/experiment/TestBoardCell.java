package experiment;

import java.util.HashSet;
import java.util.Set;

/**
 * TestBoardCell represents a single cell on the experimental 4x4 test board.
 * Methods are stubs for now so the movement tests compile and fail.
 */
public class TestBoardCell {
	private int row;
	private int col;

	/**
	 * Creates a cell at the given row and column.
	 */
	public TestBoardCell(int row, int col) {
		this.row = row;
		this.col = col;
	}

	/**
	 * Adds a cell to this cell's adjacency list.
	 */
	public void addAdjacency(TestBoardCell cell) {
		// stub
	}

	/**
	 * Returns the set of cells adjacent to this cell.
	 */
	public Set<TestBoardCell> getAdjList() {
		return new HashSet<TestBoardCell>();
	}

	/**
	 * Marks whether this cell is part of a room.
	 */
	public void setRoom(boolean isRoom) {
		// stub
	}

	/**
	 * Returns true if this cell is part of a room.
	 */
	public boolean isRoom() {
		return false;
	}

	/**
	 * Marks whether this cell is occupied by a player.
	 */
	public void setOccupied(boolean isOccupied) {
		// stub
	}

	/**
	 * Returns true if this cell is occupied by a player.
	 */
	public boolean getOccupied() {
		return false;
	}
}

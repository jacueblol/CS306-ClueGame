package tests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import experiment.TestBoard;
import experiment.TestBoardCell;

/**
 * BoardTestExp contains JUnit tests for adjacency and target
 * calculation on the experimental 4x4 TestBoard.
 */
public class BoardTestExp {
	TestBoard board;

	/**
	 * Creates a fresh board before each test.
	 */
	@BeforeEach
	public void setUp() {
		board = new TestBoard();
	}

	/**
	 * Top left corner [0][0] is adjacent only to [1][0] and [0][1].
	 */
	@Test
	public void testAdjacencyTopLeft() {
		TestBoardCell cell = board.getCell(0, 0);
		Set<TestBoardCell> testList = cell.getAdjList();
		assertEquals(2, testList.size());
		assertTrue(testList.contains(board.getCell(1, 0)));
		assertTrue(testList.contains(board.getCell(0, 1)));
	}

	/**
	 * Bottom right corner [3][3] is adjacent only to [2][3] and [3][2].
	 */
	@Test
	public void testAdjacencyBottomRight() {
		TestBoardCell cell = board.getCell(3, 3);
		Set<TestBoardCell> testList = cell.getAdjList();
		assertEquals(2, testList.size());
		assertTrue(testList.contains(board.getCell(2, 3)));
		assertTrue(testList.contains(board.getCell(3, 2)));
	}

	/**
	 * Right edge [1][3] is adjacent to [0][3], [2][3], and [1][2].
	 */
	@Test
	public void testAdjacencyRightEdge() {
		TestBoardCell cell = board.getCell(1, 3);
		Set<TestBoardCell> testList = cell.getAdjList();
		assertEquals(3, testList.size());
		assertTrue(testList.contains(board.getCell(0, 3)));
		assertTrue(testList.contains(board.getCell(2, 3)));
		assertTrue(testList.contains(board.getCell(1, 2)));
	}

	/**
	 * Bottom left corner [3][0] is adjacent only to [2][0] and [3][1].
	 */
	@Test
	public void testAdjacencyLeftEdge() {
		TestBoardCell cell = board.getCell(3, 0);
		Set<TestBoardCell> testList = cell.getAdjList();
		assertEquals(2, testList.size());
		assertTrue(testList.contains(board.getCell(2, 0)));
		assertTrue(testList.contains(board.getCell(3, 1)));
	}

	/**
	 * Middle cell [2][2] is adjacent to all four neighbors:
	 * [1][2], [3][2], [2][1], and [2][3]. Diagonals are not adjacent.
	 */
	@Test
	public void testAdjacencyMiddle() {
		TestBoardCell cell = board.getCell(2, 2);
		Set<TestBoardCell> testList = cell.getAdjList();
		assertEquals(4, testList.size());
		assertTrue(testList.contains(board.getCell(1, 2)));
		assertTrue(testList.contains(board.getCell(3, 2)));
		assertTrue(testList.contains(board.getCell(2, 1)));
		assertTrue(testList.contains(board.getCell(2, 3)));
	}

	/**
	 * Occupied cells cannot be targets or be moved through.
	 * Case 1: start [0][0], roll 2, [1][0] occupied. An empty board gives
	 * [0][2], [1][1], [2][0]; [2][0] is now blocked, but [1][1] is still
	 * reachable through [0][1].
	 * Case 2: start [3][3], roll 3, [2][3] occupied. An empty board gives
	 * 6 targets; [2][3] is occupied and [0][3] behind it is blocked.
	 */
	@Test
	public void testTargetsOccupied() {
		// Case 1: occupied cell blocks the path down the left edge
		board.getCell(1, 0).setOccupied(true);
		TestBoardCell cell = board.getCell(0, 0);
		board.calcTargets(cell, 2);
		Set<TestBoardCell> targets = board.getTargets();
		assertEquals(2, targets.size());
		assertTrue(targets.contains(board.getCell(0, 2)));
		assertTrue(targets.contains(board.getCell(1, 1)));
		assertFalse(targets.contains(board.getCell(2, 0)));

		// Case 2: occupied cell is not a target and blocks cells behind it
		board = new TestBoard();
		board.getCell(2, 3).setOccupied(true);
		cell = board.getCell(3, 3);
		board.calcTargets(cell, 3);
		targets = board.getTargets();
		assertEquals(3, targets.size());
		assertTrue(targets.contains(board.getCell(3, 0)));
		assertTrue(targets.contains(board.getCell(2, 1)));
		assertTrue(targets.contains(board.getCell(1, 2)));
		assertFalse(targets.contains(board.getCell(2, 3)));
		assertFalse(targets.contains(board.getCell(0, 3)));
	}

	/**
	 * Targets on an empty board, from three different starting cells and
	 * with rolls from 1 up to the maximum die roll of 6. A cell may not be
	 * visited twice in one move, and the move must use the whole roll.
	 */
	@Test
	public void testTargetsNormal() {
		// Case 1: top left corner [0][0], roll 1, only the two neighbors
		TestBoardCell cell = board.getCell(0, 0);
		board.calcTargets(cell, 1);
		Set<TestBoardCell> targets = board.getTargets();
		assertEquals(2, targets.size());
		assertTrue(targets.contains(board.getCell(0, 1)));
		assertTrue(targets.contains(board.getCell(1, 0)));

		// Case 2: top left corner [0][0], roll 3
		board.calcTargets(cell, 3);
		targets = board.getTargets();
		assertEquals(6, targets.size());
		assertTrue(targets.contains(board.getCell(0, 1)));
		assertTrue(targets.contains(board.getCell(0, 3)));
		assertTrue(targets.contains(board.getCell(1, 0)));
		assertTrue(targets.contains(board.getCell(1, 2)));
		assertTrue(targets.contains(board.getCell(2, 1)));
		assertTrue(targets.contains(board.getCell(3, 0)));

		// Case 3: top left corner [0][0], roll 6 (maximum die roll)
		board.calcTargets(cell, 6);
		targets = board.getTargets();
		assertEquals(7, targets.size());
		assertTrue(targets.contains(board.getCell(0, 2)));
		assertTrue(targets.contains(board.getCell(1, 1)));
		assertTrue(targets.contains(board.getCell(1, 3)));
		assertTrue(targets.contains(board.getCell(2, 0)));
		assertTrue(targets.contains(board.getCell(2, 2)));
		assertTrue(targets.contains(board.getCell(3, 1)));
		assertTrue(targets.contains(board.getCell(3, 3)));

		// Case 4: inner cell [2][1], roll 2
		cell = board.getCell(2, 1);
		board.calcTargets(cell, 2);
		targets = board.getTargets();
		assertEquals(6, targets.size());
		assertTrue(targets.contains(board.getCell(0, 1)));
		assertTrue(targets.contains(board.getCell(1, 0)));
		assertTrue(targets.contains(board.getCell(1, 2)));
		assertTrue(targets.contains(board.getCell(2, 3)));
		assertTrue(targets.contains(board.getCell(3, 0)));
		assertTrue(targets.contains(board.getCell(3, 2)));

		// Case 5: inner cell [1][2], roll 4
		cell = board.getCell(1, 2);
		board.calcTargets(cell, 4);
		targets = board.getTargets();
		assertEquals(7, targets.size());
		assertTrue(targets.contains(board.getCell(0, 1)));
		assertTrue(targets.contains(board.getCell(0, 3)));
		assertTrue(targets.contains(board.getCell(1, 0)));
		assertTrue(targets.contains(board.getCell(2, 1)));
		assertTrue(targets.contains(board.getCell(2, 3)));
		assertTrue(targets.contains(board.getCell(3, 0)));
		assertTrue(targets.contains(board.getCell(3, 2)));

		// Case 6: bottom right corner [3][3], roll 5
		cell = board.getCell(3, 3);
		board.calcTargets(cell, 5);
		targets = board.getTargets();
		assertEquals(8, targets.size());
		assertTrue(targets.contains(board.getCell(0, 1)));
		assertTrue(targets.contains(board.getCell(0, 3)));
		assertTrue(targets.contains(board.getCell(1, 0)));
		assertTrue(targets.contains(board.getCell(1, 2)));
		assertTrue(targets.contains(board.getCell(2, 1)));
		assertTrue(targets.contains(board.getCell(2, 3)));
		assertTrue(targets.contains(board.getCell(3, 0)));
		assertTrue(targets.contains(board.getCell(3, 2)));

		// Case 7: bottom right corner [3][3], roll 6 (maximum die roll)
		board.calcTargets(cell, 6);
		targets = board.getTargets();
		assertEquals(7, targets.size());
		assertTrue(targets.contains(board.getCell(0, 0)));
		assertTrue(targets.contains(board.getCell(0, 2)));
		assertTrue(targets.contains(board.getCell(1, 1)));
		assertTrue(targets.contains(board.getCell(1, 3)));
		assertTrue(targets.contains(board.getCell(2, 0)));
		assertTrue(targets.contains(board.getCell(2, 2)));
		assertTrue(targets.contains(board.getCell(3, 1)));
	}

	/**
	 * Entering a room ends the move, so a room cell can be a target even
	 * with steps left over, but no cell past it can be reached through it.
	 * Case 1: start [0][0], roll 3, room at [0][1]. An empty board gives
	 * 6 targets; now [0][3] and [1][0] cannot be reached, leaving 4.
	 * Case 2: start [3][3], roll 4, room at [2][3]. An empty board gives
	 * 6 targets; the room is now also a target even though it is only
	 * one step away, giving 7.
	 */
	@Test
	public void testTargetsRoom() {
		// Case 1: room next to the start blocks the path along the top row
		board.getCell(0, 1).setRoom(true);
		TestBoardCell cell = board.getCell(0, 0);
		board.calcTargets(cell, 3);
		Set<TestBoardCell> targets = board.getTargets();
		assertEquals(4, targets.size());
		assertTrue(targets.contains(board.getCell(0, 1)));
		assertTrue(targets.contains(board.getCell(1, 2)));
		assertTrue(targets.contains(board.getCell(2, 1)));
		assertTrue(targets.contains(board.getCell(3, 0)));
		assertFalse(targets.contains(board.getCell(0, 3)));
		assertFalse(targets.contains(board.getCell(1, 0)));

		// Case 2: room one step away is a target before the roll is used up
		board = new TestBoard();
		board.getCell(2, 3).setRoom(true);
		cell = board.getCell(3, 3);
		board.calcTargets(cell, 4);
		targets = board.getTargets();
		assertEquals(7, targets.size());
		assertTrue(targets.contains(board.getCell(2, 3)));
		assertTrue(targets.contains(board.getCell(0, 2)));
		assertTrue(targets.contains(board.getCell(1, 1)));
		assertTrue(targets.contains(board.getCell(1, 3)));
		assertTrue(targets.contains(board.getCell(2, 0)));
		assertTrue(targets.contains(board.getCell(2, 2)));
		assertTrue(targets.contains(board.getCell(3, 1)));
	}

	/**
	 * Targets with both a room and an occupied cell on the board.
	 * Case 1: start [0][3], roll 3, [0][2] occupied, room at [1][2].
	 * An empty board gives 6 targets; only [1][2], [2][2], and [3][3]
	 * remain.
	 * Case 2: start [3][0], roll 4, [2][0] occupied, room at [3][2].
	 * An empty board gives 6 targets; the occupied cell blocks the left
	 * edge and the room stops moves through the bottom row, so [2][1] can
	 * no longer be reached, leaving 5.
	 */
	@Test
	public void testTargetsMixed() {
		// Case 1: occupied cell and room together near the top right
		board.getCell(0, 2).setOccupied(true);
		board.getCell(1, 2).setRoom(true);
		TestBoardCell cell = board.getCell(0, 3);
		board.calcTargets(cell, 3);
		Set<TestBoardCell> targets = board.getTargets();
		assertEquals(3, targets.size());
		assertTrue(targets.contains(board.getCell(1, 2)));
		assertTrue(targets.contains(board.getCell(2, 2)));
		assertTrue(targets.contains(board.getCell(3, 3)));
		assertFalse(targets.contains(board.getCell(0, 2)));

		// Case 2: occupied cell above the start, room along the bottom row
		board = new TestBoard();
		board.getCell(2, 0).setOccupied(true);
		board.getCell(3, 2).setRoom(true);
		cell = board.getCell(3, 0);
		board.calcTargets(cell, 4);
		targets = board.getTargets();
		assertEquals(5, targets.size());
		assertTrue(targets.contains(board.getCell(0, 1)));
		assertTrue(targets.contains(board.getCell(1, 0)));
		assertTrue(targets.contains(board.getCell(1, 2)));
		assertTrue(targets.contains(board.getCell(2, 3)));
		assertTrue(targets.contains(board.getCell(3, 2)));
		assertFalse(targets.contains(board.getCell(2, 0)));
		assertFalse(targets.contains(board.getCell(2, 1)));
	}
}

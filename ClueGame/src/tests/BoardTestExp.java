package tests;

import static org.junit.jupiter.api.Assertions.assertEquals;
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
}

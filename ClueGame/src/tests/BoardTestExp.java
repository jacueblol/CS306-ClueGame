package tests;

import org.junit.jupiter.api.BeforeEach;

import experiment.TestBoard;

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
}

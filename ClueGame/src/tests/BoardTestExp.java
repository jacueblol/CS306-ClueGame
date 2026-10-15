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
	
	
	
	public void empty() {
		try {
			//calcTargets(TestBoardCell startCell, int pathlength)
			
			board.calcTargets(board.getCell(1,2), 1);
			
		}
		catch{
			system.out.println("Failed to calculate target");
		}
	}
	
	
	
	public void empty2() {
		try {
			board.calcTargets(board.getCell(2,4), 2);
			
		}
		catch{
			system.out.println("Failed to calculate target");
		}
	}
	
	
	
	public void empty3() {
		try {
			board.calcTargets(board.getCell(1,3), 3);
			
		}
		catch{
			system.out.println("Failed to calculate target");
		}
	}
	
	
	public void empty4() {
		try {
			board.calcTargets(board.getCell(3,1), 4);
			
		}
		catch{
			system.out.println("Failed to calculate target");
		}
	}
	
	public void empty5() {
		try {
			board.calcTargets(board.getCell(2,1), 5);
			
		}
		catch{
			system.out.println("Failed to calculate target");
		}
	}
	
	public void empty6() {
		try {
			board.calcTargets(board.getCell(1,1), 6);
			
		}
		catch{
			system.out.println("Failed to calculate target");
		}
	}
	
	
	public void empty7() {
		try {
			board.calcTargets(board.getCell(2,2), 3);
			
		}
		catch{
			system.out.println("Failed to calculate target");
		}
	}
	
	
	
	
	public void occupied1() {
		try {
			
			
			board.getCell(1,3).setOccupied();
			//setOccupied
			
			
			board.calcTargets(board.getCell(1,1), 2);
		
			
			
			Target=board.getTargets();
			
			
			for(int i=0; i<Target.size(); i++) {
				if(Target[i].getOccupied==true) {
				//if(Target.contains(OcCell[i])) {
					System.out.println("occupied cell is in target when it should not be");
				}
			}
		}
			
		catch{
			system.out.println("Failed to calculate target");
		}
	}
	
	
	public void occupied2() {
		try {
			
			board.getCell(2,3).setOccupied();
			
			
			board.calcTargets(board.getCell(2,2), 1);
			
			Target=board.getTargets();
			
			
			for(int i=0; i<Target.size(); i++) {
				if(Target[i].getOccupied==true) {
				//if(Target.contains(OcCell[i])) {
					System.out.println("occupied cell is in target when it should not be");
				}
			}
		}
			
		catch{
			system.out.println("Failed to calculate target");
		}
	}
	
	
	
	
	
	
	
	
	
	public void roomTest1() {
		try {
			
			board.getCell(1,3).setRoom(true);
			
			board.calcTargets(board.getCell(1,1), 2);
			Target=board.getTargets();
			
			
		
		for(int i=0; i<Target.size(); i++) {
			if(Target[i].isRoom==true) {
			//if(Target.contains(OcCell[i])) {
				System.out.println("There a room in the target list");

			}
			
		}
		
	}
		
			
		
		catch{
			system.out.println("Failed to calculate target");
		}
		
	}
	public void roomTest2() {
		try {
			
			board.getCell(2,3).setRoom(true);
			
			board.calcTargets(board.getCell(2,2), 1);
			Target=board.getTargets();
			
			
		
		for(int i=0; i<Target.size(); i++) {
			if(Target[i].isRoom==true) {
			//if(Target.contains(OcCell[i])) {
				System.out.println("There a room in the target list");

			}
			
		}
		
	}
		
			
			
			
		
		catch{
			system.out.println("Failed to calculate target");
		}
		
	}
	
	
	
}

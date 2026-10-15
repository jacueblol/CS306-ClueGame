package tests;

import org.junit.jupiter.api.BeforeEach;


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
	
	
	
	public void empty() {
		try {
			//calcTargets(TestBoardCell startCell, int pathlength)
			
			board.calcTargets(board.getCell(1,2), 1);
			
		}
		catch (Exception e){
			System.out.println("Failed to calculate target instead got "+e);
			
		}
	}
	
	
	
	public void empty2() {
		try {
			board.calcTargets(board.getCell(2,4), 2);
			
		}
		catch(Exception e){
			System.out.println("Failed to calculate target instead got "+e);
		}
	}
	
	
	
	public void empty3() {
		try {
			board.calcTargets(board.getCell(1,3), 3);
			
		}
		catch(Exception e){
			System.out.println("Failed to calculate target instead got "+e);
		}
	}
	
	
	public void empty4() {
		try {
			board.calcTargets(board.getCell(3,1), 4);
			
		}
		catch(Exception e){
			System.out.println("Failed to calculate target instead got "+e);
		}
	}
	
	public void empty5() {
		try {
			board.calcTargets(board.getCell(2,1), 5);
			
		}
		catch(Exception e){
			System.out.println("Failed to calculate target instead got "+e);
		}
	}
	
	public void empty6() {
		try {
			board.calcTargets(board.getCell(1,1), 6);
			
		}
		catch(Exception e){
			System.out.println("Failed to calculate target instead got "+e);
		}
	}
	
	
	public void empty7() {
		try {
			board.calcTargets(board.getCell(2,2), 3);
			
		}
		catch(Exception e){
			System.out.println("Failed to calculate target instead got "+e);
		}
	}
	
	
	
	
	public void occupied1() {
		try {
			
			
			board.getCell(1,3).setOccupied(true);
			//setOccupied
			
			
			board.calcTargets(board.getCell(1,1), 2);
		
			
			
			Set<TestBoardCell> Target= new board.getTargets();
			
			
			for(int i=0; i<Target.size(); i++) {
				if(Target[i].getOccupied==true) {
				//if(Target.contains(OcCell[i])) {
					System.out.println("occupied cell is in target when it should not be");
				}
			}
		}
			
		catch (Exception e){
			System.out.println("Failed to calculate target instead got "+e);
		}
	}
	
	
	public void occupied2() {
		try {
			
			board.getCell(2,3).setOccupied(true);
			
			
			board.calcTargets(board.getCell(2,2), 1);
			
			Set<TestBoardCell> Target= new board.getTargets();
			
			
			for(int i=0; i<Target.size(); i++) {
				if(Target[i].getOccupied==true) {
				//if(Target.contains(OcCell[i])) {
					System.out.println("occupied cell is in target when it should not be");
				}
			}
		}
			
		catch (Exception e){
			System.out.println("Failed to calculate target instead got "+e);
		}
	}
	
	
	
	
	
	
	
	
	
	public void roomTest1() {
		try {
			
			board.getCell(1,3).setRoom(true);
			
			board.calcTargets(board.getCell(1,1), 2);
			Set<TestBoardCell> Target= new board.getTargets();
			
			
		
		for(int i=0; i<Target.size(); i++) {
			if(Target[i].isRoom==true) {
			//if(Target.contains(OcCell[i])) {
				System.out.println("There a room in the target list");

			}
			
		}
		
	}
		
			
		
		catch (Exception e){
			System.out.println("Failed to calculate target instead got "+e);
		}
		
	}
	public void roomTest2() {
		try {
			
			board.getCell(2,3).setRoom(true);
			
			board.calcTargets(board.getCell(2,2), 1);
			Set<TestBoardCell> Target= new board.getTargets();
			//new HashSet<TestBoardCell>()
			
		
		for(int i=0; i<Target.size(); i++) {
			if(Target[i].isRoom==true) {
			//if(Target.contains(OcCell[i])) {
				System.out.println("There a room in the target list");

			}
			
		}
		
	}
		
			
			
			
		
		catch (Exception e){
			System.out.println("Failed to calculate target instead got "+e);
		}
		
	}
	
	
	
}

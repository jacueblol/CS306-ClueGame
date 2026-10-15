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
<<<<<<< HEAD
		catch{
			system.out.println("Failed to calculate target");
=======
		catch (Exception e){
			System.out.println("Failed to calculate target instead got "+e);
			
>>>>>>> 4e224ee000dbdd0849b61a328d6a238661e473ea
		}
	}
	
	
	
	public void empty2() {
		try {
			board.calcTargets(board.getCell(2,4), 2);
			
		}
<<<<<<< HEAD
		catch{
			system.out.println("Failed to calculate target");
=======
		catch(Exception e){
			System.out.println("Failed to calculate target instead got "+e);
>>>>>>> 4e224ee000dbdd0849b61a328d6a238661e473ea
		}
	}
	
	
	
	public void empty3() {
		try {
			board.calcTargets(board.getCell(1,3), 3);
			
		}
<<<<<<< HEAD
		catch{
			system.out.println("Failed to calculate target");
=======
		catch(Exception e){
			System.out.println("Failed to calculate target instead got "+e);
>>>>>>> 4e224ee000dbdd0849b61a328d6a238661e473ea
		}
	}
	
	
	public void empty4() {
		try {
			board.calcTargets(board.getCell(3,1), 4);
			
		}
<<<<<<< HEAD
		catch{
			system.out.println("Failed to calculate target");
=======
		catch(Exception e){
			System.out.println("Failed to calculate target instead got "+e);
>>>>>>> 4e224ee000dbdd0849b61a328d6a238661e473ea
		}
	}
	
	public void empty5() {
		try {
			board.calcTargets(board.getCell(2,1), 5);
			
		}
<<<<<<< HEAD
		catch{
			system.out.println("Failed to calculate target");
=======
		catch(Exception e){
			System.out.println("Failed to calculate target instead got "+e);
>>>>>>> 4e224ee000dbdd0849b61a328d6a238661e473ea
		}
	}
	
	public void empty6() {
		try {
			board.calcTargets(board.getCell(1,1), 6);
			
		}
<<<<<<< HEAD
		catch{
			system.out.println("Failed to calculate target");
=======
		catch(Exception e){
			System.out.println("Failed to calculate target instead got "+e);
>>>>>>> 4e224ee000dbdd0849b61a328d6a238661e473ea
		}
	}
	
	
	public void empty7() {
		try {
			board.calcTargets(board.getCell(2,2), 3);
			
		}
<<<<<<< HEAD
		catch{
			system.out.println("Failed to calculate target");
=======
		catch(Exception e){
			System.out.println("Failed to calculate target instead got "+e);
>>>>>>> 4e224ee000dbdd0849b61a328d6a238661e473ea
		}
	}
	
	
	
	
	public void occupied1() {
		try {
			
			
<<<<<<< HEAD
			board.getCell(1,3).setOccupied();
=======
			board.getCell(1,3).setOccupied(true);
>>>>>>> 4e224ee000dbdd0849b61a328d6a238661e473ea
			//setOccupied
			
			
			board.calcTargets(board.getCell(1,1), 2);
		
			
			
<<<<<<< HEAD
			Target=board.getTargets();
=======
			Set<TestBoardCell> Target= new board.getTargets();
>>>>>>> 4e224ee000dbdd0849b61a328d6a238661e473ea
			
			
			for(int i=0; i<Target.size(); i++) {
				if(Target[i].getOccupied==true) {
				//if(Target.contains(OcCell[i])) {
					System.out.println("occupied cell is in target when it should not be");
				}
			}
		}
			
<<<<<<< HEAD
		catch{
			system.out.println("Failed to calculate target");
=======
		catch (Exception e){
			System.out.println("Failed to calculate target instead got "+e);
>>>>>>> 4e224ee000dbdd0849b61a328d6a238661e473ea
		}
	}
	
	
	public void occupied2() {
		try {
			
<<<<<<< HEAD
			board.getCell(2,3).setOccupied();
=======
			board.getCell(2,3).setOccupied(true);
>>>>>>> 4e224ee000dbdd0849b61a328d6a238661e473ea
			
			
			board.calcTargets(board.getCell(2,2), 1);
			
<<<<<<< HEAD
			Target=board.getTargets();
=======
			Set<TestBoardCell> Target= new board.getTargets();
>>>>>>> 4e224ee000dbdd0849b61a328d6a238661e473ea
			
			
			for(int i=0; i<Target.size(); i++) {
				if(Target[i].getOccupied==true) {
				//if(Target.contains(OcCell[i])) {
					System.out.println("occupied cell is in target when it should not be");
				}
			}
		}
			
<<<<<<< HEAD
		catch{
			system.out.println("Failed to calculate target");
=======
		catch (Exception e){
			System.out.println("Failed to calculate target instead got "+e);
>>>>>>> 4e224ee000dbdd0849b61a328d6a238661e473ea
		}
	}
	
	
	
	
	
	
	
	
	
	public void roomTest1() {
		try {
			
			board.getCell(1,3).setRoom(true);
			
			board.calcTargets(board.getCell(1,1), 2);
<<<<<<< HEAD
			Target=board.getTargets();
=======
			Set<TestBoardCell> Target= new board.getTargets();
>>>>>>> 4e224ee000dbdd0849b61a328d6a238661e473ea
			
			
		
		for(int i=0; i<Target.size(); i++) {
			if(Target[i].isRoom==true) {
			//if(Target.contains(OcCell[i])) {
				System.out.println("There a room in the target list");

			}
			
		}
		
	}
		
			
		
<<<<<<< HEAD
		catch{
			system.out.println("Failed to calculate target");
=======
		catch (Exception e){
			System.out.println("Failed to calculate target instead got "+e);
>>>>>>> 4e224ee000dbdd0849b61a328d6a238661e473ea
		}
		
	}
	public void roomTest2() {
		try {
			
			board.getCell(2,3).setRoom(true);
			
			board.calcTargets(board.getCell(2,2), 1);
<<<<<<< HEAD
			Target=board.getTargets();
			
=======
			Set<TestBoardCell> Target= new board.getTargets();
			//new HashSet<TestBoardCell>()
>>>>>>> 4e224ee000dbdd0849b61a328d6a238661e473ea
			
		
		for(int i=0; i<Target.size(); i++) {
			if(Target[i].isRoom==true) {
			//if(Target.contains(OcCell[i])) {
				System.out.println("There a room in the target list");

			}
			
		}
		
	}
		
			
			
			
		
<<<<<<< HEAD
		catch{
			system.out.println("Failed to calculate target");
=======
		catch (Exception e){
			System.out.println("Failed to calculate target instead got "+e);
>>>>>>> 4e224ee000dbdd0849b61a328d6a238661e473ea
		}
		
	}
	
	
	
}

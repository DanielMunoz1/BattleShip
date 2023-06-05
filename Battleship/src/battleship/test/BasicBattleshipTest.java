package battleship.test;

import static org.junit.Assert.assertEquals;


import org.junit.Test;

import battleship.BattleshipEngine;
import battleship.BattleshipEngine.Direction;
import battleship.BattleshipEngine.Status;
import battleship.model.Engine;
import gradescope.grader.GradedTest;

public class BasicBattleshipTest
{
	@Test
    @GradedTest(name="Basic Functionality", max_score=15)
	public void testBasic()
	{
		BattleshipEngine engine = new Engine();
		for (char row = 'A'; row < 'A' + 10; row++)
		{
			for (int column = 1; column <= 10; column++)
			{
				assertEquals("Initial value was not empty at " + row + ", " + column,
						     Status.EMPTY, engine.getStatus(row, column));
			}
		}
		
		engine.placeShip("Cruiser", 3, 'A', 1, Direction.RIGHT);
		assertEquals("Ship was not present at " + 'A' + ", " + 1,
			     Status.SHIP, engine.getStatus('A', 1));
		assertEquals("Ship was not present at " + 'A' + ", " + 2,
			     Status.SHIP, engine.getStatus('A', 2));
		assertEquals("Ship was not present at " + 'A' + ", " + 3,
			     Status.SHIP, engine.getStatus('A', 3));

		engine.placeShip("Destroyer", 2, 'H', 10, Direction.DOWN);
		assertEquals("Ship was not present at " + 'H' + ", " + 10,
			     Status.SHIP, engine.getStatus('H', 10));
		assertEquals("Ship was not present at " + 'I' + ", " + 10,
			     Status.SHIP, engine.getStatus('I', 10));

		engine.placeShip("Battleship", 4, 'F', 4, Direction.RIGHT);
		assertEquals("Ship was not present at " + 'F' + ", " + 4,
			     Status.SHIP, engine.getStatus('F', 4));
		assertEquals("Ship was not present at " + 'F' + ", " + 5,
			     Status.SHIP, engine.getStatus('F', 5));
		assertEquals("Ship was not present at " + 'F' + ", " + 7,
			     Status.SHIP, engine.getStatus('F', 6));
		assertEquals("Ship was not present at " + 'F' + ", " + 7,
			     Status.SHIP, engine.getStatus('F', 7));
		
		engine.shoot('C', 4);
		assertEquals("Status was not miss at " + 'C' + ", " + 4,
			     Status.MISS, engine.getStatus('C', 4));
		engine.shoot('C', 7);
		assertEquals("Status was not miss at " + 'C' + ", " + 7,
			     Status.MISS, engine.getStatus('C', 7));
		engine.shoot('E', 3);
		assertEquals("Status was not miss at " + 'E' + ", " + 3,
			     Status.MISS, engine.getStatus('E', 3));
		engine.shoot('E', 8);
		assertEquals("Status was not miss at " + 'E' + ", " + 8,
			     Status.MISS, engine.getStatus('E', 8));
		engine.shoot('F', 4);
		assertEquals("Status was not hit at " + 'F' + ", " + 4,
			     Status.HIT, engine.getStatus('F', 4));
		engine.shoot('F', 5);
		assertEquals("Status was not hit at " + 'F' + ", " + 5,
			     Status.HIT, engine.getStatus('F', 5));
		engine.shoot('F', 6);
		assertEquals("Status was not hit at " + 'F' + ", " + 6,
			     Status.HIT, engine.getStatus('F', 6));
		engine.shoot('F', 7);
		assertEquals("Status was not hit at " + 'F' + ", " + 7,
			     Status.HIT, engine.getStatus('F', 7));
	}

	@Test
    @GradedTest(name="Show the Results", max_score=0)
	public void showMap()
	{
		BattleshipEngine engine = new Engine();
		engine.placeShip("Cruiser", 3, 'A', 1, Direction.RIGHT);

		engine.placeShip("Destroyer", 2, 'H', 10, Direction.DOWN);

		engine.placeShip("Battleship", 4, 'F', 4, Direction.RIGHT);
		
		engine.shoot('C', 4);
		engine.shoot('C', 7);
		engine.shoot('E', 3);
		engine.shoot('E', 8);
		engine.shoot('F', 4);
		engine.shoot('F', 5);
		engine.shoot('F', 6);
		engine.shoot('F', 7);
		printMap(engine);
	}
	

	private static void printMap(BattleshipEngine engine)
	{
		System.out.print(" ");
		for (int column = 1; column <= 10; column++)
		{
			System.out.print(column);
		}
		System.out.println();

		for (char row = 'A'; row < 'A' + 9; row++)
		{
			System.out.print(row);
			for (int column = 1; column <= 10; column++)
			{
				switch (engine.getStatus(row, column)) 
				{
				case EMPTY:
					System.out.print("~");
					break;
				case SHIP:
					System.out.print("S");
					break;
				case HIT:
					System.out.print("X");
					break;
				case MISS:
					System.out.print("O");
					break;
				}
			}
			System.out.println();
		}
		System.out.println();
	}
}
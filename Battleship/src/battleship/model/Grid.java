package battleship.model;

import java.util.TreeMap;

import battleship.BattleshipEngine;
import battleship.BattleshipEngine.Status;

public class Grid {
	
	TreeMap<String, Status> grid = new TreeMap<String,Status>();

	public TreeMap<String, Status> CreateGrid() {
		
	
		for (char row = 'A'; row < 'A' + 10; row++){
			for (int column = 1; column <= 10; column++){
				String position = row + String.valueOf(column);
				grid.put(position,  Status.EMPTY);
			}
		}
		return grid;
	}

}

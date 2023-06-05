package battleship.model;

import java.util.TreeMap;


import battleship.BattleshipEngine;
import battleship.BattleshipEngine.Status;

public class ShootShip {

	public boolean Shooting(char row, int column, TreeMap<String, BattleshipEngine.Status> t) {

		
		String position = row + String.valueOf(column);
		
		if (t.get(position) == null) {
			return false;
		}
		
		else if (t.get(position) == Status.SHIP) {
			t.remove(position);
			t.put(position, Status.HIT);
			return true;
		}
		else if (t.get(position) == Status.EMPTY) {
			t.remove(position);
			t.put(position, Status.MISS);
			
			return false;
		}
		
		return false;
	}
}

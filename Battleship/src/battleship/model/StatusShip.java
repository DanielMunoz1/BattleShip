package battleship.model;

import java.util.TreeMap;

import battleship.BattleshipEngine;
import battleship.BattleshipEngine.Status;

public class StatusShip {
	
	public Status ShipStatus(char row, int column, TreeMap<String, BattleshipEngine.Status> t) {

		
		String position = row + String.valueOf(column);
		if (t.get(position) == null) {
			return Status.EMPTY;
		}
		else {
			return t.get(position);
		}
	}
}


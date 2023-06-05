package battleship.model;

import java.util.ArrayList;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

import battleship.BattleshipEngine;
import battleship.BattleshipEngine.Direction;
import battleship.BattleshipEngine.Status;

public class getShip {
	
	public int getNumberOfActiveShips(ArrayList<List<String>> lst, TreeMap<String, Status> oceanGrid) {
		int count = 0;
		for ( int x = 0; x < lst.size(); x++) {
			List<String> l = lst.get(x);
			for(int y = 0; y < l.size(); y++) {
				if (oceanGrid.get(l.get(y)) == Status.SHIP) {
					count++;
					break;
				}
			}
		}
		return count;
	}
	
	public int getNumberOfSunkShips(ArrayList<List<String>> lst, TreeMap<String, Status> oceanGrid) {
		int count = 0;

		for ( int x = 0; x < lst.size(); x++) {
			List<String> l = lst.get(x);
			int sunkPos = 0;
			for(int y = 0; y < l.size(); y++) {
				if (oceanGrid.get(l.get(y)) == Status.HIT) {
					sunkPos++;
				}
			}
			if(sunkPos == l.size()) {
				count++;
			}
		}
		return count;
	}
	
	public int getNumberOfHits(TreeMap<String, Status> oceanGrid) {
		
		int count = 0;
		
		for(Map.Entry<String, Status> entry : oceanGrid.entrySet()) {
			if(entry.getValue() == Status.HIT) {
				count++;
			}
		}
		return count;
	}
	
	public int totalShip(TreeMap<String, Status> oceanGrid) {
		int count = 0;
		
		for(Map.Entry<String, Status> entry : oceanGrid.entrySet()) {
			if (entry.getValue() == Status.SHIP) {
				count++;
			}
		}
		return count;
	}
	
	public int getUnknownSpaces(TreeMap<String, Status> oceanGrid) {
		
		int count = 0;
		
		for(Map.Entry<String, Status> entry : oceanGrid.entrySet()) {
			if((entry.getValue() == Status.EMPTY) ) {
				count++;
			}
			else if (entry.getValue() == Status.SHIP) {
				count++;
			}
		}
		return count;
	}
	
	public int getNumberOfMisses(TreeMap<String, Status> oceanGrid) {
		int count = 0;
		
		for (char row = 'A'; row < 'A' + 10; row++){
			for (int column = 1; column <= 10; column++){
				String position = row + String.valueOf(column);
				if(oceanGrid.get(position) == Status.MISS) {
					count++;
				}
			}
			//System.out.println(entry.getKey() + " " + entry.getValue());
		}
		return count;
	}
	public boolean gameOver(TreeMap<String, Status> oceanGrid) {
		
		for (char row = 'A'; row < 'A' + 10; row++){
			for (int column = 1; column <= 10; column++){
				String position = row + String.valueOf(column);
				if(oceanGrid.get(position) == Status.SHIP) {
					return false;
				}
			}
			//System.out.println(entry.getKey() + " " + entry.getValue());
		}
		return true;
	}
	
	

	
}

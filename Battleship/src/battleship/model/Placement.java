package battleship.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import battleship.BattleshipEngine;
import battleship.BattleshipEngine.Direction;
import battleship.BattleshipEngine.Status;

public class Placement {

	int total = 0;
	
	ArrayList<List<String>> activeShips = new ArrayList<List<String>>();
	
	public void addPlacement(String name, int size, char row, int column, Direction direction, TreeMap<String, BattleshipEngine.Status> t) {
		
		String checkPosition = row + String.valueOf(column);
		List<String> list = new ArrayList<String>();
	
		
		if(t.get(checkPosition) == null) {
			return;
		}
		else if (t.get(checkPosition) == Status.SHIP) {
			return;
		}
		else {
			if (direction == Direction.RIGHT) {
				int num2 = (column + size) -1;
				if (num2 >  Math.sqrt(t.size())) {
					return;
				}
				int num = column;
				
				for(int i = 0; i < size; i++) {
					String position = row + String.valueOf(num);
					if (t.get(position) == Status.SHIP) {
						return;
					}
				}
				for(int i = 0; i < size; i++) {
					String position = row + String.valueOf(num);
					if (t.get(position) == Status.SHIP) {
						return;
					}
					list.add(position);
					t.put(position, Status.SHIP);
					num++;
				}
			}
			else if (direction == Direction.DOWN) {
				int num2 = t.lastKey().charAt(0);
				if( ((row + size) > num2)){
					return;
				}
				int num = row;
				for(int i = 0; i < size; i++) {
					String position = row + String.valueOf(num);
					if (t.get(position) == Status.SHIP) {
						return;
					}
				}
				for (int k = 0; k < size; k++) {
					String position = (char)num + String.valueOf(column);
					if (t.get(position) == Status.SHIP) {
						return;
					}
					list.add(position);
					t.put(position, Status.SHIP);
					num++;
				}
				
			}
		}
		activeShips.add(list);
		total ++;

	}
	public int totalShip() {
		return total;
	}
	public ArrayList<List<String>> getActiveShip(){
		return activeShips;
	}
	
	

}

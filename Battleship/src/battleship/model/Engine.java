package battleship.model;

import java.util.Map;

import java.util.TreeMap;


import battleship.BattleshipEngine;
import battleship.BattleshipEngine.Direction;
import battleship.BattleshipEngine.Status;
import battleship.BattleshipStatus;


public class Engine implements BattleshipEngine, BattleshipStatus
{
	public Engine(){
	}

	Grid grid = new Grid();
	Placement place = new Placement();
	ShootShip shoot = new ShootShip();
	StatusShip stats = new StatusShip();
	getShip ships = new getShip();
	
	TreeMap<String, Status> OceanGrid = grid.CreateGrid();
	
	
	@Override
	public void placeShip(String name, int size, char row, int column, Direction direction){
		place.addPlacement(name, size, row, column, direction, OceanGrid);
	}
	
	@Override
	public boolean shoot(char row, int column){
		
		return shoot.Shooting(row, column, OceanGrid);
		
	}
	@Override
	public Status getStatus(char row, int column){
		return stats.ShipStatus(row, column, OceanGrid);
		
	}
	@Override
	public int getNumberOfShips() {
		// TODO Auto-generated method stub
		return place.totalShip();
	}

	@Override
	public int getNumberOfActiveShips() {
		// TODO Auto-generated method stub
		return ships.getNumberOfActiveShips(place.activeShips, OceanGrid);
	}

	@Override
	public int getNumberOfSunkShips() {
		// TODO Auto-generated method stub
		return ships.getNumberOfSunkShips(place.activeShips, OceanGrid);
	}

	@Override
	public int getNumberOfHits() {
		// TODO Auto-generated method stub
		return ships.getNumberOfHits(OceanGrid);
	}

	@Override
	public int getNumberOfMisses() {
		
		// TODO Auto-generated method stub
		return ships.getNumberOfMisses(OceanGrid);
	}

	@Override
	public int getUnknownSpaces() {
		
		// TODO Auto-generated method stub
		return ships.getUnknownSpaces(OceanGrid);
	}

	@Override
	public boolean gameOver() {
		// TODO Auto-generated method stub
		return ships.gameOver(OceanGrid);
	}
}
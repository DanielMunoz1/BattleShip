package battleship;

public interface BattleshipEngine
{
	public enum Direction { DOWN, RIGHT }
	public enum Status {EMPTY, SHIP, HIT, MISS}
	
	public void placeShip(String name, int size, char row, int column, Direction direction);
	
	public boolean shoot(char row, int column);
	
	public Status getStatus(char row, int column);
	
	
}

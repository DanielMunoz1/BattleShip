package battleship;

public interface BattleshipStatus
{
	/**
	 * @return the number of ships placed thus far
	 */
	public int getNumberOfShips();
	
	/**
	 * @return the number of ships still active
	 */
	public int getNumberOfActiveShips();
	
	/**
	 * @return the number of sunk ship
	 */
	public int getNumberOfSunkShips();
	
	/**
	 * @return the number of hits thus far
	 */
	public int getNumberOfHits();
	
	/**
	 * @return the number of misses thus far
	 */
	public int getNumberOfMisses();

	/**
	 * @return the number of spaces so far unknown to the shooter
	 */
	public int getUnknownSpaces();
	
	/**
	 * @return if the player's game is over
	 */
	public boolean gameOver();
}

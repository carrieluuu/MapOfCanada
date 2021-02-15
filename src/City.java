/**
 * This class represents each city that is loaded in from a text file. Each
 * rectangle has a specified name, x-coordinate, y-coordinate, and a CityMarker
 * object.
 * 
 * @author Carrie Lu (251140757)
 */

public class City {
	/**
	 * Name of city
	 */
	private String name;
	/**
	 * X-coordinate
	 */
	private int x;
	/**
	 * Y-coordinate
	 */
	private int y;
	/**
	 * CityMarker object which places the PNG image of the marker onto the map image
	 * (for GUI purposes)
	 */
	private CityMarker marker;

	/**
	 * Constructor creates a city with the given name, x-coordinate, and
	 * y-coordinate
	 * 
	 * @param name name of the city
	 * @param x    x-coordinate of the city
	 * @param y    y-coordinate of the city
	 */
	public City(String name, int x, int y) {
		this.name = name;
		this.x = x;
		this.y = y;
		this.marker = new CityMarker();

	}

	/**
	 * Accessor method to get the name of the city
	 * 
	 * @return name of the city
	 */
	public String getName() {
		return name;
	}

	/**
	 * Accessor method to get the x-coordinate of the city
	 * 
	 * @return x-coordinate of the city
	 */
	public int getX() {
		return x;
	}

	/**
	 * Accessor method to get the y-coordinate of the city
	 * 
	 * @return y-coordinate of the city
	 */
	public int getY() {
		return y;

	}

	/**
	 * Accessor method to get the CityMarker of the city
	 * 
	 * @return CityMarker of the city
	 */
	public CityMarker getMarker() {
		return marker;

	}

	/**
	 * Mutator method to set the name of the city
	 * 
	 * @param name of the city
	 */
	public void setName(String newName) {
		this.name = newName;

	}

	/**
	 * Mutator method to set the x-coordinate of the city
	 * 
	 * @param x-coordinate of the city
	 */
	public void setX(int newX) {
		this.x = newX;
	}

	/**
	 * Mutator method to set the y-coordinate of the city
	 * 
	 * @param y-coordinate of the city
	 */
	public void setY(int newY) {
		this.y = newY;
	}

	/**
	 * Mutator method to set the CityMarker of the city
	 * 
	 * @param CityMarker of the city
	 */
	public void setMarker(CityMarker newMarker) {
		this.marker = newMarker;
	}

	/**
	 * Method to represent city name as a String for display purposes
	 * 
	 * @return name of the city
	 */
	public String toString() {
		return this.name;
	}

}

/**
 * This class is the entry point of the program, and will read in a file of
 * cities and create objects for each of them, contain the array of those
 * cities, and create a CompressedArray containing the distances between each of
 * the cities read in from the file.
 * 
 * @author Carrie Lu (251140757)
 */
public class Program {
	/**
	 * Count of how many cities have been read from the file
	 */
	private int cityCount;
	/**
	 * Array consisting of cities
	 */
	private City[] cityArray;
	/**
	 * Linear array that has been compressed from the original array
	 */
	private CompressedArray array;

	/**
	 * Constructor creates an array of cities and builds the map
	 * 
	 * @param fileName name of file being read
	 * @param showMap  boolean indicating whether or not the map GUI should be
	 *                 displayed
	 */
	public Program(String fileName, boolean showMap) {
		cityArray = new City[3];

		MyFileReader reader = new MyFileReader(fileName);

		cityCount = 0;

		reader.readString(); // read first line of file

		while (!reader.endOfFile()) {
			String name = reader.readString();
			int x = reader.readInt();
			int y = reader.readInt();

			City city = new City(name, x, y);

			// if the city count is a multiple of 3, call the expandCapacity() method
			if ((cityCount % 3 == 0) && (cityCount != 0)) {
				expandCapacity();
			}
			cityArray[cityCount] = city;

			cityCount++;

		}
		// if showMap is true, add city to Map object which will create a GUI of the
		// cities
		if (showMap) {
			Map map = new Map();
			for (int i = 0; i < cityCount; i++) {
				map.addCity(cityArray[i]);
			}
		}

	}

	/**
	 * Accessor method to get city array which consists of all the cities read from
	 * the file and their corresponding coordinates
	 * 
	 * @return city array
	 */
	public City[] getCityList() {
		return cityArray;
	}

	/**
	 * Method to increase the capacity of cityArray by adding 3 additional slots to
	 * the array
	 * 
	 * @return cityArray with increased capacity
	 */
	public void expandCapacity() {
		City[] expandedArray = new City[cityCount + 3];
		for (int i = 0; i < cityCount; i++) {
			expandedArray[i] = cityArray[i]; // copy elements from cityArray to expandedArray

		}
		cityArray = expandedArray;
	}

	/**
	 * Method to calculate the distance between two given cities using the Euclidean
	 * distance formula
	 * 
	 * @param city1 City containing its name, x-coordinate, and y-coordinate
	 * @param city2 City containing its name, x-coordinate, and y-coordinate
	 * @return distance between two cities
	 */
	public double distBetweenCities(City city1, City city2) {
		// distance formula: sqrt((x1-x2)^2 + (y1-y2))^2)
		int diffX = city1.getX() - city2.getX();
		int diffY = city1.getY() - city2.getY();
		double distance = Math.sqrt(Math.pow(diffX, 2) + Math.pow(diffY, 2));
		return distance;
	}

	/**
	 * Method that loops through every combination of pairs of cities and calls
	 * distBetweenCities() for each pair
	 * 
	 * @return CompressedArray object containing all the distances between cities
	 */
	public void compareDistances() {
		int N = cityCount;
		double[][] distances = new double[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				// Save the distance comparison into the corresponding cell.
				distances[i][j] = distBetweenCities(cityArray[i], cityArray[j]);
			}
		}
		array = new CompressedArray(distances);

	}

	/**
	 * Accessor method to get CompressedArray object
	 * 
	 * @return CompressedArray object
	 */
	public CompressedArray getArray() {
		return array;
	}

}

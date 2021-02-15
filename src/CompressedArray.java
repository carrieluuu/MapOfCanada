/**
 * This class represents the array that has been compressed from a matrix (2D
 * array) into a linear array that excludes elements from the diagonal and any
 * elements above or to the right of the diagonal. Only the elements forming a
 * lower triangle of the matrix are included.
 * 
 * @author Carrie Lu (251140757)
 */
public class CompressedArray {
	/**
	 * Size of original array (matrix)
	 */
	private int origArraySize;
	/**
	 * Linear array that has been compressed from the original array
	 */
	private double[] array;

	/**
	 * Constructor creates a compressed array by copying the elements from the
	 * original array into this linear array so that it contains only the lower-left
	 * triangle elements of the original array
	 * 
	 * @param origArray original 2D array
	 */
	public CompressedArray(double[][] origArray) {
		origArraySize = origArray.length;
		// Initialize array length to be the number of elements in the lower-left
		// triangle of the origArray matrix
		this.array = new double[(origArraySize * origArraySize - origArraySize) / 2];
		int l = 0;
		for (int i = 1; i < origArraySize; i++) {
			for (int j = 0; j < i; j++) {
				if (j < i) {
					array[l] = origArray[i][j];
					l++;
				}
			}
		}

	}

	/**
	 * Accessor method to get the length of the array
	 * 
	 * @return length of the new, compressed array
	 */
	public int getLength() {
		return array.length;

	}

	/**
	 * Accessor method to get the element in the new, compressed array at the given
	 * index
	 * 
	 * @param index index of element
	 * @return element at the specified index
	 */
	public double getElement(int index) {
		return array[index];
	}

	/**
	 * Method that checks equality between the two CompressedArray objects
	 * 
	 * @param arr compressed array to be compared
	 * @return true or false based on if the arrays are equal
	 */
	public boolean equals(CompressedArray arr) {
		boolean equal = false;
		// check if the two CompressedArray objects have the same length
		if (array.length == arr.getLength()) {
			for (int i = 0; i < arr.getLength(); i++) {
				// check if all the elements are identical in the same order
				if (array[i] == arr.getElement(i)) {
					equal = true;
				} else {
					equal = false;
					break;
				}
			}
		} else {
			equal = false;
		}
		return equal;

	}

	/**
	 * Method that builds a string that contains the CompressedArray and formats it
	 * in a triangular structure to look like the lower left corner of a matrix.
	 * 
	 * @return formatted string built by StringBuilder
	 */
	public String toString() {
		StringBuilder sb = new StringBuilder();
		int j = 0;
		int k = 0; // index of new line \n
		for (int i = 0; i < array.length; i++) {
			if (i == j) {
				sb.append("\n");
				k++; // increase k by 1 each time a new line is printed
				j += k;
			}
			// each appended element should take up exactly 8 characters and show 2 decimal
			// places
			sb.append(String.format("%8.2f", getElement(i)));

		}
		sb.append("\n");
		return sb.toString();

	}

}

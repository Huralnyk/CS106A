/*
 * File: ExpandableArray.java
 * --------------------------
 * This class provides methods for working with an array that expands
 * to include any positive index value supplied by the caller.
 */

import acm.util.*;

public class ExpandableArray {
	
	/**
	 * Creates a new expandable array with no elements.
	 */
	public ExpandableArray() {
		internalArray = new Object[0];
	}
	
	/**
	 * Sets the element at the given index position to the specified.
	 * value. If the internal array is not large enough to contain that
	 * element, the implementation expands the array to make room.
	 */
	public void set(int index, Object value) {
		if (index < 0) {
			throw new ErrorException("Illegal index");
		} else if (index < internalArray.length) {
			internalArray[index] = value;
		} else {
			Object[] copy = internalArray;
			internalArray = new Object[index + 1];
			internalArray[index] = value;
			for (int i = 0; i < copy.length; i++) {
				internalArray[i] = copy[i];
			}
		}
	}
	
	/**
	 * Returns the element at the specified index position, or null if
	 * no such element exists. Note that this method never throws an
	 * out-of-bounds exception; if the index is outside the bounds of
	 * the array, the return value is simply null.
	 */
	public Object get(int index) {
		if (index > 0 && index < internalArray.length) {
			return internalArray[index];
		}
		return null;
	}
	
	/**
	 * Returns string representation of the class.
	 */
	public String toString() {
		String result = "[";
		for (int i = 0; i < internalArray.length; i++) {
			if (i > 0) result += ", ";
			result += internalArray[i]; 
		}
		result += "]";
		return result;
	}
	
	/* Private instance variable */
	private Object[] internalArray;

}

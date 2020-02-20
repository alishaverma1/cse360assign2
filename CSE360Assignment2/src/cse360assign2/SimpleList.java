package cse360assign2;

/**
 * Author: Alisha Verma
 * Class ID: 316
 * Assignment: 1
 * Description: This file contains the definitions of the methods and variables
 *            for a class to create and adjust a simple list. The class includes
 *            two private variables to define an int array and an int variable count 
 *            to keep track of the number of elements in the array which have been filled.
 *            This class also includes public methods for adding an element to the array, removing 
 *            an element from the array, returning the number of elements in the array, printing the array
 *            to a string, and searching the array for a specific element.
 */

import java.util.Arrays;

/**
 * The class includes two private variables to define an int array and an int variable count 
 * to keep track of the number of elements in the array which have been filled.
 * <p>
 * This class also includes public methods for adding an element to the array, removing 
 * an element from the array, returning the number of elements in the array, printing the array
 * to a string, and searching the array for a specific element.
 * 
 * @author Alisha Verma
 */
public class SimpleList {
	
	/**
	 * An integer array meant to hold ten integers.
	 */
	private int[] list;
	
	/**
	 * A count variable to keep track of the number of integers which are currently in the list.
	 */
	private int count;
	
	/**
	 * Class constructor which initializes the array list to a size of 10 and initializes the count to 0.
	 */
	public SimpleList() {
		
		list = new int[10];
		count = 0;
	}
	
	/**
	 * Adds parameter to the beginning of the list. If list length is already 10, 
	 * then removes the elements at the end of the list which exceed the length of ten.
	 * 
	 * @param numToAdd integer to be added to the beginning of list
	 */
	public void add ( int numToAdd ) {
		
		//creates a newList with 11 elements to store an additional element if needed
		int[] newList = new int[ list.length + 1 ]; 
		
		newList[0] = numToAdd;
			
		//moves other elements up by one
		for ( int listIndex = 0; listIndex < count; listIndex++ ) {
			
			newList[listIndex + 1] = list[listIndex];
		}
		
		//if there are less than 10 elements in list, increment the count
		if ( count < 10 ) {
			
			count++;
		}
		
		//copies first ten elements of the newList into list
		list = Arrays.copyOf(newList, list.length);
	}
	
	/**
	 * Removes the parameter from the list if it is found in the list. Moves the other integers 
	 * in the list down if needed and adjusts the count as needed.
	 * 
	 * @param numToRemove integer to be removed from the list
	 */
	public void remove( int numToRemove ) {
		
		//if there are elements in the list 
		if ( count != 0 ) {
			
			boolean elementFound = false;
			int index = -1;
			
			for ( int listIndex = 0; listIndex < count; listIndex++ ) {
				
				if ( elementFound ) { 
					
					//do nothing if the element to remove has already been found
				} else {
					
					if ( list[listIndex] == numToRemove ) {
						
						elementFound = true;
						index = listIndex;
					}
				}
			}
			
			//if the numToRemove was in the list, remove it from the list
			if ( elementFound ) {
				
				for ( int listIndex = index+1; listIndex < count; listIndex++ ) {
					
					list[listIndex-1] = list[listIndex];
				}
				
				count--;
			}
		}
	}
	
	/**
	 * Returns the number of elements stored in the list.
	 * 
	 * @return the count of the number of elements stored in the list
	 */
	public int count() {
		
		return count;
	}
	
	/**
	 * Puts all elements in list into a String and separates the elements by a space.
	 * 
	 * @return the list as a String
	 */
	public String toString() {
		
		StringBuilder stringFromList = new StringBuilder();
		
		//parses through list and adds each element to StringBuilder object
		for ( int listIndex = 0; listIndex < count; listIndex++ ) {
			
			if ( listIndex > 0 ) {
				
				stringFromList.append(" ");
			}
			
			stringFromList.append(list[listIndex]);
		}
		
	    return stringFromList.toString();
	}
	
	/**
	 * Searches for the parameter in list
	 * If the parameter is found returns the index of the parameter in the list
	 * If the parameter is not in list, returns -1
	 * 
	 * @param numToFind integer to find the index of in the list
	 * @return the location of the parameter in the list
	 */
	public int search( int numToFind ) {
		
		int indexOfParam = -1;
		
		//parses through the list to find the element equal to numToFind
		for ( int listIndex = 0; listIndex < list.length; listIndex++ ) {
			
			if ( numToFind == list[listIndex] ) {
				
				indexOfParam = listIndex;
			}
			
		}
		
		return indexOfParam;
	}
}
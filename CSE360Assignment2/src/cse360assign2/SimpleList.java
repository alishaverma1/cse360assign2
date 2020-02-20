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
	 * Adds parameter to the beginning of the list. If list is already full, 
	 * then increases the size of the list by 50%.
	 * 
	 * @param numToAdd integer to be added to the beginning of list
	 */
	public void add ( int numToAdd ) {
		
		int biggerListSize = list.length + list.length/2;
		
		//creates newList to perform addition on with size increased by fifty percent
		int[] newList = new int[biggerListSize];
		
		newList[0] = numToAdd;
		
		for ( int listIndex = 0; listIndex < count; listIndex++ ) {
			
			newList[listIndex + 1] = list[listIndex];
		}
		
		if ( count >= list.length ) {
			
			//if list is full, then copy entire newList
			list = Arrays.copyOf(newList, biggerListSize);
			
		} else {
			
			//else only copy the integers from newList which already fit into list
			list = Arrays.copyOf(newList, list.length);
			
		}
		
		count++;
	}
	
	/**
	 * Removes the parameter from the list if it is found in the list. Moves the other integers 
	 * in the list down if needed and adjusts the count as needed as welll as the size of the list
	 * if more than 25% of the list is empty.
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
			
			//if the numToRemove was in the list, then remove it from the list
			if ( elementFound ) {
				
				for ( int listIndex = index+1; listIndex < count; listIndex++ ) {
					
					list[listIndex-1] = list[listIndex];
				}
				
				count--;
				
				int numOfEmptyPlaces = 0;
				
				for ( int listIndex = 0; listIndex < list.length; listIndex++ ) {
					
					if ( list[listIndex] == 0 ) {
						
						numOfEmptyPlaces++;
					}
				}
				
				//if the number of empty places is greater than 25 percent of the list, decrease list size
				if ( numOfEmptyPlaces >= list.length/4 ) {
					
					list = Arrays.copyOf(list, list.length-1);
				}
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
	
	/**
	 * Appends the parameter to the end of the list.
	 * If the list is already full, increase the size of the list by 50 percent.
	 * 
	 * @param numToAppend integer to add to end of the list
	 */
	public void append ( int numToAppend ) {
		
		int biggerListSize = list.length + list.length/2;
		
		if ( count >= list.length ) {
			
			//if the list is full, increases the size of the list by fifty percent
			list = Arrays.copyOf(list, biggerListSize);  
		}
		
		list[count] = numToAppend;
		
		count++;
	}
	
	/**
	 * Returns the first element in the list.
	 * 
	 * @return
	 */
	public int first() {
		
		return list[0];
	}
	
	/**
	 * Returns the current number of possible locations in a list.
	 * 
	 * @return the size of the list
	 */
	public int size() {
		
		return list.length;
	}
}
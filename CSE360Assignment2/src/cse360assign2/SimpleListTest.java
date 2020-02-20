package cse360assign2;
/**
 * Author: Alisha Verma
 * Class ID: 316
 * Assignment Number: 1
 * Description of Contents: This file contains six test cases to test the creation of a SimpleList object
 *                          and the implementation of all the methods defined in the SimpleList class.
 */

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * Class Description: SimpleListTest contains six test cases to test the SimpleList class. testConstructor() tests the
 * 					  creation of a SimpleList object, testAdd() tests the addition of integers into the SimpleList list,
 * 					  testRemove() tests the removal of an integer from the SimpleList list, testCount() tests the count 
 * 					  of elements in the SimpleList list, testToString() tests the creation of a string from the 
 * 				      SimpleList list, and testSearch() tests the searching of an element in the SimpleList list.
 * 					  
 * @author Alisha Verma
 */
class SimpleListTest {
	
	//creates new SimpleList object
	SimpleList obj = new SimpleList();
	
	@Test
	public void testConstructor() {
		
		//tests the initialization of the count variable
		assertEquals(0, obj.count());
	}
	
	@Test
	public void testAdd1() {
		
		//tests the addition of one integer into the list
		obj.add(1);
		assertEquals(1, obj.count());
	}
	
	@Test
	public void testAdd2() {
		
		//tests the addition of a second integer into the list
		obj.add(1);
		obj.add(2);
		assertEquals(2, obj.count());
	}
	
	@Test
	public void testAdd3() {
		
		//tests the addition of an addition eight objects into the list
		obj.add(1);
		obj.add(2);
		obj.add(3);
		obj.add(4);
		obj.add(5);
		obj.add(6);
		obj.add(7);
		obj.add(8);
		obj.add(9);
		obj.add(10);
		assertEquals(10, obj.count());
	}
	
	@Test
	public void testAdd4() {
		
		//tests the addition of elements after the list is full
		obj.add(1);
		obj.add(2);
		obj.add(3);
		obj.add(4);
		obj.add(5);
		obj.add(6);
		obj.add(7);
		obj.add(8);
		obj.add(9);
		obj.add(10);
		obj.add(11);
		assertEquals(11, obj.count());
	}
	
	@Test
	public void testRemove1() {
		
		//tests the removal of one integer from the list
		obj.add(1);
		obj.add(2);
		obj.add(3);
		obj.remove(3);
		
		assertEquals(2, obj.count());
	}
	
	@Test
	public void testRemove2() {
		
		//tests the removal of an integer when the given integer is not in the list
		obj.add(1);
		obj.remove(3);
		assertEquals(1, obj.count());
	}
	
	@Test
	public void testCount1() {
		
		//tests the count of the SimpleList object after one integer is added to the list
		obj.add(1);
		assertEquals(1, obj.count());
	}
	
	@Test
	public void testCount2() {
		
		//tests the count of the SimpleList object when no integers have been added to the list
		assertEquals(0, obj.count());
	}
	
	@Test
	public void testToString1() {
		
		//tests the toString method for an empty list
		assertEquals(obj.toString(), "");
	}
	
	@Test
	public void testToString2() {
		
		//tests the toString method for list with one integer
		obj.add(1);
		assertEquals(obj.toString(), "1");
	}
	
	@Test
	public void testToString3() {
		
		//tests the toString method for list with two integers
		obj.add(1);
		obj.add(2);
		assertEquals("2 1", obj.toString());
	}
	
	@Test
	public void testToString4() {
		
		//tests the toString method for list with removal of one integer
		obj.add(1);
		obj.add(2);
		obj.remove(1);
		assertEquals(obj.toString(), "2");
	}
	
	@Test
	public void testToString5() {
		
		//tests the toString method of list that is full
		obj.add(1);
		obj.add(2);
		obj.add(3);
		obj.add(4);
		obj.add(5);
		obj.add(6);
		obj.add(7);
		obj.add(8);
		obj.add(9);
		obj.add(10);
		obj.add(11);
		assertEquals(obj.toString(), "11 10 9 8 7 6 5 4 3 2 1");
	}
	
	@Test
	public void testSearch1() {
		
		//tests the search method for list with two integers
		obj.add(1);
		obj.add(2);
		assertEquals(1, obj.search(1));
	}
	
	@Test 
	public void testSearch2() {
		
		//tests the search method for list with five integers
		obj.add(1);
		obj.add(2);
		obj.add(3);
		obj.add(4);
		obj.add(5);
		assertEquals(1, obj.search(4));
	}
	
	@Test
	public void testSearch3() {
		
		//tests the search method when integer is not in list
		obj.add(1);
		assertEquals(-1, obj.search(2));
	}
	
	@Test
	public void testAppend1() {
		
		obj.append(1);
		assertEquals(1, obj.count());
	}
	
	@Test
	public void testAppend2() {
		
		obj.append(1);
		obj.append(2);
		
		assertEquals("1 2", obj.toString());
	}
	
	@Test
	public void testAppend3() {
		
		obj.append(1);
		obj.append(2);
		obj.append(3);
		obj.append(4);
		obj.append(5);
		obj.append(6);
		obj.append(7);
		obj.append(8);
		obj.append(9);
		obj.append(10);
		obj.append(11);
		assertEquals("1 2 3 4 5 6 7 8 9 10 11", obj.toString());
	}
	
	@Test
	public void testFirst() {
		
		obj.add(1);
		assertEquals(1, obj.first());
	}
	
	@Test
	public void testSize1() {
		
		obj.add(1);
		assertEquals(10, obj.size());
	}
	
	@Test
	public void testSize2() {
		
		obj.add(1);
		obj.add(2);
		obj.add(3);
		obj.add(4);
		obj.add(5);
		obj.add(6);
		obj.add(7);
		obj.add(8);
		obj.add(9);
		obj.add(10);
		obj.add(11);
		assertEquals(15, obj.size());
	}
	
	@Test
	public void testSize3() {
		
		obj.add(1);
		obj.add(2);
		obj.remove(1);
		assertEquals(9, obj.size());
	}
	
	@Test
	public void testSize4() {
		
		obj.append(1);
		obj.append(2);
		obj.append(3);
		obj.append(4);
		obj.append(5);
		obj.append(6);
		obj.append(7);
		obj.append(8);
		obj.append(9);
		obj.append(10);
		obj.append(11);
		assertEquals(15, obj.size());
	}
}

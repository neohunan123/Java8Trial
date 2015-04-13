package com.neo.algorithm.sort.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.neo.algorithm.sort.SortAlgorithmUtils;

public class SortUtilsTest {

	@Test
	public void test() {
		int[] testArray = {34,2,56,9,32,65,40,11,5};
		int[] resultArray = {2,5,9,11,32,34,40,56,65};
		assertArrayEquals(resultArray, SortAlgorithmUtils.insertSortIntegerArray(testArray));
	}
	
	@Test
	public void testMergeSort() {
		int[] testArray = {34,2,56,9,32,65,40,11,5};
		int[] resultArray = {2,5,9,11,32,34,40,56,65};
		assertArrayEquals(resultArray, SortAlgorithmUtils.sort(testArray, 0, testArray.length - 1));
	}

}

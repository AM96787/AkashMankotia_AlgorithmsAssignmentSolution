package com.greatlearning.stockers.search;

public class StockSearch {
	int mid;
	double key, result;

	public int searchFunction(double array[], int first, int last, double searchElement) {
		if (last >= first) {
			int mid = first + (last - first) / 2;

			// If the element is present at the middle
			if (array[mid] == searchElement)
				return mid;

			// If element is smaller than mid, then
			// search in left subarray
			if (array[mid] > searchElement)
				return searchFunction(array, first, mid - 1, searchElement);
			else
				// Else search the element in the right subarray
				return searchFunction(array, mid + 1, last, searchElement);
		}
		// if element is not present in the array
		return -1;
	}
}

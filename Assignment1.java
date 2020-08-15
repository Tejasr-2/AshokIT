package com.tej;

import java.util.Arrays;

public class Assignment1 {

	public static void main(String[] args) {

		// Array for general Operations
		int[] arr = { 3, 6, 8, -8, 10, 8 };
		int[] retArr = null;
		
		// 3 Arrays for finding Common
		int[] arr1 = { 1, 5, 10, 20, 40, 80 };
		int[] arr2 = { 6, 7, 20, 80, 100 };
		int[] arr3 = { 3, 4, 15, 20, 30, 70, 80, 120 };

		System.out.println("Original Array : ");
		printArray(arr);
		System.out.println();

		/// Q1 find duplicate elements ///
		retArr = findDuplicates(arr);
		System.out.print("Duplicate Elements : ");
		printArray(retArr);
		System.out.println();

		/// Q2 remove duplicate elements ///
		retArr = uniqueElements(arr);
		System.out.print("After Removing Duplicates : ");
		printArray(retArr);
		System.out.println();

		/// Q3 sum of unique elements ///
		sum(arr);
		System.out.println();

		/// Q4 third largest number ///
		nthLargest(arr, 3);
		System.out.println();

		/// Q5 find maximum difference ///
		maxDifference(arr);
		System.out.println();

		/// Q6 Min and Max elements ///
		minMax(arr);
		System.out.println();

		/// Q7 second Min and Second Max elements ///
		secondMinMax(arr);
		System.out.println();

		/// Q8 find common elements ///
		findCommon(arr1, arr2, arr3);
		System.out.println();

		/// Q9 element Pairs sum ///
		int sum = 16;
		pairSum(arr, sum);
		System.out.println();

		/// Q10 Smallest Pairs sum ///
		smallestPairSum(arr);

	}

	private static void smallestPairSum(int[] arr) {
		int min = Integer.MAX_VALUE;
		System.out.print("The pair ");
		int temp1 = 0, temp2 = 0;
		for (int i = 0; i < arr.length; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				if ((arr[j] + arr[i]) < min) {
					min = arr[i] + arr[j];
					temp1 = arr[i];
					temp2 = arr[j];
				}
			}
		}
		System.out.print("(" + temp1 + "," + temp2 + ") have the minimum sum.");

	}

	private static void pairSum(int[] arr, int sum) {
		System.out.print("Pairs with sum " + sum + " are ");
		for (int i = 0; i < arr.length; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				if ((arr[j] + arr[i]) == sum) {
					System.out.print("(" + arr[i] + "," + arr[j] + ")");
				}
			}
		}

	}

	private static void findCommon(int[] arr1, int[] arr2, int[] arr3) {
		arr1 = commonElements(arr1, arr2);
		arr1 = commonElements(arr1, arr3);
		System.out.print("Common Elements : ");
		printArray(arr1);

	}

	private static int[] commonElements(int[] arr1, int[] arr2) {
		int minLength = (arr1.length < arr2.length) ? arr1.length : arr2.length;
		int[] temp = new int[minLength];
		int count = 0;
		arr1 = uniqueElements(arr1);
		arr2 = uniqueElements(arr2);
		for (int i = 0; i < arr1.length; i++)
			for (int j = 0; j < arr2.length; j++) {
				if (arr1[i] == arr2[j]) {
					temp[count] = arr1[i];
					count++;
					break;
				}
			}

		int[] temp2 = new int[count];
		for (int i = 0; i < count; i++)
			temp2[i] = temp[i];
		return temp2;
	}

	private static void minMax(int[] arr) {
		nthMinimum(arr, 1);
		nthLargest(arr, 1);

	}

	private static void secondMinMax(int[] arr) {
		nthMinimum(arr, 2);
		nthLargest(arr, 2);

	}

	private static void maxDifference(int[] arr) {
		arr = uniqueElements(arr);
		int maxDif = arr[arr.length - 1] - arr[0];
		System.out.print("Max Difference is : " + maxDif);

	}

	private static void nthMinimum(int[] arr, int n) {

		arr = uniqueElements(arr);
		if (arr.length >= n)
			System.out.print(numberToName(n) + "Minimum Number : " + arr[n - 1] + "\t");
		else
			System.out.print("Array Size is Too Short");

	}

	private static void nthLargest(int[] arr, int n) {

		arr = uniqueElements(arr);
		if (arr.length >= n)
			System.out.print(numberToName(n) + "Largest Number : " + arr[arr.length - (n)]);
		else
			System.out.print("Array Size is Too Short");

	}

	private static void sum(int[] arr) {
		int sum = 0;
		for (int i : uniqueElements(arr))
			sum += i;
		System.out.print("Sum of elements : " + sum);
	}

	private static void printArray(int[] retArr) {
		for (int i : retArr)
			System.out.print(i + "  ");
	}

	private static int[] findDuplicates(int[] arr) {
		int[] temp = new int[arr.length];
		int count = 0;
		for (int i = 0; i < arr.length; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[j] == arr[i]) {
					temp[count] = arr[j];
					count++;
					break;
				}
			}
		}

		int[] temp2 = new int[count];
		for (int i = 0; i < count; i++)
			temp2[i] = temp[i];

		return temp2;

	}

	private static int[] uniqueElements(int[] arr) {
		int[] newArray = new int[arr.length];
		boolean flag = false;
		int count = 0;
		for (int i = 0; i < arr.length; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[j] == arr[i]) {
					flag = true;
					break;
				}
				flag = false;
			}
			if (flag == false) {
				newArray[count] = arr[i];
				count++;
			}
		}
		int[] arr1 = new int[count];
		for (int i = 0; i < count; i++) {
			arr1[i] = newArray[i];
		}
		Arrays.sort(arr1);
		return arr1;

	}

	private static String numberToName(int n) {
		if (n == 0) {
			return "";
		} else if (n == 1) {
			return "";
		} else if (n == 2) {
			return "Second ";
		} else if (n == 3) {
			return "Third ";
		} else if (n == 4) {
			return "Fourth ";
		}

		return "(" + n + ") ";

	}

}

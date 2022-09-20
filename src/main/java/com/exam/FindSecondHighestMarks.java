package com.exam;

import java.util.HashMap;
import java.util.Map;

public class FindSecondHighestMarks {

	public static void main(String args[]) {

//List<Integer> marksList = new ArrayList<>();
//
//marksList.add(84);
//marksList.add(80);
//marksList.add(94);
//marksList.add(75);
//marksList.add(80);
//
//// Approach 1 - By sorting
//Collections.sort(marksList);
//int element=marksList.get(marksList.size()-2);
//System.out.println("Second Largest Number: "+element);
//
//// sort in descending-order and get 2nd largest element
//int secondLargestNumber = marksList
//        .stream()
//        .sorted(Comparator.reverseOrder())
//        .skip(1)
//        .findFirst()
//        .get();
//
//System.out.println("Second Largest Number: "+secondLargestNumber);

		Integer[] arr = { 1, 9, 4, 6, 8, 11, 13 };

		int sum = 12;
		Map<Integer, Integer> isPair = findThePair(arr, sum);
		isPair.forEach((k,v) -> System.out.println("Key = "
                + k + ", Value = " + v));

		

	}

	private static Map<Integer, Integer> findThePair(Integer[] arr, int sum) {
		Map<Integer, Integer> map= new HashMap<>();

		for (int i = 0; i <= arr.length - 1; i++) {
			for (int j = arr.length - 1; j >= i; j--) {
				if (arr[i] + arr[j] == sum) {
					map.put(arr[i],arr[j]);
				}
			}
		}
		return map;
	}

}
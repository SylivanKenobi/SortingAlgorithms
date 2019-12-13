package sort;

import java.util.*;

public class test {
	public static void main(String[] args) {
		// Unsorted array
		ArrayList<Integer> a = new ArrayList<>();
		for (int i = 0; i < 16; i++) {
			a.add((int) (Math.random() * 100));
		}
		System.out.println(a + "new");
		// Call merge sort
		sorting(a);

		// Check the output which is sorted array

		System.out.println(a);
	}

	public static ArrayList<Integer> sorting(ArrayList<Integer> a) {
		if (a.size() <= 1) {
			return a;
		}
		ArrayList<Integer> merge1 = new ArrayList<>();
		ArrayList<Integer> merge2 = new ArrayList<>();
		for (int i = 0; i < a.size() / 2; i++) {
			merge1.add(a.get(i));
		}
		for (int i = merge1.size(); i < a.size(); i++) {
			merge2.add(a.get(i));
		}

		sorting(merge1);
		sorting(merge2);

		merge(merge1, merge2, a);
		return a;

	}

	public static void merge(ArrayList<Integer> first, ArrayList<Integer> second, ArrayList<Integer> result) {
		int iFirst = 0;
		int iSecond = 0;
		int iMerged = 0;

		while (iFirst < first.size() && iSecond < second.size()) {
			if (first.get(iFirst).compareTo(second.get(iSecond)) < 0) {
				result.set(iMerged, first.get(iFirst));
				iFirst++;
			} else {
				result.set(iMerged, second.get(iSecond));
				iSecond++;
			}
			iMerged++;
		}

		for (int i = 0; i < first.size() - iFirst; i++) {
			result.set(i + iMerged, first.get(iFirst + i));
		}
		for (int i = 0; i < second.size() - iSecond; i++) {
			result.set(i + iMerged, second.get(iSecond + i));
		}

	}
}
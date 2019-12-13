package sort;

import java.util.*;

public class testSelect {
	public static void main(String[] args) {
		// Unsorted array
		ArrayList<Integer> a = new ArrayList<>();

		for (int i = 0; i < 4; i++) {
			a.add((int) (Math.random() * 100));
		}
		System.out.println(a + "new");
		// Call merge sort
		a=sorting(a);

		// Check the output which is sorted array

		System.out.println(a);
	}

	public static ArrayList<Integer> sorting(ArrayList<Integer> input) {
		int r = input.size();
		ArrayList<Integer> a = new ArrayList<>();
		ArrayList<Integer> toRemove = new ArrayList<>();
		
		while (a.size() < r) {
			int i = 0;
			for (int e = i + 1; e < input.size(); e++) {
				if (input.get(i) > input.get(e)) {
					i = e;
					System.out.println(input.get(i));

				}
			}
			a.add(input.get(i));
			toRemove.add(input.get(i));
			input.removeAll(toRemove);
			if(input.size()==0) {
				return a;
			}
		
		}
		return a;

	}

}
package sort;

import java.util.ArrayList;

import processing.core.PApplet;

public class SelectionSort extends PApplet {
	ArrayList<Float> random = new ArrayList<>();
	boolean start = false;
	
	public static void main(String[] args) {
		PApplet.main("sort.SelectionSort"); // TODO Auto-generated method stub

	}

	public void settings() {
		size(1800, 1000);
		for (int i = 0; i < width; i++) {
			random.add(random(height));
		}
	}

	public void setup() {

	}

	public void draw() {

		frameRate(60);
		background(100);
		stroke(255, 192, 203);
		if (mousePressed) {
			start = true;
		}
		if (start == true) {
			random = sorting(random);
		}

		for (int i = 0; i < random.size(); i++) {
			line(i, height, i, height - random.get(i));
		}
	}

	public static ArrayList<Float> sorting(ArrayList<Float> random3) {
		int r = random3.size();
		ArrayList<Float> a = new ArrayList<>();
		ArrayList<Float> toRemove = new ArrayList<>();
		while (a.size() < r) {
			int i = 0;
			for (int e = i + 1; e < random3.size(); e++) {
				if (random3.get(i) > random3.get(e)) {
					i = e;

				}
			}
			a.add(random3.get(i));
			toRemove.add(random3.get(i));
			random3.removeAll(toRemove);

			if (random3.size() == 0) {
				return a;
			}
		}
		return a;

	}

}

import java.util.ArrayList;

import processing.core.PApplet;

public class BubbleSort extends PApplet {
	ArrayList<Float> random = new ArrayList<>();
	boolean start = false;

	public static void main(String[] args) {
		PApplet.main("sort.BubbleSort"); // TODO Auto-generated method stub

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
			for (int i = 0; i < 5; i++) {
				sort();
			}
		}
		for (int i = 0; i < random.size(); i++) {
			line(i, height, i, height - random.get(i));
		}
	}

	public void sort() {
		for (int i = 0; i < random.size() - 1; i++) {

			if (random.get(i) > random.get(i + 1)) {
				Float temp = random.get(i);
				random.set(i, random.get(i + 1));
				random.set(i + 1, temp);

			}
		}
	}

}

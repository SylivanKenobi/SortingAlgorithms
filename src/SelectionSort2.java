import java.util.ArrayList;

import processing.core.PApplet;

public class SelectionSort2 extends PApplet {
	ArrayList<Float> random = new ArrayList<>();
	boolean start = false;
	ArrayList<Float> a = new ArrayList<>();
	ArrayList<Float> toRemove = new ArrayList<>();
	int index = 0;
	int temp;
	int counter = 0;
	Float zSpeicher;
	boolean second = false;

	public static void main(String[] args) {
		PApplet.main("sort.SelectionSort2"); // TODO Auto-generated method stub

	}

	public void settings() {
		size(1800, 1000);
		for (int i = 0; i < width / 2; i++) {
			random.add(random(height / 2));
		}
		for (int i = width / 2; i < width; i++) {
			random.add(random(height / 2));
		}
		temp = random.size();
	}

	public void setup() {

	}

	public void draw() {
		frameRate(60);
		background(100);
		stroke(255, 192, 203);
		for (int e = 0; e < random.size(); e++) {
			line(e, height, e, height - random.get(e));
		}
		
		for (int i = 0; i < 10; i++) {
			index = counter;
			for (int e = index + 1; e < random.size() / 2; e++) {
				if (random.get(index) > random.get(e)) {
					index = e;
				}

				
			}
			if (counter == random.size() / 2 - 1) {
				second = true;
				System.out.println(counter);
			}
			if (second == true) {
				for (int e = index + 1; e < random.size(); e++) {
					if (random.get(index) < random.get(e)) {
						index = e;
					}
				}
			}
			if (counter < temp) {
				zSpeicher = random.get(counter);
				random.set(counter, random.get(index));
				random.set(index, zSpeicher);
				counter++;

			} else {
				fill(0);
				textSize(48);
				text("Fertig", 900, 500);
			}

		}

	}

}

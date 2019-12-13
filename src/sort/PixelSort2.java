package sort;

import java.util.ArrayList;

import processing.core.PApplet;
import processing.core.PImage;

public class PixelSort2 extends PApplet {
	ArrayList<Float> random = new ArrayList<>();
	boolean start = false;
	ArrayList<Float> a = new ArrayList<>();
	ArrayList<Float> toRemove = new ArrayList<>();
	int index = 0;
	int temp;
	int counter = 0;
	int zSpeicher;
	PImage img;
	PImage sorted;

	public static void main(String[] args) {
		PApplet.main("sort.PixelSort2"); // TODO Auto-generated method stub

	}

	public void settings() {
		size(1600, 530);
		img = loadImage("img.png");
		sorted = createImage(img.width, img.height, RGB);
		sorted = img.get();
	}

	public void setup() {

	}

	public void draw() {

		frameRate(60);
		image(img, 0, 0);
		image(sorted, img.width, 0);
		sort();
		sorted.updatePixels();
		
		
	}

	public void sort() {
		for (int i = 0; i < sorted.pixels.length; i++) {
			for (int e = i + 1; e < sorted.pixels.length; e++) {
				Float pix = brightness(sorted.pixels[i]);
				Float pix2 = brightness(sorted.pixels[e]);

				if (pix < pix2) {
					index = e;
				}

			}

			zSpeicher = sorted.pixels[i];
			sorted.pixels[i] = sorted.pixels[counter];
			sorted.pixels[counter] = zSpeicher;
		}
	}

}

import processing.core.PApplet;
import processing.core.PImage;

import java.awt.*;
import java.util.ArrayList;

public class PixelBubbleSort extends PApplet {
    PImage img;
    PImage sorted;

    public static void main(String[] args) {
        PApplet.main("PixelBubbleSort");
    }

    public void settings() {
        img = loadImage("images/img3.png");
        size(img.width, img.height);
        sorted = createImage(img.width, img.height, RGB);
        img.loadPixels();
        sorted = img.get();
        sorted.loadPixels();
    }

    public void setup() {
    }

    public void draw() {
        frameRate(60);
        image(sorted, 0, 0);
        for (int j = 0; j < 30; j++) {
            for (int i = 0; i < img.pixels.length - 1; i++) {
                if (sorted.pixels[i] > sorted.pixels[i + 1]) {
                    int tmp = sorted.pixels[i];
                    sorted.pixels[i] = sorted.pixels[i + 1];
                    sorted.pixels[i + 1] = tmp;
                }
            }
            sorted.updatePixels();
        }

    }
}
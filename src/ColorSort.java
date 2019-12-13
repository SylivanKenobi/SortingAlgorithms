import processing.core.PApplet;
import processing.core.PImage;

import java.awt.*;
import java.util.ArrayList;

public class ColorSort extends PApplet {
    PImage img;
    PImage sorted;
    ArrayList<Integer> blue = new ArrayList<>();
    ArrayList<Integer> green = new ArrayList<>();
    ArrayList<Integer> red = new ArrayList<>();
    ArrayList<Integer> grey = new ArrayList<>();
    boolean done = false;

    public static void main(String[] args) {
        PApplet.main("ColorSort");
    }

    public void settings() {
        img = loadImage("images/wave2.jpg");
        int newWidth = img.width;
        int newHeight = img.height;
        int boundary = 800;
        if (img.height > boundary || img.width > boundary) {
            if (img.width > boundary) {
                newWidth = boundary;
                newHeight = (newWidth * img.height) / img.width;
            }
            if (newHeight > boundary) {
                newHeight = boundary;
                newWidth = (newHeight * img.width) / img.height;
            }
        }
        img.resize(newWidth, newHeight);
        size(img.width, img.height);
        sorted = createImage(img.width, img.height, RGB);
        img.loadPixels();
        sorted = img.get();
        sorted.loadPixels();
        coloGrade();
    }

    private void coloGrade() {
        for (int i = 0; i < img.pixels.length; i++) {
            Color color1 = new Color(sorted.pixels[i]);
            if (color1.getRed() > color1.getBlue() && color1.getRed() > color1.getGreen()) {
                red.add(sorted.pixels[i]);
            } else if (color1.getGreen() > color1.getBlue() && color1.getGreen() > color1.getRed()) {
                green.add(sorted.pixels[i]);

            } else if (color1.getBlue() > color1.getRed() && color1.getBlue() > color1.getGreen()) {
                blue.add(sorted.pixels[i]);
            } else {
                grey.add(sorted.pixels[i]);
            }
        }
    }

    public void setup() {
    }

    public void draw() {
        frameRate(60);
        image(sorted, 0, 0);
        if (!done) {
            sorting(red);
            sorting(green);
            sorting(blue);
            sorting(grey);
            int index = 0;
            for (int i = 0; i < red.size(); i++) {
                sorted.pixels[index] = red.get(i);
                index++;
            }
            for (int i = 0; i < green.size(); i++) {
                sorted.pixels[index] = green.get(i);
                index++;
            }
            for (int i = 0; i < blue.size(); i++) {
                sorted.pixels[index] = blue.get(i);
                index++;
            }
            for (int i = 0; i < grey.size(); i++) {
                sorted.pixels[index] = grey.get(i);
                index++;
            }
            System.out.println(index);
            done = true;
        }

        sorted.updatePixels();

    }

    public static ArrayList<Integer> sorting(ArrayList<Integer> a) {
        ArrayList<Integer> merge1 = new ArrayList<>();
        ArrayList<Integer> merge2 = new ArrayList<>();

        if (a.size() <= 1) {
            return a;
        }
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
            Color color1 = new Color(first.get(iFirst));
            Color color2 = new Color(second.get(iSecond));
            if (color1.getBlue() + color1.getRed() + color1.getGreen() < color2.getBlue() + color2.getRed() + color2.getGreen()) {
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
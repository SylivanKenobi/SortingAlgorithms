import processing.core.PApplet;
import processing.core.PImage;

import java.util.ArrayList;

public class PixelMergeSort extends PApplet {
    PImage img;
    PImage sorted;
    ArrayList<Integer> pixels = new ArrayList<>();
    boolean done = false;

    public static void main(String[] args) {
        PApplet.main("PixelMergeSort");
    }

    public void settings() {
        img = loadImage("images/abstract.jpg");
        int newWidth = img.width;
        int newHeight = img.height;
        int boundary = 600;
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
        size(img.width * 2, img.height);
        sorted = createImage(img.width, img.height, RGB);
        img.loadPixels();
        sorted = img.get();
        sorted.loadPixels();
        img.loadPixels();
        for (int i = 0; i < img.pixels.length; i++) {
            pixels.add(img.pixels[i]);
        }
    }

    public void setup() {
    }

    public void draw() {
        frameRate(60);
        image(img, 0, 0);
        image(sorted, img.width, 0);
        if (!done) {
            sorting(pixels);
            done = true;
        }
        for (int i = 0; i < pixels.size(); i++) {
            sorted.pixels[i] = pixels.get(i);
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
            if (first.get(iFirst) < second.get(iSecond)) {
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
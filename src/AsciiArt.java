
import processing.core.PApplet;
import processing.core.PImage;

import java.awt.image.BufferedImage;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class AsciiArt extends PApplet {
    int index = 0;
    int counter = 0;
    PImage img;
    String[] ascii;
    File file = new File("output.txt");
    BufferedWriter writer = new BufferedWriter(new FileWriter(file, false));

    public AsciiArt() throws IOException {
    }

    public static void main(String[] args) {
        PApplet.main("AsciiArt");

    }

    public void settings() {
        img = loadImage("me.JPG");
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

    }

    public void setup() {

    }

    public void draw() {
        String toWrite = "";
        image(img, 0, 0);
        loadPixels();
        ascii = new String[img.pixels.length];
        int row = img.width;
        while (index < img.pixels.length) {
            if (brightness(img.pixels[index]) < 40) {
                toWrite = "#";
            } else if (brightness(img.pixels[index]) >= 40 && brightness(img.pixels[index]) < 80) {
                toWrite = "@";
            } else if (brightness(img.pixels[index]) >= 120 && brightness(img.pixels[index]) < 80) {
                toWrite = "O";
            } else if (brightness(img.pixels[index]) >= 120 && brightness(img.pixels[index]) < 160) {
                toWrite = "I";
            } else if (brightness(img.pixels[index]) >= 160 && brightness(img.pixels[index]) < 200) {
                toWrite = ";";
            } else if (brightness(img.pixels[index]) >= 200 && brightness(img.pixels[index]) < 240) {
                toWrite = ":";
            } else {
                toWrite = ".";
            }
            if (index == row) {
                toWrite += "\n";
                row += img.width;
            }
            ascii[index] = toWrite;
            index++;
        }
        while (index == img.pixels.length && counter < ascii.length) {
            try {
                toWrite = ascii[counter];
                writer.write(toWrite);
                counter++;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        try {
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

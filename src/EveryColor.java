import processing.core.PApplet;
import processing.core.PImage;

import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class EveryColor extends PApplet {
    PImage theThing;

    public static void main(String[] args) {
        PApplet.main("EveryColor");
    }

    public void settings() {
        size(4096, 4096);
    }

    public void setup() {
        theThing = createImage(4096, 4096, RGB);
        theThing.loadPixels();
//        generateColors();
//        generateRGBColors();
//        generateSortedColors();
        int pixel = 1;
        theThing.pixels[0] = new Color(0,0,0).getRGB();
        pixel = addReds(pixel);
        pixel = addGreens(pixel);
        addBlues(pixel);
    }

    private void generateRGBColors() {
        for (int i = 0; i < 16777216; i++) {
            theThing.pixels[i] = i;
        }
    }

    private void generateSortedColors() {
        ArrayList<Color> colors = new ArrayList<>();
        for (int i = 0; i < 16777216; i++) {
            colors.add(new Color(i));
        }
        colors = sortColors(colors);
        for (int i = 0; i < colors.size(); i++) {
            theThing.pixels[i] = colors.get(i).getRGB();
        }
    }

    private ArrayList<Color> sortColors(ArrayList<Color> colors) {
        Collections.sort(colors, new Comparator<Color>() {
            @Override
            public int compare(Color color1, Color color2) {
                if (color1.getRed() + color1.getBlue() + color1.getGreen() < color2.getRed() + color2.getBlue() + color2.getGreen()) {
                    return -1;
                } else if (color1.getRed() + color1.getBlue() + color1.getGreen() > color2.getRed() + color2.getBlue() + color2.getGreen()) {
                    return +1;
                } else {
                    return 0;
                }
            }
        });
        return colors;
    }

    private void generateColors() {
        int pixel = 0;
        for (int red = 0; red < 256; red++) {
            for (int green = 0; green < 256; green++) {
                for (int blue = 0; blue < 256; blue++, pixel++) {
                    Color color = new Color(red, green, blue);
                    theThing.pixels[pixel] = color.getRGB();
                }
            }
        }
    }

    private int addReds(int pixel) {
        int counter = 0;
        for (int red = 0; red < 256; red++) {
            for (int green = 0; green < red; green++) {
                for (int blue = 0; blue < red; blue++, pixel++) {
                    Color color = new Color(red, green, blue);
                    theThing.pixels[pixel] = color.getRGB();
                    counter++;
                }
            }
        }
        System.out.println(counter);
        return pixel;
    }

    private int addGreens(int pixel) {
        int counter = 0;
        for (int green = 0; green < 256; green++) {
            for (int blue = 0; blue < green; blue++) {
                for (int red = 0; red < green; red++, pixel++) {
                    Color color = new Color(red, green, blue);
                    theThing.pixels[pixel] = color.getRGB();
                    counter++;
                }
            }
        }
        System.out.println(counter);
        return pixel;
    }

    private int addBlues(int pixel) {
        int counter = 0;
        for (int blue = 0; blue < 256; blue++) {
            for (int green = 0; green < blue; green++) {
                for (int red = 0; red < blue; red++, pixel++) {
                    Color color = new Color(red, green, blue);
                    theThing.pixels[pixel] = color.getRGB();
                    counter++;
                }
            }
        }
        System.out.println(counter);
        return pixel;
    }

    public void draw() {
        image(theThing, 0, 0);
        save("color.png");
    }
}

import processing.core.PApplet;
import processing.core.PImage;

public class PixelSort extends PApplet {
    int index = 0;
    int counter = 0;
    int zSpeicher;
    PImage img;
    PImage sorted;

    public static void main(String[] args) {
        PApplet.main("PixelSort");
    }

    public void settings() {
        //	img = createImage(500, 500, RGB);
        img = loadImage("images/jap.png");
		/*for (int i = 0; i < img.width * img.height; i++) {
			img.pixels[i] = color(random(255), random(255), random(255));
		}**/
        size(img.width * 2, img.height);
        sorted = createImage(img.width, img.height, RGB);
        sorted = img.get();
    }

    public void setup() {
    }

    public void draw() {
        frameRate(60);
        image(img, 0, 0);
        image(sorted, img.width, 0);
        for (int i = 0; i < 300; i++) {
            index = counter;
            for (int e = index + 1; e < sorted.pixels.length; e++) {
                if (sorted.pixels[index] < sorted.pixels[e]) {
                    index = e;
                }
            }
            if (counter < sorted.pixels.length) {
                zSpeicher = sorted.pixels[index];
                sorted.pixels[index] = sorted.pixels[counter];
                sorted.pixels[counter] = zSpeicher;
                counter++;
            } else {
                counter = 0;
            }
        }
        sorted.updatePixels();
    }
}

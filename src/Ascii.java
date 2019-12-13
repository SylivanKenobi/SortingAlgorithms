
import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Ascii {

    public static void main(String[] args) throws IOException {
        int index = 0;
        String toWrite;
        File file = new File("output.txt");
        BufferedWriter writer = new BufferedWriter(new FileWriter(file, false));
        BufferedImage colorImage = ImageIO.read(new File("/home/sylvain/Documents/SortingAlgorithms/src/images/me.JPG"));
        BufferedImage image = resizePicture(colorImage);
        ArrayList<String> ascii = new ArrayList<>();
        for (int i = image.getWidth() - 1; i > 0; i--) {
            for (int j = 0; j < image.getHeight(); j++) {
                toWrite = "";
                int rgb = image.getRGB(i, j);
                int gray = rgb & 0xFF;
                if (gray < 40) {
                    toWrite = "#";
                } else if (gray >= 40 && gray < 80) {
                    toWrite = "P";
                } else if (gray >= 120 && gray < 80) {
                    toWrite = "O";
                } else if (gray >= 120 && gray < 160) {
                    toWrite = "I";
                } else if (gray >= 160 && gray < 200) {
                    toWrite = ";";
                } else if (gray >= 200 && gray < 240) {
                    toWrite = ":";
                } else {
                    toWrite = ".";
                }
                if (j == image.getHeight() - 1) {
                    toWrite += "\n";
                }
                ascii.add(toWrite);
            }
        }
        index = 0;
        while (index < ascii.size()) {
            try {
                toWrite = ascii.get(index);
                writer.write(toWrite);
                index++;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        writer.close();
    }

    static private BufferedImage resizePicture(BufferedImage image) {
        int newWidth = image.getWidth();
        int newHeight = image.getHeight();
        int boundary = 400;
        if (image.getHeight() > boundary || image.getWidth() > boundary) {
            if (image.getHeight() > boundary) {
                newWidth = boundary;
                newHeight = (newWidth * image.getHeight()) / image.getWidth();
            }
            if (newHeight > boundary) {
                newHeight = boundary;
                newWidth = (newHeight * image.getWidth()) / image.getHeight();
            }
        }
        BufferedImage outputImage = new BufferedImage(newWidth, newHeight, BufferedImage.TYPE_BYTE_GRAY);
        Graphics2D g2d = outputImage.createGraphics();
        g2d.drawImage(image, 0, 0, newWidth, newHeight, null);
        g2d.dispose();
        return outputImage;
    }

}

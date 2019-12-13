import processing.core.PApplet;

import java.util.ArrayList;

public class MergeSort extends PApplet {
    ArrayList<Float> random = new ArrayList<>();

    public static void main(String[] args) {
        PApplet.main("MergeSort");
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
        frameRate(1);
        background(0);
        for (int i = 0; i < random.size(); i++) {
            stroke(255);
            line(i, height, i, height - random.get(i));
        }

        sorting(random);
    }

    public static ArrayList<Float> sorting(ArrayList<Float> a) {
        ArrayList<Float> merge1 = new ArrayList<>();
        ArrayList<Float> merge2 = new ArrayList<>();
        System.out.println(a.size());
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

    public static void merge(ArrayList<Float> first, ArrayList<Float> second, ArrayList<Float> result) {
        int iFirst = 0;
        int iSecond = 0;
        int iMerged = 0;

        while (iFirst < first.size() && iSecond < second.size()) {
            if (first.get(iFirst) < (second.get(iSecond))) {
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

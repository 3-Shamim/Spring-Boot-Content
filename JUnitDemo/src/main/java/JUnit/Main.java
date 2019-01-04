package JUnit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Point p = new Point(2, 2);
        Point q = new Point(6, 2);

        int s = p.getDistance(q);
        System.out.println(s);

        /*String string[] = {"Banani", "Asuliya", "Gulshan"};

        List<String> stringList = new ArrayList<>();
        for (String s1 : string) {
            stringList.add(s1);
        }

        Sorter<String> stringSorter = new Sorter<>();

        List<String> sortList = stringSorter.sort(stringList);
        System.out.println(sortList);

        for (String s1 : string) {
            System.out.println(s1);
        }

        Arrays.sort(string);

        for (String s1 : string) {
            System.out.println(s1);
        }
        Collections.sort(stringList);
        System.out.println(stringList);*/

    }
}

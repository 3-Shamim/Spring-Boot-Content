import JUnit.Sorter;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SortTest {



    @Test
    public void test()
    {
        Sorter<String> stringSorter = new Sorter<>();
        String string[] = {"Banani", "Asuliya", "Gulshan"};

        List<String> stringList = new ArrayList<>();
        for (String s1 : string) {
            stringList.add(s1);
        }

        List<String> sortList = stringSorter.sort(stringList);
        List list = stringList.stream().sorted().collect(Collectors.toList());
        assertEquals(list , sortList);
        System.out.println(list + "\n" + sortList);
    }
    @Test
    public void test1()
    {
        Sorter<String> stringSorter = new Sorter<>();
        String string[] = {"Banani", "Asuliya","Uttora", "Gulshan"};

        List<String> stringList = new ArrayList<>();
        for (String s1 : string) {
            stringList.add(s1);
        }

        List<String> sortList = stringSorter.bubbleSort(stringList);
        List list = stringList.stream().sorted().collect(Collectors.toList());
        assertEquals(list , sortList);
        System.out.println(list + "\n" + sortList);
    }
}

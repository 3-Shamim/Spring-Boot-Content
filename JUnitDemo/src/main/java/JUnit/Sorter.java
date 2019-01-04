package JUnit;

import java.util.List;

public class Sorter<T> {
    public List<T> sort(List<T> list)
    {
        T temp = list.get(0);
        list.set(0, list.get(1));
        list.set(1,temp);
        return list;
    }

    public List<String> bubbleSort(List<String> list)
    {
        String temp;
        for (int i = 0; i < list.size() - 1; i++) {
            for (int j = 0; j < list.size() - 1 - i; j++) {
                if (list.get(j).compareTo(list.get(j+1)) > 0)
                {
                    temp = list.get(j);
                    list.set(j, list.get(j+1));
                    list.set(j+1, temp);
                }
            }
        }
        return list;
    }

}

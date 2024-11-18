import java.util.ArrayList;
import java.util.Comparator;

public class SelectionSorter {
    public static <T> void selectionSort(ArrayList<T> list, Comparator<T> comparator) {
        int n = list.size();

        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;

            // Find the index of the smallest element in the unsorted portion
            for (int j = i + 1; j < n; j++) {
                if (comparator.compare(list.get(j), list.get(minIndex)) < 0) {
                    minIndex = j;
                }
            }

            // Swap the smallest element with the first element of the unsorted portion
            if (minIndex != i) {
                T temp = list.get(i);
                list.set(i, list.get(minIndex));
                list.set(minIndex, temp);
            }
        }
    }
}
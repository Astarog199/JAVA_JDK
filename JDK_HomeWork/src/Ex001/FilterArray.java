package Ex001;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
Напишите обобщенный метод compareArrays(), который принимает два массива и возвращает true,
если они одинаковые, и false в противном случае. Массивы могут быть любого типа данных,
но должны иметь одинаковую длину и содержать элементы одного типа.
 */

public class FilterArray {
    public static void main(String[] args) {
        List<Integer> arr1 = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5,6));
        List<String> arr2 = new ArrayList<>(Arrays.asList("Один", "2", "3", "4", "5", "6"));
        Filter filter = new Filter<>();
        boolean res = filter.compareArrays(arr1, arr2);
        System.out.println(res);
    }

    static class Filter<T1, T2> {
        boolean compareArrays(List<? extends T1> arr1, List<? extends T2> arr2) {
            boolean checkLength = arr1.size() == arr2.size();
            boolean checkType = checkType(arr1, arr2);
            if (checkLength && checkType) return true;
            else return false;
        }

        boolean checkType (List<? extends T1> arr1, List<? extends T2> arr2){
            for (T1 t1 : arr1) {
                for (T2 t2 : arr2) {
                    if (t1.getClass() != t2.getClass()) {
                        return false;
                    }
                }
            }
            return true;
        }
    }

}
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
Напишите обобщенный метод compareArrays(), который принимает два массива и возвращает true,
если они одинаковые, и false в противном случае. Массивы могут быть любого типа данных,
но должны иметь одинаковую длину и содержать элементы одного типа.
 */

public class Main {
    public static void main(String[] args) {
        List<Integer> arr1 = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6));
        List<String> arr2 = new ArrayList<>(Arrays.asList("Один", "2", "3", "4", "5", "6"));
        Filter filter =  new Filter<>();
        boolean res = filter.compareArrays(arr1, arr2);
        System.out.println(res);
    }

static class Filter<T1,T2> {
    boolean compareArrays(List<? extends T1> arr1, List<? extends T2> arr2){

    if (arr1.get(0).getClass() == arr2.get(0).getClass()) return true;
    else return false;
//        if (arr1.size() == arr2.size()) return true;
//        else return false;
    }
}

}
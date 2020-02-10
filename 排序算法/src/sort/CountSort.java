package sort;

import common.DataChecker;
import common.Sorter;

public class CountSort extends Sorter {
    @Override
    public void sort(int[] arr) {

        int max = arr[0];
        int min = arr[0];
        int[] result = new int[arr.length];

        for (int i = 0; i < arr.length; i++){
            if (arr[i] > max) max = arr[i];
            if (arr[i] < min) min = arr[i];
        }

        int[] count = new int[1000000];
        for (int i = 0; i < arr.length; i++){
            count[arr[i]]++;
        }

        // 稳定计数排序
        for (int i = 1; i < count.length; i++){
            count[i] = count[i] + count[i-1];
        }

        for (int i = arr.length-1; i >= 0; i--){
            result[--count[arr[i]]] = arr[i];
        }

        arr = result;
    }

    public static void main(String[] args) {
        Sorter selectionSort = new CountSort();

        DataChecker dataChecker = new DataChecker();
        boolean check = dataChecker.check(selectionSort);
        System.out.println(check);
    }
}

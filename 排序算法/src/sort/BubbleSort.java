package sort;

import common.DataChecker;
import common.Sorter;

public class BubbleSort extends Sorter {

    @Override
    public void sort(int[] arr) {

        for (int i = arr.length - 1; i > 0; i--){
            for (int j = 0; j < i; j++){
                if (arr[j] > arr[j+1]) swap(arr,j,j+1);
            }
        }

    }

    public static void main(String[] args) {
        Sorter selectionSort = new BubbleSort();

        DataChecker dataChecker = new DataChecker();
        boolean check = dataChecker.check(selectionSort);
        System.out.println(check);
    }
}

/*
16
14919
true
 */
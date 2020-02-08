package sort;

import common.DataChecker;
import common.Sorter;

public class SelectionSort extends Sorter {

    @Override
    public void sort(int[] arr){

        for (int i = 0; i < arr.length; i++) {
            int minPos = i;

            for (int j = i; j < arr.length; j++) {
                minPos = arr[j] < arr[minPos] ? j : minPos;
            }

            Sorter.swap(arr,i,minPos);
        }

    }

    public static void main(String[] args) {

        Sorter selectionSort = new SelectionSort();

        DataChecker dataChecker = new DataChecker();
        boolean check = dataChecker.check(selectionSort);
        System.out.println(check);
    }

}

/*
15
3616
true
 */
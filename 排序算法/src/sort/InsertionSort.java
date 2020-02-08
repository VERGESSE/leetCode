package sort;

import common.DataChecker;
import common.Sorter;

public class InsertionSort extends Sorter {

    @Override
    public void sort(int[] arr) {

        for (int i = 1; i < arr.length; i++){
            for (int j = i; j > 0; j--){
                if (arr[j] < arr[j - 1]){
                    swap(arr,j,j - 1);
                }else break;
            }
        }
    }

    public static void main(String[] args) {

        Sorter selectionSort = new InsertionSort();

        DataChecker dataChecker = new DataChecker();
        boolean check = dataChecker.check(selectionSort);
        System.out.println(check);
    }
}

/*
13
1599
true
 */
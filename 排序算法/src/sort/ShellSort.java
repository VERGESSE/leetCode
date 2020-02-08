package sort;

import common.DataChecker;
import common.Sorter;

public class ShellSort extends Sorter {

    @Override
    public void sort(int[] arr) {

        int h = 1;
        while (h <= arr.length/3){
            h = h*3 +1;
        }

//        for (int gap = arr.length >> 1; gap > 0; gap >>= 1){
        for (int gap = h; gap > 0; gap = (gap-1)/3){

            for (int i = gap; i < arr.length; i++){
                for (int j = i; j > gap-1; j-=gap){
                    if (arr[j] < arr[j-gap]){
                        swap(arr,j,j-gap);
                    }else break;
                }
            }
        }
    }

    public static void main(String[] args) {

        Sorter selectionSort = new ShellSort();

        DataChecker dataChecker = new DataChecker();
        boolean check = dataChecker.check(selectionSort);
        System.out.println(check);
    }
}

/*
14
16
true
 */
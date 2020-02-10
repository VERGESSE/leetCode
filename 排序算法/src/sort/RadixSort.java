package sort;

import common.DataChecker;
import common.Sorter;

import java.util.Arrays;

public class RadixSort extends Sorter {

    @Override
    public void sort(int[] arr) {
        int[] result = new int[arr.length];
        int[] count = new int[10];
        int max = arr[0];

        //求最大数多少位
        for (int i : arr) {
            if (arr[i] > max)
                max = arr[i];
        }
        int maxBit = 1;
        while ((max = max/10) != 0)
            maxBit++;

        for (int i = 0; i < maxBit; i++){
            int division = (int)Math.pow(10,i);
            for (int j = 0; j < arr.length; j++){
                int num = arr[j]/division % 10;
                count[num]++;
            }

            for (int m = 1; m < count.length; m++){
                count[m] = count[m] + count[m-1];
            }

            for (int n = arr.length-1; n >= 0; n--){
                int num = arr[n]/division % 10;
                result[--count[num]] = arr[n];
            }
            Arrays.fill(count,0);
            System.arraycopy(result,0,arr,0,arr.length);
        }
    }

    public static void main(String[] args) {
        Sorter selectionSort = new RadixSort();

        DataChecker dataChecker = new DataChecker();
        boolean check = dataChecker.check(selectionSort);
        System.out.println(check);
    }

}

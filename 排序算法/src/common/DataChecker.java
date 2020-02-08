package common;

import java.util.Arrays;
import java.util.Random;

public class DataChecker {

    private static int[] generateRandomArray(){
        Random random = new Random();

        int[] arr = new int[100000];

        for (int i = 0; i < arr.length; i++){
            arr[i] = random.nextInt(100000);
        }

        return arr;
    }

    public boolean check(Sorter sorter){
        int[] arr1 = generateRandomArray();
        int[] arr2 = new int[arr1.length];

        System.arraycopy(arr1,0,arr2,0,arr1.length);

        long pre = System.currentTimeMillis();
        Arrays.sort(arr1);
        long post = System.currentTimeMillis();
        System.out.println(post - pre);

        pre = System.currentTimeMillis();
        sorter.sort(arr2);
        post = System.currentTimeMillis();
        System.out.println(post - pre);

        for (int i = 0; i < arr1.length; i++){
            if (arr1[i] != arr2[i])
                return false;
        }

        return true;
    }
}

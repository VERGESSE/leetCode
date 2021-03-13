package sort;

import common.DataChecker;
import common.Sorter;

public class MergeSort extends Sorter {

    @Override
    public void sort(int[] arr) {

        sort(arr,0,arr.length-1);
    }

    static void sort(int[] arr,int left,int right){
        if (left == right) return;
        // 分成两半
        int mid = left + (right - left)/2;
        // 左边排序
        sort(arr,left,mid);
        // 右边排序
        sort(arr,mid+1,right);

        merge(arr,left,mid+1,right);
    }

    static void merge(int[] arr,int leftPtr,int rightPtr,int rightBound){
        int mid = rightPtr - 1;
        int[] temp = new int[rightBound - leftPtr + 1];

        int i = leftPtr;
        int j = rightPtr;
        int k = 0;

        while (i <= mid && j <= rightBound){
            temp[k++] = arr[i] <= arr[j] ? arr[i++] : arr[j++];
        }

        while (i<=mid) temp[k++] = arr[i++];
        while (j<=rightBound) temp[k++] = arr[j++];

        for (int m = 0; m < temp.length; m++)
            arr[leftPtr + m] = temp[m];
    }

    public static void main(String[] args) {
        Sorter selectionSort = new MergeSort();

//        int[] arr = {1,4,8,9,6,3,2,5,7};
//        selectionSort.sort(arr);
//        for (int i = 0; i < arr.length; i++)
//            System.out.print(arr[i] + " ");
        DataChecker dataChecker = new DataChecker();
        boolean check = dataChecker.check(selectionSort);
        System.out.println(check);
    }
}

/*
17
29
true
 */

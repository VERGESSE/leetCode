package sort;

import common.DataChecker;
import common.Sorter;

public class QuickSort extends Sorter {

    @Override
    public void sort(int[] arr) {

        sort(arr,0,arr.length-1);
    }

    static void sort(int[] arr,int leftBound,int rightBound){
        if (leftBound >= rightBound) return;
        int mid = partition(arr,leftBound,rightBound);
        sort(arr,leftBound,mid-1);
        sort(arr,mid+1,rightBound);
    }

    static int partition(int[] arr, int leftBound, int rightBound) {

        int pivot = arr[rightBound];
        int left = leftBound;
        int right = rightBound - 1;

        while (left <= right){
            while (left <= right && arr[left] <= pivot) left++;
            while (left <= right && arr[right] >= pivot) right--;

            if (left < right) swap(arr,left,right);
        }

        swap(arr,left,rightBound);

        return left;
    }

    public static void main(String[] args) {

        Sorter selectionSort = new QuickSort();

        DataChecker dataChecker = new DataChecker();
        boolean check = dataChecker.check(selectionSort);
        System.out.println(check);
    }
}

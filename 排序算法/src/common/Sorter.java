package common;

public abstract class Sorter{

    public abstract void sort(int[] arr);

    public static void swap(int[] arr,int i,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}

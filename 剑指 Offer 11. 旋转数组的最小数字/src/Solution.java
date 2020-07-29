class Solution {
    public int minArray(int[] numbers) {
        int low = 0;
        int high = numbers.length - 1;
        while (low < high) {
            int pivot = low + (high - low) / 2;
            if (numbers[pivot] < numbers[high]) {
                high = pivot;
            } else if (numbers[pivot] > numbers[high]) {
                low = pivot + 1;
            } else {
                high -= 1;
            }
        }
        return numbers[low];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.minArray(
                new int[]{2,2,3,0,1}));
    }
}

/*
public int minArray(int[] numbers) {

    int res = numbers[0];
    for (int number : numbers) {
        if (number < res)
            return number;
    }
    return res;
}
 */

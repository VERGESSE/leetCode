class Solution {
    public int maxTurbulenceSize(int[] arr) {

        int len = arr.length;
        if(len < 2){
            return len;
        }
        
        int i = 0, j = 1;
        int max = 1;
        while(j < len && arr[i] == arr[j]){
            i++; j++;
        }
        boolean flag = arr[i] < arr[i];

        while(j < len){
            int cur = j - 1;
            if(flag ?
                    ((cur - i) % 2 == 1 && arr[cur] > arr[j]) ||
                    ((cur - i) % 2 == 0 && arr[cur] < arr[j]) :
                    ((cur - i) % 2 == 1 && arr[cur] < arr[j]) ||
                    ((cur - i) % 2 == 0 && arr[cur] > arr[j])
            ){
                j++;
            } else {
                max = Math.max(max, j - i);
                i = cur;
                while(j < len && arr[i] == arr[j]){
                    i++; j++;
                }
                if (j < len){
                    flag = arr[i] < arr[j];
                }
            }
        }

        return Math.max(max, j - i);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.maxTurbulenceSize(new int[]{0,1,1,0,1,0,1,1,0,0}));
    }
}

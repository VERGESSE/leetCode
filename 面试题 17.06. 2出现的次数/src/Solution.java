class Solution {

    public int numberOf2sInRange(int n) {
        if(n < 2){
            return 0;
        }
        int[] bitNumAndFirst = bitNum(n);
        int bitNum = bitNumAndFirst[0];
        int num = numberOf2InBitRange(bitNum-1);
        int first = bitNumAndFirst[1];
        num *= first;
        if(first == 1){
            return num + numberOf2sInRange(getLast(n, bitNum, first));
        } else if(first == 2){
            return num + getLast(n, bitNum, first)
                    + numberOf2sInRange(getLast(n, bitNum, first));
        } else {
            return num + getFullInt(bitNum) +
                    numberOf2sInRange(getLast(n, bitNum, first));
        }
    }

    // 获取长度为 bitNum 位的全部数的包含2的数量
    private int numberOf2InBitRange(int bitNum){
        if(bitNum == 0)
            return 0;
        int num = 1;
        for(int i = 2; i <= bitNum; i++){
            num *= 10;
            num += getFullInt(i);
        }
        return num;
    }

    // 获取 bitNum 位的数的第一个数， 例第一个三位数为100
    private int getFullInt(int bitNum){
        int n = 1;
        for(int k = bitNum; k > 1; k--)
            n *= 10;
        return n;
    }

    // 获取一个数的位数和第一个数字 组成一个数组返回
    private int[] bitNum(int n){
        int num = 1;
        while(n /10 != 0){
            n /= 10;
            num++;
        }
        return new int[]{num, n};
    }

    // 获取一个数除去第一个数字后剩下的数， 当前数 - 第一个数 * 该位数的数的第一个数
    // 例输入 123456 6 1 返回 2356
    private int getLast(int n, int bitNum, int first){
        if(bitNum == 1)
            return n;
        return n - first * getFullInt(bitNum);
    }
}
